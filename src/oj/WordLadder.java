package oj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		List<String> pre = new ArrayList<>(), next = wordList, t1 = new ArrayList<>(), t2 = new ArrayList<>();
		pre.add(beginWord);
	//	next.add(endWord);
		int step = 1;
		while (!pre.isEmpty()) {
			System.out.println(pre);
			System.out.println(next);
			System.out.println();
			step++;
			for (String str : pre) {
				for (String str1 : next) {
					if (compare(str1, str) <= 1) {
						if (str1.equals(endWord))
							return step;
						t1.add(str1);
					} else {
						t2.add(str1);
					}
				}
				next = t2;
				t2 = new ArrayList<>();
			}
			pre = t1;
			t1 = new ArrayList<>();
		}
		return 0;
	}

	int compare(String str1, String str2) {
		int tmp = 0;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i))
				tmp++;
		}
		return tmp;
	}

	public static void main(String[] args) {
		List<String> test =new ArrayList<>();
		test.add("hot");
		test.add("dot");
		test.add("dog");
		test.add("lot");
		test.add("log");
		//test.add("cog");
		System.out.println(new WordLadder().ladderLength("hit", "cog", test));
	}
}


class Solution {
	   public int ladderLength(String beginWord, String endWord, List<String> wordList) {
			if (wordList.size() == 0) return 0;
			if (!wordList.contains(endWord)) return 0;
			Set<String> q1 = new HashSet<>();
			Set<String> q2 = new HashSet<>();
			HashSet<String> hashSet = new HashSet<>(wordList);
			q1.add(beginWord);
			q2.add(endWord);
			hashSet.remove(endWord);
			return twoEndBFS(q1, q2, hashSet, 2);
		}

		private int twoEndBFS(Set<String> q1, Set<String> q2, Set<String> dic, int len) {
			if (q1.isEmpty() || q2.isEmpty())
				return 0;
			if (q1.size() > q2.size())
				return twoEndBFS(q2, q1, dic, len);
			Set<String> temp = new HashSet<>();
			for (String word : q1) {
				char[] arr = word.toCharArray();
				for (int i = 0; i < arr.length; i++) {
					char c = arr[i];
					for (char newC = 'a'; newC <= 'z'; newC++) {
						arr[i] = newC;
						String newS = String.valueOf(arr);
						if (q2.contains(newS))
							return len;
						if (dic.contains(newS)) {
							temp.add(newS);
							dic.remove(newS);
						}
					}
					arr[i] = c;
				}
			}
			return twoEndBFS(temp, q2, dic, len + 1);
		}
	}
