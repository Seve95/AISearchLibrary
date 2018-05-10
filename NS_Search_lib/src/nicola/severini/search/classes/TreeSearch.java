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
	
	public List<Node> getFrontier(int level) {
		return nodes.getValuesAtLevel(level);
	}
	
	public void addNewFrontier(boolean onlyFrontier) {
		ArrayList<Node> frontier = (ArrayList<Node>) nodes.getLastValues();
		int currentLevel = getFrontierLevel();
		for (int i = 0; i<frontier.size(); i++) {
			for (int j = 0; j<frontier.get(i).getSons().size(); j++) {
				nodes.put(currentLevel+1, frontier.get(i).getSons().get(j));
			}
		}
		if(onlyFrontier) {
			for (int i = 0; i<nodes.getKeys().size(); i++) {
				if(nodes.getKeys().get(i) != nodes.getLastKeyLevel()) nodes.delete(i);
			}
		}
	}
	
	//used by depthfirst so, set visited true
	public boolean addNewSingleNode() {
		if(nodes.getLastValues().get(0).getSons().size() > 0) {
			Node value = nodes.getLastValues().get(0).getSons().get(0);
			value.setVisited(true);
			nodes.put(getFrontierLevel()+1,  nodes.getLastValues().get(0).getSons().get(0));
			return true;
		}
		return false;
	}
	
	public boolean hasMoreBrothers(int level, int node) {
		Node father = this.getFrontier(level).get(node).getFather();
		int totalBrothers = father.getSons().size();
		
		int allocatedBrothers = 0;
		
		for (Node n : this.nodes.getValuesAtLevel(level)) {
			if(n.getFather().equals(father)) allocatedBrothers++;
		}
		
		return totalBrothers > allocatedBrothers;
	}
	
	public void addNewBrother(int level, int node) {
		//already checked a brother of that node exist
		Node father = this.getFrontier(level).get(node).getFather();
		int totalBrothers = father.getSons().size();
		int allocatedBrothers = 0;
		for (Node n : this.nodes.getValuesAtLevel(level)) {
			if(n.getFather().equals(father)) allocatedBrothers++;
		}
		
		nodes.put(level, this.getFrontier(level).get(node).getFather().getSons().get(totalBrothers - allocatedBrothers));
	}
}
