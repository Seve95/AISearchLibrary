package nicola.severini.search.test;

import java.util.ArrayList;
import java.util.List;

import nicola.severini.search.interfaces.IState;

public class MyState implements IState {
	
	private int val1;
	private int val2;
	
	
	public MyState(int val1, int val2) {
		this.val1 = val1;
		this.val2 = val2;
	}

	@Override
	public boolean isGoalTest() {
		return val1 == 0 && val2 == 0;
	}

	@Override
	public List<IState> getSuccessors() {
		ArrayList<IState> res = new ArrayList<IState>();
		
		if(!isGoalTest()) {
			if(val1 >= val2) {
				res.add(new MyState(this.val1-1, this.val2));
			} if (val2 >= val1) {
				res.add(new MyState(this.val1, this.val2-1));
			}
		}
		return res;
	}
	
	public String toString() {
		return "(" + this.val1 + ", " + this.val2 + ")";
	}

}
