class Solution {
    public int videoStitching(int[][] clips, int T) {
        int ans = 0;
        int e = -1;
        int len = clips.length;
        for(int i=0; i<len; ++i) {
            if(clips[i][0] == 0) e = Math.max(e, clips[i][0]);
        }
        if(e==-1) return -1;
        for(int i=0; i<len; ++i) {
            if(e >= T) break;
            int k = -1;
            for(int j=0; j<len; ++j) {
                if(clips[j][0] <= e) {//��ǰ��ķ�������
                    k = Math.max(k, clips[j][1]);//��һ����Զ����
                }
            }
            if(k==-1) return -1;
            ans++;
            e = k;
        }
        return e>=T?ans:-1;
    }
}