package oj;

import java.util.HashMap;
import java.util.Map;

//太慢
public class FreqStack {
	//当前的最大重复个数
	int maxLength;
	//重复的个数
	Map<Integer, Integer> vcMap=null;
	ListNode stack=null;
	public FreqStack() {
	}

	public void push(int x) {
		if(stack==null) {
			stack=new ListNode(x, 1);
			maxLength=1;
			vcMap=new HashMap<>();
			vcMap.put(x, 1);
		}else {
			if(vcMap.containsKey(x)) {
				vcMap.put(x, vcMap.get(x)+1);
			}else {
				vcMap.put(x, 1);
			}
			ListNode tmp=new ListNode(x, vcMap.get(x));
			stack.next=tmp;
			tmp.preve=stack;
			stack=tmp;
			if(vcMap.get(x)>maxLength) {
				maxLength=vcMap.get(x);
			}
		}
	}
	public int pop() {
		int res=-1;
		if(stack.count==maxLength) {
			res=stack.val;
			stack=stack.preve;
			if(stack!=null) {
				stack.next.preve=null;
				stack.next=null;
			}
			
		}else {
			ListNode tmp=stack;
			while (tmp!=null) {
				if(tmp.count!=maxLength)
					tmp=tmp.preve;
				else {
					res=tmp.val;
					tmp.preve.next=tmp.next;
					tmp.next.preve=tmp.preve;
					break;
				}
			}
		}
		vcMap.put(res, vcMap.get(res)-1);
		maxLength=maxLength-1;
		for(Integer val: vcMap.keySet()) {
			if(maxLength<vcMap.get(val)) {
				maxLength++;
				break;
			}
		}
		
		return res;
	}
	static class ListNode {
		 public int val;
		 public int count;
		 public ListNode next;
		 public ListNode preve;
		 public ListNode(int x,int count) { val = x; this.count=count; }
	}
}
