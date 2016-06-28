package interview.cracking_interview.recursion;

public class Permute
{
	public void permute(String str){
		permute("", str);
	}
	
	private void permute(String soFar, String rem){
		if(rem.isEmpty()){
			System.out.println(soFar);
			return;
		}
		
		for(int i=0; i<rem.length(); i++){
			permute(soFar + rem.charAt(i), rem.substring(0,i) + rem.substring(i+1));
		}
	}
	
	public static void main(String[] args){
		new Permute().permute("abc");
	}
}
