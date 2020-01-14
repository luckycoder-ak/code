class Solution {
    public int minDistance(String word1, String word2) {
        int len = word1.length();
        int len2=word2.length();
        int[][] arr = new int[len+1][len2+1];
        for(int i=1; i<=len; ++i) arr[i][0] = i;
        for(int i=1; i<=len2; ++i) arr[0][i] = i;
        for(int i=1; i<=len; ++i) {
            for(int j=1; j<=len2; ++j) {
                if(word1.charAt(i-1)==word2.charAt(j-1)) {
                    arr[i][j] = arr[i-1][j-1];
                } else {
                    arr[i][j] = Math.min(arr[i-1][j-1], Math.min(arr[i-1][j], arr[i][j-1])) + 1;
                }
            }
        }
        return arr[len][len2];
    }
}