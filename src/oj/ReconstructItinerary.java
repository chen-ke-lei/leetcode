package oj;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructItinerary {
	public List<String> findItinerary(String[][] tickets) {
		List<String> res = new ArrayList<>();
		if (tickets == null || tickets.length == 0)
			return res;
		Map<String, List<String>> tiMap = new HashMap<>();
		for (int i = 0; i < tickets.length; i++) {
			if (tickets[i] == null || tickets[i].length != 2)
				return res;
			if (!tiMap.containsKey(tickets[i][0])) {
				tiMap.put(tickets[i][0], new ArrayList());

			}
			tiMap.get(tickets[i][0]).add(tickets[i][1]);
		}
		for (String key : tiMap.keySet()) {
			Collections.sort(tiMap.get(key));
		}
		String from = "JFK";
		res.add(from);
		dfs(tiMap, from, res, tickets.length + 1);
		return res;
	}

	boolean dfs(Map<String, List<String>> map, String key, List<String> res, int length) {
	//	System.out.println(map);
		System.out.println(res);
		if (key == null || key.length() == 0) {
			if (res.size() == length)
				return true;
			return false;
		}
		List<String> list = map.get(key);
		if (list == null || list.size() == 0) {
			if (res.size() == length)
				return true;
			return false;
		}
		int empty = 0;
		for (int i = 0; i < list.size(); i++) {
			String newKey=list.get(i);
			if (newKey == null || newKey.length() == 0) {
				empty++;
				continue;
			}
				
			list.set(i, "");
			res.add(newKey);
			if (dfs(map, newKey, res, length))
				return true;
			res.remove(res.size()-1);
			list.set(i, newKey);

		}
		if(empty==list.size()&& res.size()==length)
			return true;
		return false;

	}

	public static void main(String[] args) {
		System.out.println(new ReconstructItinerary().findItinerary(new String[][] {{"EZE","TIA"},{"EZE","HBA"},{"AXA","TIA"},{"JFK","AXA"},
			{"ANU","JFK"},{"ADL","ANU"},{"TIA","AUA"},{"ANU","AUA"},{"ADL","EZE"},{"ADL","EZE"},{"EZE","ADL"},{"AXA","EZE"},{"AUA","AXA"},
			{"JFK","AXA"},{"AXA","AUA"},{"AUA","ADL"},{"ANU","EZE"},{"TIA","ADL"},{"EZE","ANU"},{"AUA","ANU"}}));
	}
	
	class Solution {
	    public List<String> findItinerary(String[][] tickets) {
	        HashMap<String, List<String>> map = new HashMap<>();
	        for (String[] ticket : tickets){
	            if (!map.containsKey(ticket[0]))
	                map.put(ticket[0], new ArrayList<>());
	            List<String> list = map.get(ticket[0]);
	            int index = 0;
	            int size = list.size();
	            while (index < size){
	                if (list.get(index).compareTo(ticket[1])>0){
	                    break;
	                }
	                index++;
	            }
	            list.add(index, ticket[1]);
	        }

	        List<String> ans = new ArrayList<>();
	        ans.add("JFK");
	        dfs(ans, tickets.length+1, "JFK", map);
	        return ans;
	    }

	    public boolean dfs(List<String> ans, int count, String s, HashMap<String, List<String>> map){
	        if (ans.size()==count)
	            return true;

	        List<String> list = map.get(s);
	        if (list==null)
	            return false;
	        for (int i=0; i<list.size(); i++){
	            String tmp = list.get(i);
	            ans.add(tmp);
	            list.remove(i);

	            if (dfs(ans, count, tmp, map))
	                return true;

	            ans.remove(ans.size()-1);
	            list.add(i, tmp);
	        }
	        return false;
	    }
	}
}
