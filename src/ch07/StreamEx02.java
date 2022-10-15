package ch07;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamEx02 {

	public static void main(String[] args) {
		InputStream in = System.in; //System.in = 키보드에 연결된 스트림
		InputStreamReader ir = new InputStreamReader(in); //65->'A'로 바로 부호화시켜줌
		
		try {
			char[] data = new char[3];
			ir.read(data);
			System.out.println(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
