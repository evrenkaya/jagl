package ca.cglab.jagl.graph;


public class UndirectedSimpleGraph<V, E> extends AbstractUndirectedGraph<V, E>
{
	public void addEdge(V source, V destination, E e, EdgeDirection edgeDirection)
	{
		if(e == null || source == null || destination == null)
		{
			throw new IllegalArgumentException("Vertex or edge null");
		}
		if(edgeDirection != EdgeDirection.UNDIRECTED)
		{
			throw new IllegalArgumentException("Edge is not undirected");
		}
		if(source.equals(destination))
		{
			throw new IllegalArgumentException("Loops are not allowed");
		}
		if(super.edgeBetween(source, destination))
		{
			throw new IllegalArgumentException("Edge already exists between vertices");
		}
		super.addEdge(source, destination, e, edgeDirection);
	}
}
