package ch07;

public class ExceptionTest {

	public static void main(String[] args) throws Exception {
		//런타임 예외(개발자가 알 수있다.)
		int[] nums = {1,2,3};
		System.out.println(nums[3]); //강제종료
		System.out.println("메인스레드 종료");
	}

}
