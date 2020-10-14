//Practical 3 .

public class Fibonacci 
{
	//Practical Example :
	static int fibonacciIterative(int n){
		  if (n<=1)
		      return 1; 

		  int fib = 1;
		  int prevFib =  1;

		  for (int i = 2; i <= n; i++) {
		   int temp = fib;
		   fib = fib + prevFib;
		   prevFib = temp;
		  }
		  return fib;
		 }

	//Recursive :
	public static int fibonacci(int num)
	{
		if(num == 0)
		{
			return 1;
		}
		
		else if(num == 1)
		{
			return 1;
		}
		
		else
		{
			return fibonacci(num-1) + fibonacci(num-2);
		}
	}
	
	public static void main(String args[])
	{
		int n = 9;
		System.out.println("Expected result : " + fibonacciIterative(n));
		System.out.println("Result : " + fibonacci(n));
	}
}
