class Solution {
    public static int row = 0;
    public static int col = 0;
    public static int[][] sum = null;
    public static boolean check(int area) {
        for(int x1 = 1; x1<=row; ++x1) {
            for (int x2 = row; x2>=x1; --x2) {
                int width = x2-x1+1;
//                if(area%width!=0) continue;
                int height = area/width; // yµÄ¿í¶È
                if(height*width!=area) height++;
                for(int y1=1; y1+height-1<=col; ++y1) {
                    int y2 = y1+height-1;
                    int s = sum[x2][y2]-sum[x2][y1-1]-sum[x1-1][y2]+sum[x1-1][y1-1];
                    if((width*height==s)&&(area <= s)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static int maximalRectangle(char[][] matrix) {
        row = matrix.length;
        if(row==0) return 0;
        col = matrix[0].length;
        sum =  new int[row+1][col+1];
        for(int i=1; i<=row; ++i) for (int j=1; j<=col; ++j) sum[i][j] = (matrix[i-1][j-1]-'0')+sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1];
        int left = 0, right=sum[row][col], mid;
        int ans = 0;
//        System.out.println(left+" "+right+" "+ ((left+right)>>1)+ " "+ans);
        while (left<=right) {
            mid = (left+right)>>1;
            if(check(mid)) {
                ans = mid;
                left = mid+1;
            } else right = mid-1;
//            System.out.println(left+" "+right+" "+ mid+ " "+ans);
        }
        return ans;
    }
}