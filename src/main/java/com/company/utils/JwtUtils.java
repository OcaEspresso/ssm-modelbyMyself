package com.company.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.company.entity.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class JwtUtils {
    private static final long EXPIRE_DATE=30*60*1000;
    //token秘钥
    private static final String TOKEN_SECRET = "qianggezainaliwyywyasdaDQWCWQ%5ASAACACAssdsdsbalgda";

    /**
     * 生成token
     * @param username
     * @param userId
     * @return
     */
    public static String token (Integer userId,String username){

        String token = "";
        try {
            //过期时间
            Date date = new Date(System.currentTimeMillis()+EXPIRE_DATE);
            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息
            Map<String,Object> header = new HashMap<>();
            header.put("typ","JWT");
            header.put("alg","HS256");
            //携带username，password信息，生成签名
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("username",username)
                    .withClaim("userId",userId)
                    .withExpiresAt(date)
                    .sign(algorithm);
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
        return token;
    }

    /**
     * 校验
     * @param token
     * @return
     */
    public static boolean verify(String token){
        /**
         * @desc   验证token，通过返回true
         * @params [token]需要校验的串
         **/
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }

    public static User parse(String token){
        DecodedJWT decodedJWT = JWT.decode(token);

        Map<String, Claim> claims = decodedJWT.getClaims();
        String username = claims.get("username").asString();
        Integer userId = claims.get("userId").asInt();

        User user = new User();
        user.setId(userId);
        user.setUsername(username);


        return user;

    }



    public static void main(String[] args) {

//        String token = token(10,"zs");
//        System.out.println(token);
//
//        //eyJhbGciOiJIUzI1NiIsIn·R5cCI6IkpXVCJ9.eyJpbWFnZSI6IuayoeaciSIsInBob25lIjoiMTEwIiwiZXhwIjoxNjI1MDE4MTA5LCJ1c2VybmFtZSI6ImFsZyJ9.jMj6tR9h9QHxPEVQ23Ph3J1zLi7Fe3xcArAywee5EH0
//        System.out.println(token);
//
//        //验签
        String a = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MDY0MTM0OTksInVzZXJJZCI6MTAsInVzZXJuYW1lIjoienMifQ.LrsCgu6OizNeyVWvR4YfroabVn5w_W8gM4mGktnFxYk";
        boolean isLogin= verify(a);


        User user = parse(a);
//
        System.out.println(user);

    }

}