package com.network.graph;

import java.util.ArrayList;
import java.util.List;

/*
 * Main file that executes the calls all the functions
 * 
 */

public class Main {
	public static void main(String[] args) {
		ArrayList<Node> graph;
		DominatingSets dom = new DominatingSets();

		graph = GraphGenerator.generateGraph();//generates random graph
		
		//graph = generateTestGraph();//UnComment this to run test graph
		
		// Display graph and degree of each node
		System.out.println("The random graph generated for "+ GraphGenerator.NUMBER_OF_NODES +" nodes is as follows: ");
		System.out.println();
		for(Node node : graph){
			System.out.print(node.toString());
			System.out.println(" Degree : " + node.getAdj().size());
		}
		System.out.println();
		System.out.println("The Dominating Set for this graph is as follows: ");
		System.out.println();
		dom.generateDominatingSets(graph);
	}
	
	public static ArrayList<Node> generateTestGraph(){
		
		ArrayList<Node> graph = new ArrayList<Node>();
		//Enter nodes equal to NUMBER_OF_NODES initialized in GraphGenerator.java
		
		Node node1 = new Node();
		node1.setIndex(1);
		node1.setLife(10);
		List<Integer> adjlist = new ArrayList<Integer>();
		adjlist.add(5);
		adjlist.add(2);
		adjlist.add(6);
		node1.setAdj(adjlist);
		
		
		Node node2 = new Node();
		node2.setIndex(2);
		node2.setLife(10);
		adjlist = new ArrayList<Integer>();
		adjlist.add(1);
		node2.setAdj(adjlist);
		
		Node node3 = new Node();
		node3.setIndex(3);
		node3.setLife(10);
		adjlist = new ArrayList<Integer>();
		adjlist.add(10);
		adjlist.add(4);
		adjlist.add(8);
		adjlist.add(9);
		adjlist.add(7);
		node3.setAdj(adjlist);
		
		
		Node node4 = new Node();
		node4.setIndex(4);
		node4.setLife(10);
		adjlist = new ArrayList<Integer>();
		adjlist.add(3);
		node4.setAdj(adjlist);
		
		Node node5 = new Node();
		node5.setIndex(5);
		node5.setLife(10);
		adjlist = new ArrayList<Integer>();
		adjlist.add(1);
		adjlist.add(7);
		adjlist.add(9);
		adjlist.add(10);
		node5.setAdj(adjlist);
		
		Node node6 = new Node();
		node6.setIndex(6);
		node6.setLife(10);
		adjlist = new ArrayList<Integer>();
		adjlist.add(1);
		node6.setAdj(adjlist);
		
		Node node7 = new Node();
		node7.setIndex(7);
		node7.setLife(10);
		adjlist = new ArrayList<Integer>();
		adjlist.add(3);
		adjlist.add(5);
		node7.setAdj(adjlist);
		
		Node node8 = new Node();
		node8.setIndex(8);
		node8.setLife(10);
		adjlist = new ArrayList<Integer>();
		adjlist.add(3);
		adjlist.add(9);
		node8.setAdj(adjlist);
		
		Node node9 = new Node();
		node9.setIndex(9);
		node9.setLife(10);
		adjlist = new ArrayList<Integer>();
		adjlist.add(3);
		adjlist.add(5);
		adjlist.add(8);
		adjlist.add(10);
		node9.setAdj(adjlist);
		
		Node node10 = new Node();
		node10.setIndex(10);
		node10.setLife(10);
		adjlist = new ArrayList<Integer>();
		adjlist.add(3);
		adjlist.add(5);
		adjlist.add(9);
		node10.setAdj(adjlist);
		
		graph.add(node1);
		graph.add(node2);
		graph.add(node3);
		graph.add(node4);
		graph.add(node5);
		graph.add(node6);
		graph.add(node7);
		graph.add(node8);
		graph.add(node9);
		graph.add(node10);
		
		return graph;
	}
}
