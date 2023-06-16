package network.com.ict.edu3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	ServerSocket ss = null;
	InputStream in = null;
	BufferedInputStream bis = null;
	OutputStream out = null;
	Socket s = null;
	
	
	BufferedOutputStream bos = null;
	
	public EchoServer() {
	
		try {
			ss = new ServerSocket(7778);
			System.out.println("서버 대기중 ...")
			;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		while (true) {
			try {
				s = ss.accept();
				String ip = s.getInetAddress().getHostAddress();
				
				in = s.getInputStream();
				bis = new BufferedInputStream(in);
				byte[] b = new byte[1024];
				bis.read(b);
				
				String msg = new String(b).trim();
				
				out = s.getOutputStream();
				bos = new BufferedOutputStream(out);
				bos.write(msg.getBytes());
				bos.flush();
				
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				try {
					s.close();
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}
	public static void main(String[] args) {
	new EchoServer();
	}
}
