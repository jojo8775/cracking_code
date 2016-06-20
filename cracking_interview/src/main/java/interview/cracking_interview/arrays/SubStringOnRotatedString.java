package interview.cracking_interview.arrays;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Assume you have a method isSubstring which checks if one word is a substring
 * of another. Given two strings, s1 and s2, write code to check if s2 is a
 * rotation of s1 using only one call to isSubstring (i.e., “waterbottle” is a
 * rotation of “erbottlewat”)
 * 
 * @author jojo
 *
 */
public class SubStringOnRotatedString {
	public boolean isSubstring(String s1, String s2){
		if(s1.length() != s2.length()){
			return false;
		}
		
		// idea is to concatenate s1 to itself so and then check for substring
		s1 += s1;
		Pattern pattern = Pattern.compile(s2);
		Matcher matcher = pattern.matcher(s1);
		
		return matcher.find();
	}
	
	public static void main(String[] args){
		System.out.println(new SubStringOnRotatedString().isSubstring("abcd", "cdab"));
	}
}
