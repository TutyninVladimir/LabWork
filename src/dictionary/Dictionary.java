package dictionary;

public interface Dictionary {

	boolean add(DictionaryItem a);
	String find(String key);
	int getSize();
	int getCount();
	boolean remove(String key);
	void clear();
}
