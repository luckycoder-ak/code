class Solution {
    //概率dp
    //除了第一个人和第n个人外，第i个人选了座位之后（无论是否是第i个座位），第i个座位一定是有人的
    //也就是到第n个人的时候，第2~n-1个座位全是坐满的。所以，要么坐在自己的位置上，要么坐在第一个位置上
    //只有两种可能性
    public double nthPersonGetsNthSeat(int n) {
        return n==1?1:0.5;
    }
}