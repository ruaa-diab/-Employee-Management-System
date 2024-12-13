package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class loadFile {
	public static void main(String[] args) {
		
		myList<Employee>employees=new myList<>(10);
		
	
	
	try {
		File file=new File("employee.txt");
		
		Scanner scanner=new Scanner(file);
		while(scanner.hasNextLine()) {
			String line =scanner.nextLine();
			
	
			
			String[] lines=line.split(",");
			
			if(lines.length!=6) {
				System.out.println("there is some missing info");
				
			}else {
				if(lines[0].equalsIgnoreCase("employeeid")&&lines[2].equalsIgnoreCase("age")) {
					continue;
				}else {
				
				Employee employee=new Employee(lines[0],lines[1],Integer.parseInt(lines[2]),lines[3],lines[4],lines[5]);
				//if(employees.size()>0) {
					
				
				employees.insert(employee);
				
			}
			}
		
		}
	}catch (NumberFormatException x) {
		System.out.println("there has been an age entered inpropebly");
			} catch (FileNotFoundException e) {
				System.out.println("the file has not been found");
				
			}catch (IOException ex) {
				System.out.println("an error has been detected");
			}
	
	
	
	System.out.println(employees.size());
	
	
	try {
		File file1=new File("updatedEmployee.txt");
		PrintWriter printer=new PrintWriter(file1);
		for(int i=0;i<employees.size();i++) {
			
		
		printer.println(employees.getAt(i));
		
		}
		printer.close();
	}catch (FileNotFoundException e) {
		System.out.println("sth went wrong with finding the file");
	}catch (Exception ex) {
		System.out.println("sth went wrong");
	}
	//System.out.println(employees1.print());

	
//employees.print();
			
				
		}
			
		
	}

	
	
	


