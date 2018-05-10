package nicola.severini.search.classes;

import java.util.ArrayList;
import java.util.List;

public class TreeSearch {
	
	private ArrayList<ArrayList<Node>> nodes;
	
	public TreeSearch(Node root) {
		nodes = new ArrayList<ArrayList<Node>>();
		ArrayList<Node> inner = new ArrayList<>();
		inner.add(root);
		nodes.add(inner);
	}
	
	public int getFrontierLevel() {
		return nodes.size();
	}
	
	public ArrayList<Node> getFrontier() {
		return nodes.get(nodes.size()-1);
	}
	
	public List<Node> getFrontier(int level) {
		return nodes.get(level);
	}
	
	public void addNewFrontier() {
		ArrayList<Node> frontier = this.getFrontier();
		ArrayList<Node> newFrontier = new ArrayList<>();
		for (int i = 0; i<frontier.size(); i++) {
			for (int j = 0; j<frontier.get(i).getSons().size(); j++) {
				newFrontier.add(frontier.get(i).getSons().get(j));
			}
		}
		nodes.add(newFrontier);
	}
}
