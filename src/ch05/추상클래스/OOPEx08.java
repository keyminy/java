package ch05.추상클래스;

abstract class 육식동물{
	void walk() {
		System.out.println("걷다.");
	}
	//미완성 설계도 -> 공격하는 부분이 다르니까 미완성으로 두고 자식에게 위임
	abstract void 공격();
}

class 뱀 extends 육식동물{

	@Override
	void 공격() {
		System.out.println("독으로 공격");
	}
	
}
class 사자 extends 육식동물{
	@Override
	void 공격() {
		System.out.println("이빨로 공격");
	}
}

public class OOPEx08 {
	public static void main(String[] args) {
		육식동물 u1 = new 사자();
		육식동물 u2 = new 뱀();
		u1.walk();
		u1.공격();
		u2.walk();
		u2.공격();
	}	
}
