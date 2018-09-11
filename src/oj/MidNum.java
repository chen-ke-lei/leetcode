package oj;

public class MidNum {
	Node node;
	int size=0;
	 public void Insert(Integer num) {
		 if(size==0) {
			 node=new Node();
			 node.val=num;
		 }else {
			Node tmp=node,parent=node;
			while(tmp!=null) {
				parent=tmp;
				if(num>=tmp.val)
					tmp=tmp.right;
				else {
					tmp=tmp.left;
				}
			}
			Node newNode=new Node();
			newNode.val=num;
			if(num>=parent.val) {
				parent.right=newNode;
			}else {
				parent.left=newNode;
			}//Ðý×ªÎ´Ð´Íê
			Node left=node.left;
			Node right=node.right;
			while(left.right!=null)
				left=left.right;
			while(right.left!=null)
				right=right.left;
			if(size%2==0&&num>=node.val) {
				
			}else if(size%2==1 && num<node.val) {
				
			}
			
		 }
		 size++;
			 
	    }

	    public Double GetMedian() {
	    	if(size==0)
	    	return 0.0;
	    	if(size%2==1)
	    		return node.val+0.0;
	    	return (node.val+node.right.val+0.0)/2.0;
	        
	    }
	    class Node{
	    	Node left;
	    	Node right;
	    	int val;
	    }
}
