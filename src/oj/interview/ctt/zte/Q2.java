package oj.interview.ctt.zte;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int times = Integer.valueOf(input.trim());
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            input = scanner.nextLine();
            int lineNum = Integer.valueOf(input.split("[ ]+")[0]);
            int hp = Integer.valueOf(input.split("[ ]+")[1]);
            List<List<Integer>> skills = new ArrayList<>();
            for (int j = 0; j < lineNum; j++) {
                List<Integer> skill = new ArrayList<>();
                input = scanner.nextLine();
                skill.add(Integer.valueOf(input.split("[ ]+")[0]));
                skill.add(Integer.valueOf(input.split("[ ]+")[1]));
                skills.add(skill);
            }

            res.add(cal(skills, hp, 0));
        }
        for (int num : res)
            System.out.println(num);
    }

    public static int cal(List<List<Integer>> skills, int hp, int times) {
        if (skills.size() == 0)
            return -1;
        for (int i = 0; i < skills.size(); i++) {
            List<Integer> skill = skills.get(i);
            int tmp = 0;
            if (skill.get(1) >= hp) {
                tmp = (2 * skill.get(0));
            } else {
                tmp = skill.get(0);
            }
            hp -= tmp;
            if (hp <= 0)
                return times + 1;
            skills.remove(skill);
            int res = cal(skills, hp, times + 1);
            if (res != -1)
                return res;
            skills.add(i, skill);
            hp += tmp;

        }
        return -1;
    }
}
