package ch07.socket1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile {
	
	//클라이언트 연결을 받는 서버 소켓
	ServerSocket serverSocket;
	//서버 소켓으로부터 생성된, 실제 통신을 하는 소켓
	Socket socket;
	BufferedReader br;//전역변수로 선언만 한거라 아직 메모리에 뜨지 않았따.
	//new를 해야 메모리에 뜹니다.
	
	public ServerFile() {
		System.out.println("1. 서버 소켓 시작========================");
		try {
			//서버소켓 만들기
			serverSocket = new ServerSocket(10000);//포트 10,000번
			System.out.println("2. 서버 소켓 생성 완료! : 클라이언트 접속 대기 중 ==============");
			socket = serverSocket.accept(); //클라이언트 접속 대기 중...
			
			/* 버퍼 달기 */
			System.out.println("3. 클라이언트 연결 완료 - buffer연결완료(read)");
			//System.in 키보드와 연결하는게 아닌, socket.getInputStream()과 연결하여 버퍼 담
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String msg = br.readLine();
			System.out.println("4. 클라이언트로 부터 받은 메시지 : " + msg);
		} catch (Exception e) {
			System.out.println("서버소켓 에러 발생함 : " + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		new ServerFile();
	}

}
