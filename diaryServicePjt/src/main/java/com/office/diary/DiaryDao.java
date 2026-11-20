package com.office.diary;

public class DiaryDao {
	
	private int diaryNo;
	private String diaryWord;
	private String memId;
	private String diaryRegDate;
	private String diarymodDate;
	
	public DiaryDao(int diaryNo, String diaryWord, String memId, String diaryRegDate, String diarymodDate) {
		super();
		this.diaryNo = diaryNo;
		this.diaryWord = diaryWord;
		this.memId = memId;
		this.diaryRegDate = diaryRegDate;
		this.diarymodDate = diarymodDate;
	}
	
	
	public DiaryDao(String diaryWord, String memId) {
		super();
		this.diaryWord = diaryWord;
		this.memId = memId;
	}




	public DiaryDao() {
		// TODO Auto-generated constructor stub
	}

	public int getDiaryNo() {
		return diaryNo;
	}

	public void setDiaryNo(int diaryNo) {
		this.diaryNo = diaryNo;
	}

	public String getDiaryWord() {
		return diaryWord;
	}

	public void setDiaryWord(String diaryWord) {
		this.diaryWord = diaryWord;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getDiaryRegDate() {
		return diaryRegDate;
	}

	public void setDiaryRegDate(String diaryRegDate) {
		this.diaryRegDate = diaryRegDate;
	}

	public String getDiarymodDate() {
		return diarymodDate;
	}

	public void setDiarymodDate(String diarymodDate) {
		this.diarymodDate = diarymodDate;
	}
	
	
	

	

}
