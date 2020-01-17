class Solution {
static public void deleteEl(StringBuffer s) {
        int last_inx= s.length()-1;
        if(last_inx<2) return;
        char c1 = s.charAt(last_inx);
        char c2 = s.charAt(last_inx-1);
        char c3 = s.charAt(last_inx-2);
        if(c1==c2  && c2==c3) while (last_inx>=0 && s.charAt(last_inx) == c1) s.deleteCharAt(last_inx--);
        return;
    }
    static public StringBuffer getNewClone(StringBuffer s) {
        StringBuffer s_new = new StringBuffer();
        int len = s.length();
        for(int i=0; i<len; ++i) s_new.append(s.charAt(i));
        return s_new;
    }
    public static int solve(StringBuffer s, int inx, String board, int[] mark, int cnt, int used) {
        if(inx>=board.length() && s.length() == 0) return used;
        if(inx>=board.length() && cnt == used && s.length()!=0) return Integer.MAX_VALUE;
        if(inx<board.length()) {
            char cur_c = board.charAt(inx);
            s.append(cur_c);
            while (inx+1<board.length() && board.charAt(inx+1)==cur_c) {
                s.append(cur_c);
                ++inx;
            }
            deleteEl(s);
            ++inx;
        }
        int len = s.length();
        int ans = Integer.MAX_VALUE;
        if (len!=0){
            char c = s.charAt(len-1);
            if(mark[c-'A'] != 0) {
                mark[c-'A'] --;
                StringBuffer s1 = getNewClone(s);
                s1.append(c);
                if(mark[c-'A'] != 0) {
                    mark[c-'A'] --;
                    s1.append(c);
                    deleteEl(s1);
                    ans = solve(s1, inx, board, mark, cnt,  used+2);
                    mark[c-'A']++;
                }
                s1 = getNewClone(s);
                s1.append(c);
                deleteEl(s1);
                ans = Math.min(ans, solve(s1, inx, board, mark,cnt,  used+1));
                mark[c-'A'] ++;
            }
        }
        if (s.length()==0 && inx >= board.length()) ans = Math.min(ans, used);
        if(inx<board.length()) ans = Math.min(ans, solve(s, inx, board, mark, cnt, used));
        return ans;
    }
    public static int findMinStep(String board, String hand) {
        int[] mark = new int[26];
        for(int i=0; i<hand.length(); ++i) mark[hand.charAt(i)-'A']++;
        int res = solve(new StringBuffer(), 0, board, mark, hand.length(), 0);
        return (res==Integer.MAX_VALUE)?-1:res;
    }
}