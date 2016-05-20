import java.math.BigInteger;
import java.lang.Object;
import java.util.*;

public class MyTest {

  public static int hashCode(String input){
    final int TABLE_SIZE = 101;
    int hash = 0;
    //int strlen = input.length();
    int sum = 0;
    for (int i = 0; i < input.length(); i++) {
      //hash = hash*17 +
      sum = sum*31 + input.charAt(i);
    }
    hash = sum%TABLE_SIZE;
    return hash;
}

  public static int[] stringToBitseq(String s){ //molly16
		String characters = "123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] charArray = s.toCharArray(); // [m] [o] [l] [l] [y] [1] [6]
		int[] arr = new int[charArray.length]; //initialize arr[] length 5
		int[] bitString = new int[96]; //int array bitString length 96
		String[] strBit = new String[arr.length]; //[] [] [] [] [] [] [] empty same length as molly
		String bits = ""; //empty string var

		for(int i = 0; i < charArray.length; i++){
			arr[i] = characters.indexOf(charArray[i]) + 1;
      System.out.print("Position: " + arr[i] + " ");
			strBit[i] = Integer.toString(arr[i], 2);
     System.out.println(" | Binary: " + strBit[i] + " ");
		}
    for(int i = 0; i < strBit.length; i++){
			while(strBit[i].length() != 6){
				strBit[i] = "0" + strBit[i]; //padding
			}
			bits = bits.concat(strBit[i]); //mix it together
		}

		while(bits.length() != 96){
			bits = "0" + bits;
		}

		for(int i = 0; i < bits.length(); i++){
			bitString[i] = Integer.parseInt(String.valueOf(bits.charAt(i)));
		}
		return bitString;
  }

  public static int[] bitseqToDigitSeq(int[] bitseq, int k){
		//put into chunks of six, pass to following
		//Integer.valueOf(binaryValue,baseCurrentlyIn)
		//store into array
		String chunk = "";
		int digitLen = bitseq.length/k;
		int[] digitseq = new int[digitLen];
		int numDigits = 0;
		int digit = 0;
		int looptimes = (bitseq.length+k)-(bitseq.length%k);
		for(int i = 0; i<looptimes; i++){
			if(i%(k+1) == 0 && i>0){
				digitseq[i/k-1] = Integer.valueOf(chunk,2);
				chunk = "";
			}else{
				if(i<bitseq.length)
				chunk = chunk+bitseq[i];
				else
				chunk = chunk+"0";
			}
		}
		return digitseq;
	}


  public static void main(String[] args) {
    //BigInteger bi = new BigInteger("moLLY1", 2);
    //System.out.println("bignum: " + bi);

      /*String s = "molly16";
      String t = "";
      for (int i = 0; i < s.length(); ++i) {
          char ch = s.charAt(i);
          if (!t.isEmpty()) {
              t += " ";
          }
          int n = (int)ch - (int)'a' + 1;
          t += String.valueOf(n);
      }
      System.out.println(t);*/
      //System.out.println(hashCode("a"));
    //  stringToBitseq("molly1");
     // System.out.println(bitseqToDigitSeq(stringToBitseq("moLLY1"), 4));

		int customerId = 0;
		//m: prime number
		//table size of currently allocated hash table
		int m = 31; 
		System.out.println("m: " + m);
		int w = (int)(Math.log(m)/(Math.log(2))); //width of binary rep of digits {0,..,m-1} to the base m
		System.out.println("w: " + w);
		int bs = (6*16);
		System.out.println("bs: " + bs);
		int k = (int) Math.ceil((int)(bs/w));
		System.out.println("k: " + k);
  }
}
