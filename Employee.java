package application;



public class Employee  implements Comparable<Employee>{
	private String name;
	private int age;
	private String dep;
	private String date;
	private String gender;
	private String line;
	private String employeeId;
	
	
	
	public String getEmployeeId() {
		return employeeId;
	}



	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		
		if(age>=0) {
			
		
		
		this.age = age;
		}else {
			System.out.println("you just enterd unsuitable age ");
		}
	}



	public String getDep() {
		return dep;
	}



	public void setDep(String dep) {
		this.dep = dep;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		
		if(gender.equalsIgnoreCase("female")||gender.equalsIgnoreCase("male")) {
			
		
		this.gender = gender;
		}else {
			System.out.println("you have enterd invalid gender"); // i didn't make the gender invalid because when a user enters a wrong value i dont want to be saved like this.
		}
	}


	
	
	
	
	public Employee(){
		
	}
	
	
	
	public Employee(String line) {
		setLine(line);
		
	}
	
	
	public Employee(String employeeId,String name,int age,String dep,String date,String gender) {
		
		setEmployeeId(employeeId);
		setName(name);
		setAge(age);
		setDep(dep);
		setDate(date);
		setGender(gender);
		
	}



	public String getLine() {
		return line;
	}



	public void setLine(String line) {
		this.line = line;
	}
	@Override
	public String toString() {
		return this.employeeId+","+this.name+" ,"+this.age+", "+this.dep+" ,"+this.date+","+this.gender;
	}



	@Override
	public int compareTo(Employee o) {
		if(this.employeeId.compareToIgnoreCase(o.employeeId)>0) {
			return 1;
			
		}else if(this.employeeId.compareToIgnoreCase(o.employeeId)<0) {
			return -1;
		}else {
			
		
		return 0;}
		
	}
	
	
	
	
	
	
	

}
