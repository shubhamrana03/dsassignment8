import java.util.Scanner;
class ArrayList
{
	private int x[];
	private int size;
	private int osize;
	private int index;
	
	ArrayList(int size)
	{
		this.size = size;
		osize = size;
		index = -1;
		x = new int[size];
	}
	
	public void traverse()
	{
		if(index == -1)
			System.out.println("List is empty.");
		else
		{
			for(int i=0;i<=index;i++)
				System.out.print(x[i] + " ");
			System.out.println();
		}
	}
	
	public void add(int data)
	{
		if(index == size-1)
		{
			int temp[] = x;
			this.size = (int)(this.size*1.5);
			x = new int[this.size];
			
			for(int i=0;i<=index;i++)
				x[i] = temp[i];
		}
		index++;
		x[index] = data;
	}
	
	public int getIndex()
	{
		return index;
	}
	
	public void delete(int data)
	{
		if(index == -1)
			System.out.println("List is empty.");
		else
		{
			int pos = -1;
			for(int i=0;i<=index;i++)
			{
				if(x[i] == data)
				{
					pos = i;
					break;
				}
			}
			if(pos == -1)
				System.out.println(data + " was not found in the ArrayList.");
			else
			{
				for(int i=pos;i<index;i++)
					x[i] = x[i+1];
				x[index] = -999;
				index--;
			}
		}
	}
	
	public void deleteAll()
    	{
		if(index == -1)
		    System.out.println("List is already empty.");
		else
		{
			System.out.println("> Before deletion, no. of elements = " + (getIndex()+1));
			index = -1;
			x = new int[osize];
			System.out.println("> After deletion, no. of elements = " + (getIndex()+1));
		}
    	}
}
public class collection1_1
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of elements : ");
		int i,n = sc.nextInt(),choice;
		ArrayList l = new ArrayList(n);
		System.out.println("\nStart entering the elements :-");
		for(i=0;i<n;i++)
			l.add(sc.nextInt());
		
		System.out.println("What do you want to do next?");
		System.out.println("----------------------------");
		System.out.println("1. Inserting a number.");
		System.out.println("2. Deleting a number.");
		System.out.println("3. Deleting all the elements.");
		System.out.println("4. Display the array.");
		System.out.println("5. Exit.");
		System.out.println("----------------------------");
		System.out.print("Enter choice : ");
		choice = sc.nextInt();
		while(choice != 5)
		{
			switch(choice)
			{
				case 1:
						System.out.print("// Enter the num to insert : ");
						l.add(sc.nextInt());
						System.out.println("> Done.");
						break;
				
				case 2:
						System.out.print("// Enter the num to delete : ");
						l.delete(sc.nextInt());
						System.out.println("> Done.");
						break;
				
				case 3:
						System.out.println("// Deleting all the elements.");
						l.deleteAll();
						System.out.println("> Done.");
						break;
				
				case 4:
						l.traverse();
						break;
				
				default:
						System.out.println("> Invalid option.");
			}
			System.out.println("----------------------------");
			System.out.print("Enter choice : ");
			choice = sc.nextInt();
		}
	}
}