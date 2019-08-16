package com.tensquare.web.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Zj
 * @date 2019/8/16 17:16
 */
@Component
public class WebFilter extends ZuulFilter {
  @Override
  public String filterType() {
    return "pre";
  }

  @Override
  public int filterOrder() {
    return 0;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() throws ZuulException {
    //得到request上下文
    RequestContext requestContext = RequestContext.getCurrentContext();
    //得到request域
    HttpServletRequest request = requestContext.getRequest();
    //得到头信息
    String header = request.getHeader("Authorization");
    if(header!=null && !"".equals(header)){
      requestContext.addZuulRequestHeader("Authorization",header);
    }
    return null;
  }
}
