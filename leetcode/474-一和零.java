class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[] zero = new int[len];
        int[] one = new int[len];
        for(int i=0; i<len; ++i) { // 数1和0个数
            int sz = strs[i].length();
            for(int j=0; j<sz; ++j) zero[i]+=(strs[i].charAt(j)=='0')?1:0;
            one[i] = sz-zero[i];
        }
        int[][] res = new int[m+1][n+1]; // res[i][j] 表示i个0,j个1
        for(int i=0; i<=m; ++i) for(int j=0; j<=n; ++j) res[i][j] = -10000000;
        res[0][0] = 0;
        int ans = 0;
        for(int k=0; k<len; ++k) {
            if(zero[k] > m || one[k]>n) continue;
            for(int i=m; i>=zero[k]; --i) {
                for(int j=n; j>=one[k]; --j) {
                    res[i][j] = Math.max(res[i][j], res[i-zero[k]][j-one[k]]+1);
                    ans=Math.max(ans, res[i][j]);
                }
            }
        }
        return ans;
    }
}