package ch01;

class Note{
	int price = 2000;
}

public class VarEx05 {

	public static void main(String[] args) {
		Note note1 = new Note(); //heap공간에 Note클래스가 가지고 있는 모든 데이터를 할당해!!(대신 static제외)
		Note note2 = new Note(); //heap공간
		Note note3 = new Note(); //heap공간
		int age = 25;//main의 stack공간
		System.out.println(note1.price);
		System.out.println(note1.price);
		System.out.println(note1.price);
	}

}
