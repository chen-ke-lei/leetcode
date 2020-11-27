package oj.hot200;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Q353 {
    class SnakeGame {
        LinkedList<int[]> body;
        Set<String> set;
        int index;
        int width;
        int height;
        int[][] food;

        /**
         * Initialize your data structure here.
         *
         * @param width  - screen width
         * @param height - screen height
         * @param food   - A list of food positions
         *               E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
         */
        public SnakeGame(int width, int height, int[][] food) {
            set = new HashSet<>();
            body = new LinkedList<>();
            body.addFirst(new int[]{0, 0});
            set.add("0_0");
            this.food = food;
            this.index = 0;
            this.width = width;
            this.height = height;
        }

        /**
         * Moves the snake.
         *
         * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
         * @return The game's score after the move. Return -1 if game over.
         * Game over when snake crosses the screen boundary or bites its body.
         */
        public int move(String direction) {
            int[] last = body.getFirst();
            int[] next = new int[2];
            switch (direction) {
                case "D":
                    next[0] = last[0] + 1;
                    next[1] = last[1];
                    break;
                case "R":
                    next[0] = last[0];
                    next[1] = last[1] + 1;
                    break;
                case "U":
                    next[0] = last[0] - 1;
                    next[1] = last[1];
                    break;
                case "L":
                    next[0] = last[0];
                    next[1] = last[1] - 1;
                    break;

            }
            if (next[0] < 0 || next[1] < 0 || next[0] >= height || next[1] >= width) return -1;
            if (next[0] == food[index][0] && next[1] == food[index][1]) {
                index++;
            } else {
                int[] ints = body.removeLast();
                set.remove(ints[0] + "_" + ints[1]);
            }
            if (set.contains(next[0] + "_" + next[1])) return -1;
            body.addFirst(next);
            set.add(next[0] + "_" + next[1]);

            return index;
        }


    }
}
