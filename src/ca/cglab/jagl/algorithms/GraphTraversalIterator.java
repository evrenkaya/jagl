package ca.cglab.jagl.algorithms;

import java.util.Collection;

import ca.cglab.jagl.graph.Graph;

/**
 * An abstract class to represent any kind of graph traversal object 
 * that advances in its iteration only when told to.
 * 
 * Created on June 26, 2015
 * 
 * @author Evren Kaya
 */
public abstract class GraphTraversalIterator<V, E>
{
	protected final Graph<V, E> graph;
	
	public GraphTraversalIterator(Graph<V, E> graph)
	{
		this.graph = graph;
	}
	
	public abstract boolean hasNext();
	
	public abstract V next();
	
	public abstract Collection<V> getVisitedVertices();

}
