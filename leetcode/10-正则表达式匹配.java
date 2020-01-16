class Solution {
    public boolean isMatch(String s, String p) {
        int s_len = s.length();
        int p_len = p.length();
        if(s_len>0 && p_len==0) return false;
        if(s_len==0 && p_len==0) return true;
        boolean[][] arr = new boolean[s_len+1][p_len+1];
        for(int i=0; i<=s_len; ++i) Arrays.fill(arr[i],false);
        arr[0][0] = true;
        for(int j=1; j<=p_len; ++j) {
            char pj = p.charAt(j-1);
            if(pj == '*') arr[0][j] = arr[0][j-2];
            else {
                if(j==p_len || p.charAt(j)!='*') {
                    arr[0][j] = false;
                } else arr[0][j] = arr[0][j-1];
            }
        }
        for (int i=1; i<=s_len; ++i) {
            char si = s.charAt(i-1);
            for (int j=1, k=0; j<=p_len; ++j, ++k) {
                char pj = p.charAt(k);
                if(pj == '.') { // 则p[j] == s[i]
                    arr[i][j] = arr[i-1][j-1];//前移
                    if(j!=p_len && p.charAt(k+1) =='*') { // .*情况
                        arr[i][j] |= arr[i][j-1];
                        arr[i][j] |= arr[i-1][j];
                    }
                } else if(pj=='*') {
                    char pj_1 = p.charAt(k-1);
                    if(pj_1 == '.' || pj_1 == si) {
                        arr[i][j]  = arr[i-1][j-2];
                        arr[i][j] |= arr[i-1][j-1];
                    }
                    else {
                        arr[i][j] = arr[i][j-2];
                    }
                    arr[i][j] |= arr[i][j-2];
                } else {
                    if (pj == si) arr[i][j] = arr[i-1][j-1];
                    else { // pj != si
                        if(j==p_len) arr[i][j] = false;
                        else {
                            char pj1 = p.charAt(k+1);
                            if(pj1 == '*') arr[i][j] = arr[i][j-1];
                            else arr[i][j] = false;
                        }
                    }
                }
            }
        }
        return arr[s_len][p_len];
    }
}