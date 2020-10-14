
//Practical 8 :

public class Tries 
{
	static final int ALPHABET_SIZE = 26;
	
	//Trie Node class :
	static class TrieNode
	{
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];
		boolean isEndOfWord;
		
		TrieNode()
		{
			isEndOfWord = false;
			
			for(int i = 0; i < ALPHABET_SIZE; i++)
			{
				children[i] = null;
			}
		}
	}
	
	static TrieNode root;
	
	//If not key present inserts into trie :
	static void insert(String key)
	{
		int level;
		int i;
		
		TrieNode node = root;
		
		for(level = 0; level < key.length(); level++)
		{
			i = key.charAt(level) - 'a';
			
			if(node.children[i] == null)
			{
				node.children[i] = new TrieNode();
			}
			
			node = node.children[i];
		}
		
		node.isEndOfWord = true;
	}
	
	//Returns true if key is present in trie :
	static boolean search(String key)
	{
		int level;
		int i;
		TrieNode node = root;
		
		for(level = 0; level < key.length(); level++)
		{
			i = key.charAt(level) - 'a';
			
			if(node.children[i] == null)
			{
				return false;
			}
			
			node = node.children[i];
		}
		
		return node != null && node.isEndOfWord;
	}
	
	//Driver :
	public static void main(String args[])
	{
		String keys[] = {"bank", "book", "bar", "bring", "film", "filter", 
				"simple", "slit", "silver"};
		String output[] = {"Not present in trie", "Present in trie"};
		
		root = new TrieNode();
		int i;
		
		for(i = 0; i < keys.length; i++)
		{
			insert(keys[i]);
		}
		
		//Searching for different keys :
		if(search("bank") == true)
		{
			System.out.println("bank : " + output[1]);
		}
		
		else
		{
			System.out.println("bank : " + output[0]);
		}
		
		if(search("film") == true)
		{
			System.out.println("film : " + output[1]);
		}
		
		else
		{
			System.out.println("film : " + output[0]);
		}
		
		if(search("egg") == true)
		{
			System.out.println("egg : " + output[1]);
		}
		
		else
		{
			System.out.println("egg : " + output[0]);
		}
		
		if(search("bar") == true)
		{
			System.out.println("bar : " + output[1]);
		}
		
		else
		{
			System.out.println("bar : " + output[0]);
		}
		
		if(search("silver") == true)
		{
			System.out.println("silver : " + output[1]);
		}
		
		else
		{
			System.out.println("silver : " + output[0]);
		}
		
		if(search("help") == true)
		{
			System.out.println("help : " + output[1]);
		}
		
		else
		{
			System.out.println("help : " + output[0]);
		}
	}
}
