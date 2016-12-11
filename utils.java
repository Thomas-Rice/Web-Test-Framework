package automationFramework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class utils {

	public static String readFile(String fileName) throws IOException {
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

	public static void writeFile(String fileName, String content) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
	    
	    try {
	    	bw.write(content);
	        }

	     finally {
	    	bw.close();
	    }
	}
	
	
	
}
