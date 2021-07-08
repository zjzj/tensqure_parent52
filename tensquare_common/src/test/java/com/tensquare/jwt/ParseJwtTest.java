package com.tensquare.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.text.SimpleDateFormat;

/**
 * @author Zj
 * @date 2019/8/12 18:17
 */
public class ParseJwtTest {
  public static void main(String[] args) {
    String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMTYwNzQ0NTM2ODE3OTMwMjQwIiwic3ViIjoi5bCP5piOIiwiaWF0IjoxNTY1NzA1MjA2LCJyb2xlcyI6ImFkbWluIiwiZXhwIjoxNTY1NzA4ODA2fQ.Ky-geseu6_hdZkFwt0nvI9Mko9dWEOC50bwGsLs_URU";
    Claims claims = Jwts.parser().setSigningKey("itcast").parseClaimsJws(token).getBody();
    System.out.println("用户id：" + claims.getId());
    System.out.println("用户名字：" + claims.getSubject());
;
  }
}
