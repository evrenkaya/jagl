package ca.cglab.jagl.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ca.cglab.jagl.graph.EdgeWeightTransformer;
import ca.cglab.jagl.graph.Graph;

/**
 * An object that calculates the shortest path between 2 vertices in a graph,
 * the run method is based off of the pseudocode from the Wikipedia page at URL:
 * https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
 * 
 * @author Evren Kaya
 */

public class DijkstraShortestPathAlgorithm<V, E> implements GraphAlgorithm
{
	private final Graph<V, E> graph;
	
	private final V source;
	private final V dest;
	
	private final EdgeWeightTransformer<V, E> edgeWeights;
	
	private double distance;

	public DijkstraShortestPathAlgorithm(Graph<V, E> graph, V source, V dest, EdgeWeightTransformer<V, E> edgeWeights)
	{
		this.graph = graph;
		this.source = source;
		this.dest = dest;
		this.edgeWeights = edgeWeights;
		distance = 0;
	}

	public void run()
	{
		Set<V> vertices = new HashSet<>();
		Map<V, Double> dist = new HashMap<>();
		Map<V, V> prev = new HashMap<>();
		
		for(V vertex : graph.getVertices())
		{
			vertices.add(vertex);
			dist.put(vertex, Double.POSITIVE_INFINITY);
			prev.put(vertex, null);
		}
		
		dist.put(source, 0D);
		
		while(vertices.isEmpty())
		{
			V min = minDist(vertices, dist);
			if(min == dest)
			{
				distance = dist.get(min);
				break;
			}
			vertices.remove(min);
			
			for(V neighbor : graph.getNeighborsOf(min))
			{
				double alt = dist.get(neighbor) + edgeWeights.weightOf(min, neighbor);
				if(alt < dist.get(min))
				{
					dist.put(neighbor, alt);
					prev.put(neighbor, min);
				}
			}
		}
	}
	
	private V minDist(Set<V> vertices, Map<V, Double> dist)
	{
		V min = null;
		double distance = Double.MAX_VALUE;
		for(V vertex : vertices)
		{
			if(dist.get(vertex) < distance)
			{
				min = vertex;
				distance = dist.get(vertex);
			}
		}
		return min;
	}
	
	public double getShortestDistance()
	{
		return distance;
	}
}


