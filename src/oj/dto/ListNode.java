package oj.dto;

public class ListNode {
	 public int val;
	 public ListNode next;
	 public ListNode(int x) { val = x; }
	 public static ListNode create(int[] array){
	 	if(array==null||array.length==0)
	 		return null;
	 	ListNode res=new ListNode(array[0]);
	 	ListNode pointer=res;
	 	for(int i=1;i<array.length;i++){
	 		pointer.next=new ListNode(array[i]);
	 		pointer=pointer.next;
		}
	 	return res;
	 }

	@Override
	public String toString() {
		return this.val+ (this.next==null?" ":"->"+this.next);
	}
}
