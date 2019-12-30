class Solution {
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> ans = new HashSet<>();
        Set<Integer> last = new HashSet<>();
        Set<Integer> tmp = new HashSet<>();
        int len = A.length;
        for(int i=0; i<len; ++i) {
            Iterator it = last.iterator();
            tmp.clear();
            while (it.hasNext()) {
                int x = (int)it.next();
                ans.add(x|A[i]);
                tmp.add(x|A[i]);
            }
            ans.add(A[i]);
            tmp.add(A[i]);
            last.clear();
            Iterator its = tmp.iterator();
            while (its.hasNext()) last.add((int)its.next());
        }
        return ans.size();
    }
}