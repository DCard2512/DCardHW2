package passwordApp;

public class Password {
	private String pswrd;
	
	public Password(String s) {
		this.pswrd = s;
	}
	
	//Checks to see if the password has any spaces within the string
	public boolean hasSpace() {
		if(pswrd.contains(" "))
			return true;
		else
			return false;
			
	}
	
	
	//Checks if the length of password will be between 8 to 12 characters
	public boolean isLength() {
		if(pswrd.length() >= 8 && pswrd.length() <= 12)
			return true;
		else 
			return false;
		
	}
	
	//Finds the largest block of same characters within the password string 
	public int largestBlock() {
		int max = 0;
		int count = 1;
		
		for(int i = 1; i < pswrd.length(); i++) {
			if(pswrd.charAt(i) == pswrd.charAt(i-1)) {
				count++;
			}
			else {
				if(count > max) {
					max = count;
				}
				count = 1;
			}
		}
		
		if(count > max) {
			max = count;
		}
		return max;
	}
	
	
	
}
