package nicola.severini.search.classes;

import java.util.ArrayList;
import java.util.List;

import nicola.severini.search.interfaces.IState;

public class SearchResult {

	private IState state;
	private MultiHashMap <Integer, Node> path;
	
	public SearchResult(IState state, MultiHashMap <Integer, Node> path) {
		this.state = state;
		this.path = path;
	}
	
	public void addToPath(int key, Node value) {
		path.put(key, value);
	}
	
	public SearchResult() {
		path = new MultiHashMap <Integer, Node>();
	}

	public IState getState() {
		return state;
	}

	public void setState(IState state) {
		this.state = state;
	}

	public MultiHashMap <Integer, Node> getPath() {
		return path;
	}

	public void setPath(MultiHashMap <Integer, Node> path) {
		this.path = path;
	}
	
}
