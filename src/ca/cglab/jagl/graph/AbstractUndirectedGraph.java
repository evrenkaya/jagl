package ca.cglab.jagl.graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ca.cglab.jagl.util.Pair;

public abstract class AbstractUndirectedGraph<V, E> implements UndirectedGraph<V, E>
{
	protected Map<V, Set<V>> vertexAdjacencyMap;
	protected Map<E, Pair<V, V>> edgeVertexMap;

	
	public AbstractUndirectedGraph()
	{
		vertexAdjacencyMap = new HashMap<>();
		edgeVertexMap = new HashMap<>();
	}
	
	public void removeAllVertices()
	{
		vertexAdjacencyMap = new HashMap<>();
		removeAllEdges();
	}
	
	public void removeAllEdges()
	{
		edgeVertexMap = new HashMap<>();
	}

	public void addVertex(V v)
	{
		if(v == null)
		{
			throw new IllegalArgumentException("Vertex null");
		}
		vertexAdjacencyMap.put(v, new HashSet<V>());
	}
	
	public void addEdge(V source, V destination, E e, EdgeDirection edgeDirection)
	{
		vertexAdjacencyMap.get(source).add(destination);
		vertexAdjacencyMap.get(destination).add(source);
		
		edgeVertexMap.put(e, new Pair<V, V>(source, destination));
	}
	
	public void removeVertex(V v)
	{
		Set<V> neighbors = vertexAdjacencyMap.remove(v);
		for(Map.Entry<E, Pair<V, V>> entry : edgeVertexMap.entrySet())
		{
			E edge = entry.getKey();
			Pair<V, V> vertexPair = entry.getValue();
			for(V vertex : neighbors)
			{
				if(vertexPair.contains(v) && vertexPair.contains(vertex))
				{
					edgeVertexMap.remove(edge);
				}
			}
			
			
		}
	}


	public void removeEdge(V source, V destination, E e)
	{
		Pair<V, V> pair = edgeVertexMap.remove(e);
		vertexAdjacencyMap.get(pair.getA()).remove(pair.getB());
		vertexAdjacencyMap.get(pair.getB()).remove(pair.getA());
	}
	
	public boolean edgeBetween(V source, V dest)
	{
		Set<V> srcNeighbors = vertexAdjacencyMap.get(source);
		
		return (srcNeighbors.contains(dest));
	}


	public boolean containsVertex(V v)
	{
		return vertexAdjacencyMap.containsKey(v);
	}

	public boolean containsEdge(E e)
	{
		return edgeVertexMap.containsKey(e);
	}
	
	public Collection<V> getVertices()
	{
		return vertexAdjacencyMap.keySet();
	}

	public Collection<E> getEdges()
	{
		return edgeVertexMap.keySet();
	}

	public Collection<V> getNeighborsOf(V v)
	{
		return vertexAdjacencyMap.get(v);
	}
}
