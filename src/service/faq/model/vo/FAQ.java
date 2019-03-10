package service.faq.model.vo;

public class FAQ implements java.io.Serializable{
	private static final long serialVersionUID = 14L;
	
	private int fNo;
	private String fTitle;
	private String content;
	private String userId;
	
	public FAQ() {}

	public FAQ(int fNo, String fTitle, String content, String userId) {
		super();
		this.fNo = fNo;
		this.fTitle = fTitle;
		this.content = content;
		this.userId = userId;
	}

	public int getfNo() {
		return fNo;
	}

	public void setfNo(int fNo) {
		this.fNo = fNo;
	}

	public String getfTitle() {
		return fTitle;
	}

	public void setfTitle(String fTitle) {
		this.fTitle = fTitle;
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

	@Override
	public String toString() {
		return fNo + ", " + fTitle + ", " + content + ", " + userId;
	}

	
	
}

