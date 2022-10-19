package design.ex03_adapter;

/*
 * 어댑터 패턴
 * : 외부 요소를 기존 시스템에 재사용하고 싶지만 아직 만들어지지 않은 경우
 * : 외부 요소를 기존 시스템에 재사용하고 싶지만 호환되지 않는 경우(O,실습하기)
 * */
public class App {
	public static void main(String[] args) {
		Mouse m = new Mouse();
		Cat c = new Cat();
		TigerAdapter ot = new TigerAdapter(new OuterTiger());
		DoorMan dm = new DoorMan();
		dm.쫒아내(m);
		dm.쫒아내(c);
		dm.쫒아내(ot);
	}
}
