package com.company.utils;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.UUID;

public class Md5Utils {
	
	
	
	/**
	 * 生成盐
	 * @return
	 */
	public static String crateSalt() {
		return UUID.randomUUID().toString();
	}
	
	/**
	 * 加密操作
	 * @param password 明文
	 * @param salt  调料
	 * @return 加密后的密码 
	 */
	public static String md5Password(String password,String salt) {
		
		try {
		
		//1.获取md5加密算法
		MessageDigest digest = MessageDigest.getInstance("md5");
		
		//2.加密密码 
		byte[] md5 = digest.digest((password+salt).getBytes());
		
		//3.Base64进行编码
		byte[] encoder = Base64.getEncoder().encode(md5);
		
		return new String(encoder);
		
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("加密失败!");
		}
	}

	public static void main(String[] args) {
		String salt = crateSalt();
		System.out.println(salt);
		String pwd = md5Password("ls", salt);
		System.out.println(pwd);

	}
	
}