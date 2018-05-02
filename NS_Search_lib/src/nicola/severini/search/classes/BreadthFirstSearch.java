package nicola.severini.search.classes;

public class BreadthFirstSearch {

	private TreeSearch tree;
	
	public BreadthFirstSearch(TreeSearch tree) {
		this.tree = tree;
	}
	
	public SearchResult search(boolean onlyFrontier) {
		SearchResult res = new SearchResult();
		boolean found = false;
		while(!found) {
			for(int i = 0; i<tree.getFrontier().size(); i++) {
				Node currentNode = tree.getFrontier().get(i);
				int currentLevel = tree.getFrontierLevel();
				if(currentNode.getState().isGoalTest()) {
					found = true;
					res.setState(currentNode.getState());
					res.addToPath(currentLevel, currentNode);
					while (currentNode.getFather() != null) {
						currentLevel --;
						currentNode = currentNode.getFather();
						res.addToPath(currentLevel, currentNode);
					}
					break;
				}
			}
			tree.addNewFrontier(onlyFrontier);
		}
		return res;
	}
	
}
