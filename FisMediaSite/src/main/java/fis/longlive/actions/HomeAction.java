package fis.longlive.actions;

public class HomeAction {
	
	private String test = "It worked! from HomeAction";
	
	public String getHome(){
		return "success";
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
	
}
