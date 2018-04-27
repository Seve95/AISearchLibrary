package nicola.severini.search.classes;


import nicola.severini.search.interfaces.IState;

public class SearchResult {

	
	private IState goalState;
	private MultiHashMap <Integer, Node> path;
	
	public SearchResult(IState goalState, MultiHashMap <Integer, Node> path) {
		this.goalState = goalState;
		this.path = path;
	}
	
	public void addToPath(int key, Node value) {
		path.put(key, value);
	}
	
	public SearchResult() {
		path = new MultiHashMap <Integer, Node>();
	}

	public IState getState() {
		return goalState;
	}

	public void setState(IState goalState) {
		this.goalState = goalState;
	}

	public MultiHashMap <Integer, Node> getPath() {
		return path;
	}

	public void setPath(MultiHashMap <Integer, Node> path) {
		this.path = path;
	}
	
	public String simpleToString() {
		if (this.goalState == null) {
			return "Not found";
		} else return this.goalState.toString(); 
	}
	
	public String completeToString() {
		String res = "";
		if (this.goalState == null) {
			res += "Not found";
		}
		else {
			res += "State: " + goalState.toString() + "\n\n";
			res += "Path: \n";
			for (int i = 0; i<path.size(); i++) {
				res += path.getKeys().get(i) + " " + path.getValues().get(i) +"\n";
			}
		}
		return res;
	}
	
}
