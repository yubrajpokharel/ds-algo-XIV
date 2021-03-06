import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1.3
 Design an algorithm and write code to remove the duplicate characters in a string
 without using any additional buffer.

 NOTE: One or two additional variables are fine.
 An extra copy of the array is not.

 FOLLOW UP
 Write the test cases for this method.

 Time complexity is O(n2)

 eg.
 Appple
 Till 1 => Appple with length => 6
 Till 2 => Aplple with length => 6
 Till 3 => Aplele with length => 6
 Till 4 => Aple e with length => 6
 Appple(6) after removal becomes => Aple e(6)
 */

public class RemoveDuplicateCharsFromString {

	public static String removeDuplicates(char[] stringArray){
    if (stringArray == null) return "";
    int len = stringArray.length;
    if (len < 2) return "";
    char[] charsArray = stringArray; //extra copy :)
		int tailIndex = 1;
		for (int compareToIndex = 1; compareToIndex < len ; ++compareToIndex) {
			int compareWithLessThanTail;
			for (compareWithLessThanTail = 0; compareWithLessThanTail < tailIndex; ++compareWithLessThanTail) {
				if (charsArray[compareToIndex] == charsArray[compareWithLessThanTail]) break;
			}
      // if compare index reaches the tail (means nothing matched),
      // then need to take one more character ie increase tailIndex
			if (compareWithLessThanTail == tailIndex) {
        charsArray[tailIndex] = charsArray[compareToIndex];
        System.out.println("Till " + tailIndex + " => " + String.valueOf(charsArray) + " with length => " + String.valueOf(charsArray).length());
				++tailIndex;
			}
		}
    charsArray[tailIndex] = 0;
    System.out.println("Till " + tailIndex + " => " + String.valueOf(charsArray) + " with length => " + String.valueOf(charsArray).length());
		return String.valueOf(charsArray);
	}

	public static void main (String[] args) throws IOException {
    System.out.println("Enter string to remove duplicate : ");
		String str = getString(); //args[0];
    String after = removeDuplicates(str.toCharArray());
		System.out.println(str + "(" + str.length() +")"
        + " after removal becomes => " +after +"("+after.length()+")");
	}

  //reads a string from the keyboard input
  public static String getString() throws IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String s = br.readLine();
    return s;
  }

}
