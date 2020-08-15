package com.bdqn.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;

public class Server {
	public static void main(String[] args) {
		byte[] infos = new byte[1024];
		DatagramPacket dp = new DatagramPacket(infos, infos.length);
		DatagramSocket socket = null;
		try {
			socket = new DatagramSocket(8800);
			// ���տͻ��˵����ݰ���������Ϣ��װ��dp��
			socket.receive(dp);

			// ����һ���ַ���
			String info = new String(dp.getData(), 0, dp.getData().length);
			System.out.println("�ͻ���˵��" + info);

			// ���ͻ���һ����Ӧ
			String reply = "���ã����ڣ���˵��";
			// �ͻ��˵ĵ�ַ
			SocketAddress sa = dp.getSocketAddress();
			// ��һ������
			DatagramPacket dp1 = new DatagramPacket(reply.getBytes(), 0, reply.getBytes().length, sa);
			// ����������
			socket.send(dp1);
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			socket.close();
		}

	}
}
