package hashTablesHandsOn;
public class Employee{
  private static int id;
  private String name;
  private String email;
  
  public Employee() {
    this.id = 0;
    this.name = null;
    this.email = null;
  }
  
  public Employee(String name, String email) {
	this.id =  = (int)((Math.random()*100)+1);
    this.name = name;
    this.email = email;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getEmail() {
    return this.email;
  }
  
  public int getId() {
    return this.id;
  }
  
  public boolean equals(Employee employee) {
    return hashCode() == employee.hashCode(); 
  }
  
  public int hashCode() {
    return name.hashCode();
  }
  
  public String toString() {
    return "Name: "+name+" Email: "+email+" Id: "+id;
  }
}