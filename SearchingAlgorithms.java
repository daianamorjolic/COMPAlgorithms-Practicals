
//Practical 7 :

public class SearchingAlgorithms 
{
	//Brute Force Algorithm :
	public static int bruteForceSearch(String text , String pattern)
	{
		int n = text.length();
		int m = pattern.length();
		
		for(int i = 0; i < n - m; i++)
		{
			int j;
			
			for(j = 0; j < m; j++)
			{
				if(text.charAt(i + j) != pattern.charAt(j))
				{
					break;
				}
			}
			
			if(j == m)
			{
				return i;
			}
		}
		
		return n;
	}
	
	// Knuth Morris Pratt Algorithm :
	public static void KMPSearch(String text , String pattern)
	{
		int n = text.length();
		int m = pattern.length();
		int lps[] = new int[m];
		int j = 0; //index for pattern .
		int i = 0; //index for string .
		
		computeLPSArray(pattern,m,lps);
		
		while( i < n)
		{
			if(pattern.charAt(j) == text.charAt(i))
			{
				j++;
				i++;
			}
			
			if(j == m)
			{
				System.out.println("Pattern found at index : " + (i - j));
				j = lps[j - 1];
			}
			
			else if(i < n && pattern.charAt(j) != text.charAt(i))
			{
				if( j != 0)
				{
					j = lps[j - 1];
				}
				
				else
				{
					i = i + 1;
				}
			}
		}
		
	}
	
	public static void computeLPSArray(String pattern , int m , int lps[])
	{
		int length = 0;
		int i = 1;
		lps[0] = 0; //always 0 .
		
		//loops calculates lps[i] for i = 1 to m - 1 .
		while(i < m)
		{
			if(pattern.charAt(i) == pattern.charAt(length))
			{
				length++;
				lps[i] = length;
				i++;
			}
			
			else
			{
				if(length != 0)
				{
					length = lps[length - 1];
				}
				
				else
				{
					lps[i] = length;
					i++;
				}
			}
		}
	}
	
	public static void main(String args[])
	{
		SearchingAlgorithms test = new SearchingAlgorithms();
		
		String text = "ABABDABACDABABCABAB";
		String pattern = "ABABCABAB";
		
		test.KMPSearch(text, pattern);
	}
}
