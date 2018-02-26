package model;

public interface IMember {
	
	
	public void setMemberID (int memberID);
	public void setFirstName(String firstName);
	public void setLastName(String lastName);
	public void setEmailAddress(String email);
	public void setUserName(String user);
	public void setPassword(String pass);
	
	public int getMemberID();
	public String getFirstName();
	public String getLastName();
	public String getEmailAddress();
	public String getUserName();
	public String getPassword();
}
