package ca.cglab.jagl.graph;

public class DirectedSimpleGraph<V, E> extends AbstractDirectedGraph<V, E>
{
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
		if(source.equals(destination))
		{
			throw new IllegalArgumentException("Loops are not allowed");
		}
		if(super.containsEdge(e))
		{
			throw new IllegalArgumentException("Edge already exists between vertices");
		}
		//edges.add(e);
	}
}
