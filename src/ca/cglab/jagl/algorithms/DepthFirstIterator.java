package ca.cglab.jagl.algorithms;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

import ca.cglab.jagl.graph.Graph;
import ca.cglab.jagl.util.Stack;

public class DepthFirstIterator<V, E> extends GraphTraversalIterator<V, E>
{
	private final List<V> visitedVertices = new ArrayList<>();
	private final Stack<V> stack = new Stack<>();
	
	public DepthFirstIterator(Graph<V, E> graph, V startingVertex)
	{
		super(graph);
		stack.push(startingVertex);
	}

	public boolean hasNext()
	{
		return !stack.isEmpty();
	}

	public V next() throws NoSuchElementException
	{
		V next = stack.pop();
		if(!visitedVertices.contains(next))
		{
			visitedVertices.add(next);
			Collection<V> neighbors = graph.getNeighborsOf(next);
			for(V v : neighbors)
			{
				stack.push(v);
			}
		}
		return next;
	}

	public Collection<V> getVisitedVertices()
	{
		return visitedVertices;
	}

}
