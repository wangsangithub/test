package com.bdqn.demo;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class DemoA {
	public static void main(String[] args) {
		
		try {
			InetAddress ia=InetAddress.getByName("www.baidu.com");
			System.out.println(ia);
			System.out.println(ia.getHostName());
			System.out.println(ia.getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
