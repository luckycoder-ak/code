class Solution {
    public static List<Integer> zero = new ArrayList<>();
    public static boolean CompareList(List<Integer> needs, List<Integer> resource) {
        int len = needs.size();
        int len2 = resource.size();
        for(int i=0; i<len; ++i) {
            if(i==len2) break;
            if(needs.get(i)<resource.get(i)) return false;
        }
        return true;
    }
    public static int dfs(List<Integer>price, List<List<Integer>> special, List<Integer> needs, int sum) {
        if(CompareList(zero,needs)) return sum;
        int ans = sum;
        for(int i=0; i<needs.size(); ++i) {
            ans += needs.get(i)*price.get(i);
        }
        int len = price.size();
        for(List<Integer> obj: special) {
            if(CompareList(needs, obj)) {
                for (int i=0; i<len; ++i) {
                    needs.set(i, needs.get(i)-obj.get(i));
                }
                ans = Math.min(ans,dfs(price, special, needs, sum+obj.get(len)));
                for (int i=0; i<len; ++i) {
                    needs.set(i, needs.get(i)+obj.get(i));
                }
            }
        }
        return ans;
    }
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        zero.clear();
        for(int i=0; i<needs.size(); ++i) zero.add(0);
        return dfs(price, special, needs, 0);
    }
}