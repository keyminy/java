package com.study;

public class QnaWrite extends AbstractWrite{
	//추상 메서드는 상속 받는 곳에서 꼭 구현 해야한다!!
	@Override
	public void init() {
		this.setBoardName("Q&A board");
	}	
}
