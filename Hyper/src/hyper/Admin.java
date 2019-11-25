/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyper;

/**
 *
 * @author Ahmed Kamal
 */
public class Admin extends EmployeeClass {
    // QUESTION TO THE TEAM LEADER ???
    //Why is the "EmloyeeID" in the child class not the parent !!!?
    private int EmployeeID ;

    //Empty constructor
    public Admin() {
    }

    //Main Constructor
    public Admin(int EmployeeID, String phonenumber, String password, String name, String type) {
        super(phonenumber, password, name, type);
        this.EmployeeID = EmployeeID;
    }

    //ID Constructor
    public Admin(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    
    //setters and getters of the child class ( Admin )
    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }
 
   //Method that search for an employee
    public void searchEmployee(int id)
    {
        //will be done after making the database or files
    }
    
       //Method that add an employee
    public void addEmployee(int id)
    {
        //will be done after making the database or files
    }
    
       //Method that delete an employee
    public void deleteEmployee(int id)
    {
        //will be done after making the database or files
    }
}


