package ch07.socket3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientFile {

	Socket socket;
	BufferedWriter bw;
	BufferedReader keyboard;// 키보드 연결을 위해
	BufferedReader sbr;// 소켓데이터 읽기

	public static void main(String[] args) {
		new ClientFile();
	}

	public ClientFile() {
		try {
			System.out.println("1. 클라이언트 소켓 시작========================");
			socket = new Socket("localhost", 10000); // 실행 시 -> 서버소켓쪽의 serverSocket.accept(); 실행됨
			// socket = new Socket("ip주소",포트번호);

			System.out.println("2. 버퍼(write) 연결완료===============");
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			// OutputStreamWriter = 쓰는 정수를 문자로 바꾸어줌
			// 클라이언트 입장에서는 연결되는 선은 socket.getOutputStream()이다.
			// <=> 서버는 socket.getInputStream()이 연결되는 선이다.

			/* 키보드로부터 입력받아 메시지 쓰기 */
			// 1.키보드 연결
			System.out.println("3. 키보드 스트림 + 버퍼(read) 연결 완료==============");
			keyboard = new BufferedReader(new InputStreamReader(System.in));
			
			sbr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			/* 새로운 스레드 역할 (글 읽기) */
			ReadThread rt = new ReadThread();
			Thread t1 = new Thread(rt);
			t1.start();

			while (true) {
				System.out.println("4. 키보드 메시지 입력 대기중========================");
				String keyboardMsg = keyboard.readLine();
				// 2.읽은 키보드 메시지를 소켓서버에 쓰기
				bw.write(keyboardMsg + "\n"); // 통신 규칙 : 메시지의 끝을 의미하는 '\n' 달아야함
				bw.flush(); // 버퍼 비우기,남아 있는 데이터를 모두 출력 시킴
			}

		} catch (Exception e) {
			System.out.println("클라이언트소켓 에러 발생함 : " + e.getMessage());
		}

	}

	class ReadThread implements Runnable {

		@Override
		public void run() {
			while(true) {
				try {
					String msg = sbr.readLine();
					System.out.println("서버로 부터 받은 메시지 : " + msg);
				} catch (Exception e) {
					System.out.println("클라이언트소켓쪽에서 서버소켓 메시지를 입력받는 중 오류 발생 : " + e.getMessage());

				}
			}
		}

	}

}
