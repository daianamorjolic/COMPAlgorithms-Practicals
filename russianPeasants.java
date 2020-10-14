//Practical 1 :

public class russianPeasants 
{
	//Russian Peasant's algorithm :
	public static int multiply(int a , int b)
	{
		int res = 0;
			
		while(b > 0)
		{
			if(b % 2 != 0)
			{
				res += a;
			}
				
			a *= 2;
			b /= 2;
		}
			
		return res;
	}
		
	public static void main(String[] args)
	{
		System.out.println("Result : " + multiply(68,139));
	}
}
