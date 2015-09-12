package ca.cglab.jagl.graph;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class AbstractDirectedGraph implements DirectedGraph
{
	protected Set<DefaultVertex> vertices;
	protected Set<DefaultEdge> edges;
	
	public AbstractDirectedGraph()
	{
		vertices = new HashSet<DefaultVertex>();
		edges = new HashSet<DefaultEdge>();
	}
	
	public void removeAllVertices()
	{
		DefaultVertex.existingVertices -= vertices.size();
		vertices.clear();
		
		removeAllEdges();
	}
	
	public void removeAllEdges()
	{
		DefaultEdge.existingEdges -= edges.size();
		edges.clear();
	}

	public void addVertex(DefaultVertex v)
	{
		if(v == null)
		{
			throw new IllegalArgumentException("Vertex null");
		}
		vertices.add(v);
	}
	
	public void addEdge(DefaultEdge e)
	{
		if(e == null)
		{
			throw new IllegalArgumentException("Edge null");
		}
		if(e.getDirection() != DefaultEdge.DIRECTED)
		{
			throw new IllegalArgumentException("Edge is not directed");
		}
	}


	public void removeVertex(DefaultVertex v)
	{
		if(vertices.remove(v))
		{
			DefaultVertex.existingVertices--;
		}
	}


	public void removeEdge(DefaultEdge e)
	{
		if(edges.remove(e))
		{
			DefaultEdge.existingEdges--;
		}
	}

	public int numVertices()
	{
		return vertices.size();
	}


	public int numEdges()
	{
		return edges.size();
	}


	public boolean containsVertex(DefaultVertex v)
	{
		return vertices.contains(v);
	}

	public boolean containsEdge(DefaultEdge e)
	{
		return edges.contains(e);
	}
	
	public Collection<DefaultVertex> getVertices()
	{
		return vertices;
	}

	public Collection<DefaultEdge> getEdges()
	{
		return edges;
	}

	public Collection<DefaultVertex> getNeighborsOf(DefaultVertex v)
	{
		HashSet<DefaultVertex> neighbors = new HashSet<DefaultVertex>();
		for(Iterator<DefaultEdge> it = edges.iterator(); it.hasNext();)
		{
			DefaultEdge e = it.next();
			if(e.getFirstVertex() == v)
			{
				neighbors.add(e.getSecondVertex());
			}
		}
		return neighbors;
	}

	public Collection<DefaultVertex> getPredecessorsOf(DefaultVertex v)
	{
		HashSet<DefaultVertex> predecessors = new HashSet<DefaultVertex>();
		for(Iterator<DefaultEdge> it = edges.iterator(); it.hasNext();)
		{
			DefaultEdge e = it.next();
			if(e.getSecondVertex() == v)
			{
				predecessors.add(e.getFirstVertex());
			}
		}
		return predecessors;
	}
}
