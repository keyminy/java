package junion;

public class MyException extends Exception{

	private static final long serialVersionUID = 1L;

	public MyException(String message) {
		super(message+" 너도 예외이다.");
	}
	@Override
	public String toString() {
		return this.getMessage();
	}
}
 