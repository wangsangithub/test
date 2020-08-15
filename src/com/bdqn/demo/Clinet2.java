package com.bdqn.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Clinet2 {
	public static void main(String[] args) {
		try {
			Socket socket=new Socket("localhost",8800);
			OutputStream os=socket.getOutputStream();
			User user=new User("TOM","123456");
			ObjectOutputStream oos=new ObjectOutputStream(os);
			oos.writeObject(user);

			socket.shutdownOutput();
			
			InputStream is=socket.getInputStream();
			BufferedReader br=new BufferedReader(new InputStreamReader(is));
			String reply;
			while((reply=br.readLine())!=null){
				System.out.println("服务器的响应："+reply);
			}
			//3、释放资源
			br.close();
			is.close();
			os.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
