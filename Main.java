package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Main extends Application {

	private TableView<Employee> table;
	myList<Employee> employees1 = new myList<>(8);
	VBox mainLayout=new VBox();

	@Override
	public void start(Stage primaryStage) {
		

		table = new TableView<>();
		
		
		
	


			Label l1 = new Label("choose a file");
			FileChooser f1 = new FileChooser();
			Button b1 = new Button("choose a file");
			Button b2 = new Button("insert");
			  Button b3 = new Button("Delete");
		        Button b4 = new Button("Search");
		        Button b5 = new Button("Group by Age");
		        Button b6 = new Button("Save");
		        String buttonStyle = "-fx-background-color: #4CAF50; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 14px; " +
                        "-fx-padding: 10px; " +
                        "-fx-margin: 5px; " +
                        "-fx-border-radius: 5px; " +
                        "-fx-background-radius: 5px;";
   
   b1.setStyle(buttonStyle);
   b2.setStyle(buttonStyle);
   b3.setStyle(buttonStyle);
   b4.setStyle(buttonStyle);
   b5.setStyle(buttonStyle);
   b6.setStyle(buttonStyle);
   
		        
		        
		        
			EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ex) {
					File file = f1.showOpenDialog(primaryStage);
					try {

						Scanner scanner = new Scanner(file);
						while (scanner.hasNextLine()) {
							String line = scanner.nextLine();
							// System.out.println(line);

							String[] lines = line.split(",");

							if (lines.length != 6) {
								
								Stage sprimaryStage = new Stage();
								Label l9 =new Label("there is some missing info");
							         Scene scene = new Scene(l9, 600, 400);
							        
							        
							        primaryStage.setScene(scene);
							        primaryStage.setTitle("Employee TableView");
							        primaryStage.show();
								
								return;

							} else {
								if (lines[0].equalsIgnoreCase("employeeid") && lines[2].equalsIgnoreCase("age")) {
									continue;
								} else {

									Employee employee = new Employee(lines[0], lines[1], Integer.parseInt(lines[2]),
											lines[3], lines[4], lines[5]);
									// if(employees.size()>0) {

									employees1.insert(employee);

								}
							}

						}
						for(int i=0;i<employees1.size();i++) {
							
							table.getItems().add(employees1.getAt(i));
							
						}

						
						System.out.println("the file has been found and the data inlisted");
						
						

						TableColumn<Employee, String> idcolumn = new TableColumn<>("Id number");

						idcolumn.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
						
						
						TableColumn<Employee, String> namecolumn = new TableColumn<>("Name");

						namecolumn.setCellValueFactory(new PropertyValueFactory<>("name"));
						
						
						
						TableColumn<Employee, Integer> agecolumn = new TableColumn<>("Age");

						 agecolumn.setCellValueFactory(new PropertyValueFactory<>("age"));
						
						
						
						TableColumn<Employee, String> depcolumn = new TableColumn<>("Dep");

						depcolumn.setCellValueFactory(new PropertyValueFactory<>("dep"));
						
						
						
						TableColumn<Employee, String> datecolumn = new TableColumn<>("Date");

						datecolumn.setCellValueFactory(new PropertyValueFactory<>("date"));
						
						
						
						TableColumn<Employee, String> gendercolumn = new TableColumn<>(" Gender");

						gendercolumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
						table .getColumns().addAll(idcolumn,namecolumn,agecolumn,depcolumn,datecolumn,gendercolumn);
						
						

						HBox hbox=new HBox(10,b2,b3,b4,b5,b6);
						mainLayout.getChildren().addAll(table,hbox);
					         Scene scene = new Scene(mainLayout, 700, 500);
					        
					        
					        primaryStage.setScene(scene);
					        primaryStage.setTitle("Employee TableView");
					        primaryStage.show();
						
						
						
						
						
						
						
						
						
					        b2.setOnAction(e -> {
					         
					            mainLayout.getChildren().removeIf(node -> node instanceof HBox);

					           
					            Label lblId = new Label("Employee ID:");
					            TextField txtId = new TextField();
					            Label lblName = new Label("Name:");
					            TextField txtName = new TextField();
					            Label lblAge = new Label("Age:");
					            TextField txtAge = new TextField();
					            Label lblDep = new Label("Department:");
					            TextField txtDep = new TextField();
					            Label lblDate = new Label("Date:");
					            TextField txtDate = new TextField();
					            Label lblGender = new Label("Gender:");
					            TextField txtGender = new TextField();
					            Button add = new Button("Add");

					          
					            HBox formLayout = new HBox(10, lblId, txtId, lblName, txtName, lblAge, txtAge, lblDep, txtDep, lblDate, txtDate, lblGender, txtGender, add);

					            mainLayout.getChildren().add(formLayout);

					            add.setOnAction((e2 -> {
					                // Check for empty fields
					                if (txtId.getText().isEmpty() || txtName.getText().isEmpty() || txtAge.getText().isEmpty() ||
					                    txtDep.getText().isEmpty() || txtDate.getText().isEmpty() || txtGender.getText().isEmpty()) {
					                    Label l = new Label("There is a missing element");
					                    mainLayout.getChildren().add(l);
					                    return;
					                }

					                // Check for duplicate employee
					                for (int i = 0; i < employees1.size(); i++) {
					                    if ((employees1.getAt(i).getEmployeeId().compareToIgnoreCase(txtId.getText())==0)||(
											(employees1.getAt(i).getName().equalsIgnoreCase(txtName.getText())&&
											(employees1.getAt(i).getAge()==Integer.parseInt(txtAge.getText())&&
											(employees1.getAt(i).getDate().equalsIgnoreCase(txtDep.getText()))&&
											(employees1.getAt(i).getDate().compareToIgnoreCase(txtDep.getText())==0)&&
													(employees1.getAt(i).getGender().equalsIgnoreCase(txtGender.getText())))))) {
					                        Label l = new Label("That employee ID already exists.");
					                        mainLayout.getChildren().add(l);
					                        return;
					                    }
					                }

					                // Attempt to parse age
					                int age;
					                try {
					                    age = Integer.parseInt(txtAge.getText());
					                } catch (NumberFormatException ex1) {
					                    Label l = new Label("Age must be a number.");
					                    mainLayout.getChildren().add(l);
					                    return;
					                }

					                // Create new Employee object
					                Employee employee = new Employee(
					                    txtId.getText(),
					                    txtName.getText(),
					                    age,
					                    txtDep.getText(),
					                    txtDate.getText(),
					                    txtGender.getText()
					                );

					                // Insert the new employee into employees1 list
					                employees1.insert(employee);
					                employees1.setN(employees1.size() + 1);

					                // Add employee to the TableView
					                table.getItems().add(employee);

					                // Append new employee to the file
					                try (FileWriter writer = new FileWriter("employee.txt", true)) { // true for append mode
					                    writer.write(txtId.getText() + "," + txtName.getText() + "," + age + ","
					                                 + txtDep.getText() + "," + txtDate.getText() + "," + txtGender.getText() + "\n");
					                } catch (IOException ioException) {
					                    Label l = new Label("Error writing to file");
					                    mainLayout.getChildren().add(l);
					                }

					                // Clear input fields after adding
					                txtId.clear();
					                txtName.clear();
					                txtAge.clear();
					                txtDep.clear();
					                txtDate.clear();
					                txtGender.clear();
					            }));
					        });
					        
					        
					        

						
					        b3.setOnAction(e -> {
					            // Clear previous form if exists
					            mainLayout.getChildren().removeIf(node -> node instanceof HBox);

					            // Create label and text field for Employee ID to delete
					            Label lblIdToDelete = new Label("Employee ID to Delete:");
					            TextField txtIdToDelete = new TextField();
					            Button deleteButton = new Button("Delete");

					            
					            HBox deleteFormLayout = new HBox(10, lblIdToDelete, txtIdToDelete, deleteButton);

					            mainLayout.getChildren().add(deleteFormLayout);

					            deleteButton.setOnAction(e2 -> {
					                String idToDelete = txtIdToDelete.getText().trim();

					                // Check if the ID field is empty
					                if (idToDelete.isEmpty()) {
					                    Label errorLabel = new Label("Please enter an Employee ID.");
					                    mainLayout.getChildren().add(errorLabel);
					                    return;
					                }

					                // Check if the employee exists and delete if found
					                boolean exists = false;
					                for (int i = 0; i < employees1.size(); i++) {
					                    Employee existingEmployee = employees1.getAt(i);
					                    if (existingEmployee.getEmployeeId().compareToIgnoreCase(idToDelete) == 0) {
					                        exists = true;

					                        // Call your existing delete method
					                        boolean isDeleted = employees1.delete(existingEmployee); // Use your delete method here

					                        // Remove employee from the TableView
					                        if (isDeleted) {
					                            table.getItems().remove(existingEmployee);

					                            // Rewrite the employee file without this employee
					                            try (FileWriter writer = new FileWriter("employee.txt")) {
					                                for (int j = 0; j < employees1.size(); j++) {
					                                    Employee emp = employees1.getAt(j);
					                                    writer.write(emp.getEmployeeId() + "," + emp.getName() + "," + emp.getAge() + ","
					                                            + emp.getDep() + "," + emp.getDate() + "," + emp.getGender() + "\n");
					                                }
					                            } catch (IOException ioException) {
					                                Label errorLabel = new Label("Error writing to file.");
					                                mainLayout.getChildren().add(errorLabel);
					                            }

					                            // Notify user of successful deletion
					                            Label successLabel = new Label("Employee deleted successfully.");
					                            mainLayout.getChildren().add(successLabel);
					                        }
					                        break; // Exit the loop since we found and deleted the employee
					                    }
					                }

					                // If the employee was not found, show an error message
					                if (!exists) {
					                    Label errorLabel = new Label("Employee not found.");
					                    mainLayout.getChildren().add(errorLabel);
					                }

					                // Clear input field after deletion
					                txtIdToDelete.clear();
					            });
					        });

					        
					        
					        b4.setOnAction(e -> {
					            // Clear previous form if exists
					            mainLayout.getChildren().removeIf(node -> node instanceof HBox);

					            // Create label and text field for Employee ID to search
					            Label lblSearchId = new Label("Enter Employee ID to Search:");
					            TextField txtSearchId = new TextField();
					            Button searchButton = new Button("Search");

					            // Create an HBox for the search form
					            HBox searchFormLayout = new HBox(10, lblSearchId, txtSearchId, searchButton);

					            // Add the search form to the layout
					            mainLayout.getChildren().add(searchFormLayout);

					            searchButton.setOnAction(e2 -> {
					                String searchId = txtSearchId.getText().trim();

					                // Check if the ID field is empty
					                if (searchId.isEmpty()) {
					                    Label errorLabel = new Label("Please enter an Employee ID.");
					                    mainLayout.getChildren().add(errorLabel);
					                    return;
					                }

					                // Search for the employee
					                boolean found = false;
					                for (int i = 0; i < employees1.size(); i++) {
					                    Employee existingEmployee = employees1.getAt(i);
					                    if (existingEmployee.getEmployeeId().equalsIgnoreCase(searchId)) {
					                        // If found, display the employee information
					                        Label foundLabel = new Label("Employee Found: " +
					                                "ID: " + existingEmployee.getEmployeeId() +
					                                ", Name: " + existingEmployee.getName() +
					                                ", Age: " + existingEmployee.getAge() +
					                                ", Department: " + existingEmployee.getDep() +
					                                ", Date: " + existingEmployee.getDate() +
					                                ", Gender: " + existingEmployee.getGender());
					                        mainLayout.getChildren().add(foundLabel);
					                        found = true;
					                        break; // Exit the loop since we found the employee
					                    }
					                }

					                // If the employee was not found, show an error message
					                if (!found) {
					                    Label errorLabel = new Label("Employee not found.");
					                    mainLayout.getChildren().add(errorLabel);
					                }

					                // Clear input field after searching
					                txtSearchId.clear();
					            });
					        });
					        
					        
					       
					       
					        b6.setOnAction(e -> {

					        	try {
					        		File file1=new File("updatedEmployee.txt");
					        		PrintWriter printer=new PrintWriter(file1);
					        		for(int i=0;i<employees1.size();i++) {
					        			
					        		
					        		printer.println(employees1.getAt(i));
					        		
					        		}
					        		mainLayout.getChildren().add(new Text("it has been added to updated employee"));
					        		
					        		printer.close();
					        	}catch (FileNotFoundException e1) {
					        		System.out.println("sth went wrong with finding the file");
					        	}catch (Exception ex2) {
					        		System.out.println("sth went wrong");
					        	}
					        });


					        
						

					} catch (NumberFormatException x) {
						System.out.println("there has been an age entered inpropebly");
					} catch (FileNotFoundException e) {
						Stage s = new Stage();
						Label l = new Label("the file has not been found");
						Scene c = new Scene(l, 200, 200);
						s.setScene(c);
						s.show();

					} catch (IOException exy) {
						System.out.println("an error has been detected");
					}

				}

			};
			b1.setOnAction(event);

		
		
		
		
		
		
		

			 VBox layout = new VBox(10);
			 layout.getChildren().addAll(b1,l1);
			 layout.setStyle("-fx-padding: 20px; -fx-alignment: center;");
			 
			 
			Scene scene = new Scene(layout, 600, 400);
			primaryStage.setScene(scene);
	        primaryStage.setTitle("Employee TableView");
	        primaryStage.show();
	
		
		
		
		
		
		
		

		

		

			EventHandler<ActionEvent> e = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {

					Label l2 = new Label("please enter the info of the new employee");
					Label l3 = new Label("employee id");
					Text t1 = new Text("HERE");

					Label l4 = new Label("employee id");
					Text t2 = new Text();

					Label l5 = new Label("employee id");
					Text t3 = new Text();

					Label l6 = new Label("employee id");
					Text t4 = new Text();

					Label l7 = new Label("employee id");
					Text t5 = new Text();

					Label l8 = new Label("employee id");
					Text t6 = new Text();

					Stage sprimaryStage = new Stage();
					VBox g5 = new VBox();
					VBox g6 = new VBox();
					g5.getChildren().addAll( l3, l4, l5, l6, l7, l8);
					g6.getChildren().addAll(t1,t2,t4,t4,t5,t6);
					HBox h=new HBox (g5,g6);
					
					Scene scene = new Scene(h, 400, 450);

					sprimaryStage.setScene(scene);
					sprimaryStage.show();

					if ((t1.getText().equals(null)) || (t2.getText().equals(null)) || (t3.getText().equals(null))
							|| (t4.getText().equals(null)) || (t5.getText().equals(null))
							|| (t6.getText().equals(null))) {
						Label l = new Label("there is a missing element");

						sprimaryStage = new Stage();

						scene = new Scene(l, 200, 200);

						sprimaryStage.setScene(scene);
						sprimaryStage.show();
					} else {

						Employee employee = new Employee(t1.getText(), t2.getText(), Integer.parseInt(t3.getText()),
								t4.getText(), t5.getText(), t6.getText());
						if ((employees1.size() + 1) <= employees1.size()) {

							employees1.insert(employee);
							employees1.setN(employees1.size() + 1);

							sprimaryStage = new Stage();
							Label l = new Label("the new employee has been added");
							scene = new Scene(l, 200, 200);

							sprimaryStage.setScene(scene);
							sprimaryStage.show();
						} else {
							employees1.setN(employees1.size() + 1);
							employees1.insert(employee);

							sprimaryStage = new Stage();
							Label l = new Label("the new employee has been added");
							scene = new Scene(l, 200, 200);

							sprimaryStage.setScene(scene);
							sprimaryStage.show();
						}

					}

				}
		
			};

			b2.setOnAction(e);
	}
			
	
	
	
	
	


	public static void main(String[] args) {

		launch(args);

	}
}
