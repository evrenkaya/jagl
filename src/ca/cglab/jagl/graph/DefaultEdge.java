package ca.cglab.jagl.graph;

/**
 * Default edge type that all edges should inherit from.
 * Contains an id, weight, references to two vertices, and a direction.
 * <br>
 * <br>
 * Created on June 26, 2015
 * 
 * @author Evren Kaya
 */
public class DefaultEdge
{
	/*public enum Direction
	{
		UNDIRECTED,
		DIRECTED
	}*/
	
	public static final int UNDIRECTED = 0;
	public static final int DIRECTED = 1;
	
	static int existingEdges = 0;
	
	protected DefaultVertex first;
	protected DefaultVertex second;
	
	private int id;
	private int weight;
	private int direction;
	
	public DefaultEdge(DefaultVertex first, DefaultVertex second, int weight, int direction)
	{
		if(first == null || second == null)
		{
			throw new IllegalArgumentException("Endpoint cannot be null");
		}
		if(direction > DIRECTED)
		{
			throw new IllegalArgumentException("Invalid edge direction");
		}
		id = existingEdges++;
		this.first = first;
		this.second = second;
		this.weight = weight;
		this.direction = direction;
	}
	
	public int getDirection()
	{
		return direction;
	}
	
	public int getWeight()
	{
		return weight;
	}
	
	public int hashCode()
	{
		return id;
	}
	
	void setID(int id)
	{
		this.id = id;
	}
	
	public int getID()
	{
		return id;
	}
	
	public DefaultVertex getFirstVertex()
	{
		return first;
	}
	
	public DefaultVertex getSecondVertex()
	{
		return second;
	}
	
	public boolean equals(Object o)
	{
		if(!(o instanceof DefaultEdge))
		{
			return false;
		}
		
		DefaultEdge e = (DefaultEdge)o;
		return (this.first == e.first && this.second == e.second)
			|| (this.first == e.second && this.second == e.first);
	}
}
