package handsone2.leetcode;


class ListNode1{
	int val ;
	ListNode1 next;
}

class LinkedList1{
	
//	ListNode1 head = null;
	
	void add(int val, ListNode1 head)
	{
		ListNode1 temp = head;
		
		if(temp == null)
		{
			ListNode1 p = new ListNode1();
			p.val = val;
			p.next = null;
			temp= p;
			head = p;
		}
		else {
			
			while(temp.next != null)
			{
				temp = temp.next;
			}
			
			ListNode1 p = new ListNode1();
			p.val = val;
			p.next = null;
			temp.next = p;
			
		}
		
		
		
	}
	
	void print(ListNode1 head)
	{
		ListNode1 last = head;
		while(last != null)
		{
			System.out.print(last.val + " -> ");
			last = last.next;
		}
		System.out.println();
	}
	
	
	ListNode1 mergeList(ListNode1 h1, ListNode1 h2)
	{
		ListNode1 head = null;
		ListNode1 temp = head;
		
		ListNode1 l1 = h1;
		ListNode1 l2 = h2;
		
		if(l1.val < l2.val)
		{
			head = l1;
			l1 = l1.next;
			temp = head;
			temp.next = null;
			
			
		}
		else
		{
			head = l2;
			l2 = l2.next;
			temp = head;
			temp.next = null;
			
		}
		
		
		while(l1 != null && l2 != null)
		{
//			System.out.println(l1.val +", " + l2.val);
			if(l1.val < l2.val)
			{
				
				temp.next = l1;
				l1 = l1.next;
				temp = temp.next;
				temp.next = null;
			}
			else
			{
				temp.next = l2;
				l2 = l2.next;
				temp = temp.next;
				temp.next = null;
			}
		}
		
		
		return head;
	}
}

public class Merge2SortedLists {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList1 l1 = new LinkedList1();
		
		
		
		ListNode1 h1 = new ListNode1();
		
		ListNode1 h2 = new ListNode1();
		
		for(int i = 1 ; i < 21; i++)
		{
			if(i % 2  == 0)
				l1.add(i, h1);
			else
				l1.add(i, h2);
		}
		
		l1.print(h1);
		l1.print(h2);
		
		ListNode1 h3 = l1.mergeList(h1, h2);
		l1.print(h3);
		
	}

}
