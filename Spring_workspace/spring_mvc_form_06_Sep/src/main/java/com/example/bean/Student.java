package com.example.bean;

import java.util.LinkedHashMap;

import org.springframework.stereotype.Component;
@Component("student1")
public class Student {
	
	private int id;
private String fname;
private String lname;
private String email;
private String country;
private LinkedHashMap<String, String> countryOption;
private String lang;
private String os;


private String favoriteLanguage;

public Student() {
	
	// populate country options: used ISO country code
	countryOption = new LinkedHashMap<String ,String>();
	
	countryOption.put("BR", "Brazil");
	countryOption.put("FR", "France");
	countryOption.put("DE", "Germany");
	countryOption.put("IN", "India");
	countryOption.put("US", "United States of America");		

}

public String getFname() {
	return fname;
}

public void setFname(String fname) {
	this.fname = fname;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getLname() {
	return lname;
}

public void setLname(String lname) {
	this.lname = lname;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public LinkedHashMap<String, String> getCountryOption() {
	return countryOption;
}

public void setCountryOption(LinkedHashMap<String, String> countryOption) {
	this.countryOption = countryOption;
}

public String getLang() {
	return lang;
}

public void setLang(String lang) {
	this.lang = lang;
}

public String getOs() {
	return os;
}

public void setOs(String os) {
	this.os = os;
}

public String getFavoriteLanguage() {
	return favoriteLanguage;
}

public void setFavoriteLanguage(String favoriteLanguage) {
	this.favoriteLanguage = favoriteLanguage;
}

@Override
public String toString() {
	return "Student [fname=" + fname + ", lname=" + lname + ", email=" + email + ", country=" + country
			+ ", countryOption=" + countryOption + ", lang=" + lang + ", os=" + os + ", favoriteLanguage="
			+ favoriteLanguage + "]";
}



}
