package nicola.severini.search.test;

import java.util.ArrayList;
import java.util.List;

import nicola.severini.search.interfaces.IState;

public class SquareState implements IState{
	
	private int [][] matrix;
	private int freeSquare;
	private int lastValue;
	
	
	public SquareState() {
		matrix = new int[10][10];
		init();
		
	}
	
	public SquareState(int [][] matrix) {
		int [][] copy = new int[10][10];
		
		for (int i = 0; i < 10; i++) {
			System.arraycopy(matrix[i], 0, copy[i] , 0, matrix[i].length);
		}
		
		this.matrix = copy;
		this.freeSquare = calcFree();
		this.lastValue = 100 - freeSquare;
	}
	

	
	private void init() {
		for (int i = 0; i<10; i++) {
			for(int j = 0; j<10; j++) {
				matrix[i][j] = 0;
			}
		}
		matrix[0][0] = 1;
		freeSquare = 99;
		lastValue = 1;
	}
	
	private boolean isFree(int val) {
		return val == 0;
	}
	
	private int calcFree() {
		int res = 0;
		for (int i = 0; i<10; i++) {
			for(int j = 0; j<10; j++) {
				if(isFree(matrix[i][j])) res++;
			}
		}
		return res;
	}

	private void setValue(int i, int j, int val) {
		this.matrix[i][j] = val;
		this.freeSquare--;
		this.lastValue++;
	}
	
	@Override
	public List<IState> getSuccessors() {

		List<IState> res = new ArrayList<>();
		
		for (int i = 0; i<10; i++) {
			for(int j = 0; j<10; j++) {
				if(!isFree(matrix[i][j]) && matrix[i][j] == lastValue) {
					//Horizontal
					if(i+2 < 10 && isFree(matrix[i+2][j])) {
						res.add(assignValue(i+2, j, lastValue+1));
					}
					if(i-2 >=0 && isFree(matrix[i-2][j])) {
						res.add(assignValue(i-2, j, lastValue+1));
					}
					
					//Vertical
					if(j-2 >=0 && isFree(matrix[i][j-2])) {
						res.add(assignValue(i, j-2, lastValue+1));
					}
					if(j+2 <10 && isFree(matrix[i][j+2])) {
						res.add(assignValue(i, j+2, lastValue+1));
					}
					
					//Oblique
					if(i+1 <10 && j+1 <10 && isFree(matrix[i+1][j+1])) {
						res.add(assignValue(i+1, j+1, lastValue+1));
					}
					if(i+1 <10 && j-1 >=0 && isFree(matrix[i+1][j-1])) {
						res.add(assignValue(i+1, j-1, lastValue+1));
					}
					if(i-1 >=0 && j+1 <10 && isFree(matrix[i-1][j+1])) {
						res.add(assignValue(i-1, j+1, lastValue+1));
					}
					if(i-1 >=0 && j-1 >=0 && isFree(matrix[i-1][j-1])) {
						res.add(assignValue(i-1, j-1, lastValue+1));
					}
				}
			}
		}
		return res;
	}

	@Override
	public boolean isGoalTest() {
		return freeSquare == 50;
	}
	
	private SquareState assignValue (int i, int j, int val) {
		SquareState newState = new SquareState(this.matrix);
		
		newState.setValue(i, j, val);
		
		return newState;
	}
	
	public String toString() {
		String res = "";
		for (int i = 0; i<10; i++) {
			for(int j = 0; j<10; j++) {
				if (isFree(matrix[i][j])) res += "- ";
				else res += matrix[i][j]+ " ";
			}
			res+="\n";
		}
		return res;
	}

}
