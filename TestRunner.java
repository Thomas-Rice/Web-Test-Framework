package automationFramework;
import java.io.IOException;

import automationFramework.Tests.checkURLOpens;

public class TestRunner {

	public static void main(String[] args) throws IOException {
		checkURLOpens testObj = new checkURLOpens();
		testObj.test();
	
	}

}
