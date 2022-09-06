package com.study;

import java.util.HashMap;
import java.util.Map;

public class Board {
	
	private AbstractWrite write = new QnaWrite();
	//추상메서드 타입으로 받아 주었습니다.
	public void boardWrite() {
		write.doWrite();
	}
}
