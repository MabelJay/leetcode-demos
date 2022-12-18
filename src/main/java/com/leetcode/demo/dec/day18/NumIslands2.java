package com.leetcode.demo.dec.day18;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class NumIslands2 {

    private static class Element<V> {
        V value;

        public Element(V value) {
            this.value = value;
        }
    }

    private static class UnionFindSet<V> {
        HashMap<V, Element<V>> elementMap;
        HashMap<Element<V>, Element<V>> fatherMap;
        HashMap<Element<V>, Integer> sizeMap;

        public UnionFindSet(List<V> list) {
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();

            for (V val : list) {
                Element<V> element = new Element<V>(val);
                elementMap.put(val, element);
                fatherMap.put(element, element);
                sizeMap.put(element, 1);
            }
        }

        private Element<V> findHead(Element<V> element) {
            LinkedList<Element<V>> stack = new LinkedList<>();
            while (element != fatherMap.get(element)) {
                stack.push(element);
                element = fatherMap.get(element);
            }

            while (!stack.isEmpty()) {
                fatherMap.put(stack.pop(), element);
            }
            return element;
        }

        private boolean isSameSet(V val1, V val2) {
            if (elementMap.containsKey(val1) && elementMap.containsKey(val2)) {
                return findHead(elementMap.get(val1)) == findHead(elementMap.get(val2));
            }
            return false;
        }

        private void union(V val1, V val2) {
            if (elementMap.containsKey(val1) && elementMap.containsKey(val2)) {
                Element<V> val1F = findHead(elementMap.get(val1));
                Element<V> val2F = findHead(elementMap.get(val2));

                if (val1F != val2F) {
                    Element<V> bigEle = sizeMap.get(val1F) >= sizeMap.get(val2F) ? val1F : val2F;
                    Element<V> smallEle = bigEle == val1F ? val2F : val1F;
                    fatherMap.put(smallEle, bigEle);
                    sizeMap.put(bigEle, sizeMap.get(smallEle) + sizeMap.get(bigEle));
                    sizeMap.remove(smallEle);
                }
            }
        }
    }
}
