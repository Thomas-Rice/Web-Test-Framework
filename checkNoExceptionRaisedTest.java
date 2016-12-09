package automationFramework;
import automationFramework.Tests.checkURLOpens;

public class checkNoExceptionRaisedTest {

	static int testPassed = 0;
	
	public static void evalPassed( checkURLOpens testObj){
		
		try{
			Boolean passed = testObj.test();
			testPassed = 1;
			System.out.println(passed);
		}
		catch (Exception e){
			System.out.print("@@@ Fail @@@");
			System.out.print("Exception Raised in Test");
			System.out.print(e);
			
		}

	}
}
