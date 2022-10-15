package ch07.socket1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientFile {

	Socket socket;
	BufferedWriter bw;
	BufferedReader br;//키보드 연결을 위해
	
	public static void main(String[] args) {
		new ClientFile();
	}
	
	public ClientFile() {		
		try {
			System.out.println("1. 클라이언트 소켓 시작========================");
			socket = new Socket("localhost",10000); //실행 시 -> 서버소켓쪽의 serverSocket.accept(); 실행됨
			//socket = new Socket("ip주소",포트번호);	
			
			System.out.println("2. 버퍼(write) 연결완료===============");
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			//OutputStreamWriter = 쓰는 정수를 문자로 바꾸어줌
			//클라이언트 입장에서는 연결되는 선은 socket.getOutputStream()이다. 
			// <=> 서버는 socket.getInputStream()이 연결되는 선이다. 
			
			/*키보드로부터 입력받아 메시지 쓰기*/
			//1.키보드 연결
			System.out.println("3. 키보드 스트림 + 버퍼(read) 연결 완료==============");
			br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("4. 키보드 메시지 입력 대기중========================");
			String keyboardMsg = br.readLine();
			//2.읽은 키보드 메시지를 소켓서버에 쓰기
			bw.write(keyboardMsg+"\n"); //통신 규칙 : 메시지의 끝을 의미하는 '\n' 달아야함
			bw.flush(); //버퍼 비우기,남아 있는 데이터를 모두 출력 시킴
		} catch (Exception e) {
			System.out.println("클라이언트소켓 에러 발생함 : " + e.getMessage());
		}
		
	}

}
