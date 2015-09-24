package ca.cglab.jagl.graph;

public interface EdgeWeightTransformer<E>
{
	
	/**
	 * @param e An edge
	 * @return The weight of an edge
	 */
	double weightOf(E e);
}
