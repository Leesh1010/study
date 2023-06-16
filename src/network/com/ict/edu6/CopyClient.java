package network.com.ict.edu6;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class CopyClient extends Thread{
	Socket s ;
	ChatServer server;
	
	// 객체 직렬화
	ObjectInputStream in;
	ObjectOutputStream out;
	String nickName;
	
	public CopyClient(Socket s, ChatServer server) { //생성자에 인자값을 전역변수로 만들어라.
		this.s = s;
		this.server = server;
		try {
			in = new ObjectInputStream(s.getInputStream());
			out = new ObjectOutputStream(s.getOutputStream());
			
		} catch (Exception e) {

		}
	}
	@Override
	public void run() {
		esc: while(true) {
			try {
				Object obj = in.readObject();
				if(obj != null) {
					Protocol p = (Protocol)obj;
					switch (p.getCmd()) {
					case 0://접속종료
						out.writeObject(p);
						break esc;

					case 1: // 닉네임 받기
						nickName = p.getMsg();
						p.setCmd(2);
						p.setMsg(nickName + "님 입장");
						
						// 접속자 모두에게 전달
						server.sendMsg(p);
						break;
						
					case 2: // 일반채팅 메세지
						p.setCmd(2);
						p.setMsg(nickName + ":" + p.getMsg());
						server.sendMsg(p);
						break;
					}
				}
			} catch (Exception e) {

			}
		} // 무한 반복 끝
		try {
			out.close();
			in.close();
			s.close();
			server.removeClient(this);
			Protocol p2 = new Protocol();
			p2.setCmd(2); // 채팅을 하거 있는 이용자들에게 보여지는 메세지라 채팅 메세지로 !!!!
			p2.setMsg(nickName + "님 퇴장");
			server.sendMsg(p2);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
