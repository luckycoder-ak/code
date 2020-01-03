class Solution {
    static HashMap<Long,Long> map = new HashMap<>();
    static HashMap<Integer, Boolean> mark = new HashMap<>();
    public int numFactoredBinaryTrees(int[] A) {
        map.clear();
        mark.clear();
        int Mod = 1000000007;
        int ans=0;
        Arrays.sort(A);
        for(int i=0; i<A.length; ++i) {
            int target = A[i];
            mark.put(target, true);
            long res = 1;
            for(int j=0; j<i; ++j) {
                int m = target/A[j];
                if(A[j]>m) break;
                if(m*A[j] == target && mark.get(m)!=null) { //find
                    long tmp = map.get(Long.valueOf(A[j]))*map.get(Long.valueOf(m));
                    if(m==A[j]) res += tmp;
                    else res += 2*tmp;
                }
                res%=Mod;
            }
            ans += (int)res;
            ans%=Mod;
            map.put(Long.valueOf(A[i]), Long.valueOf(res));
        }
        return ans;
    }
}