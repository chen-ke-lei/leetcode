package oj.hot100;

import java.util.Arrays;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int res = 0;
        Integer[] taskNum = new Integer[26];
        Arrays.fill(taskNum,0);
        for (char c : tasks) {

            taskNum[(c - 'A')] += 1;
        }
        Arrays.sort(taskNum, (a, b) -> b - a);
        int tmp = n;
        int i = 0;
        while (taskNum[0] > 0) {
            for (; i < 26; i++) {
                if (tmp > 0) {
                    if (taskNum[i] > 0) {
                        tmp--;
                        res++;
                        taskNum[i]--;
                    } else {
                        res += tmp;
                        break;
                    }
                } else {
                    Arrays.sort(taskNum, (a, b) -> b - a);
                    break;
                }
            }
            tmp = n;
            i=0;
        }
        return res + tmp;
    }

    public static void main(String[] args) {
        System.out.println(new TaskScheduler().leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }
}
