package leetcode;

class ListNode{
	int val;
	ListNode next;
}

class LinkedList
{
	ListNode head;
	
	ListNode add(int val, ListNode head)
	{
		ListNode last = head;
		ListNode p = new ListNode();
		p.val = val;
		p.next = null;
		if(last == null)
		{
			head = p;
			return head;
		}
		while(last.next != null)
		{
			last = last.next;
		}
		
		last.next = p;
		
		return head;
	
		
	}
	
	void print(ListNode head)
	{
		ListNode last = head;
		while(last != null)
		{
			System.out.print(last.val + " ");
			last = last.next;
		}
		System.out.println();
	}
	
	ListNode reorder(ListNode head)
	{
		
		ListNode slow = head;
		ListNode fast = head;
		ListNode prev =  null;
		
		while(fast != null && fast.next != null)
		{
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		prev.next = null;
		
		ListNode h2 = slow;
		
		h2 = reverse(h2);
		
		print(head);
		print(h2);
		
			
		return  merge(head,h2);
	}
	
	ListNode reverse(ListNode head)
	{
		ListNode prev = null;
		
		ListNode p = head;
		
		while(p != null)
		{
			ListNode last = p.next;
			p.next = prev;
			prev = p;
			p = last;
		}
		
		return prev;
	}
	
	ListNode merge(ListNode h1,ListNode h2)
	{
		ListNode head = h1;
		
		
		while(h1 != null )
		{
			ListNode h1_next = h1.next;
			ListNode h2_next = h2.next;
			
			h1.next = h2;
			if(h1_next == null )
				break;
			
			h2.next = h1_next;
//			h1_next.next = h2_next;
			
			
			h1 = h1_next;
			h2 = h2_next;
		}
		
		
		
		
		
		return head;
	}
	
}
public class ReorderList_143 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList l = new LinkedList();
	
		ListNode head = l.add(1, null);
		
		for(int i = 2; i <= 3; i++)
		{
			l.add(i, head);
		}
		
		l.print(head);
		
//		ListNode h2 = l.reverse(head);
//		l.print(h2);
		
		l.print(l.reorder(head));
		

	}

}
