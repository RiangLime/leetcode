//给你一个 无重叠的 ，按照区间起始端点排序的区间列表。 
//
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出：[[1,5],[6,9]]
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出：[[1,2],[3,10],[12,16]]
//解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。 
//
// 示例 3： 
//
// 
//输入：intervals = [], newInterval = [5,7]
//输出：[[5,7]]
// 
//
// 示例 4： 
//
// 
//输入：intervals = [[1,5]], newInterval = [2,3]
//输出：[[1,5]]
// 
//
// 示例 5： 
//
// 
//输入：intervals = [[1,5]], newInterval = [2,7]
//输出：[[1,7]]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= intervals[i][0] <= intervals[i][1] <= 10⁵ 
// intervals 根据 intervals[i][0] 按 升序 排列 
// newInterval.length == 2 
// 0 <= newInterval[0] <= newInterval[1] <= 10⁵ 
// 
//
// Related Topics 数组 👍 869 👎 0


package cn.lime.leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Q0057 {
    public static void main(String[] args) {
        Solution solution = new Q0057().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            if (intervals.length == 0) {
                return new int[][]{newInterval};
            } else {
                List<Bean> beanList = new ArrayList<>();
                for (int[] interval : intervals) {
                    beanList.add(new Bean(interval));
                }
                beanList.add(new Bean(newInterval));
                List<int[]> intervalList =  beanList.stream().sorted().map(b -> {
                    return new int[]{b.getA(), b.getB()};
                }).collect(Collectors.toList());

                return merge(intervalList).toArray(new int[][]{});
            }


        }

        public static class Bean implements Comparable<Bean>{
            private int a;
            private int b;

            public Bean(int[] i) {
                this.a = i[0];
                this.b = i[1];
            }

            public int getA() {
                return a;
            }

            public void setA(int a) {
                this.a = a;
            }

            public int getB() {
                return b;
            }

            public void setB(int b) {
                this.b = b;
            }

            @Override
            public int compareTo(Bean o) {
                //this当前对象 与 o 比较
                //返回数据有三种类型：
                //整数 ： 代表this当前对象较大
                //0   :  代表一样大
                //负数 ： 代表this当前对象较小
                if(this.a > o.a){
                    return 1;
                }else if(this.a == o.a){
                    return 0;
                }
                return -1;
            }
        }

        private List<int[]> merge(List<int[]> intervalList) {
            // merge
            while (true) {
                for (int i = 0; i < intervalList.size(); i++) {
                    if (i == intervalList.size() - 1) {
                        return intervalList;
                    }
                    if (intervalList.get(i)[1] >= intervalList.get(i + 1)[0]
                            && intervalList.get(i)[1] <= intervalList.get(i + 1)[1]) {
                        intervalList.get(i)[1] = intervalList.get(i + 1)[1];
                        intervalList.remove(i + 1);
                        break;
                    }
                    if (intervalList.get(i)[1] >= intervalList.get(i + 1)[0]
                            && intervalList.get(i)[1] >= intervalList.get(i + 1)[1]) {
                        intervalList.remove(i + 1);
                        break;
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}