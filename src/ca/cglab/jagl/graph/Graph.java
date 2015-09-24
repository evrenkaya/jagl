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
 */
/**
 * @author Brayden
 *
 * @param <V>
 * @param <E>
 */
public interface Graph<V, E>
{
	/**
	 * Adds the given vertex to the graph.
	 * 
	 * @param v A vertex
	 */
	void addVertex(V v);
	
	/**
	 * Adds the given edge to the graph.
	 * 
	 * @param e An edge
	 * @param v1 First vertex attached to e
	 * @param v2 Second vertex attached to e
	 * @param edgeDirection Direction of edge e
	 */
	void addEdge(V source, V destination, E e, EdgeDirection edgeDirection);
	
	/**
	 * @param v A vertex
	 */
	void removeVertex(V v);
	
	/**
	 * @param e An edge
	 */
	void removeEdge(V source, V destination, E e);
	
	void removeAllVertices();
	
	void removeAllEdges();
	
	/**
	 * @return Number of vertices currently in this graph
	 */
	int numVertices();
	
	/**
	 * @return Number of edges currently in this graph
	 */
	int numEdges();
	
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
	 * @return true if one or more edges between source and dest
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
	
	int UNDIRECTED_EDGE = 0;
	int DIRECTED_EDGE = 1;
}
