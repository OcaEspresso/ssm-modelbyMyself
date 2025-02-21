package com.company.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseUtils {

    public static void responseToJson(String json, HttpServletResponse response){
        try {
            //设置响应头
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("发送数据失败!");
        }

    }

}