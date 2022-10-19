package design.ex02_proxy;

public class DoorManProxy{
	//composition
	private DoorMan doorMan;
	
	//생성자 만들어줌
	public DoorManProxy(DoorMan doorMan) {
		super();
		this.doorMan = doorMan;
	}

	public void 쫒아내(Animal a) {
		System.out.println("안녕ㅎㅎ");//새로운 코드
		doorMan.쫒아내(a);
	}
}
