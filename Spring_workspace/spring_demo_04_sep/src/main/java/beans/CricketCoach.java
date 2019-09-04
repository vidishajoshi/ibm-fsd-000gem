package beans;

public class CricketCoach implements Coach {

	private String teamname;
	private String email;
	public CricketCoach() {
		super();
	}
	public String getTeamname() {
		return teamname;
	}
	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "CricketCoach [teamname=" + teamname + ", email=" + email + "]";
	}
	public String getDailyWorlkout() {
		// TODO Auto-generated method stub
		return "5k daily running";
	}
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}
	
	


	
}
