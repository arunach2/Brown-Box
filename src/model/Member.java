package model;

public class Member implements IMember {
	
	private int memberID;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String userName;
	private String password;
	
	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
	
	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
		
	}
	@Override
	public void setEmailAddress(String email) {
		this.emailAddress = email;
	}
	@Override
	public void setUserName(String user) {
		this.userName = user;		
	}
	@Override
	public void setPassword(String pass) {
		this.password = pass;
	}
	
	public int getMemberID() {
		return memberID;
	}
	@Override
	public String getFirstName() {
		return firstName;
	}
	@Override
	public String getLastName() {
		return lastName;
	}
	@Override
	public String getEmailAddress() {
		return emailAddress;
	}
	@Override
	public String getUserName() {
		return userName;
	}
	@Override
	public String getPassword() {
		return password;
	}
	
	
	
	
}
