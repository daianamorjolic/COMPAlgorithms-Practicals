//practical 3 .

public class towersOfHanoi 
{
	public static void hanoi(int disc , String source , String destination , String auxilliary)
	{
		if(disc == 1)
		{
			System.out.println("Move disc " + disc + " from " + source + " to " + destination);
			return;
		}
		
		else if(disc == 0)
		{
			System.out.println("A to C");
		}
		
		else
		{
			hanoi(disc - 1,source,auxilliary,destination);
			System.out.println("Move disc " + disc + " from " + source + " to " + destination);
			hanoi(disc - 1,auxilliary,destination,source);
		}
	}
	
	public static void main(String[] args)
	{
		int n = 3;
		hanoi(n,"A","B","C");
	}
}
