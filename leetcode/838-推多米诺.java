class Solution {
    public String pushDominoes(String dominoes) {
        int sz = dominoes.length();
        int[] check = new int[sz];
        int add_right = 0;
        int add_left = 0;
        StringBuffer ans = new StringBuffer();
        for(int i=sz-1; i>=0; --i) {
            if (dominoes.charAt(i) == 'L') add_left = 1;
            else if (dominoes.charAt(i) == 'R') add_left = 0;
            else { // s.charAt(i) == '.'
                check[i]=add_left;
                if(add_left>0) add_left++;
            }
        }
        for(int i=0; i<sz; ++i) {
            if (dominoes.charAt(i) == 'R') {
                add_right = 1;
                ans.append('R');
            }else if (dominoes.charAt(i) == 'L') {
                add_right = 0;
                ans.append('L');
            }else { // s.charAt(i) == '.'
                if(check[i]==0) {
                    if(add_right==0) ans.append('.');
                    else ans.append('R');
                } else if(check[i]<add_right || add_right==0) ans.append('L');
                else if(check[i]==add_right) ans.append('.');
                else if(check[i]>add_right) ans.append('R');
                if (add_right>0) add_right++;
            }
        }
        return ans.toString();
    }
}