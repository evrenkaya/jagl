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
public abstract class AdjacencyGraph implements Graph
{
	private Map<DefaultVertex, ArrayList<DefaultVertex>> adjacencyMap;
	private Collection<DefaultEdge> edges;
	
	public void addVertex(DefaultVertex v)
	{
		adjacencyMap.put(v, new ArrayList<DefaultVertex>());
	}
	
	public void addEdge(DefaultEdge e)
	{
		if(e == null)
		{
			throw new IllegalArgumentException("Edge is null");
		}
		
		edges.add(e);
		adjacencyMap.get(e.getFirstVertex()).add(e.getSecondVertex());
		adjacencyMap.get(e.getSecondVertex()).add(e.getFirstVertex());
	}
	
	public void removeVertex(DefaultVertex v)
	{
		ArrayList<DefaultVertex> neighbors = adjacencyMap.remove(v);
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
		DefaultVertex.existingVertices--;
	}
	
	public void removeEdge(DefaultEdge e)
	{
		edges.remove(e);
		adjacencyMap.get(e.getFirstVertex()).remove(e.getSecondVertex());
		adjacencyMap.get(e.getSecondVertex()).remove(e.getFirstVertex());
		DefaultEdge.existingEdges--;
	}
	
	public void removeAllVertices()
	{
		DefaultVertex.existingVertices -= adjacencyMap.size();
		adjacencyMap.clear();
		removeAllEdges();
	}
	
	public void removeAllEdges()
	{
		DefaultEdge.existingEdges -= edges.size();
		adjacencyMap.values().clear();
		edges.clear();
	}
	
	public int numVertices()
	{
		return adjacencyMap.size();
	}
	
	public int numEdges()
	{
		return edges.size();
	}
	
	public boolean containsVertex(DefaultVertex v)
	{
		return adjacencyMap.containsKey(v);
	}
	
	public boolean containsEdge(DefaultEdge e)
	{
		return edges.contains(e);
	}
	
	public Collection<DefaultVertex> getVertices()
	{
		return adjacencyMap.keySet();
	}
	
	public Collection<DefaultEdge> getEdges()
	{
		return edges;
	}
	
	public Collection<DefaultVertex> getNeighborsOf(DefaultVertex v)
	{
		return adjacencyMap.get(v);
	}
}
