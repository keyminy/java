package ch07;

class 총{
	void shoot() {
		System.out.println("총을 발사했습니다.");
	}
}
public class ExceptionEx01 {
	public static void main(String[] args) {
		//컴파일 예외 (Java가 알수잇다)
		try {
			System.out.println("잠자기 시작");
			Thread.sleep(1000); //main스레드가 1초동안 잠을 잔다.
			System.out.println("잠자기 끝");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//런타임 예외(개발자가 알 수있 다.)
		int[] nums = {1,2,3};
		try {
			System.out.println(nums[3]); //강제종료
		} catch (Exception e) {
			System.out.println("괜찮아 그냥 진행해");
			System.out.println(e.getMessage());
			e.printStackTrace(); 
		}
		총 s = null;
		try {
			s.shoot();			
		} catch (Exception e) {
			System.out.println("총이 없어 총을 만들고 다시 시도하겠습니다.");
			s=new 총();
			s.shoot();
		}
		
		System.out.println("메인스레드 종료"); //강제종료되어 실행되지않는다.
	}

}
