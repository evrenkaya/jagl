package ca.cglab.jagl.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * A Graph that uses some kind of vertex adjacency data structure.
 * 
 * Created on July 3, 2015
 * 
 * @author Evren Kaya
 */
public abstract class AdjacencyGraph<V, E> implements Graph<V, E>
{
	private Map<V, ArrayList<V>> adjacencyMap;
	private Collection<E> edges;
	
	public void addVertex(V v)
	{
		//adjacencyMap.put(v, new ArrayList<DefaultVertex>());
	}
	
	public void addEdge(E e)
	{
		if(e == null)
		{
			throw new IllegalArgumentException("Edge is null");
		}
		
		/*edges.add(e);
		adjacencyMap.get(e.getFirstVertex()).add(e.getSecondVertex());
		adjacencyMap.get(e.getSecondVertex()).add(e.getFirstVertex());*/
	}
	
	public void removeVertex(V v)
	{
		/*ArrayList<DefaultVertex> neighbors = adjacencyMap.remove(v);
		for(DefaultVertex neighbor : neighbors)
		{
			adjacencyMap.get(neighbor).remove(v);
		}
		
		for(DefaultEdge e : edges)
		{
			if(e.getFirstVertex().equals(v) || e.getSecondVertex().equals(v))
			{
				removeEdge(e);
			}
		}
		DefaultVertex.existingVertices--;*/
	}
	
	public void removeEdge(V source, V destination, E e)
	{
/*		edges.remove(e);
		adjacencyMap.get(e.getFirstVertex()).remove(e.getSecondVertex());
		adjacencyMap.get(e.getSecondVertex()).remove(e.getFirstVertex());
		DefaultEdge.existingEdges--;*/
	}
	
	public void removeAllVertices()
	{
/*		DefaultVertex.existingVertices -= adjacencyMap.size();
		adjacencyMap.clear();
		removeAllEdges();*/
	}
	
	public void removeAllEdges()
	{
/*		DefaultEdge.existingEdges -= edges.size();
		adjacencyMap.values().clear();
		edges.clear();*/
	}
	
	public int numVertices()
	{
		return adjacencyMap.size();
	}
	
	public int numEdges()
	{
		return edges.size();
	}
	
	public boolean containsVertex(V v)
	{
		return adjacencyMap.containsKey(v);
	}
	
	public boolean containsEdge(E e)
	{
		return edges.contains(e);
	}
	
	public boolean edgeBetween(V source, V dest)
	{
		return false;
	}
	
	public Collection<V> getVertices()
	{
		return adjacencyMap.keySet();
	}
	
	public Collection<E> getEdges()
	{
		return edges;
	}
	
	public Collection<V> getNeighborsOf(V v)
	{
		return adjacencyMap.get(v);
	}
}
