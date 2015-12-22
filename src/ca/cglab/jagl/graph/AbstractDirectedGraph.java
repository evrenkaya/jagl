package ca.cglab.jagl.graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ca.cglab.jagl.util.Pair;

public abstract class AbstractDirectedGraph<V, E> implements DirectedGraph<V, E>
{
	protected Map<V, Set<V>> vertexAdjacencyMap;
	protected Map<E, Pair<V, V>> edgeVertexMap;
	
	public AbstractDirectedGraph()
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
		edgeVertexMap.put(e, new Pair<V, V>(source, destination));
	}


	public void removeVertex(V v)
	{
		// TODO Fix this implementation
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
	}

	public boolean containsVertex(V v)
	{
		return vertexAdjacencyMap.containsKey(v);
	}

	public boolean containsEdge(E e)
	{
		return edgeVertexMap.containsKey(e);
	}
	
	public boolean edgeBetween(V source, V dest)
	{
		Set<V> srcNeighbors = vertexAdjacencyMap.get(source);
		Set<V> destNeighbors = vertexAdjacencyMap.get(dest);
		
		return srcNeighbors.contains(dest) || destNeighbors.contains(source);
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

	public Collection<V> getDirectPredecessorsOf(V v)
	{
		Set<V> predecessors = new HashSet<>();
		for(Map.Entry<E, Pair<V, V>> entry : edgeVertexMap.entrySet())
		{
			Pair<V, V> vertices = entry.getValue();
			if(vertices.getB().equals(v))
			{
				predecessors.add(v);
			}
		}
		return predecessors;
	}
	
	public Collection<V> getDirectSuccessorsOf(V v)
	{
		return getNeighborsOf(v);
	}
}
