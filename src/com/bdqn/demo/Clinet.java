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
		String info="���ã�������ѯһ�����⣡";
		byte[] infos=info.getBytes();
		DatagramSocket socket=null;
		try {
			InetAddress ia=InetAddress.getByName("localhost");
			//�����ͻ���Ҫ���͵����ݰ�����
			DatagramPacket dp=new DatagramPacket(infos, infos.length,ia,8800);
			//�ͻ�����Ҫһ��DatagramSocket����
			socket=new DatagramSocket();
			//ͨ��DatagramSocket���������ݰ���������
			socket.send(dp);

			//���շ���������Ӧ
			byte[] replys=new byte[1024];
			DatagramPacket dp1=new DatagramPacket(replys, replys.length);
			socket.receive(dp1);
			String reply=new String(dp1.getData(),0,dp1.getData().length);
			System.out.println("��������Ӧ��"+reply);
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
