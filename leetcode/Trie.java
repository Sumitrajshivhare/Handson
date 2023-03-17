package leetcode;

class Node{
	Node next;
	char c;
	Node children[] = new Node[26];
	boolean endOfWord = false;
}

public class Trie {
	
	Node root = new Node();
	void insert(String word )
	{
		Node temp = root;
		for(int i = 0; i < word.length(); i++)
		{
			int idx = word.charAt(i) - 'a';
			if(temp.children[idx] == null)
			{
				temp.children[idx] =  new Node();
				temp.children[idx].c = word.charAt(i);
			}
			
			temp = temp.children[idx];
		}
		
		temp.endOfWord = true;
	}
	
	void printNode(Node p)
	{
		for(int i = 0; i < 26; i++)
		{
			System.out.print(p.c + " - > ");
		}
	}
	
	boolean search(String word)
	{
		Node temp = root;
		
		for(int i = 0; i < word.length(); i++)
		{
			int idx = word.charAt(i) - 'a';
			
			if(temp.children[idx] == null)
			{
				return false;
			}
			
			temp = temp.children[idx];
		}
		
		if(temp.endOfWord ==  true)
			return true;
		
		return false;
	}
	
	boolean startsWith(String word)
	{
		Node temp = root;
		
		for(int i = 0; i < word.length(); i++)
		{
			int idx = word.charAt(i) - 'a';
			
			if(temp.children[idx] == null)
			{
				return false;
			}
			
			temp = temp.children[idx];
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String words[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};
		
		Trie trie =  new Trie();
		for(int i = 0 ; i < words.length; i++)
		{
			trie.insert(words[i]);
		}
		
		
		System.out.println(trie.search("the"));
		
		System.out.println(trie.search("to"));
		
		System.out.println(trie.startsWith("th"));
		
		System.out.println(trie.startsWith("tho"));
		
		

	}

}
