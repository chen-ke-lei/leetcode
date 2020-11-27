package oj.hot200;

public class Q251 {
    class Vector2D {
        int[][] v;
        int x;
        int y;

        public Vector2D(int[][] v) {
            this.v = v;
            this.x = 0;
            this.y = 0;
        }

        public int next() {
            int val = v[x][y];
            y++;
            if (y >= v[x].length) {
                x++;
                y = 0;
            }
            return val;
        }

        public boolean hasNext() {
            while (x < v.length && v[x].length == 0) {
                x++;
                y = 0;
            }
            return x < v.length - 1 || (x == v.length - 1 && y < v[v.length - 1].length);
        }
    }
}
