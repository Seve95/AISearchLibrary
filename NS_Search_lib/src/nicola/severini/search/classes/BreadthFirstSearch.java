package nicola.severini.search.classes;

public class BreadthFirstSearch {

	private TreeSearch tree;
	
	public BreadthFirstSearch(TreeSearch tree) {
		this.tree = tree;
	}
	
	public SearchResult search() {
		SearchResult res = new SearchResult();
		boolean found = false;
		while(!found) {
			for(int i = 0; i<tree.getFrontier().size(); i++) {
				Node currentNode = tree.getFrontier().get(i);
				int currentLevel = tree.getFrontierLevel();
				if(currentNode.getState().isGoalTest()) {
					found = true;
					res.setState(currentNode.getState());
					break;
				}
			}
			tree.addNewFrontier();
		}
		return res;
	}
	
}
