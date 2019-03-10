package service.qna.model.vo;

import java.sql.Date;

public class QNA implements java.io.Serializable{
	private static final long serialVersionUID = 12L;
	
	private int qNo;
	private String category;
	private String qTitle;
	private String contents;
	private Date qDate;
	private int qHits;
	private String pwd;
	private String userId;
	private String file1;
	private String file2;
	private String file3;
	private String refile1;
	private String refile2;
	private String refile3;
	
	public QNA() {}

	public QNA(int qNo, String category, String qTitle, String contents, Date qDate, int qHits, String pwd,
			String userId, String file, String file2, String file3, String refile, String refile2, String refile3) {
		super();
		this.qNo = qNo;
		this.category = category;
		this.qTitle = qTitle;
		this.contents = contents;
		this.qDate = qDate;
		this.qHits = qHits;
		this.pwd = pwd;
		this.userId = userId;
		this.file1 = file;
		this.file2 = file2;
		this.file3 = file3;
		this.refile1 = refile;
		this.refile2 = refile2;
		this.refile3 = refile3;
	}

	public int getqNo() {
		return qNo;
	}

	public void setqNo(int qNo) {
		this.qNo = qNo;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getqTitle() {
		return qTitle;
	}

	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getqDate() {
		return qDate;
	}

	public void setqDate(Date qDate) {
		this.qDate = qDate;
	}

	public int getqHits() {
		return qHits;
	}

	public void setqHits(int qHits) {
		this.qHits = qHits;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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

	public void setFile1(String file) {
		this.file1 = file;
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

	public void setRefile1(String refile) {
		this.refile1 = refile;
	}

	public String getRefile2() {
		return refile2;
	}

	public void setRefile2(String refile2) {
		this.refile2 = refile2;
	}

	public String getRefile3() {
		return refile3;
	}

	public void setRefile3(String refile3) {
		this.refile3 = refile3;
	}

	@Override
	public String toString() {
		return qNo + ", " + category + ", " + qTitle + ", " + contents
				+ ", " + qDate + ", " + qHits + ", " + pwd + ", " + userId + ", " + file1
				+ ", " + file2 + ", " + file3 + ", " + refile1 + ", " + refile2 + ", "
				+ refile3;
	}

	


	

}
