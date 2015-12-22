package ca.cglab.jagl.graph;


public class UndirectedMultiGraph<V, E> extends AbstractUndirectedGraph<V, E>
{
	// This method allows multi edges and loops
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
		
		super.addEdge(source, destination, e, edgeDirection);
	}
}
