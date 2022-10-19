package design.ex03_adapter;

public class TigerAdapter extends Animal{

	//Composition 하기
	private OuterTiger outerTiger;
	
	//생성자 만들기
	public TigerAdapter(OuterTiger outerTiger) {
		super();
		this.outerTiger = outerTiger;
	}
	//이렇게하면 기존의 outerTiger에 끼워맞춰짐!!
	@Override
	public String getName() {
		return outerTiger.getFullName();
	}
}
