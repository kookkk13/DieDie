package service.qna.model.vo;

import java.sql.Date;

public class QNAReply implements java.io.Serializable{
	private static final long serialVersionUID = 13L;
	
	private int qRpNo;
	private Date qdate;
	private String content;
	private String userId;
	private int qNo;
	
	public QNAReply() {}

	public QNAReply(int qRpNo, Date qdate, String content, String userId, int qNo) {
		super();
		this.qRpNo = qRpNo;
		this.qdate = qdate;
		this.content = content;
		this.userId = userId;
		this.qNo = qNo;
	}

	public int getqRpNo() {
		return qRpNo;
	}

	public void setqRpNo(int qRpNo) {
		this.qRpNo = qRpNo;
	}

	public Date getQdate() {
		return qdate;
	}

	public void setQdate(Date qdate) {
		this.qdate = qdate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getqNo() {
		return qNo;
	}

	public void setqNo(int qNo) {
		this.qNo = qNo;
	}

	@Override
	public String toString() {
		return qRpNo + ", " + qdate + ", " + content + ", " + userId
				+ ", " + qNo;
	}

	
	

}
