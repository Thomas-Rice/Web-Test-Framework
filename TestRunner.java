package automationFramework;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRunner {
	
	//This will run through all the methods in a class and call each one in turn
	//Therefore we can call all the tests in a test suite.
	
	
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        // Choose the name of the test class to run
		Class c = Class.forName("automationFramework.Tests.testSuite");
		// Run all methods in the testSuite class 
        runTestSuite(c);
        
	}
	
	private static void runTestSuite(Class c) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		//Reflection enables Java code to discover information about the fields, methods and constructors of loaded classes, and to use reflected fields, methods, and constructors to operate on their underlying counterparts, within security restrictions
		Constructor constructor = c.getConstructor();
		Object testsClass = constructor.newInstance();
		//Return all methods of the class
		Method[] m = c.getDeclaredMethods();
		
		for (Method test : m) {
		    try {
		    	//Call the method of the class
		        test.invoke(testsClass);
		        System.out.printf("TestName is ---> " + test.getName() + "\n");
		    } catch (Exception e) {
		        System.out.printf("Fail to run through methods " + test.getName() + " \n" + e + " \n");
		        }
		    }
		}

}




//
//enterTextIntoSearchBox testObj = new enterTextIntoSearchBox();
//Boolean passed = testObj.test();
//
//if(passed){
//	System.out.println("Test Has Passed and Written out To file");
//}
//


//private HashMap testCases(){
//HashMap tests = new HashMap();
//tests.put("checkPageGoesForward", "checkPageGoesForward");
//tests.put("checkURLOpens", "checkURLOpens");
//tests.put("checkURLTitle", "checkURLTitle");
//tests.put("clickLoginButton", "clickLoginButton");
//tests.put("enterTextIntoSearchBox", "enterTextIntoSearchBox");
//
//return tests;
//
//}
