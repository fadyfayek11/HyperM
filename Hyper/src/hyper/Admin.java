
package hyper;


public class Admin extends EmployeeClass{
    
    
    
  /*main constractor*/  
public  Admin(int id_of_employee, String phonenumber, String password, String name, String type)    
{
        super(id_of_employee, phonenumber, password, name, type);
       
}


/*empty constractor*/
    public Admin() {  
    }

    /* main function of admin*/





//ADD employee
    public void AddEmployee(int id_of_employee, String phonenumber, String password, String name, String type) {
        //files work
        super.setName(name);
        super.setNumber(phonenumber);
        super.setPassword(password);
        super.setType(type);
        super.setId_of_employee(id_of_employee);
        Updatelist();
    }
    
    
    //Delete
public  void DeleteEmployee(int id_of_employee)
{
    //files work
    Updatelist();
}



//Update
public static void Updatelist()
{
    //files work with gui
    //will show hint "updatet after every fun"
    System.out.println("updated");
}




//Searsh
public static int SearchEmployee(int id_of_employee)
{
    /*if id in file */
    return 1;
    /*else 
    return 0;*/
}


//list
public static void ListofEmployee()
{
    //files
}
}
