class Solution {
    public int lastRemaining(int n) {
        int step = 1; //步长
        int ans = n;
        int del = 1;
        while(n>1) {
            if((del == 1 && n%2==1) || (del!=1)) {
                ans-=step;
            }
            n>>=1;
            if(del==1) del = n;
            else del = 1;
            step <<=1;
        }
        return ans;
    }
}