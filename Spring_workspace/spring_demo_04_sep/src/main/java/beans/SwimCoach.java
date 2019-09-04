package beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach{
    @Value("admin@g.com")
    //@Value("${foo.email}"
	private String email;
    @Value("the spring team")
    private String teamName;
    
    private FortuneService service;
    @Autowired
    public SwimCoach(FortuneService service) {
    	super();
    	this.service=service;
    }
	public SwimCoach() {
		super();
	}
	public SwimCoach(String email, String teamName) {
		super();
		this.email = email;
		this.teamName = teamName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public FortuneService getService() {
		return service;
	}
	public void setService(FortuneService service) {
		this.service = service;
	}
	@Override
	public String toString() {
		return "SwimCoach [email=" + email + ", teamName=" + teamName + ", service=" + service + "]";
	}
	public String getDailyWorlkout() {
		// TODO Auto-generated method stub
		return "go swim";
	}
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return service.getFortune();
	}
	@PostConstruct
	public void setWaterLevel()
	{
		System.out.println("make water level high.");
	}
	@PreDestroy
	public void destroySwim()
	{
		System.out.println("pre destroy called..");
	}
    
    
	
}
