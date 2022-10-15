package ch06;

class 호랑이{
	String name = "호랑이";
}
class 사자{
	String name = "사자"; 
}

/*Object타입으로 받는 것의 단점이 있다.
 * 큰바구니에다가 경우에따라 호랑이,사자를 담아보자 */
class 큰바구니<T>{
	T data;
}

public class GenericEx02 {

	public static void main(String[] args) {
		//큰바구니<호랑이> : 호랑이를 담는 바구니 만들자.
		큰바구니<호랑이> s1 = new 큰바구니<>();
		s1.data = new 호랑이();
		System.out.println(s1.data.name);
		
		큰바구니<사자> s2 = new 큰바구니<>();
		s2.data = new 사자();
		System.out.println(s2.data.name);
	}
}
