import java.lang.reflect.Array;
import java.util.Arrays;

//Practical 4 :

public class Sorting 
{
	public static void selectionSort(int arr[])
	{
		int temp;
		int minIndex;
		
		for(int i = 0; i < arr.length - 1; i++)
		{
			minIndex = i;
			
			for(int j = i + 1; j < arr.length; j++)
			{
				if(arr[minIndex] > arr[j])
				{
					minIndex = j;
				}
			}
				
			temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
		
		System.out.println("After Selection Sort : " + Arrays.toString(arr));
	}
	
	public static int[] insertionSort(int arr[])
	{
		for(int i = 1; i < arr.length; ++i)
		{
			int key = arr[i];
			int j = i - 1;
			
			while(j >= 0 && arr[j] > key)
			{
				arr[j+1] = arr[j];
				j = j - 1;
				arr[j+1] = key;
			}
		}
		
		return arr;
	}
	
	public static int[] stalinSort(int[] arr)
	{
		int i = 0;
		
		for(int j = 1; j < arr.length; i++, j++)
		{
			if(arr[i] > arr[j])
			{
				i--;
			}
			
			else
			{
				if(j - i > 1)
				{
					arr[i + 1] = arr[j];
				}
			}
		}
		
		return Arrays.copyOf(arr , i + 1);
	}
	
	//practical 5 :
	public static int[] mergeSort(int[] arr , int n)
	{
		if (n < 2)
		{
			return arr;
		}
		
		int mid = n / 2;
		int[] l = new int[mid];
		int[] r = new int[n - mid];
		
		for (int i = 0; i < mid; i++) 
		{
			l[i] = arr[i];
		}
		
		for (int i = mid; i < n; i++)
		{
			r[i-mid] = arr[i];
		}
		
		mergeSort(l,mid);
		mergeSort(r,n-mid);
		
		//Second version of merge sort :
		if(l[l.length - 1] <= r[0])
		{
			int left = l.length;
			int right = r.length;
			
			int[] sorted = new int[left + right];
			
			System.arraycopy(l, 0, sorted, 0, left);
			System.arraycopy(r, 0, sorted, left, right);
			
			return sorted;
		}
		
		merge(arr,l,r,mid,n-mid);
		
		return arr;
	}
	
	public static int[] merge(int[] arr , int[] l , int[] r , int left , int right)
	{
		int i = 0;
		int j = 0;
		int k = 0;
		
		while (i < left && j < right) 
		{
			if (l[i] <= r[j])
			{
				arr[k++] = l[i++];
			}
			
			else
			{
				arr[k++] = r[j++];
			}
		 }
		
		while (i < left)
		{
			arr[k++] = l[i++];
		}
		
		while (j < right)
		{	
			arr[k++] = r[j++];
		}
		
		return arr;
	}
	
	//practical 6 :
	public static int[] quickSort(int[] arr , int low , int high)
	{
		if(low < high)
		{
			int pi = partition(arr,low,high);
			
			//Before pi :
			quickSort(arr,low,pi - 1);
			//After pi :
			quickSort(arr,pi + 1,high);
		}
		
		return arr;
	}
	
	//Second version of quickSort :
	public static int[] enhancedQuickSort(int[] arr , int low , int high)
	{
		int cutoff = 10;
		
		if(high <= low + cutoff)
		{
			insertionSort(arr);
			
			return arr;
		}
		
		if(low < high)
		{
			int pi = partition(arr,low,high);
			
			//Before pi :
			quickSort(arr,low,pi - 1);
			//After pi :
			quickSort(arr,pi + 1,high);
		}
	
		return arr;
	}
	
	public static int partition(int arr[] , int low , int high)
	{
		int pivot = arr[high];
		
		//index of smaller element :
		int i = (low - 1);
		
		for(int j = low; j <= high - 1; j++)
		{
			//if smaller element is smaller than pivot 
			if(arr[j] < pivot)
			{
				//increment index of smaller element .
				i++;
				
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		
		return (i + 1);
	}
	
	public static void main(String args[])
	{
		int[] a = {1, 3, 2, 7, 14, 8};
		int[] b = {3, 5, 9, 11, 10, 2};
		int[] c = {1, 5 , 3, 6, 12, 7, 13, 4};
		int[] d = {1, 9, 11, 7, 6, 5, 10, 3, 2, 14};
		int[] e = {4, 12, 7, 8, 1, 10, 9};
		
		System.out.println("Before Selection Sort : " + Arrays.toString(a));
		selectionSort(a);
		
		System.out.println("Before Inserion Sort : " + Arrays.toString(b));
		System.out.println("After Insertion Sort : " + Arrays.toString(insertionSort(b)));
		
		System.out.println("Before Stalin Sort : " + Arrays.toString(c));
		System.out.println("After Gulag : " + Arrays.toString(stalinSort(c)));
		
		System.out.println("Before Merge Sort : " + Arrays.toString(d));
		System.out.println("After Merge Sort : " + Arrays.toString(mergeSort(d,10)));
		
		System.out.println("Before Quick Sort : " + Arrays.toString(e));
		System.out.println("After Quick Sort : " + Arrays.toString(quickSort(e,0,6)));
		System.out.println("After Enhanced Quick Sort : " + Arrays.toString(enhancedQuickSort(e,0,6)));
	}
}
