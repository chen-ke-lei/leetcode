package oj;

import java.util.*;

public class RandomizedCollection {
    Map<Integer, Set<Integer>> valNums = new HashMap<>();
    //    Map<Integer, Integer> index2Num = new HashMap<>();
    List<Integer> list = new ArrayList<>();
//    Set<Integer> set = new HashSet<>();
//    int length = 0;

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {

    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        boolean res = false;
        if (!valNums.containsKey(val)) {
            res = true;
            valNums.put(val, new HashSet<>());
        }
        list.add(val);

        valNums.get(val).add(list.size() - 1);
        return res;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {

        boolean res = false;
        if (valNums.containsKey(val)) {
            res = true;
            int index = valNums.get(val).iterator().next();
            valNums.get(val).remove(index);
            if (index!=list.size()-1){
                list.set(index, list.get(list.size() - 1));
                valNums.get(list.get(index)).remove(list.size() - 1);
                valNums.get(list.get(index)).add(index);
            }

            list.remove(list.size() - 1);
            if (valNums.get(val).size() == 0) {
                valNums.remove(val);
            }
        }

        return res;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
       // System.out.println(list);
        return list.get(new Random().nextInt(list.size()));

    }

    public static void main(String[] args) {
        RandomizedCollection collection = new RandomizedCollection();
        collection.insert(0);
        collection.remove(0);
        collection.insert(-1);
        collection.remove(0);
      //  collection.remove(1);
        System.out.println(collection.getRandom());
    }
}


