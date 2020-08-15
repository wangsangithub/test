package com.bdqn.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class LoginThread extends Thread{
	
	Socket socket=null;
	//ÿ����һ���̣߳���ӦSocket
	public LoginThread(Socket socket){
		this.socket=socket;
	}
	@Override
	public void run() {
		try {
			//�����������
			InputStream is=socket.getInputStream();
			OutputStream os=socket.getOutputStream();
			//�����л�
			ObjectInputStream ois=new ObjectInputStream(is);
			User user=(User)ois.readObject();
			if(!(user==null)){
				System.out.println("���Ƿ��������ͻ���¼��ϢΪ��"+user.getUserName()+","+user.getPwd());
			}			
			//���ͻ���һ����Ӧ�����������д����Ϣ
			String reply="��ӭ�㣬��¼�ɹ�!";
			os.write(reply.getBytes());
			//�ر���Դ
			ois.close();
			os.close();
			is.close();
			socket.close();			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		
		
		
	}
	
}
