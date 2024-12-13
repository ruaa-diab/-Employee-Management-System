package application;

public interface listable <T>{

	
	void insert(T data);
	boolean delete (T data);
	boolean search(T data);
	void clear();
	void print();
	T getAt(int index);
	int size();
}
