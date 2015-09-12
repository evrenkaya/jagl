/**
 * 
 */
package ca.cglab.jagl.unused;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import ca.cglab.jagl.graph.DefaultEdge;
import ca.cglab.jagl.graph.DefaultVertex;
import ca.cglab.jagl.graph.Graph;

/**
 * An undirected graph that does not support
 * loops or multiple edges between a pair of vertices.
 * This graph is only efficient for graphs with low average connectivity (< 500,000 edges)
 * 
 * @author Evren Kaya
 */
public class UndirectedSparseSimpleGraph implements Graph
{
	private ArrayList<DefaultVertex> vertices;
	private HashMap<DefaultEdge, ArrayList<DefaultVertex>> edges;
	
	public UndirectedSparseSimpleGraph(int initialVertexCapacity)
	{
		vertices = new ArrayList<DefaultVertex>(initialVertexCapacity);
		edges = new HashMap<DefaultEdge, ArrayList<DefaultVertex>>();
	}

	public void addVertex(DefaultVertex v)
	{
		vertices.add(v);
	}

	public void addEdge(DefaultEdge e)
	{
		ArrayList<DefaultVertex> endpoints = new ArrayList<DefaultVertex>(2);
		endpoints.add(e.getFirstVertex());
		endpoints.add(e.getSecondVertex());
		edges.put(e, endpoints);
	}

	public void removeVertex(DefaultVertex v)
	{
		vertices.remove(v);
		
		Iterator<Entry<DefaultEdge, ArrayList<DefaultVertex>>> it = edges.entrySet().iterator();
	    while (it.hasNext())
	    {
	        Map.Entry<DefaultEdge, ArrayList<DefaultVertex>> pair = it.next();
	        ArrayList<DefaultVertex> vertexPair = pair.getValue();
	        
	        if(vertexPair.contains(v))
	        {
	        	it.remove();	// Avoids a ConcurrentModificationException
	        }
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	    }
		
		//DefaultVertex.existingVertices--;
	}

	public void removeEdge(DefaultEdge e)
	{
		edges.remove(e);
		//DefaultEdge.existingEdges--;
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
		//return v.getID() < vertices.size();
		return vertices.contains(v);
	}

	public boolean containsEdge(DefaultEdge e)
	{
		//return e.getID() < edges.size();
		return edges.containsKey(e);
	}

	/*public boolean isConnected()
	{
		BreadthFirstIterator bfi = new BreadthFirstIterator(this, vertices.get(0));
		while(bfi.hasNext())
		{
			bfi.next();
		}
		
		return bfi.getVisitedVertices().size() == vertices.size();
	}*/

	public Collection<DefaultVertex> getVertices()
	{
		return vertices;
	}

	public Collection<DefaultEdge> getEdges()
	{
		return edges.keySet();
	}

	public Collection<DefaultVertex> getNeighborsOf(DefaultVertex v)
	{
		ArrayList<DefaultVertex> neighbors = new ArrayList<DefaultVertex>();
		
		Iterator<Entry<DefaultEdge, ArrayList<DefaultVertex>>> it = edges.entrySet().iterator();
	    while (it.hasNext())
	    {
	        Map.Entry<DefaultEdge, ArrayList<DefaultVertex>> pair = it.next();
	        ArrayList<DefaultVertex> vertexPair = pair.getValue();
	        
	        if(vertexPair.get(0) == v)
	        {
	        	neighbors.add(vertexPair.get(1));
	        }
	        else if(vertexPair.get(1) == v)
	        {
	        	neighbors.add(vertexPair.get(0));
	        }
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	    }
		return neighbors;
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

}
