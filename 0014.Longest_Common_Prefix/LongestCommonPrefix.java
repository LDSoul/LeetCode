class Solution {
    public String longestCommonPrefix(String[] strs) {
        // 問題分析
        // 1. 搜尋"共同"最大長度前綴
        // 解題分析
        // 1. 先抓第一筆資料當作前綴
        // 2. 開始跟其他筆資料比較，若用indexOf中沒找到一樣的，就將前綴尾巴砍掉1個，直到找到為止。
		if(strs == null || strs.length == 0) return "";
		String prefix = strs[0];
		
		for(int i=1;i<strs.length;i++){
			while(strs[i].indexOf(prefix) != 0){
				prefix = prefix.substring(0,prefix.length()-1);
			}
		}
		return prefix;
    }
}