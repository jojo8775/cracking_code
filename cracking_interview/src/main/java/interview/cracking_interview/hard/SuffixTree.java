package interview.cracking_interview.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuffixTree {
	private SuffixNode root = new SuffixNode();
	public SuffixTree(String str) {
		for(int i=0; i<str.length(); i++){
			root.insert(str.substring(i), i);
		}
	}
	
	public List<Integer> getIndex(String s){
		return root.getIndex(s);
	}
	
	private static class SuffixNode{
		public Map<Character, SuffixNode> children = new HashMap<Character, SuffixNode>();
		public List<Integer> index = new ArrayList<Integer>();
		
		public void insert(String s, int idx){
			index.add(idx);
			if(s != null && !s.isEmpty()){
				SuffixNode child = null;
				char ch = s.charAt(0);
				if(children.containsKey(ch)){
					child = children.get(ch);
				}
				else{
					child = new SuffixNode();
					children.put(ch, child);
				}
				
				child.insert(s.substring(1), idx);
			}
		}
		
		public List<Integer> getIndex(String str){
			if(str == null || str.isEmpty()){
				return index;
			}
			
			char ch = str.charAt(0);
			if(children.containsKey(ch)){
				return children.get(ch).getIndex(str.substring(1));
			}
			
			return null;
		}
	} 
}
