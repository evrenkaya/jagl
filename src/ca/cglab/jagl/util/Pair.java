package ca.cglab.jagl.util;

public class Pair<A, B>
{
	private A a;
	private B b;
	
	public Pair(A a, B b)
	{
		this.a = a;
		this.b = b;
	}

	public A getA()
	{
		return a;
	}

	public void setA(A a)
	{
		this.a = a;
	}

	public B getB()
	{
		return b;
	}

	public void setB(B b)
	{
		this.b = b;
	}
	
	public boolean contains(Object o)
	{
		return a.equals(o) || b.equals(o);
	}
	
	public boolean equals(Object o)
	{
		if(!(o instanceof Pair))
		{
			return false;
		}
		Pair<?, ?> otherPair = (Pair<?, ?>) o;
		return a.equals(otherPair.getA()) && b.equals(otherPair.getB());
	}
	
	
}
