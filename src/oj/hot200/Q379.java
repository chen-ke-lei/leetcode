package oj.hot200;

import java.util.HashSet;
import java.util.Set;

public class Q379 {
}

class PhoneDirectory {
    Set<Integer> set;
    int maxNumbers;

    /**
     * Initialize your data structure here
     *
     * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
     */
    public PhoneDirectory(int maxNumbers) {
        this.maxNumbers = maxNumbers;
        set = new HashSet<>();
        for (int i = 0; i < maxNumbers; i++) set.add(i);
    }

    /**
     * Provide a number which is not assigned to anyone.
     *
     * @return - Return an available number. Return -1 if none is available.
     */
    public int get() {
        if (!set.isEmpty()) {
            int num = set.iterator().next();
            set.remove(num);
            return num;
        }
        return -1;
    }

    /**
     * Check if a number is available or not.
     */
    public boolean check(int number) {
        return set.contains(number);
    }

    /**
     * Recycle or release a number.
     */
    public void release(int number) {
        set.add(number);
    }
}
