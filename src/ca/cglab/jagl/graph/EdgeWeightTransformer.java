package ca.cglab.jagl.graph;

public interface EdgeWeightTransformer<V, E>
{
	
	/**
	 * @param v1 Source vertex
	 * @param v2 Destination vertex
	 * @return The weight of the edge between them, if it exists
	 */
	double weightOf(V v1, V v2);
}
