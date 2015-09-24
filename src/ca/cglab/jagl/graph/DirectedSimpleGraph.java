package ca.cglab.jagl.graph;

public class DirectedSimpleGraph<V, E> extends AbstractDirectedGraph<V, E>
{
	public void addEdge(V source, V destination, E e, EdgeDirection edgeDirection)
	{
		if(source.equals(destination))
		{
			throw new IllegalArgumentException("Loops are not allowed");
		}
		//edges.add(e);
	}
}
