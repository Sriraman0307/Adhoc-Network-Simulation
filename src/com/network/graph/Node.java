package com.network.graph;

import java.util.ArrayList;
import java.util.List;

/*
 * Class Node contains information about each node of graph 
 */

public class Node {
	private int index;
	private int life;
	private List<Integer> adj = new ArrayList<Integer>();


	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}

	public List<Integer> getAdj() {
		return adj;
	}
	public void setAdj(List<Integer> adj) {
		this.adj = adj;
	}
	@Override
	public String toString() {
		return "Node [index=" + index + ", life=" + life
				+ ", adj=" + adj + "]";
	}
}
