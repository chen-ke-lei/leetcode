package oj;


import java.util.*;
import java.util.Map.Entry;


public class SortCharactersByFrequency {
	public static void main(String[] args) {
		System.out.println(new SortCharactersByFrequency().frequencySort("tree"));
	}
	//too low
	 public String frequencySort(String s) {
	        Map<Character, Integer> resTmp=new HashMap<Character, Integer>();
	        for(int i=0;i<s.length();i++) {
	        	if(resTmp.containsKey(s.charAt(i))) {
	        		resTmp.put(s.charAt(i), resTmp.get(s.charAt(i))+1);
	        	}else {
					resTmp.put(s.charAt(i), 1);
				}
	        }
	        List<Entry<Character, Integer>> enList=new ArrayList<>();
	        for(Entry<Character, Integer> entry: resTmp.entrySet())
	        	enList.add(entry);
	        enList.sort(new Comparator<Entry<Character, Integer>>() {

				@Override
				public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
					
					return o2.getValue()-o1.getValue();
				}
			});
	        s="";
	        for(Entry<Character, Integer> entry: enList) {
	        	for(int i=1;i<=entry.getValue();i++)
	        		s+=entry.getKey();  
	        }
		 return s;
	    }
}
