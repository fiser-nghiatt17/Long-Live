package fis.longlive.action;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport{
	
	private String test = "If you see that, It means It worked!";
	
	public String getHome(){
		return SUCCESS;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
	
}
