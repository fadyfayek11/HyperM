
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
        String t=getType();
        File f = new File(getId_of_employee() + ".txt");
        if (!f.exists()) {
            FileWriter f1 = new FileWriter(f);
            f1.write(getName() + ";");
            f1.write(getType() + ";");
            f1.write(getId_of_employee() + ";");
            f1.write(getPassword() + ";");
            f1.write(getNumber() + ";");
                  if(t.equals("Inventory Employee"))
           {
                getdata(); 
           }
           else if(getType().equals("Marketing Employee"))
           {
               getdata();
           }
           else if(getType().equals("Seller Employee"))
           {
               getdata();
           }
           else if(getType().equals("Admin"))
           {
              getdata();
           }
            f1.close();
            Updatelist();
        } else {
            System.out.println("is already created");
        }

    }

        /*this function will sort every em by his type*/
    public void getdata() throws IOException
   {
                  File f3=new File(getType()+".txt");
                  FileWriter f2=new FileWriter(f3,true);
                  f2.write(getName()+"\n");
                  f2.write(getType()+"\n");
                  //f2.write(getId_of_employee()+";");
                  f2.write(getPassword()+"\n");
                  f2.write(getNumber()+"\n");
                  f2.write("#\n");
                  f2.close();
   }
    
    //Delete
    public void DeleteEmployee(int id_of_employee) {
       File f=new File(id_of_employee+".txt");
       if(f.delete())
       {
           System.out.println("delete employee complite");
       }
       else
       {
           System.out.println("please try again-ENTER CORRECT ID");
       }
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
