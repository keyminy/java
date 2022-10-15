package junion;

public class JunionException1 {

	public static void main(String[] args) throws Exception  {
		int[] array = new int[10];
		for(int i=0;i<array.length;i++) {
			array[i] = i;
		}
		String s = null;
		try {
			System.out.println(array[array.length]);
			s.toString(); //NullPointException
		} catch (ArrayIndexOutOfBoundsException ae) {
			System.out.println("1. " + ae.getMessage());
			throw new Exception("나는 예외다!");//throw한 Exception을 받아 줄 녀석이 필요하다.
			//main이 받아주고, main이 다시 JVM에게 던진다.
			//단 finally먼저 실행해주고 이루어짐.!!
		} catch(NullPointerException ne) {
			System.out.println("2. " + ne.getMessage());
		}catch(Exception e)   {
			System.out.println("3. " + e.getMessage());
		}finally {
			System.out.println("4. " + "finally");
		}
	}

}
