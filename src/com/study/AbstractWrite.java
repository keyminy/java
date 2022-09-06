package com.study;

abstract class AbstractWrite {

	private String boardName;
	
	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	
	public AbstractWrite() {
		// TODO Auto-generated constructor stub
		this.init();
	}
	
	/*초기화 함수*/
	//추상 메서드는 상속 받는 곳에서 꼭 구현 해야한다!!
	abstract void init();
	
	public void doWrite() {
		System.out.println(this.getBoardName() + " write down!!");
	}
}
