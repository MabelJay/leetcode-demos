package com.leetcode.demo.easy.dec.dec_30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargeGroupPositions {

    public static void main(String[] args) {
        // 输入：s = "abcdddeeeeaabbbcd"
        //输出：[[3,5],[6,9],[12,14]]
        //解释：较大分组为 "ddd", "eeee" 和 "bbb"
        String s = "abcdddeeeeaabbbcd";
        System.out.println(new LargeGroupPositions().largeGroupPositions2(s));
    }

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> resList = new ArrayList<>();
        int len = s.length();
        int pre = 0;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) != s.charAt(pre)) {
                if (i - pre > 2) {
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(pre);
                    tmpList.add(i - 1);
                    resList.add(tmpList);
                }
                pre = i;
            } else if (i == len - 1 && i - pre >= 2) {
                List<Integer> tmpList = new ArrayList<>();
                tmpList.add(pre);
                tmpList.add(i);
                resList.add(tmpList);
            }
        }
        return resList;
    }

    public List<List<Integer>> largeGroupPositions2(String s) {
        List<List<Integer>> resList = new ArrayList<>();
        int num = 1;
        int len = s.length();
        for (int i = 1; i < len; i++) {
            if (i == len - 1 || s.charAt(i) != s.charAt(i + 1)) {
                if (num >= 3) {
                    resList.add(Arrays.asList(i - num + 1, i));
                }
                num = 1;
            } else {
                num++;
            }
        }
        return resList;
    }
}
