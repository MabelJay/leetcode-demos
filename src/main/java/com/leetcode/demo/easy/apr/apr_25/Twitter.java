package com.leetcode.demo.easy.apr.apr_25;

import java.util.*;

public class Twitter {

    class User {
        int userId;
        Map<Integer, Long> twistIds;
        Set<Integer> followeeIds;

        public User(int userId, Map<Integer, Long> twistIds, Set<Integer> followeeIds) {
            this.userId = userId;
            this.twistIds = twistIds;
            this.followeeIds = followeeIds;
        }
    }

    Map<Integer, User> map;

    public Twitter() {
        map = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (map.containsKey(userId)) {
            User user = map.get(userId);
            user.twistIds.put(tweetId, System.currentTimeMillis());
            map.put(userId, user);
        } else {
            Map<Integer, Long> twistIds = new HashMap<>();
            twistIds.put(tweetId, System.currentTimeMillis());
            User user = new User(userId, twistIds, new HashSet<>());
            map.put(userId, user);
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList<>();
        if (map.containsKey(userId)) {
            Set<Integer> followeeIds = map.get(userId).followeeIds;
            PriorityQueue<Map.Entry<Integer, Long>> minHeap = new PriorityQueue<>((o1, o2) -> (int) (o1.getValue() - o2.getValue()));
            for (Integer followeeId : followeeIds) {
                User tmpUser = map.get(followeeId);
                if (tmpUser == null) break;
                Map<Integer, Long> twistIds = tmpUser.twistIds;
                for (Map.Entry<Integer, Long> entry : twistIds.entrySet()) {
                    minHeap.add(entry);
                    if (minHeap.size() > 10) minHeap.poll();
                }
            }
            for (Map.Entry<Integer, Long> entry : map.get(userId).twistIds.entrySet()) {
                minHeap.add(entry);
                if (minHeap.size() > 10) minHeap.poll();
            }

            while (!minHeap.isEmpty()) {
                list.add(minHeap.poll().getKey());
            }
            Collections.reverse(list);
        }
        return list;
    }

    public void follow(int followerId, int followeeId) {
        if (map.containsKey(followerId)) {
            User user = map.get(followerId);
            user.followeeIds.add(followeeId);
            map.put(followerId, user);
        } else {
            Set<Integer> followeeIds = new HashSet<>();
            followeeIds.add(followeeId);
            User user = new User(followeeId, new HashMap<>(), followeeIds);
            map.put(followerId, user);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (map.containsKey(followerId)) {
            User user = map.get(followerId);
            user.followeeIds.remove(Integer.valueOf(followeeId));
            map.put(followerId, user);
        }
    }
}
