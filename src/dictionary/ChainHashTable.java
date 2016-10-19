package dictionary;

import java.util.ArrayList;
import java.util.List;

public class ChainHashTable implements Dictionary {
	List<DictionaryItem> a[];
	private int size;
	private int count;
	
	public ChainHashTable(int size) {
		a = new List[size];
		this.size = size;
		count = 0;
		for (int i=0;i<size;i++) {
			a[i] = new ArrayList<DictionaryItem>();
		}
	}
	
	public int getSize() {
		return size;
	}
	
	public int getCount() {
		return count;
	}
	
	int hash(String str) {
		int h = 0;
		if (str == null || str.equals(""))
			return 0;
		for(int i=0;i<str.length();i++) 
			h = (h*256 + (byte)str.charAt(i)) % size;		
		return h;
	}
	
	public boolean add(DictionaryItem x) {
		if (size == count || x.key.equals("")) {
			return false;
		}
		int tmp = hash(x.key);
		DictionaryItem elem = new DictionaryItem();
		elem.key = x.key;
		elem.value = x.value;
		for(int i = 0;i<a[tmp].size();i++) {
			if (a[tmp].get(i).key.equals(x.key)) {
				a[tmp].set(i, elem);
				return true;
			}
		}
		a[tmp].add(elem);
		count++;
		return true;
	}

	public String find(String key) {
		if (key == "") {
			return null;
		}
		int tmp = hash(key);
		for(int i = 0;i<a[tmp].size();i++) {
			if (a[tmp].get(i).key.equals(key))
				return a[tmp].get(i).value;
		}
		return null;
	}

	public boolean remove(String key) {
		if (count == 0 || key == "") {
			return false;
		}
		int tmp = hash(key);
		for(int i = 0;i<a[tmp].size();i++) {
			if (a[tmp].get(i).key.equals(key)) {
				a[tmp].remove(i);
				count--;
				return true;
			}
		}
		return false;
	}

	public void clear() {
		for (int i=0;i<size;i++) {
			a[i].clear();
		}
		count = 0;
	}
	
}