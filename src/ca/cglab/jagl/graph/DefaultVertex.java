package ca.cglab.jagl.graph;

/**
 * The default vertex type that all vertices should inherit from.
 * All vertices have a unique id that can be used by other classes.
 * <br>
 * <br>
 * Created on June 26, 2015
 * 
 * @author Evren Kaya
 */
public class DefaultVertex
{
	static int existingVertices = 0;
	
	private int id;
	
	public DefaultVertex()
	{
		id = existingVertices++;
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
	
}
