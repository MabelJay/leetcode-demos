package com.leetcode.demo.easy.may.may_09;

public class CuttingRope2 {

    public static void main(String[] args) {
        // 输入: 10
        //输出: 36
        //解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36

        System.out.println(Integer.MAX_VALUE > 1000000008);
        System.out.println(new CuttingRope2().cuttingRope2(120));
    }

    public int cuttingRope2(int n) {
        if(n < 4){
            return n - 1;
        }

        long res = 1;
        while(n > 4){
            res  = res * 3 % 1000000007;
            n -= 3;
        }
        return (int) (res * n % 1000000007);
    }
}
