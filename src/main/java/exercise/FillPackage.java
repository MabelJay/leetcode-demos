package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FillPackage {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);

        int[] arr = {1, 4, 3, 4, 5, 2, 7};
        int[] arr2 = {20, 24, 24, 44};
        int[] arr3 = {8, 37, 29, 19, 35, 49, 9, 34, 8};
        System.out.println(new FillPackage().fill(arr, 15));
        System.out.println(new FillPackage().fill(arr2, 38));
        System.out.println(new FillPackage().fill(arr3, 81));

        System.out.println(new FillPackage().fill2(arr, 15));
        System.out.println(new FillPackage().fill2(arr2, 38));
        System.out.println(new FillPackage().fill2(arr3, 81));
    }

    public boolean fill(int[] arr, int totalWeight) {
        return canFill(arr, totalWeight, 0);
    }

    public boolean canFill(int[] arr, int total, int index) {
        for (int j = index; j < arr.length; j++) {
            if (arr[j] < total) {
                boolean flag = canFill(arr, total - arr[j], j + 1);
                if (flag) {
                    return true;
                }
            } else if (arr[j] == total) {
                return true;
            }
        }
        return false;
    }

    public boolean fill2(int[] arr, int totalWeight) {
        return canFill2(arr, totalWeight, 0);
    }

    public boolean canFill2(int[] arr, int total, int index) {
        if (total == 0) return true;
        if (total < 0 || index >= arr.length) return false;

        if (arr[index] <= total) {
            boolean selected = canFill2(arr, total - arr[index], index + 1);
            if (selected) return true;
        }
        return canFill2(arr, total, index + 1);
    }
}
