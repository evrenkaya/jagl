package ca.cglab.jagl.graph;

public class Edge<E, V>
{
	private E data;
	
	private V source;
	private V destination;
	
	private EdgeDirection edgeDirection;

	public Edge(E data, V source, V destination, EdgeDirection edgeDirection)
	{
		this.data = data;
		this.source = source;
		this.destination = destination;
		this.edgeDirection = edgeDirection;
	}
	
	public E getData()
	{
		return data;
	}

	public V getSource()
	{
		return source;
	}

	public void setSource(V source)
	{
		this.source = source;
	}
	
	public V getDestination()
	{
		return destination;
	}

	public void setDestination(V destination)
	{
		this.destination = destination;
	}
	
	public EdgeDirection getEdgeDirection()
	{
		return edgeDirection;
	}

	public void setEdgeDirection(EdgeDirection edgeDirection)
	{
		this.edgeDirection = edgeDirection;
	}
}
