package automationFramework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class baseTestTypes {

	
	public static Boolean checkStringEquals( String String1, String String2) {
		Boolean testPassed = false;
		if (String1.equals("http://" + String2)){
			System.out.println("Verification Successful - " + " " + String1 + " " + "is equal to" + " " +String2);
			System.out.println("@@@PASS@@@");
			testPassed = true;
		}
		else{
			System.out.println("Verification Failed - " + " " + String1 + " " + "is NOT equal to" + " " + String2);
			//In case of Fail, you like to print the actual and expected URL for the record purpose
			System.out.println("@@@Fail@@@");
		}
		return testPassed;
	}
	
	
	//This probably wont work as the sources seem to be dynamic
	public static Boolean checkSourceAgainstReference(String source1, String referencePath) throws IOException{
		Boolean testPassed = false;
		
		writeFile(referencePath, source1);

		String test = readFile(referencePath);
//		System.out.println(source1);
//		System.out.println(test);
		
		if (source1.equals(test)){
			System.out.println("@@@PASS@@@");
			testPassed = true;
		}
		else{
			System.out.println("@@@Fail@@@");
			System.out.println("Page Sources Are Not The Same");
		}
		return testPassed;
	}
	
	


private static String readFile(String fileName) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(fileName));
    
    try {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append("\n");
            line = br.readLine();
        }
        return sb.toString();
    } finally {
        br.close();
    }
}

private static void writeFile(String fileName, String content) throws IOException {
	BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
    
    try {
    	bw.write(content);
        }

     finally {
    	bw.close();
    }
}







}
