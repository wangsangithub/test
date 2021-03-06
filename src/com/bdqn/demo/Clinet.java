package com.bdqn.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Clinet {
	public static void main(String[] args) {
		String info="您好，我想咨询一个问题！";
		byte[] infos=info.getBytes();
		DatagramSocket socket=null;
		try {
			InetAddress ia=InetAddress.getByName("localhost");
			//构建客户端要发送的数据包对象
			DatagramPacket dp=new DatagramPacket(infos, infos.length,ia,8800);
			//客户端需要一个DatagramSocket对象
			socket=new DatagramSocket();
			//通过DatagramSocket对象发送数据包到服务器
			socket.send(dp);

			//接收服务器的响应
			byte[] replys=new byte[1024];
			DatagramPacket dp1=new DatagramPacket(replys, replys.length);
			socket.receive(dp1);
			String reply=new String(dp1.getData(),0,dp1.getData().length);
			System.out.println("服务器回应："+reply);
			socket.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
