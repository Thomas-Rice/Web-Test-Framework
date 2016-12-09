package automationFramework;

public class baseTestTypes {

	
	public static Boolean checkStringEquals( String String1, String String2) {
		Boolean testPassed = false;
		if (String1.equals("http://" + String2)){
			System.out.println("Verification Successful - " + " " + String1 + " " + "is equal to" + " " +String2);
//			System.out.println("@@@ PASS @@@");
		}
		else{
			System.out.println("Verification Failed - " + " " + String1 + " " + "is NOT equal to" + " " + String2);
			//In case of Fail, you like to print the actual and expected URL for the record purpose
//			System.out.println("@@@ Fail @@@");
		}
		return testPassed;
	}
	
	
	
	
}
