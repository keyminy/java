package ch05.추상클래스;

//모든 동물들에게 행위에대한 제한을 주고싶다 = interface
interface MoveAble{
	//public abstract가 생략되어있어요!
	void 위();
	void 아래();
	void 왼쪽();
	void 오른쪽();
	//사나운동물 동작 추가
	void 냄새맡기();
}

//온순한 동물은 행위에 대한 제약을 사나운 동물과 다르게 주고파..
//implements도 Moveable2를 구현하게함
//온순한 동물은 땅바닥숨기() 옵션 주었다.
interface MoveAble2{
	void 위();
	void 아래();
	void 왼쪽();
	void 오른쪽();
	void 땅바닥숨기();
}


abstract class 사나운동물 implements MoveAble{
	abstract void 공격();
	@Override
	public void 아래() {
		System.out.println("아래로 이동");
	}
	@Override
	public void 위() {
		System.out.println("위로 이동");
	}
	@Override
	public void 오른쪽() {
		System.out.println("오른쪽로 이동");
		
	}
	@Override
	public void 왼쪽() {
		System.out.println("왼쪽으로 이동");
	}
	@Override
	public void 냄새맡기() {
		// 냄새맡는 것은 사나운 동물의 공통점이므로 추상클래스에서 구현한다.
		System.out.println("코로 냄새맡기");
	}
}
abstract class 온순한동물 implements MoveAble2{
	abstract void 채집();

	@Override
	public void 아래() {
		System.out.println("아래로 이동");
	}
	@Override
	public void 위() {
		System.out.println("위로 이동");
	}
	@Override
	public void 오른쪽() {
		System.out.println("오른쪽로 이동");
		
	}
	@Override
	public void 왼쪽() {
		System.out.println("왼쪽으로 이동");
	}

	@Override
	public void 땅바닥숨기() {
		System.out.println("땅바닥으로 숨기!");
	}
	
}

//구현이 자식 클래스로 위임됨(위,아래,왼,오 구현해주기)
class 원숭이 extends 온순한동물{

	@Override
	void 채집() {
		System.out.println("바나나 채집");
		
	}
}

class 소 extends 온순한동물{
	@Override
	void 채집() {
		System.out.println("풀 채집");
	}
}
class 호랑이  extends 사나운동물{
	@Override
	void 공격() {
		System.out.println("이빨로 공격");
	}
}
class 코뿔소 extends 사나운동물{

	@Override
	void 공격() {
		System.out.println("몸통 박치기로 공격");
	}
	
}

//신입아 말 만들어줘(온순한 동물 상속해서 만들어)
class 말 extends 온순한동물{

	@Override
	void 채집() {
		//신입이 이렇게 편하게 일을 할 수 있따!!
		System.out.println("풀을 먹다.");
	}
}

public class OOPEx09 {
	static void 조이스틱(온순한동물 u1) {
		u1.채집();
		u1.땅바닥숨기();
		u1.위();
		u1.아래();
		u1.오른쪽();
		u1.왼쪽();
		System.out.println("================");
	}
	//사나운 동물 조작하고싶다.. => 메서드 오버로딩
	static void 조이스틱(사나운동물 u1) {
		u1.공격();
		u1.위();
		u1.아래();
		u1.오른쪽();
		u1.왼쪽();
		u1.냄새맡기();
		System.out.println("================");
	}
	
	public static void main(String[] args) {
		소 u1 = new 소();
		조이스틱(u1);
		원숭이 u2 = new 원숭이();
		조이스틱(u2);
		호랑이 u3 = new 호랑이();
		조이스틱(u3);
		코뿔소 u4 = new 코뿔소();
		조이스틱(u4);
		말 u5 = new 말();
		조이스틱(u5);
	}
}
