class Solution {
    // dp[i] = (sub[j..i] in List) && dp[j-1]
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String, Boolean> mark = new HashMap<>();
        // 存入词典
        for(String x: wordDict) {
            mark.put(x, true);
        }
        //dp[i] ：表示前i个字符可以拆成一个或多个在字典中出现的单词
        int len = s.length();
        if(len == 0) return mark.get("");
        boolean[] dp = new boolean[len];
        int[] lastTrue = new int[len+1];
        int true_inx = 0;
        lastTrue[0] = -1;
        for(int i=0; i<len; ++i) {
            for(int j=true_inx; j>=0; --j) {
                if(mark.get(s.substring(lastTrue[j]+1, i+1))!=null) {
                    dp[i] = true;
                    lastTrue[++true_inx] = i;
                    break;
                }
            }
        }
        return dp[len-1];
    }
}