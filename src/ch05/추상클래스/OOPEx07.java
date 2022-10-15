package ch05.추상클래스;

abstract class Animal{
	abstract void speak(); //껍데기 만 만듬
	//추상메서드 (몸체 {}가 없다)
}

class Dog extends Animal{
	//오버 라이드(Animal의 speak()가 무효화된다.)
	void speak() {
		System.out.println("멍멍");
	}; //껍데기 만듬
}

class Cat extends Animal{
	//오버 라이드(Animal의 speak()가 무효화된다.)
	void speak() {
		System.out.println("야옹");
	}; //껍데기 만듬
}

//신입아 , Bird를 만들어!!,Animal을 상속해서 만들고 sysout 쨱쨱!!
class Bird extends Animal{

	@Override
	void speak() {
		System.out.println("짹쨱");
	}
	
}

public class OOPEx07 {
	public static void main(String[] args) {
		//메모리에 뛰우기
		Animal a1 = new Dog();
		Animal a2 = new Cat();
		Animal a3 = new Bird();
		a1.speak();//부모의 speak()가 무효화되어, 자식의 speak()가 호출되는 동적바인딩 일어남
		a2.speak();
		//a1과 a2변수의 타입을 Animal타입으로 일치시킬 수 있다!!
		
		//Animal a3 = new Animal(); //이 불가하다(인스턴스로 만들 수가 없어)
		a3.speak();
	}
}
