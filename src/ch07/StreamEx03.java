package ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamEx03 {

	public static void main(String[] args) {
		InputStream in = System.in;;
		InputStreamReader ir = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(ir);
		
		/*Buffer는 배열로 받는게 아닌,
		 * String으로 데이터를 받을 수 있다.*/
		try {
			String data = br.readLine();
			System.out.println(data);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
