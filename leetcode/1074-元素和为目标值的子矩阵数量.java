class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int row = matrix.length;
        if(row==0) return 0;
        int col = matrix[0].length;
        for(int i=1; i<col; ++i) matrix[0][i] += matrix[0][i-1];
        for(int i=1; i<row; ++i) matrix[i][0] += matrix[i-1][0];
        for(int i=1; i<row; ++i) for (int j=1; j<col; ++j) matrix[i][j] += matrix[i-1][j] + matrix[i][j-1] - matrix[i-1][j-1];
        int ans = 0;
        HashMap<Integer, Integer> mark = new HashMap<>();
        for(int x1 = 0; x1<row; ++x1) {
            for(int x2=x1; x2<row; ++x2) {
                mark.clear();
                for(int y = 0; y<col; ++y) {
                    int sum = matrix[x2][y] - ((x1>=1)?matrix[x1-1][y]:0);
                    if(sum == target) ans++;
                    if(mark.get(sum-target)!=null) ans += mark.get(sum-target);
                    int add = (mark.get(sum)!=null)?mark.get(sum):0;
                    mark.put(sum, add+1);
                }
            }
        }
        return  ans;
    }
}