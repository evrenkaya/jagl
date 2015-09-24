package ca.cglab.jagl.graph;

import ca.cglab.jagl.util.Pair;

public class UndirectedSimpleGraph<V, E> extends AbstractUndirectedGraph<V, E>
{
	public void addEdge(V source, V destination, E e, EdgeDirection edgeDirection)
	{
		super.addEdge(source, destination, e, edgeDirection);
		if(source.equals(destination))
		{
			throw new IllegalArgumentException("Loops are not allowed");
		}
		
		vertexAdjacencyMap.get(source).add(destination);
		vertexAdjacencyMap.get(destination).add(source);
		
		edgeVertexMap.put(e, new Pair<V, V>(source, destination));
	}
}
