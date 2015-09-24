package ca.cglab.jagl.algorithms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import ca.cglab.jagl.graph.Graph;

/**
 * @author Evren Kaya
 */
public class ConnectedComponentsGraphAlgorithm<V, E> implements GraphAlgorithm
{
	private final Graph<V, E> graph;
	private ArrayList<ArrayList<V>> connectedComponents;

	
	public ConnectedComponentsGraphAlgorithm(Graph<V, E> graph)
	{
		this.graph = graph;
	}
	// This method only needs to be called once
	public void run()
	{
		connectedComponents = new ArrayList<>();
		
		Collection<V> vertices = graph.getVertices();
		Iterator<V> vertexIterator = vertices.iterator();
		HashSet<V> visitedVertices = new HashSet<>();
		
		// Start with the first component in the iterator
		ArrayList<V> first = getComponentWith(vertexIterator.next());
		visitedVertices.addAll(first);
		connectedComponents.add(first);

		while(vertexIterator.hasNext())
		{
			V v = vertexIterator.next();
			if(!visitedVertices.contains(v))
			{
				// Determine the connected component that v is in
				ArrayList<V> nextComponent = getComponentWith(v);
				visitedVertices.addAll(nextComponent);
				connectedComponents.add(nextComponent);
			}
		}
	}
	
	public ArrayList<V> getComponentWith(V v)
	{
		BreadthFirstIterator<V, E> iterator = new BreadthFirstIterator<>(graph, v);
		ArrayList<V> component = new ArrayList<>();
		while(iterator.hasNext())
		{
			component.add(iterator.next());
		}
		return component;
	}
	
	
	public int numComponentsWithExactlyKVertices(int k)
	{
		int total = 0;
		for(ArrayList<V> v : connectedComponents)
		{
			if(v.size() == k)
			{
				total++;
			}
		}
		
		return total;
	}
	
	public int numComponentsWithAtLeastKVertices(int k)
	{
		int total = 0;
		for(ArrayList<V> v : connectedComponents)
		{
			if(v.size() >= k)
			{
				total++;
			}
		}
		
		return total;
	}

}
