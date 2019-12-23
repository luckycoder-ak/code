class Solution {
    public int totalFruit(int[] tree) {
        int ans = 0;
        int len = tree.length;
        int one=-1, two=-1;
        int inx_one=-1, inx_two=-1;
        int last=0;
        for(int i=len-1; i>=0; --i) {
            if(one == -1) {
                one = tree[i];
                inx_one = i;
                ans = 1;
                last=1;
            } else if(tree[i]!=one&&two == -1){
                ans++;
                two = one;
                inx_two = inx_one;
                one = tree[i];
                inx_one = i;
                last=ans;
            } else { // 都不为0
                if(tree[i] == one) { // 与最近的那个相等
                    ans = Math.max(ans, last+1);
                    inx_one = i;
                    last++;
                } else if(tree[i] == two){
                    ans = Math.max(ans, last+1);
                    last++;
                    // swap实现
                    int tmp, inx_tmp;
                    tmp = one;
                    inx_tmp = inx_one;
                    one = two;
                    inx_one = i;
                    two = tmp;
                    inx_two = inx_tmp;
                }
                else {
                    ans = Math.max(ans, inx_two-i);
                    last = inx_two-i;
                    two = one;
                    inx_two = inx_one;
                    one = tree[i];
                    inx_one = i;
                }
            }
        }
        return ans;
    }
}