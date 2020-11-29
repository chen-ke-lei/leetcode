package oj.hot200;

import java.util.*;

public class Q1244 {
}

class Leaderboard {
    TreeMap<Integer, Set<Integer>> scoreMap;
    Map<Integer, Integer> players;

    public Leaderboard() {
        scoreMap = new TreeMap<>((a, b) -> b - a);
        players = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        if (players.containsKey(playerId)) {
            score += players.get(playerId);
            scoreMap.get(players.get(playerId)).remove(playerId);
        }
        if (!scoreMap.containsKey(score)) scoreMap.put(score, new HashSet<>());
        scoreMap.get(score).add(playerId);
        players.put(playerId, score);
    }

    public int top(int K) {
        int sum = 0, index = 0;
        for (Integer integer : scoreMap.keySet()) {
            for (Integer integer1 : scoreMap.get(integer)) {
                sum += integer;
                index++;
                if (index == K) return sum;
            }
        }
        return sum;
    }

    public void reset(int playerId) {
        if (players.containsKey(playerId)) {
            scoreMap.get(players.get(playerId)).remove(playerId);
            players.remove(playerId);
        }
    }
}
