package user.model.vo;

import java.sql.Date;

public class User implements java.io.Serializable {
	private static final long serialVersionUID = 4L;
	
	private String userId;
	private String userNm;
	private String userPwd;
	private String nickName;
	private Date birth;
	private String gender;
	private String address;
	private String email;
	private String purpose;
	private String agreeYN;
	private String profile;
	private int weight;
	private int cautionCount;
	private int score;
	private String dropYN;
	private Date enrollDate;
	private String partnerId;
	
	public User() {}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getAgreeYN() {
		return agreeYN;
	}

	public void setAgreeYN(String agreeYN) {
		this.agreeYN = agreeYN;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getCautionCount() {
		return cautionCount;
	}

	public void setCautionCount(int cautionCount) {
		this.cautionCount = cautionCount;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getDropYN() {
		return dropYN;
	}

	public void setDropYN(String dropYN) {
		this.dropYN = dropYN;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return userId + ", " + userNm + ", " + userPwd + ", " + nickName
				+ ", " + birth + ", " + gender + ", " + address + ", " + email + ", "
				+ purpose + ", " + agreeYN + ", " + profile + ", " + weight + ", "
				+ cautionCount + ", " + score + ", " + dropYN + ", " + enrollDate
				+ ", " + partnerId;
	}
	
	
}
