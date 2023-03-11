package leetcode;

import java.util.List;


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	void printInOrder(TreeNode root)
	{
		if(root != null)
		{
			printInOrder(root.left);
			System.out.print(root.val + " ");
			printInOrder(root.right);
		}
	}
}
 

public class ConvertListToBST_109 {
	
	static void addNode(TreeNode root, int val)
	{
		if(root == null)
		{
			TreeNode p = new TreeNode(val);
			p.left = null;
			p.right = null;
			root = p;
			return ;
		}
		
		if(root.val > val)
		{
			if(root.left != null)
			{
				addNode(root.left, val);
			}
			else
			{
				TreeNode p = new TreeNode(val);
				p.left = null;
				p.right = null;
				root.left = p;
				return ;
			}
		}
		else
		{
			if(root.right != null)
			{
				addNode(root.right, val);
			}
			else
			{
				TreeNode p = new TreeNode(val);
				p.right = null;
				p.right = null;
				root.right = p;
				return ;
			}
		}
	}

	static void convertToBSF(ListNode head)
	{
		LinkedList l = new LinkedList();
		ListNode slow = head;
		ListNode fast = head;
		ListNode prev = null;
		
		while(fast != null &&  fast.next != null)
		{
			prev = slow;
			fast = fast.next.next;
			slow = slow.next;
		}
		
		prev.next = null;
		
		ListNode h1 = head;
		ListNode root = slow;
		ListNode h2 = slow.next;
		
//	    l.print(h1);
//	    l.print(root);
//	    l.print(h2);
	    
	    ListNode temp = h1;
	    TreeNode t = new TreeNode(root.val);
//	    temp = temp.next;
	    while(temp != null)
	    {
	    	addNode(t, temp.val);
	    	temp = temp.next;
	    }
	    
	   
	    
	    temp = h2;
	    while(temp != null)
	    {
	    	addNode(t, temp.val);
	    	temp = temp.next;
	    }
	    
	    t.printInOrder(t);
		
	}
	
	static ListNode mid(ListNode head)
	{
		ListNode slow = head;
		ListNode fast = head;
		ListNode prev = null;
		
		while(fast != null &&  fast.next != null)
		{
			prev = slow;
			fast = fast.next.next;
			slow = slow.next;
		}
		
		if(prev != null)
		 prev.next = null;
		return slow;
	}
	static TreeNode convertToBSF_v2(ListNode head)
	{
		if(head == null)
			return null;
		
		ListNode mid = mid(head);
		TreeNode root = new TreeNode(mid.val);
		
		if(head == mid)
			return root;
		
		root.left = convertToBSF_v2(head);
		root.right = convertToBSF_v2(mid.next);
		
		return root;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList l = new LinkedList();
		
		ListNode head = l.add(-10, null);
		
		List<Integer> list = List.of(-3,0,5,9);
		
		System.out.println(list);
		
		for(int i =0; i< list.size(); i++)
		{
			l.add(list.get(i), head);
		}
		
		l.print(head);
		
//		convertToBSF(head);
		
		TreeNode t = convertToBSF_v2(head);
		t.printInOrder(t);
		
	}

}
