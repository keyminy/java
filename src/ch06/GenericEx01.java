package ch06;

/* 바구니 : 경우에는 문자열을 담고, 어떨땐 숫자를 담음
 * => Object타입으로 받자!. */
class 바구니{
	Object data;
}


public class GenericEx01 {

	public static void main(String[] args) {
		바구니 s1 = new 바구니();
		s1.data = 1;
		System.out.println(s1.data);
		//새로운 바구니 만들기
		바구니 s2 = new 바구니();
		s2.data = "문자열";
		System.out.println(s2.data);
	}

}
