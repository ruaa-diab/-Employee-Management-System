package application;


public class myList<T extends Comparable <T>> implements listable<T> {
	
	
	private T[] arr;
	
	private int n=0;
	
	
	public myList(int s) {
		arr=(T[])new Comparable[s];
	}
	@Override
	public void insert(T data) {
		
		if(n<arr.length) {
			arr[n]=data;
			n++;
		}else {
			System.out.println("the list is full");
			
		}
		
		
		
	}
	public T[] getArr() {
		return arr;
	}
	public void setArr(T[] arr) {
		this.arr = arr;
	}
	
	public void setN(int n) {
		if(n>=0) {
			
		
		this.n = n;
	}else {
		
	
	System.out.println("inavlid number");	
	}
	
	}
	@Override
	public boolean delete(T data) {
		
		for(int i=0;i<n;i++) {
			if(data.compareTo(arr[i])==0) {
				
				
				for(int j=i;j<n-1;j++) {
					arr[j]=arr[j+1];
					
					
					
				}
				n--;
				return true;
				
			}
			
			return false;
		}
		return false;
		
	}
	@Override
	public boolean search(T data) {
		for(int i=0;i<n;i++) {
			if(data.compareTo(arr[i])==0) {
				return true;
			}}
	
		return false;
	
	}
	@Override
	public void clear() {
		n=0;
		
		
	}
	@Override
	public void print() {
		for (int i=0;i<n;i++) {
			System.out.println(i+" "+arr[i]);
			
		}
		
	}
	@Override
	public T getAt(int index) {
		if(index<n)
			return arr[index];
		else {
			
		
		return null;
	}}
	
	
	
	@Override
	public int size() {
		
		return n;
	}
	
	
	
	
	

}

