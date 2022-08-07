package com.leetcode.demo.easy.feb.feb_13;

import java.util.*;

public class TopKFrequent {

    static class NamePair {
        int val;
        int frequency;
    }

    public static void main(String[] args) {
        // 输入: nums = [1,1,1,2,2,3], k = 2
        //输出: [1,2]

        // 输入: nums = [1], k = 1
        //输出: [1]

        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] nums2 = {3, 0, 1, 0};
        System.out.println(Arrays.toString(new TopKFrequent().topKFrequent2(nums2, 1)));
        System.out.println(Arrays.toString(new TopKFrequent().topKFrequent3(nums2, 1)));
        System.out.println(Arrays.toString(new TopKFrequent().topKFrequent4(nums2, 1)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Iterator<Integer> keyIterator = map.keySet().iterator();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int count = 0;
        while (count < k) {
            minHeap.add(map.get(keyIterator.next()));
            count++;
        }

        while (keyIterator.hasNext()) {
            int key = keyIterator.next();
            int val = map.get(key);
            if (val > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(val);
            }
        }

        int kFreq = minHeap.peek();
        int[] arr = new int[k];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= kFreq) {
                arr[index++] = entry.getKey();
            }
        }
        return arr;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();

            if (minHeap.size() == k) {
                if (val > minHeap.peek()[1]) {
                    minHeap.poll();
                    minHeap.add(new int[]{key, val});
                }
            } else {
                minHeap.add(new int[]{key, val});
            }
        }

        int[] res = new int[k];
        int index = 0;
        while (index < k) {
            res[index++] = minHeap.poll()[0];
        }

        return res;
    }

    public int[] topKFrequent3(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] valueArr = new int[map.size()];
        int index = 0;
        Iterator<Integer> iterator = map.values().iterator();
        while (iterator.hasNext()) {
            valueArr[index++] = iterator.next();
        }
        int[] res = new int[k];
        index = 0;
        int frequency = process(valueArr, k - 1, 0, valueArr.length - 1);
        System.out.println("frequency=" + frequency);
        System.out.println(map);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= frequency) {
                res[index++] = entry.getKey();
            }
        }
        return res;
    }

    public int process(int[] arr, int index, int left, int right) {
        if (left == right) return arr[index];
        int pivot = arr[left + (int) (Math.random() * (right - left + 1))];
        int[] range = partition(arr, pivot, left, right);
        if (index >= range[0] && index <= range[1]) return arr[index];
        else if (index > range[1]) return process(arr, index, range[1] + 1, right);
        else return process(arr, index, left, range[0] - 1);
    }

    public int[] partition(int[] arr, int pivot, int left, int right) {
        int small = left - 1;
        int large = right + 1;
        int cur = left;

        while (cur < large) {
            if (arr[cur] > pivot) {
                swap(arr, ++small, cur++);
            } else if (arr[cur] < pivot) {
                swap(arr, --large, cur);
            } else cur++;
        }
        return new int[]{small + 1, large - 1};
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int[] topKFrequent4(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int frequency = processList(list, k - 1, 0, list.size() - 1);
        int[] res = new int[k];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
           if (entry.getValue()>=frequency) res[index++] = entry.getKey();
        }
        return res;
    }

    public int processList(List<int[]> list, int index, int start, int end) {
        if (start == end) return list.get(start)[1];
        int pivot = list.get(start + (int) (Math.random() * (end - start + 1)))[1];
        int[] range = partition(list, pivot, start, end);
        if (index >= range[0] && index <= range[1]) return list.get(index)[1];
        else if (index < range[0]) {
            return processList(list, index, start, range[0] - 1);
        } else {
            return processList(list, index, range[1] + 1, end);
        }
    }

    public int[] partition(List<int[]> list, int pivot, int start, int end) {
        int small = start - 1;
        int large = end + 1;
        int cur = start;

        while (cur < large) {
            if (list.get(cur)[1] > pivot) {
                Collections.swap(list, ++small, cur++);
            } else if (list.get(cur)[1] < pivot) {
                Collections.swap(list, --large, cur);
            } else cur++;
        }
        return new int[]{small + 1, large - 1};
    }
}
