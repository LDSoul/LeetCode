import java.util.*;
class Test{
	public static void main(String[] args){	
		String[] strs = {"aaa","aa","aaa"};
		if(strs == null || strs.length == 0){System.out.println("null");};
		String prefix = strs[0];
		
		for(int i=1;i<strs.length;i++){
			while(strs[i].indexOf(prefix) != 0){
				prefix = prefix.substring(0,prefix.length()-1);
			}
		}
		System.out.println(prefix);
	}
}

