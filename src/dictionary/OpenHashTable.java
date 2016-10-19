package dictionary;

public class OpenHashTable implements Dictionary {
	
	private DictionaryItem[] a;
	private int size;
	private int count;
	
	public OpenHashTable(int size) {
		a = new DictionaryItem[size];
		this.size = size;
		count = 0;
		for (int i=0;i<size;i++) {
			a[i] = new DictionaryItem();
			a[i].key = new String("");
			a[i].value = new String("");
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
			h = (h*256 + (byte)str.charAt(i) + (i+1)) % size;		
		return h;
	}
	
	public boolean add(DictionaryItem x) {
		if (size == count || x.key.equals("")) {
			return false;
		}
		int tmp = hash(x.key);
		for (int i=0;i<=size;i++)
		{
			if (a[tmp].key.equals(x.key)) {
				a[tmp].value = x.value;
				return true;
			}
			if (a[tmp].key.equals(""))
			{
				a[tmp].key = x.key;
				a[tmp].value = x.value;
				count++;
				return true;
			}
			else
			{
				tmp = (tmp + 1) % size;
			}
		}
		return false;
	}

	public String find(String key) {
		if (key.equals("")) {
			return null;
		}
		int tmp = hash(key);
		for (int i=0;i<=size;i++)
		{
			if (a[tmp].key.equals(key))
			{
				return a[tmp].value;
			}
			else
			{
				tmp = (tmp + 1) % size;
			}
		}
		return null;
	}

	public boolean remove(String key) {
		if (count == 0 || key.equals("")) {
			return false;
		}
		int tmp = hash(key);
		for (int i=0;i<=size;i++)
		{
			if (a[tmp].key.equals(key))
			{
				a[tmp].key = "";
				a[tmp].value = "";
				count--;
				return true;
			}
			else
			{
				tmp = (tmp + 1) % size;
			}
		}
		return false;
	}

	public void clear() {
		for (int i=0;i<size;i++) {
			a[i].key = "";
			a[i].value = "";
		}
		count = 0;
	}
	
}
