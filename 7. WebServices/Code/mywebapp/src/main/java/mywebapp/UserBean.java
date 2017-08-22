package mywebapp;

public class UserBean 
{
	private String userNM;
	private String firstNM;
	
	public String getUserNM() {
		return userNM;
	}
	public void setUserNM(String userNM) {
		this.userNM = userNM;
	}
	public String getFirstNM() {
		return firstNM;
	}
	public void setFirstNM(String firstNM) {
		this.firstNM = firstNM;
	}
	@Override
	public String toString() {
		return "UserBean [userNM=" + userNM + ", firstNM=" + firstNM + "]";
	}
}
