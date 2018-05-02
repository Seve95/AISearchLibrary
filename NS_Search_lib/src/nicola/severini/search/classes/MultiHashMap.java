package nicola.severini.search.classes;

import java.util.ArrayList;
import java.util.List;

public class MultiHashMap <X,Y> {

	private ArrayList<X> keys;
	private ArrayList<Y> values;
	
	public MultiHashMap() {
		keys = new ArrayList<X>();
		values = new ArrayList<Y>();
	}
	
	public void put(X key, Y value) {
		keys.add(key);
		values.add(value);
	}
	
	public int numberOfKey(X key) {
		int res = 0;
		for (int i = 0; i<keys.size(); i++) {
			if(keys.get(i) == key) res++;
		}
		return res;
	}
	
	public X getLastKeyLevel() {
		return keys.get(keys.size() - 1);
	}
	
	public int size() {
		return keys.size();
	}
	
	public List<X> getKeys() {
		return keys;
	}
	public List<Y> getValues() {
		return values;
	}
	
	public List<Y> getLastValues() {
		ArrayList<Y> res = new ArrayList<>();
		for(int i = 0; i<keys.size(); i++) {
			if(keys.get(i) == getLastKeyLevel()) res.add(values.get(i));
		}
		return res;
	}
	
	public List<Y> getValuesAtLevel(X key) {
		ArrayList<Y> res = new ArrayList<>();
		for(int i = 0; i<keys.size(); i++) {
			if(keys.get(i) == key) res.add(values.get(i));
		}
		
		return res;
	}
	
	public void delete(int i) {
		keys.remove(i);
		values.remove(i);
	}
}
