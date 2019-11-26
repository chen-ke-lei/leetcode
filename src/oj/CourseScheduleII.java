package oj;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] counts = new int[numCourses];
        int[] res = new int[numCourses];
        int last = numCourses;
        for (int i = 0; i < prerequisites.length; i++) {
            counts[prerequisites[i][0]]++;
        }

        int deleteV = -1;
        for (int i = 0; i < counts.length; i++)
            if (counts[i] == 0) {
                deleteV = i;
                break;
            }
        while (deleteV != -1) {
            res[numCourses-last]=deleteV;
            last--;
            counts[deleteV] = -1;

            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == (deleteV)) {
                    counts[prerequisites[i][0]]--;
                }
            }
            deleteV = -1;
            for (int i = 0; i < counts.length; i++)
                if (counts[i] == 0) {
                    deleteV = i;
                    break;
                }
        }
        //   System.out.println(last);
        return last == 0?res:new int[0];
    }
}
