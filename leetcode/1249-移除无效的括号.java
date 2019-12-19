class Solution {
    public String minRemoveToMakeValid(String s) {
        int len = s.length();
        int[] record = new int[len];
        int[] mark = new int[len];
        int start = 0;//下标从start开始
        for (int i=0; i<len; ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                record[start++] = i;
            } else if(c == ')') {
                if(start>0) {
                    --start;
                } else {
                    mark[i] = 1;
                }
            }
        }
        for(int i=0; i<start; ++i) mark[record[i]] = 1;
        StringBuffer ans = new StringBuffer();
        for (int i=0; i<len; ++i) {
            if(mark[i]==1) continue;
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}