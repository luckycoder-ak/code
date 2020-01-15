class NumMatrix {

    private static int[][] mat=null;
    public NumMatrix(int[][] matrix) {
        int row_len = matrix.length;
        if(row_len==0) return;
        int col_len = matrix[0].length;
        mat = new int[row_len+1][col_len+1];
        for(int i=1; i<=row_len; ++i) {
            for(int j=1; j<=col_len; ++j) {
                this.mat[i][j] = matrix[i-1][j-1] + mat[i-1][j] + mat[i][j-1] - mat[i-1][j-1];
            }
        }
    }
    public static int sumRegion(int row1, int col1, int row2, int col2) {
        if(mat == null) return 0;
        row1++;
        col1++;
        row2++;
        col2++;
        return mat[row2][col2]-mat[row2][col1-1]-mat[row1-1][col2]+mat[row1-1][col1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */