package com.leetcode.demo.easy.may.may_18;

import java.util.HashMap;
import java.util.Map;

public class FruitCache implements FruitInventory {

    Map<String, Fruit> cache;

    public FruitCache() {
        cache = new HashMap<>();
    }

    @Override
    public Double getFruitPrice(String fruitName) {
        if (cache.containsKey(fruitName)) {
            return cache.get(fruitName).getPrice();
        }
        return null;
    }

    public void put(Fruit fruit) {
        if (fruit != null && fruit.getName() != null && fruit.getPrice() != null) {
            cache.put(fruit.getName(), fruit);
        }
    }

    @Override
    public int getHigherPriceFruits(double price) {
        int count = 0;
        for (Map.Entry<String, Fruit> entry : cache.entrySet()) {
            if (entry.getValue().getPrice() > price) count++;
        }
        return count;
    }
}
