package com.bdqn.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class LoginThread extends Thread{
	
	Socket socket=null;
	//每启动一个线程，对应Socket
	public LoginThread(Socket socket){
		this.socket=socket;
	}
	@Override
	public void run() {
		try {
			//打开输入输出流
			InputStream is=socket.getInputStream();
			OutputStream os=socket.getOutputStream();
			//反序列化
			ObjectInputStream ois=new ObjectInputStream(is);
			User user=(User)ois.readObject();
			if(!(user==null)){
				System.out.println("我是服务器，客户登录信息为："+user.getUserName()+","+user.getPwd());
			}			
			//给客户端一个响应，即向输出流写入信息
			String reply="欢迎你，登录成功!";
			os.write(reply.getBytes());
			//关闭资源
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
