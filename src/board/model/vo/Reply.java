package board.model.vo;

import java.sql.Date;

public class Reply implements java.io.Serializable{

	   private static final long serialVersionUID = 5556L;
	   
	   private int rNo;
	   private Date rdate;
	   private String rcontent;
	   private String userId;
	   private int rbNo;
	   
	   public Reply() {}
	   
	   public Reply(int rNo, Date rdate, String rcontent, String userId, int rbNo) {
		super();
		this.rNo = rNo;
		this.rdate = rdate;
		this.rcontent = rcontent;
		this.userId = userId;
		this.rbNo = rbNo;
	   }

	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
	}

	public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getRbNo() {
		return rbNo;
	}

	public void setRbNo(int rbNo) {
		this.rbNo = rbNo;
	}
	  	
	@Override
	public String toString() {
		return this.getrNo()+", "+this.getRcontent()+", "+this.getUserId()+", "+this.getRdate()+", "+this.getRbNo();
	}
}
