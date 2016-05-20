import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class BestStuffEver {

	public static void main(String args[])throws IOException{
		UIMS hashtable = new UIMS();
               hashtable.salt = hashtable.generateSalt();

		Scanner in = new Scanner(new File("INPUT"));

		while(in.hasNextLine()){
			String UI = in.nextLine();

			if(inputCorrect(UI)){
				if(hashtable.isAvailable(UI)){	//check if User ID already exist in hashtable
					hashtable.add(UI);
				}

				//check if hashtable needs doubling and reallocation
                                if(hashtable.load(hashtable.m, hashtable.customerId)){
                                        hashtable.userT = hashtable.reallocate(hashtable.userT);
                                }

			}
		}
		in.close();
		hashtable.printCurrentState(); //write state of hashtable to a file
	}

	//inputCorrect
	//checks if user ID is within 16 characters and if it has non-alphanumeric characters
	static boolean inputCorrect(String UI){
                //for finding if string contains special character (stackOverflow.com)
                Pattern regex = Pattern.compile("[^A-Za-z0-9]");
                Matcher match;
	        match = regex.matcher(UI);
                boolean specialChar = match.find();

                //incorrect input
                if(UI.length() > 16){
                       System.out.println(UI + " has more than 16 characters");
			return false;
                }
                else if(specialChar){
                       System.out.println(UI + " can only contain 0-9, a-z, or A-Z");
			return false;
                }
                //correct input
                else{
			return true;
		}

	}
}