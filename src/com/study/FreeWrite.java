package com.study;

public class FreeWrite implements InterfaceWrite{
	
	private String boardName;
	
	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public FreeWrite() {
		this.setBoardName("Free board");
	}
	
	public void doWrite() {
		System.out.println(this.getBoardName() + " write down!!");
	}

}
