class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<obj> list = new ArrayList<>();
        int n = startTime.length;
        int i, j=n-1;
        for(i=0; i<n; ++i) {
            list.add(new obj(startTime[i], endTime[i], profit[i]));
        }
        Collections.sort(list);
        for (i=0; i<n; ++i) {
            obj x = list.get(i);
            startTime[i] = x.st;
            endTime[i] = x.et;
            profit[i] = x.pt;
            System.out.println(x.st+ " "+ x.et+" "+x.pt);
        }
        int[] dp = new int[n+2];
        for(i=n-1; i>=0; --i) { //第一个到第n个
            int st = startTime[i]; // 当前任务的开始时间
            int et = endTime[i]; //当前任务结束时间
            int pt = profit[i];// 当前任务产生的价值
            j = Arrays.binarySearch(startTime, et);
            for(j=i+1; j<n; ++j) {
                if(startTime[j]>=et) break;
            }
            dp[i] = Math.max(dp[i+1], pt+dp[j]);
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