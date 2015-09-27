package ca.cglab.jagl.graph;

public interface MixedGraph<V, E> extends UndirectedGraph<V, E>, DirectedGraph<V, E>
{
	EdgeDirection directionOf(V source, V destination, E edge);
}
