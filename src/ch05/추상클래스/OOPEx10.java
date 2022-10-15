package ch05.추상클래스;

/* 행위 제약 interfcae : 홀직원인 종업원과 캐셔는 손님과 talk()가능 */
interface CanAble{
	public abstract void talk();
}

abstract class 홀직원 implements CanAble{
	abstract void 청소();
	//손님과 대화하는 건 다 똑같으므로 talk()메소드를 여기다 구현
	@Override
	public void talk() {
		System.out.println("손님과 대화!");
	}
}

abstract class 종업원 extends 홀직원{
	void 서빙하기() {
		System.out.println("서빙하기");
	}
	/*주문을 수기주문 => 키오스크 주문으로 바뀌었다면 해당 메소드 지우면됨*/
	void 주문받기() {
		System.out.println("주문받기");
	}
}

abstract class 캐셔 extends 홀직원{
	void 정산하기() {
		System.out.println("수기 정산 => 계산기 정산하기");
	}
	void 계산하기() {
		System.out.println("현금계산 => 카드 계산하기");
	}
}

abstract class 요리사{
	abstract void 요리();
}

class 홍길동 extends 종업원{

	요리사 j;
	
	@Override
	void 청소() {
		System.out.println("화장실 청소");
		
	}
	
}
class 임꺽정 extends 종업원{
	
	요리사 j;
	
	@Override
	void 청소() {
		System.out.println("주방 청소");
		
	}
	
}
class 김유신 extends 캐셔{

	@Override
	void 청소() {
		System.out.println("홀 청소");
		
	}
	
}
class 이몽룡 extends 캐셔{

	@Override
	void 청소() {
		System.out.println("테이블 청소");
		
	}
}
class 장보고 extends 요리사{

	@Override
	void 요리() {
		System.out.println("양식 만들기");
	}
}

/*장보고가 퇴사하고 정몽주가 요리사로 들어왔다면??*/
class 정몽주 extends 요리사{
	
	@Override
	void 요리() {
		System.out.println("새로와서 고민중");
	}
}

class 이순신 extends 요리사{

	@Override
	void 요리() {
		System.out.println("한식 만들기");
		
	}
	
}

public class OOPEx10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
