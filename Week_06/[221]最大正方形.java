//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。 
//
// 示例: 
//
// 输入: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4 
// Related Topics 动态规划 
// 👍 494 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {
        /**
         dp[i][j]表示以matrix[i][j]为右下角所能构成的最大正方形边长, 则递推式为:
         dp[i][j] = 1 + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]);
         **/
        int m = matrix.length;
        if(m < 1) return 0;
        int n = matrix[0].length;
        int max = 0;
        int[]pre = new int[n+1];
        int[]cur = new int[n+1];

        for(int i = 1; i <= m; ++i) {
            for(int j = 1; j <= n; ++j) {
                if(matrix[i-1][j-1] == '1') {
                    cur[j] = 1 + Math.min(pre[j-1], Math.min(pre[j], cur[j-1]));
                    max = Math.max(max, cur[j]);
                }
                pre[j - 1] = cur[j - 1];// 上一行的j-1位置用不到了，此时就可以替换为本行的结果，为下一行的运算做准备。
                cur[j - 1] = 0;// 本行用不到的结果置0，为下一行做准备。
            }
            pre[n] = cur[n];
            cur[n] = 0;
        }
        return max*max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
