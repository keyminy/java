package design.ex04_singletone;

public class DoorMan {
	
	//static으로 직접 객체 만듬
	//static이란 main메서드를 호출하기 전,JVM이 읽어서 메모리에 올라온다.
	private static DoorMan doorMan = new DoorMan();
	
	//private static을 접근할 수 있는 getter만들기
	public static DoorMan getInstance() {
		return doorMan; 
	}

	//priavte 생성자!!
	private DoorMan() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void 쫒아내(Animal a) {
		System.out.println(a.getName() + " 쫒아내");
	}
}
