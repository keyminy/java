package ch07;

/*SubThread는 부모가 Runnable이므로
 * Runnable타입이기도 합니다. */
class SubThread implements Runnable{
	//자바의 서브 스레드
	@Override
	public void run() {
		for(int i=1;i<6;i++) {
			try {
				System.out.println("서브스레드 : " + i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

public class ThreadEx01 {	
	//자바의 메인 스레드
	public static void main(String[] args) {
		SubThread st = new SubThread();
		Thread t1 = new Thread(st);//타겟을 선정하면서 스레드를 만드는 작업이다
		t1.start(); //run()메서드가 실행됨
		for(int i=1;i<6;i++) {
			try {
				System.out.println("메인스레드 : " + i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
