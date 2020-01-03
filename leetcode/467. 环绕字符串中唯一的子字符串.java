class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] mark = new int[26];
        int len = p.length();
        for(int i=0; i<26; ++i) {
            for(int j=0; j<len; ++j) {
                if(p.charAt(j)-'a' != i) continue;
                else {
                    int sz = 1;
                    int last = (int)p.charAt(j);
                    ++j;
                    while(j<len) {
                        int t = p.charAt(j);
                        if((t-last+26)%26==1) {
                            ++sz;
                            ++j;
                            last = t;
                        } else {
                            --j;
                            break;
                        }
                    }
                    mark[i] = Math.max(mark[i], sz);
                }
            }
        }
        int ans = 0;
        for (int i=0; i<26; ++i) {
            ans += mark[i];
        }
        return ans;
    }
}