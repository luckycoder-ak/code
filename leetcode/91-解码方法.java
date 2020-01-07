class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        int f1=1, f2=1;
        if(len==0 || s.charAt(0) == '0') return 0;
        for(int i=1; i<len; ++i) {
            if(s.charAt(i) == '0' && (s.charAt(i-1)>'2' || s.charAt(i-1)=='0')) return 0;
            if(s.charAt(i) == '0') {
                f2=f1;
            } else if(s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i)<='6')) {
                int f = f1+f2;
                f1 = f2;
                f2 = f;
            } else {
                f1 = f2;
            }
        }
        return f2;
    }
}