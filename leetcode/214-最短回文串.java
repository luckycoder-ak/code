class Solution {
    // 暴力解法。
    // 可采用KMP求最大子回文串（以第一个元素开头）
    public String shortestPalindrome(String s) {
        String s_rev = new StringBuilder(s).reverse().toString();
        int len = s.length();
        for(int i=0; i<len; ++i) {
            String s_sub = s.substring(0, len-i);
            String s_rev_sub = s_rev.substring(i, len);
            if(s_sub.compareTo(s_rev_sub) == 0) {
                StringBuilder ans = new StringBuilder(s_rev);
                i = len-i;
                while(i<len) {
                    ans.append(s.charAt(i));
                    i++;
                }
                return ans.toString();
            }
        }
        return "";
    }
}