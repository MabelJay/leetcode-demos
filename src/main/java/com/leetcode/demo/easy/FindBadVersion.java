package com.leetcode.demo.easy;

public class FindBadVersion {

    public static void main(String[] args) {
        //2126753390
        //1702766719
        System.out.println(new FindBadVersion().firstBadVersion2(5));
    }

    public boolean isBadVersion(int version) {
        return version > 3;
    }

    public int firstBadVersion2(int n) {
        int low = 1, high = n;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
}
