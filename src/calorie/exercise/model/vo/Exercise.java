package calorie.exercise.model.vo;

public class Exercise implements java.io.Serializable {
	private static final long serialVersionUID = 227L;
	
	private int exerNo;
	private String exerNm;
	private double met;
	private int exerTime;
	private double exerKcal;
	
	public Exercise() {}

	public Exercise(int exerNo, String exerNm, double met, int exerTime, double exerKcal) {
		this.exerNo = exerNo;
		this.exerNm = exerNm;
		this.met = met;
		this.exerTime = exerTime;
		this.exerKcal = exerKcal;
	}

	public int getExerNo() {
		return exerNo;
	}

	public void setExerNo(int exerNo) {
		this.exerNo = exerNo;
	}

	public String getExerNm() {
		return exerNm;
	}

	public void setExerNm(String exerNm) {
		this.exerNm = exerNm;
	}

	public double getMet() {
		return met;
	}

	public void setMet(double met) {
		this.met = met;
	}

	public int getExerTime() {
		return exerTime;
	}

	public void setExerTime(int exerTime) {
		this.exerTime = exerTime;
	}

	public double getExerKcal() {
		return exerKcal;
	}

	public void setExerKcal(double exerKcal) {
		this.exerKcal = exerKcal;
	}

	@Override
	public String toString() {
		return "exerNo : " + exerNo + ", exerNm : " + exerNm + ", met : " + met + ", exerTime : " + exerTime
				+ ", exerKcal : " + exerKcal;
	}
	
	
	
	
	
	
	
	
	

}
