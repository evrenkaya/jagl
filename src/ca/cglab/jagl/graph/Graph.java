package ca.cglab.jagl.graph;

import java.util.Collection;

/**
 * In graph theory, a graph G is defined as a non-empty set of vertices and a set of edges.
 * This interface specifies possible operations on all types of graphs.
 * All graphs should be able to add/remove vertices/edges, provide an
 * iterator over the collection of vertices and edges, and keep track of
 * the vertex and edge count. The storing of the vertices and edges is
 * left up to all implementing classes.
 * <br>
 * <br>
 * Created on June 26, 2015
 * 
 * @author Evren Kaya
 * 
 * @param <V> The Vertex data type
 * @param <E> The Edge data type
 */
public interface Graph<V, E>
{
	/**
	 * Adds <code>v</code> to the graph if it does not already exist.
	 * 
	 * @param v A vertex
	 */
	void addVertex(V v);
	
	/**
	 * Adds the <code>e</code> to the graph. In a graph where multi 
	 * edges are permitted, there may be more than edge between 
	 * <code>source</code> and <code>dest</code>. In a graph where multi edges
	 * are not permitted, if one edge is already present between
	 * <code>source</code> and <code>dest</code>, this method does
	 * not change the graph.
	 * 
	 * @param e An edge
	 * @param source Source vertex attached to <code>e</code>
	 * @param dest Destination vertex attached to <code>e</code>
	 * @param edgeDirection Direction of edge e
	 */
	void addEdge(V source, V dest, E e, EdgeDirection edgeDirection);
	
	/**
	 * Removes <code>v</code> from the graph if it has not already been removed.
	 * Also removes any edges <code>v</code> was attached to.
	 * 
	 * @param v A vertex
	 */
	void removeVertex(V v);
	
	/**
	 * Removes the given edge <code>e</code> between <code>source</code>
	 * and <code>dest</code> vertices from the graph if it has not already been removed.
	 * 
	 * @param source Source vertex attached to <code>e</code>.
	 * @param dest Destination vertex attached to <code>e</code>.
	 * @param e An edge
	 */
	void removeEdge(V source, V dest, E e);
	
	/**
	 * Removes all the vertices and edges in the graph.
	 * 
	 */
	void removeAllVertices();
	
	/**
	 * Removes all the edges in the graph, leaving the vertices unchanged.
	 * 
	 */
	void removeAllEdges();
	
	/**
	 * @param v A vertex
	 * @return True if vertex is in the graph, false if it is not contained or it is null
	 */
	boolean containsVertex(V v);
	
	/**
	 * @param e An edge
	 * @return True if edge is in the graph, false if it is not contained or it is null
	 */
	boolean containsEdge(E e);
	
	
	/**
	 * @param source vertex
	 * @param dest vertex
	 * @return true if one or more edges exist between <code>source</code>
	 * and <code>dest</code>
	 */
	boolean edgeBetween(V source, V dest);
	
	/**
	 * @return A collection of all vertices in this graph.
	 */
	Collection<V> getVertices();
	
	/**
	 * @return A collection of all edges in this graph
	 */
	Collection<E> getEdges();
	
	/**
	 * @param v The vertex to get the neighbors of
	 * @return A collection view of all the traversable vertex neighbors of <code>v</code>
	 */
	Collection<V> getNeighborsOf(V v);
}
