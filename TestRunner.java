package automationFramework;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.Map.Entry;


public class TestRunner {
	
	//This will run through all the methods in a class and call each one in turn
	//Therefore we can call all the tests in a test suite.
	
	
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        // Choose the name of the test class to run
		Class c = Class.forName("automationFramework.Tests.Google_testSuite");
		// Run all methods in the testSuite class 
        runTestSuite(c, true);
        
	}
	
	private static void runTestSuite(Class c, Boolean invoke) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Boolean testResult = null;
		int testTotalCounter = 0;
		int testPassCounter = 0;
		HashMap<String, ArrayList> tests = new HashMap<String, ArrayList>();
		
		//Reflection enables Java code to discover information about the fields, methods and constructors of loaded classes, and to use reflected fields, methods, and constructors to operate on their underlying counterparts, within security restrictions
		Constructor constructor = c.getConstructor();
		Object testsClass = constructor.newInstance();
		//Return all methods of the class
		Method[] m = c.getDeclaredMethods();

		
		for (Method test : m) {
			//Count the amount of tests being run
			testTotalCounter = testTotalCounter + 1; 
		    try {
		    	if (invoke){
		    		//Get the test start time
		    		long start = System.currentTimeMillis();
					System.out.println("************************ Running Test ************************");
					System.out.printf("********************** " + test.getName() + " *********************** \n" );
					
			    	//Call the method of the class
		    		testResult = (Boolean) test.invoke(testsClass);
		    		
		    		//Get the test stop time
		    		long totalTestTime = testTime(start);
		    		//Add test data to the ArrayList
		    		ArrayList testArrayList = testData(test.getName(), testResult, totalTestTime);
		    		tests.put(test.getName(), testArrayList);
		    		
		    		// Count the amount of passed tests for later evaluation
		    		if(testResult){
		    			testPassCounter +=1;
		    		}
		    	}
		    } 
		    catch (Exception e) {
		        System.out.printf("Fail to run through methods " + test.getName() + " \n" + e + " \n");
		        }
		}
		printTestResults(tests, testTotalCounter, testPassCounter);
		
	}
	
	//Prints all the tests in the given class/testSuite
	public void printAvailableTests(String testSuite) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        // Choose the name of the test class to run
		Class c = Class.forName(testSuite);
		// Run all methods in the testSuite class 
        runTestSuite(c, true);
	}
	
	
	//Prints all the test data for each test in a nicer format.
	private static void printTestResults( HashMap<String, ArrayList> tests, int testTotalCounter, int testPassCounter){
		String testPassed;
	    for (Entry<String, ArrayList> entry : tests.entrySet()) {
	    	
	    	//If the testPassed comes in as null or flase then we change the output to Flase to make it more readable
	        if((boolean) entry.getValue().get(1) != true){
	        	testPassed = "False";
	        }
	        else{
	        	testPassed = "True";
	        }
	        
	        //Print out all of the test data in the arrayList
	        System.out.println("*************************************************" + "\n");
	        System.out.println("Test => " + entry.getKey() + "\n");
	        System.out.println("Test Passed? => " + testPassed + "\n");
	        System.out.println("Test Time => " + entry.getValue().get(2)+ " Seconds" + "\n");
	    }
	    float overallResult = (( testPassCounter*100 /testTotalCounter));
	    System.out.println("************** " +  overallResult + "% of tests passed" + " **************"+"\n");
	}
	

	//Calculates the time of the test
	private static long testTime(long startTime){	
	long stopTime = System.currentTimeMillis();
	long elapsedTime = ((stopTime - startTime)/ 1000);
//	System.out.println(elapsedTime);
	return elapsedTime;
}


// I don't like this but its an array that is hard cast to take the test data. This should be more dynamic
private static ArrayList testData (String testName, Boolean testPassed, Long testTime){
	
	ArrayList testData = new ArrayList();
	testData.add(testName);
	testData.add(testPassed);
	testData.add(testTime);
	
	return testData;


}







}

