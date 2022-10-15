package ch05.추상클래스;

interface RemoconAble{
	public void 초록버튼();
	public void 빨간버튼();
}

class Samsung implements RemoconAble{

	@Override
	public void 초록버튼() {
		System.out.println("전원 켜짐");
	}

	@Override
	public void 빨간버튼() {
		System.out.println("전원 꺼짐");
	}
	
}
class LG implements RemoconAble{
	@Override
	public void 초록버튼() {
		System.out.println("전원 켜짐");
	}

	@Override
	public void 빨간버튼() {
		System.out.println("전원 꺼짐");
	}
}

public class ExampleEx01 {

	public static void main(String[] args) {
		// 삼성 리모콘 2개 만들기(new2번)
		Samsung s1 = new Samsung();
		Samsung s2 = new Samsung();
		// LG 리모콘 2개 만들기(new 2번)
		LG g1 = new LG();
		LG g2 = new LG();
	}

}
