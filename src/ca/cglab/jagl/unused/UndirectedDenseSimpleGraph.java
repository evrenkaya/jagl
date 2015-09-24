package ca.cglab.jagl.unused;

import java.util.ArrayList;
import java.util.Collection;

import ca.cglab.jagl.graph.EdgeDirection;
import ca.cglab.jagl.graph.UndirectedGraph;

/**
 * An undirected simple graph that is suitable for graphs with high average connectivity ( < 5,000,000 edges)
 * 
 * @author Evren Kaya
 */
public class UndirectedDenseSimpleGraph<V, E> implements UndirectedGraph<V, E>
{
	private ArrayList<V> vertices;
	private ArrayList<E> edges;
	
	public UndirectedDenseSimpleGraph(int initialVertexCapacity)
	{
		vertices = new ArrayList<>(initialVertexCapacity);
		edges = new ArrayList<>(initialVertexCapacity);
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

	public void addVertex(V v)
	{
		//vertices.add(v);
	}
	
	public void addEdge(V source, V destination, E e, EdgeDirection edgeDirection)
	{
		//edges.add(e);
	}


	public void removeVertex(V v)
	{
		vertices.remove(v);
	}


	public void removeEdge(V source, V destination, E e)
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


	public boolean containsVertex(V v)
	{
		return vertices.contains(v);
	}

	public boolean containsEdge(E e)
	{
		return edges.contains(e);
	}

	public boolean isConnected()
	{
		return false;
	}
	
	public boolean edgeBetween(V source, V dest)
	{
		return false;
	}

	public Collection<V> getVertices()
	{
		return vertices;
	}

	public Collection<E> getEdges()
	{
		return edges;
	}

	public Collection<V> getNeighborsOf(V v)
	{
		/*ArrayList<DefaultVertex> neighbors = new ArrayList<DefaultVertex>();
		for(int i = 0; i < edges.size(); i++)
		{
			E e = edges.get(i);
			if(e.getFirstVertex() == v)
			{
				neighbors.add(e.getSecondVertex());
			}
			else if(e.getSecondVertex() == v)
			{
				neighbors.add(e.getFirstVertex());
			}
		}
		return neighbors;*/
		return null;
	}



}
