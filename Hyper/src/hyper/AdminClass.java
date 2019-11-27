
package hyper;
import java.io.*;

public class AdminClass extends EmployeeClass{
    
    
    
    /*main constractor*/
    public AdminClass(int id_of_employee, String phonenumber, String password, String name, String type) {
        super(id_of_employee, phonenumber, password, name, type);

    }


    /*empty constractor*/
    public AdminClass() {
    }

    /* main function of admin*/





//ADD employee
    public void AddEmployee() throws IOException {

        File f = new File(getId_of_employee() + ".txt");
        if (!f.exists()) {
            FileWriter f1 = new FileWriter(f);
            f1.write(getName() + ";");
            f1.write(getType() + ";");
            f1.write(getId_of_employee() + ";");
            f1.write(getPassword() + ";");
            f1.write(getNumber() + ";");
            f1.close();
            Updatelist();
        } else {
            System.out.println("is already created");
        }

    }

    //Delete
    public void DeleteEmployee(int id_of_employee) {
        //files work
        Updatelist();
    }

//Update
    public static void Updatelist() {
        //files work with gui
        //will show hint "updatet after every fun"
        System.out.println("updated");
    }

//Searsh
    public static int SearchEmployee(int id_of_employee) {
        /*if id in file */
        return 1;
        /*else 
    return 0;*/
    }

//list
    public static void ListofEmployee() {
        //files
    }
}
