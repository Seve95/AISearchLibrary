package nicola.severini.search.classes;

import java.util.ArrayList;
import java.util.List;

public class TreeSearch {
	
	private MultiHashMap<Integer, Node> nodes;
	
	public TreeSearch(Node root) {
		nodes = new MultiHashMap<>();
		nodes.put(0, root);
	}
	
	public int getFrontierLevel() {
		return nodes.getLastKeyLevel();
	}
	
	public List<Node> getFrontier() {
		return nodes.getLastValues();
	}
	
	public void addNewFrontier() {
		ArrayList<Node> frontier = (ArrayList<Node>) nodes.getLastValues();
		int currentLevel = getFrontierLevel();
		for (int i = 0; i<frontier.size(); i++) {
			nodes.put(currentLevel+1, frontier.get(i));
		}
	}
	

}
