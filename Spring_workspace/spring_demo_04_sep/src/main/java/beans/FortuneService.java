package beans;

import org.springframework.stereotype.Component;

@Component
public class FortuneService implements FortuneInterface{

	public String getFortune() {
		
		return "today is not a lucky day";
	}

}
