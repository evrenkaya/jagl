package ca.cglab.jagl.algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Queue;

import ca.cglab.jagl.graph.DefaultVertex;
import ca.cglab.jagl.graph.Graph;

/**
 * An object that can iterate over a graph using the breadth first search.
 * Only advances to the next vertex when next() is called.
 * 
 * Created on June 26, 2015
 * 
 * @author Evren Kaya
 */
public class BreadthFirstIterator extends GraphTraversalIterator
{
	private final ArrayList<DefaultVertex> visitedVertices = new ArrayList<DefaultVertex>();
	private final Queue<DefaultVertex> queue = new ArrayDeque<DefaultVertex>();
	
	public BreadthFirstIterator(Graph graph, DefaultVertex startingVertex)
	{
		super(graph);
		queue.add(startingVertex);
		visitedVertices.add(startingVertex);
	}

	public boolean hasNext()
	{
		return !queue.isEmpty();
	}

	public DefaultVertex next() throws NoSuchElementException
	{
		DefaultVertex next = queue.remove();
		Collection<DefaultVertex> neighbors = graph.getNeighborsOf(next);
		for(DefaultVertex v : neighbors)
		{
			if(!visitedVertices.contains(v))
			{
				queue.add(v);
				visitedVertices.add(v);
			}
		}
		
		return next;
	}
	
	public Collection<DefaultVertex> getVisitedVertices()
	{
		return visitedVertices;
	}

}
