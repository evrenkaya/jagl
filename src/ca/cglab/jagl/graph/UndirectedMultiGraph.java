package ca.cglab.jagl.graph;

import ca.cglab.jagl.util.Pair;

public class UndirectedMultiGraph<V, E> extends AbstractUndirectedGraph<V, E>
{
	// This method allows multi edges and loops
	public void addEdge(V source, V destination, E e, EdgeDirection edgeDirection)
	{
		super.addEdge(source, destination, e, edgeDirection);
		vertexAdjacencyMap.get(source).add(destination);
		vertexAdjacencyMap.get(destination).add(source);
		
		edgeVertexMap.put(e, new Pair<V, V>(source, destination));
	}
}
