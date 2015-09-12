package ca.cglab.jagl.algorithms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import ca.cglab.jagl.graph.DefaultVertex;
import ca.cglab.jagl.graph.Graph;

/**
 * @author Evren Kaya
 */
public class ConnectedComponentsGraphAlgorithm implements GraphAlgorithm
{
	private final Graph graph;
	private ArrayList<ArrayList<DefaultVertex>> connectedComponents;

	
	public ConnectedComponentsGraphAlgorithm(Graph graph)
	{
		this.graph = graph;
	}
	// This method only needs to be called once
	public void run()
	{
		connectedComponents = new ArrayList<ArrayList<DefaultVertex>>();
		
		Collection<DefaultVertex> vertices = graph.getVertices();
		Iterator<DefaultVertex> vertexIterator = vertices.iterator();
		HashSet<DefaultVertex> visitedVertices = new HashSet<DefaultVertex>();
		
		// Start with the first component in the iterator
		ArrayList<DefaultVertex> first = getComponentWith(vertexIterator.next());
		visitedVertices.addAll(first);
		connectedComponents.add(first);

		while(vertexIterator.hasNext())
		{
			DefaultVertex v = vertexIterator.next();
			if(!visitedVertices.contains(v))
			{
				// Determine the connected component that v is in
				ArrayList<DefaultVertex> nextComponent = getComponentWith(v);
				visitedVertices.addAll(nextComponent);
				connectedComponents.add(nextComponent);
			}
		}
	}
	
	public ArrayList<DefaultVertex> getComponentWith(DefaultVertex v)
	{
		BreadthFirstIterator iterator = new BreadthFirstIterator(graph, v);
		ArrayList<DefaultVertex> component = new ArrayList<DefaultVertex>();
		while(iterator.hasNext())
		{
			component.add(iterator.next());
		}
		return component;
	}
	
	
	public int numComponentsWithExactlyKVertices(int k)
	{
		int total = 0;
		for(ArrayList<DefaultVertex> v : connectedComponents)
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
		for(ArrayList<DefaultVertex> v : connectedComponents)
		{
			if(v.size() >= k)
			{
				total++;
			}
		}
		
		return total;
	}

}
