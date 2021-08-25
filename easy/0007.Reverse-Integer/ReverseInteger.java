class Solution {
    public int reverse(int x) {
        // 問題分析
        // 1. 將有號32位元整數x做反轉處理
        // 2. 若反轉後超出-2^31~2^31-1範圍，回傳0
        // 解題分析
        // 1. 用取餘數方式取得x尾數
        // 2. 新增一個變數(newResult)，專門用於原本result*10計算，並加上新取到的餘數
        // 3. 判斷溢出，檢核計算後值是否相同，因為Java如果值溢出會壞掉
        //    Ex:964632435*10 會變成 1056389758 
        int result = 0;
		int newResult = 0;
		while(x!=0){
			int a = x % 10;
			newResult = result * 10 + a;
			if((newResult-a)/10 != result ){return 0;}
			result = newResult;
			x /=10;
		}
		return result;
    }
}