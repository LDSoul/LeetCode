class Solution {
    public boolean isPalindrome(int x) {
        // 問題分析
        // 1. 回文判斷，有負號可能。
        // 2. 範圍在 -2^31 <= x <= 2^31 - 1
        // 解題分析
        // 1. 負號一律回傳false
        // 2. 先Reverse後，再判斷兩者是否相同
        
        if(x < 0){return false;}
		int oldX = x;
		int result = 0;
		int newResult = 0;
		while(x != 0){
			int a = x % 10;
			newResult = result * 10 + a;
			if(newResult / 10 != result){return false;}
			result = newResult;
			x/=10;
		}
		if(oldX == result){
			return true;
		}
		else{
			return false;
		}
    }
}