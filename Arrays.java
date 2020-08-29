import java.util.Scanner ;
import java.util.Random ;
class Arrays
{	
	int array[];
	int size =10 , index=0;
	Arrays(int size)
	{
		this.size = size;
		array = new int[size];
	}

	Arrays()
	{
		array = new int[size];			
	}
	void autoFill()
	{
		Random rand = new Random();

		for(int i=index; i<array.length;i++)
		{
			array[i] = rand.nextInt(100);
			index++;
		}	
	}

	void add(int element)
	{ 
		if(index<0)
		{
			index=0;
		}	
		if(index<size)
		{
			array[index] = element ;
			
			index++;
		} 
		else if(index >= size )
		{
			int[] b = new int[size];

			for(int i=0; i< array.length ; i++)
			{
				b[i] = array[i];
			}
			array = null;
			array = new int[size *= 2];
			for(int i=0; i< b.length ; i++)
			{
				array[i] = b[i];
			}
			b=null;	
			array[index] = element;
			index++;
			
		}
		
	}

	boolean remove(int element)
	{
		int counter=0;
		for(int i=0; i<array.length ; i++)
		{
			if(array[i]==element)
			{
				counter++;
			}	
		}
		System.out.print("counter ="+counter);	
		
		if(index>0)
		{
			int  temp_count=0;
			int[] temp_array = new int[size-=1];	

			for(int i=0; i<array.length ; i++)
			{
				if(array[i]!=element)
				{
					temp_array[temp_count++] = array[i];
				}	
			}	
			array = null;
			array = new int[size];

			for (int i=0;i<array.length ;i++) 
			{
				array[i] = temp_array[i];	
			}
			temp_array=null;
			
			if(index>0)
			{
				index--;
			}	
			if(counter>1)
			{
				index = index - counter;
			}	
			
			return true;
		}
		else
		{
			return false;
		}	
	}
	void print()
	{
		System.out.println("Printing array");
		System.out.print("[ ");
		for(int i=0 ; i<size ; i++)
		{
			System.out.print(array[i]+",");
		}	
		System.out.println(" ] \n");
	}

	public static void main(String[] args) 
	{
		System.out.println("Welcome to dynamic array tutorial");
		Arrays a = new Arrays(6);
		Scanner sc = new Scanner(System.in);
		int element = 0;
		int choice = 0;
		do
		{
			System.out.println("Enter choice :- 1. To add element in array\n \t\t2. To remove element\n \t\t3. To print\n \t\t4. To autofill array\n \t\t5. To exit");
			choice = sc.nextInt();

			if(choice == 1)
			{
				element = 0;
				System.out.print("Enter element to be added :- ");
				element = sc.nextInt();
				a.add(element);
				System.out.println();
			}
			else if(choice==2)
			{
				element=0;
				a.print();
				System.out.println("Enter element to be removed :- ");
				element = sc.nextInt();
				a.remove(element);
				System.out.println();
			}
			else if(choice == 3)
			{
				a.print();
			}	
			else if(choice == 4)
			{
				a.autoFill();
			}	
		}while(choice!=5);
			
	}
}