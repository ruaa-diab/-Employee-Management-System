package application;

public class ArrayStack<T extends Comparable <T >> {
	
	
	private Object[] arr;
	private int i=-1;
	
	public ArrayStack(int c) {
		arr=new Object[c];
	}
	
	
	
	
	
	public boolean isEmpty() {
		return i==-1;
	}
	public void push(T data) {
		arr[++i]=data;
	}
	
	
	public Object pop(){
		
		if(!isEmpty()) 
			return arr[i--];
			return null;
		
		
	}





	public int getI() {
		return i;
	}





	public void setI(int i) {
		this.i = i;
	}
	
	
	
	
	public String toString() {
		   String res = "Top-->"; 
	        for(int j=i; j>=0;j--) 
	            res+="["+arr[j]+"]-->"; 
	        return res+"Null"; 
	}
	
	
	
	
	
	
	
	

}
