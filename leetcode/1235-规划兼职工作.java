class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<obj> list = new ArrayList<>();
        int n = startTime.length;
        int i, j;
        for(i=0; i<n; ++i) {
            list.add(new obj(startTime[i], endTime[i], profit[i]));
        }
        Collections.sort(list);
        int[] dp = new int[n+2];
        for(i=n-1; i>=0; --i) { //第一个到第n个
            obj x = list.get(i);
            for(j=i+1; j<n; ++j) {
                if(list.get(j).st>=x.et) break;
            }
            dp[i] = Math.max(dp[i+1], x.pt+dp[j]);
        }
        return dp[0];
    }
    static class obj implements Comparable<obj>{
        public int st;
        public int et;
        public int pt;
        public obj(int ast, int aet, int apt){
            this.st = ast;
            this.et = aet;
            this.pt = apt;
        }
        @Override
        public int compareTo(obj o) {
            return this.st-o.st;
        }
    }
}