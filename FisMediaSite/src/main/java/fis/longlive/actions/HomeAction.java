package fis.longlive.actions;

public class HomeAction {
	
	private String test = "Message from HomeAction";
	
	public String execute(){
		return "success";
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
	
}
