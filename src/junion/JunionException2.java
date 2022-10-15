package junion;

public class JunionException2 {
	public static void testException(int[] array) throws MyException{
		try {
			System.out.println(array[array.length]);
		} catch (ArrayIndexOutOfBoundsException ae) {
			System.out.println("1. " + ae.getMessage());
			throw new MyException("나는 예외다!!");
		}catch(NullPointerException ne) {
			System.out.println("2. " + ne.getMessage());
		}catch(Exception e) {
			System.out.println("3. " + e.getMessage());
		}finally {
			System.out.println("4. " + "finally");
		}
	}
	
	public static void main(String[] args) {
		int[] array= new int[10];
		for(int i=0;i<array.length;i++) {
			array[i] = i;
		}
		
		//testException(array);
		//이걸 할려면 main메소드에 throws MyException해줘야함
		
		try {
			testException(array);
		} catch (MyException me) {
			System.out.println("5. " + me.getMessage());
		}
	}
}
