package oj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AccountsMerge {
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		List<List<String>> res = new ArrayList<>();
		Map<String, List<Set<String>>> fuckAccount = new HashMap<>();
		outer: for (List<String> account : accounts) {
			String name = account.get(0);
			if (!fuckAccount.containsKey(name)) {
				List<Set<String>> accountList = new ArrayList<>();
				accountList.add(new HashSet<>(account));
				accountList.get(0).remove(name);
				fuckAccount.put(name, accountList);
			} else {
				List<Set<String>> accountList = new ArrayList<>();
				for (Set<String> subAccount : accountList) {
					for (int i = 1; i < account.size(); i++) {
						if (subAccount.contains(account.get(i))) {
							subAccount.addAll(account);
							subAccount.remove(name);
							continue outer;
						}
					}
				}
			}		
		}
		for(Entry<String, List<Set<String>>> nameList:fuckAccount.entrySet()) {
			String name=nameList.getKey();
			for(int i=0;i<nameList.getValue().size();i++) {
				List<String> tmpList=new ArrayList<>(nameList.getValue().get(i));
				Collections.sort(tmpList);
				tmpList.add(0,name);
				res.add(tmpList);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		
	}
}
