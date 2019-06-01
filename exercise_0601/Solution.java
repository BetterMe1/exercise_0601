package exercise.exercise_0601;

/*
64. 最小路径和
给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
说明：每次只能向下或者向右移动一步。
示例:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
 */

/*
class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int j=1; j<dp[0].length; j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for(int i=1; i<dp.length; i++){
            dp[i][0] = dp[i-1][0] +grid[i][0];
        }
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) +grid[i][j];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}*/

/*
71. 简化路径
以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；
两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。
最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
示例 1：
输入："/home/"
输出："/home"
解释：注意，最后一个目录名后面没有斜杠。

示例 2：
输入："/../"
输出："/"
解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。

示例 3：
输入："/home//foo/"
输出："/home/foo"
解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。

示例 4：
输入："/a/./b/../../c/"
输出："/c"

示例 5：
输入："/a/../../b/../c//.//"
输出："/c"

示例 6：
输入："/a//b////c/d//././/.."
输出："/a/b/c"
 */

/*class Solution {
    public String simplifyPath(String path) {
        String result = "/";
        String[] tmp = path.split("/");
        for(int i=0; i<tmp.length; i++){
            //System.out.println(tmp[i]);
            if(tmp[i].equals("..")){
                if(!result.equals("/")){
                    int m=0;
                    for(; m<2; m++){
                        int k = result.lastIndexOf('/');
                        if(k == 0){
                            result = "/";
                            break;
                        }else{
                            result = result.substring(0,k);
                        }
                    }
                    if(m == 2){
                        result += "/";
                    }
                }
            }else if(!tmp[i].equals("") && !tmp[i].equals(".")){
                result += tmp[i] + "/";
            }
        }
        if(!result.equals("/") && "/".equals(result.substring(result.length()-1))) {
            result = result.substring(0,result.length()-1);
        }
        return result;
    }
}*/

/*
119. 杨辉三角 II
给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 3
输出: [1,3,3,1]

进阶：

你可以优化你的算法到 O(k) 空间复杂度吗？
 */

import java.util.ArrayList;
import java.util.List;

//组合公示C（n,i)=n!/(i!*(n-i)!)
//i+1项是第i项的(n-i)/(i+1)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        long num = 1;
        for(int i=0; i<=rowIndex; i++){
            result.add((int)num);
            num = num*(rowIndex-i)/(i+1);
        }
        return result;
    }
}