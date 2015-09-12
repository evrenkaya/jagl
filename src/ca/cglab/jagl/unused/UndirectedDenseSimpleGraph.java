package ca.cglab.jagl.unused;

import java.util.ArrayList;
import java.util.Collection;

import ca.cglab.jagl.graph.DefaultEdge;
import ca.cglab.jagl.graph.DefaultVertex;
import ca.cglab.jagl.graph.UndirectedGraph;

/**
 * An undirected simple graph that is suitable for graphs with high average connectivity ( < 5,000,000 edges)
 * 
 * @author Evren Kaya
 */
public class UndirectedDenseSimpleGraph implements UndirectedGraph
{
	private ArrayList<DefaultVertex> vertices;
	private ArrayList<DefaultEdge> edges;
	
	public UndirectedDenseSimpleGraph(int initialVertexCapacity)
	{
		vertices = new ArrayList<DefaultVertex>(initialVertexCapacity);
		edges = new ArrayList<DefaultEdge>(initialVertexCapacity);
	}
	
	public void removeAllVertices()
	{
		vertices.clear();
		//DefaultVertex.existingVertices = 0;
		removeAllEdges();
	}
	
	public void removeAllEdges()
	{
		edges.clear();
		//DefaultEdge.existingEdges = 0;
	}

	public void addVertex(DefaultVertex v)
	{
		vertices.add(v);
	}
	
	public void addEdge(DefaultEdge e)
	{
		edges.add(e);
	}


	public void removeVertex(DefaultVertex v)
	{
		vertices.remove(v);
	}


	public void removeEdge(DefaultEdge e)
	{
		edges.remove(e);
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

	public boolean isConnected()
	{
		return false;
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
		ArrayList<DefaultVertex> neighbors = new ArrayList<DefaultVertex>();
		for(int i = 0; i < edges.size(); i++)
		{
			DefaultEdge e = edges.get(i);
			if(e.getFirstVertex() == v)
			{
				neighbors.add(e.getSecondVertex());
			}
			else if(e.getSecondVertex() == v)
			{
				neighbors.add(e.getFirstVertex());
			}
		}
		return neighbors;
	}



}
