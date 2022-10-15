package ch07.socket3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile {

	// 클라이언트 연결을 받는 서버 소켓
	ServerSocket serverSocket;
	// 서버 소켓으로부터 생성된, 실제 통신을 하는 소켓
	Socket socket;
	BufferedReader br;// 전역변수로 선언만 한거라 아직 메모리에 뜨지 않았따.
	// new를 해야 메모리에 뜹니다.
	
	/*양방향 통신하기, 서버가 클라쪽으로 쓰기용 버퍼 */
	BufferedWriter bw;//새로운 스레드가 필요하다.
	BufferedReader keyboard; //새로운 스레드가 필요하다.
	//키보드로부터 읽어서 클라쪽으로 쓰는 버퍼를 이용함

	public ServerFile() {
		System.out.println("1. 서버 소켓 시작========================");
		try {
			// 서버소켓 만들기
			serverSocket = new ServerSocket(10000);// 포트 10,000번

			System.out.println("2. 서버 소켓 생성 완료! : 클라이언트 접속 대기 중 ==============");
			socket = serverSocket.accept(); // 클라이언트 접속 대기 중...

			/* 버퍼 달기 */
			System.out.println("3. 클라이언트 연결 완료 - buffer연결완료(read)");
			// System.in 키보드와 연결하는게 아닌, socket.getInputStream()과 연결하여 버퍼 담
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			keyboard = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			//write 스레드가 실행됨(글쓰기)
			WriteThread wt = new WriteThread();
			Thread t1 = new Thread(wt);
			t1.start();
			
			//main스레드의 역할(글 읽기)
			while (true) {
				String msg = br.readLine();
				System.out.println("4. 클라이언트로 부터 받은 메시지 : " + msg);
			}
		} catch (Exception e) {
			System.out.println("서버소켓 키보드 입력 받는 에러 발생함 : " + e.getMessage());
		}
	}

	//내부 클래스 형식으로 write스레드 생성
	class WriteThread implements Runnable{

		@Override
		public void run() {
			while(true) {
				try {
					String keyboardMsg = keyboard.readLine();
					//키보드로 입력받은거 bw로 쓰기
					bw.write(keyboardMsg+"\n");// 끝을 나타내는 "\n" 빼지말기
					bw.flush();
				} catch (Exception e) {
					System.out.println("서버소켓쪽에서 키보드 입력 받는 중 오류 발생 : "+e.getMessage());
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		new ServerFile();
	}

}
