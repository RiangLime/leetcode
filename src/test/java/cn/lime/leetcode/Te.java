package cn.lime.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: Te
 * @Description: TODO
 * @Author: Lime
 * @Date: 2024/2/20 11:40
 */
public class Te {
    public static void main(String[] args) {
        String data = "Pass the English CET-4 exam[60 days]";
        String str = data.substring(data.indexOf("["));
        String res =  str.replaceAll("[^0-9]","");
        System.out.println(res);
    }
}
