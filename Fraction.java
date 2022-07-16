package fractions;
import java.util.*;
public class Fraction 
{
	private Scanner scan = new Scanner(System.in);
	private int num=1;
	private int denom=1;
	
	public Fraction()
	{
		
	}
	public Fraction (int n, int d)
	{
		setFraction(n,d);
	}
	public void setFraction(int n, int d)
	{
		num = n;
		denom = d;
		reduce();
	}
	public Fraction add(Fraction op)
	{
		return (new Fraction(num * op.denom + denom * op.num, denom * op.denom));
	}
	public Fraction subtract(Fraction op)
	{
		return (new Fraction(num * op.denom - denom * op.num, denom * op.denom));
	}
	public Fraction multiply(Fraction op)
	{
		return (new Fraction(num * op.num , denom * op.denom));
	}
	public Fraction divide(Fraction op) 
	{
		return (new Fraction(num * op.denom , denom * op.num));
	}
	private void reduce()
	{
		int smaller;
		smaller = Math.abs(num) < Math.abs(denom)? Math.abs(num) :Math.abs(denom);
		for (int divisor = 2; divisor <= smaller; divisor++)
		{
			while(num % divisor == 0 && denom % divisor == 0)
			{
				num /= divisor;
				denom /= divisor;
				smaller /= divisor;
			}
		}
	}
	public boolean equals(Fraction f)
	{
		return num == f.num && denom == f.denom;
	}
	public String toString()
	{
		return num + "/" + denom;
	}
	public void readin(String label)
	{
		while (true) 
		{
			System.out.print(label);
			String temp = scan.next();
			temp = temp.trim();
			
			int index = temp.indexOf('/');
			if (index >= 0)
			{
				String numStr = temp.substring(0, index);
				String denomStr = temp.substring(index+1);
				int n = Integer.parseInt(numStr);
				int d = Integer.parseInt(denomStr);
				setFraction(n,d);
				return;
			}
			else
				System.out.println("Input Fraction missing / ");
	}
}

public static void main(String[] args) 
{
	Fraction f1 = new Fraction();
	Fraction f2 = new Fraction();
	Fraction f3 = null;
	Scanner scan = new Scanner(System.in);
	
	while (true)
	{
		System.out.println();
		System.out.print("Enter operation: + - * / q (q ==> quit) : ");
		String input = scan.next();
		if (input.charAt(0) == 'q')
			break;
		
		f1.readin("Enter Fraction 1: ");
		f2.readin("Enter Fraction 2: ");
		System.out.println("f1 = " + f1);
		System.out.println("f2 = " + f2);
		
		if (f1.equals(f2))
			System.out.println("f1 and f2 are equal");
		else
			System.out.println("f1 and f2 are not equal");
		
		switch (input.charAt(0))
		{
		case '+':
			f3 = f1.add(f2);
			System.out.println("f1 + f2= " + f3);
			break;
			
		case '-':
			f3 = f1.subtract(f2);
			System.out.println("f1 - f2= " + f3);
			break;
			
		case '*':
			f3 = f1.multiply(f2);
			System.out.println("f1 * f2= " + f3);
			break;
			
		case '/':
			f3 = f1.divide(f2);
			System.out.println("f1 / f2= " + f3);
			break;
			
		default:
			System.out.println("Illegal command: " + input );
			break;
		}
	}
	System.out.println("Bye");
	}
}