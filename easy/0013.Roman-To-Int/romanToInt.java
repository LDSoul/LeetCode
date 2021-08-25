class Solution {
    public int romanToInt(String s) {
        // 問題分析
        // 1. 七種不同羅馬文字轉數字
        // 2. I、X、C擺在對應羅馬文字前面，代表減法。
        // 解題分析
        // 1. 倒著方式去計算總合，判斷遇到前一項要做減法時，先標記一下，讓下一步去做減法。
        // 2. 若為減法，要再去判斷下一個是不是相同字元(是代表還要再減，否則不減)，進而更新標籤。
        if(s.length() < 1 || s.length() > 15){return 0;}
		
		boolean flag = false;
		int i = s.length();
		int sum = 0; 
		while(i > 0){
			char c = s.charAt(i-1);
			if(flag == true){
				if(i != 1){
					if(s.charAt(i-2) != s.charAt(i-1)){
						flag = false;
					}
				}
				sum -= table(c);
			}
			else{
				if((c == 'V' || c == 'X') && i != 1){ // 5,10
					if(s.charAt(i-2) == 'I'){
						flag = true;
					}
					else{
						flag = false;
					}

				}
				else if((c == 'L' || c == 'C') && i != 1){ // 50,100
					if(s.charAt(i-2) == 'X'){
						flag = true;
					}
					else{
						flag = false;
					}

				}
				else if((c == 'D' || c == 'M') && i != 1){ // 500,1000
					if(s.charAt(i-2) == 'C'){
						flag = true;
					}
					else{
						flag = false;
					}
					
				}
				sum += table(c);
			}
			i--;
		}
		return sum; 
    }
    public static int table(char a){
		switch(a){
			case 'I': 
				return 1;
			case 'V': 
				return 5;
			case 'X': 
				return 10;
			case 'L': 
				return 50;
			case 'C': 
				return 100;
			case 'D': 
				return 500;
			case 'M': 
				return 1000;
			default:
				return 0;
		}
	}
}