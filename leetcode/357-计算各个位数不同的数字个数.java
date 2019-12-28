class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        if(n==1) return 10;
        int last=9;
        int ans=10;
        n=Math.min(10, n);
        for(int i=1; i<n; ++i) {
            last = last*(10-i);
            ans+=last;
        }
        return ans;
    }
}