package ca.cglab.jagl;

import ca.cglab.jagl.algorithms.ConnectedComponentsGraphAlgorithm;
import ca.cglab.jagl.graph.EdgeDirection;
import ca.cglab.jagl.graph.Graph;
import ca.cglab.jagl.graph.UndirectedSimpleGraph;

public class TestMain
{

	public static void main(String[] args)
	{
		final Graph<String, String> graph = new UndirectedSimpleGraph<>();
		long startTime = System.currentTimeMillis();
		
		for(int i = 0; i < 1000; i++)
		{
			String v = "#" + i;
			graph.addVertex(v);
		}
		
		
		
		for(String first : graph.getVertices())
		{
			int counter = 0;
			for(String second : graph.getVertices())
			{
				if(first != second && counter % 1000 == 0)
				{
					String edge = first + ", " + second;
					graph.addEdge(first, second, edge, EdgeDirection.UNDIRECTED);
				}
				counter++;
			}
			
		}
		new ConnectedComponentsGraphAlgorithm<String, String>(graph).run();
		long endTime = System.currentTimeMillis();
		long elapsed = endTime - startTime;
		System.out.println("Elapsed: " + elapsed);
	}
}
