package cn.lime.leetcode;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: SingleTest
 * @Description: TODO
 * @Author: Lime
 * @Date: 2024/3/7 15:42
 */
public class SingleTest {

    @Test
    public void test1(){
        List<Bean> list = new ArrayList<>();
        list.add(new Bean(new int[]{0,3}));
        list.add(new Bean(new int[]{4,6}));
        list.add(new Bean(new int[]{2,4}));
        list.add(new Bean(new int[]{1,7}));

        list = list.stream().sorted().toList();
        System.out.println(JSON.toJSONString(list));
    }

    private static class Bean implements Comparable<Bean>{
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

}
