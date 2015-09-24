/**
 * 
 */
package ca.cglab.jagl.unused;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import ca.cglab.jagl.graph.EdgeDirection;
import ca.cglab.jagl.graph.Graph;

/**
 * An undirected graph that does not support
 * loops or multiple edges between a pair of vertices.
 * This graph is only efficient for graphs with low average connectivity (< 500,000 edges)
 * 
 * @author Evren Kaya
 */
public class UndirectedSparseSimpleGraph<V, E> implements Graph<V, E>
{
	private ArrayList<V> vertices;
	private HashMap<E, ArrayList<V>> edges;
	
	public UndirectedSparseSimpleGraph(int initialVertexCapacity)
	{
		vertices = new ArrayList<>(initialVertexCapacity);
		edges = new HashMap<>();
	}

	public void addVertex(V v)
	{
		vertices.add(v);
	}

	public void addEdge(V source, V destination, E e, EdgeDirection edgeDirection)
	{
		/*ArrayList<DefaultVertex> endpoints = new ArrayList<DefaultVertex>(2);
		endpoints.add(e.getFirstVertex());
		endpoints.add(e.getSecondVertex());
		edges.put(e, endpoints);*/
	}

	public void removeVertex(V v)
	{
		/*vertices.remove(v);
		
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
		*/
		//DefaultVertex.existingVertices--;
	}

	public void removeEdge(V source, V destination, E e)
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

	public boolean containsVertex(V v)
	{
		//return v.getID() < vertices.size();
		return vertices.contains(v);
	}

	public boolean containsEdge(E e)
	{
		//return e.getID() < edges.size();
		return edges.containsKey(e);
	}
	
	public boolean edgeBetween(V source, V dest)
	{
		return false;
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

	public Collection<V> getVertices()
	{
		return vertices;
	}

	public Collection<E> getEdges()
	{
		return edges.keySet();
	}

	public Collection<V> getNeighborsOf(V v)
	{
		/*ArrayList<DefaultVertex> neighbors = new ArrayList<DefaultVertex>();
		
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
		return neighbors;*/
		return null;
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
