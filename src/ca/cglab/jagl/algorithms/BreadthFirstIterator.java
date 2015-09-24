package ca.cglab.jagl.algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

import ca.cglab.jagl.graph.Graph;

/**
 * An object that can iterate over a graph using the breadth first search.
 * Only advances to the next vertex when next() is called.
 * 
 * Created on June 26, 2015
 * 
 * @author Evren Kaya
 */
public class BreadthFirstIterator<V, E> extends GraphTraversalIterator<V, E>
{
	private final List<V> visitedVertices = new ArrayList<>();
	private final Queue<V> queue = new ArrayDeque<>();
	
	public BreadthFirstIterator(Graph<V, E> graph, V startingVertex)
	{
		super(graph);
		queue.add(startingVertex);
		visitedVertices.add(startingVertex);
	}

	public boolean hasNext()
	{
		return !queue.isEmpty();
	}

	public V next() throws NoSuchElementException
	{
		V next = queue.remove();
		Collection<V> neighbors = graph.getNeighborsOf(next);
		for(V v : neighbors)
		{
			if(!visitedVertices.contains(v))
			{
				queue.add(v);
				visitedVertices.add(v);
			}
		}
		
		return next;
	}
	
	public Collection<V> getVisitedVertices()
	{
		return visitedVertices;
	}

}
