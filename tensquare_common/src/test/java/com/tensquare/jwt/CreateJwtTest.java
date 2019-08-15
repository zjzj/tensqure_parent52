package com.tensquare.jwt;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @author Zj
 * @date 2019/8/12 18:13
 */
public class CreateJwtTest {
  public static void main(String[] args) {

    JwtBuilder builder = Jwts.builder()
      .setId("666")
      .setSubject("小马")
      .setIssuedAt(new Date())
      .signWith(SignatureAlgorithm.HS256,"itcast")
      .setExpiration(new Date(new Date().getTime()+60000));
    System.out.println(builder.compact());

  }
}
