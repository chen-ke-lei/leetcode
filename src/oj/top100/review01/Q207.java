package oj.top100.review01;

public class Q207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses];
        int[] site = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[0]][prerequisite[1]]++;
            site[prerequisite[1]]++;
        }
        boolean x = true;
        while (x) {
            x = false;
            for (int i = 0; i < site.length; i++) {
                if (site[i] == 0) {
                    site[i] = -1;
                    x = true;
                    numCourses--;
                    for (int j = 0; j < graph.length; j++) {
                        if (graph[i][j] == 1) site[j]--;
                    }
                }
            }
        }
        if (numCourses == 0) return true;
        return false;
    }
}
