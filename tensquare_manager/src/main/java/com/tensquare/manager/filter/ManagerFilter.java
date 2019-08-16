package com.tensquare.manager.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Zj
 * @date 2019/8/16 15:18
 */
@Component
public class ManagerFilter extends ZuulFilter {

  @Autowired
  private JwtUtil jwtUtil;

  /**
   * 表示在请求前还是后执行，pre之前，post之后
   *
   * @return
   */
  @Override
  public String filterType() {
    return "pre";
  }

  /**
   * 优先等级0最大
   *
   * @return
   */
  @Override
  public int filterOrder() {
    return 0;
  }

  /**
   * 当前过滤器是否开启，true开启
   *
   * @return
   */
  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() throws ZuulException {
    System.out.println("经过了后台过滤器");
    //得到request上下文
    RequestContext requestContext = RequestContext.getCurrentContext();
    //得到request域
    HttpServletRequest request = requestContext.getRequest();
    //得到头信息
    String header = request.getHeader("Authorization");

    //
    if ("OPTIONS".equals(request.getMethod())) {
      return null;
    }

    //登录不拦截
    if(request.getRequestURI().indexOf("login")>0){
      return null;
    }

    if (header != null && !"".equals(header)) {
      if (header.startsWith("Bearer ")) {
        String token = header.substring(7);
        try {
          Claims claims = jwtUtil.parseJWT(token);
          String roles = (String) claims.get("roles");
          if ("admin".equals(roles)) {
            //转发头信息，并放行
            requestContext.addZuulRequestHeader("Authorization", header);
            return null;
          }
        } catch (Exception e) {
          //中止运行
          e.printStackTrace();
          requestContext.setSendZuulResponse(false);
        }
      }
    }
    requestContext.setSendZuulResponse(false);
    requestContext.setResponseStatusCode(403);
    requestContext.setResponseBody("权限不足");
    requestContext.getResponse().setContentType("text/html;charset=utf-8");
    return null;
  }
}
