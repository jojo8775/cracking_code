package interview.cracking_interview.hard;

import java.util.ArrayList;
import java.util.List;

public class Hard_Prob8 {
	public List<String> findMath(String[] strArr, String s){
		int[] pattern = new int[s.length()];
		
		for(int j=0,i=1; i<s.length();i++){
			if(s.charAt(j) != s.charAt(i)){
				if(j != 0){
					j = j - 1;
					while(j!=0 && pattern[j] != pattern[i]){
						j = pattern[j];
					}
				}
			}
			else{
				j = j+1;
				pattern[i] = j;
			}
		}
		
		List<String> result = new ArrayList<String>();
		for(String str : strArr){
			int i=0;
			for(int j=0; j<str.length() && i<pattern.length; j++){
				char ch = str.charAt(j);
				if(ch == s.charAt(i)){
					i++;
				}
				else if(i != 0){
					i = i-1;
					while(i!=0 && ch != s.charAt(pattern[i])){
						i = pattern[i];
					}
					
					if(ch == s.charAt(i)){
						i++;
					}
				}
			}
			
			if(i == pattern.length){
				result.add(str);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args){
		String[] words = {"sdaiiwscsd", "qwewfsiiwvdrer", "iiw", "drgweuyiiwvdb", "iiwzsfwe", "weweiiw", "asbsdiiiwsfe"};
		List<String> result = new Hard_Prob8().findMath(words, "iiw");
		print(result);
	}
	
	private static void print(List<String> words){
		for(String w : words){
			System.out.println(w);
		}
	}
}
