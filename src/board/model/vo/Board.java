package board.model.vo;

import java.sql.Date;

public class Board implements java.io.Serializable{
	
	private static final long serialVersionUID = 5555L;
	
	private int bNo;			//게시글번호
	private String bTtitle;		//제목
	private String content;		//내용
	private Date bDate;			//작성일자
	private int bUp;			//조회수
	private int bHits;			//추천수
	private String userId;		//작성자
	private String file1;		//파일경로
	private String file2;		//파일경로
	private String file3;		//파일경로
	private String refile1;
	private String refile2;
	private String refile3;
	
	public Board() {}

	public Board(int bNo, String bTtitle, String content, Date bDate, int bUp, int bHits, String userId, String file1,
			String file2, String file3) {
		super();
		this.bNo = bNo;
		this.bTtitle = bTtitle;
		this.content = content;
		this.bDate = bDate;
		this.bUp = bUp;
		this.bHits = bHits;
		this.userId = userId;
		this.file1 = file1;
		this.file2 = file2;
		this.file3 = file3;
	}

	public Board(int bnum, String btitle, String bcontent, String file, String refile) {
		this.bNo = bnum;
		this.bTtitle= btitle;
		this.content = bcontent;
		this.file1 = file;
		this.refile1 = refile;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public String getbTtitle() {
		return bTtitle;
	}

	public void setbTtitle(String bTtitle) {
		this.bTtitle = bTtitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getbDate() {
		return bDate;
	}

	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}

	public int getbUp() {
		return bUp;
	}

	public void setbUp(int bUp) {
		this.bUp = bUp;
	}

	public int getbHits() {
		return bHits;
	}

	public void setbHits(int bHits) {
		this.bHits = bHits;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFile1() {
		return file1;
	}

	public void setFile1(String file1) {
		this.file1 = file1;
	}

	public String getFile2() {
		return file2;
	}

	public void setFile2(String file2) {
		this.file2 = file2;
	}

	public String getFile3() {
		return file3;
	}

	public void setFile3(String file3) {
		this.file3 = file3;
	}
	
	public String getRefile1() {
		return refile1;
	}
	
	public void setRefile1(String refile1) {
		this.refile1=refile1;
	}
	
	public String getRefile2() {
		return refile2;
	}
	
	public void setRefile2(String refile2) {
		this.refile2=refile2;
	}
	public String getRefile3() {
		return refile3;
	}
	
	public void setRefile3(String refile3) {
		this.refile3=refile3;
	}
	@Override
	public	String toString() {
		return	this.bNo +", "+this.bTtitle+", "+this.content+", "+this.bDate+", "+this.bUp+", "+this.bHits+", "+this.userId
				+", "+this.file1+", "+this.file2+", "+this.file3;
	}
}
