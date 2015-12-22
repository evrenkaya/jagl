package ca.cglab.jagl.graph;

public class DirectedMultiGraph<V, E> extends AbstractDirectedGraph<V, E>
{
	// This method allows multi edges and loops
	public void addEdge(V source, V destination, E e, EdgeDirection edgeDirection)
	{
		if(e == null)
		{
			throw new IllegalArgumentException("Edge null");
		}
		if(edgeDirection != EdgeDirection.DIRECTED)
		{
			throw new IllegalArgumentException("Edge is not directed");
		}
		
		super.addEdge(source, destination, e, edgeDirection);
	}
}
