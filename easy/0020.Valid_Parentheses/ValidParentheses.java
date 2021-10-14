import java.util.*;

class Solution {
    public boolean isValid(String s) {
        /*
            問題分析
            1. 一字串有三種括號，括號必須對應相同型態之括號，例如{ 需對應}。
            2. 左邊括號的另一邊一定要對應同樣的括號。
            解題分析
            1. 用Stack即可。
        */
        Stack<String> st = new Stack<String>();
				
		for(int i=0;i<s.length();i++){
			if(s.substring(i, i+1).equals(")") || s.substring(i, i+1).equals("]") || s.substring(i, i+1).equals("}")) {
                if(st.size() == 0) return false;
				if(method(st.pop()) != method(s.substring(i, i+1))) {
					return false;
				}
			}
			else {
				st.push(s.substring(i, i+1));
			}
		}
        if(st.size() != 0) {
			return false;
		}
		return true;
    }
    public static int method(String s) {
		if(s.equals(")") || s.equals("(")) {
			return 1;
		}
		else if(s.equals("]") || s.equals("[")) {
			return 2;
		}
		else {
			return 3;
		}
	}
}

