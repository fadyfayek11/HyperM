
package hyper;
import java.io.*;
import java.util.ArrayList;

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
                  f2.write(getName()+"@");
                  f2.write(getType()+"@");
                  f2.write(getPassword()+"@");
                  f2.write(getNumber()+"@");
                  f2.write("@\n");
                  f2.close();
   }
    
    //Delete
    public void DeleteEmployee(String Id_of_employee, String Type) throws FileNotFoundException, IOException {
        /*delte file of employee*/
        File f11 = new File(Id_of_employee + ".txt");
        if (f11.delete()) {
            System.out.println("delete employee complite");
        } else {
            System.out.println("please try again");
        }
        /*delet line data in section file of employee*/
 /*array list play role like temp in swap function in c*/
        ArrayList<String> ss = new ArrayList<>();

        File f = new File(Type + ".txt");  //open file to read  
        FileReader f1 = new FileReader(f);
        BufferedReader f2 = new BufferedReader(f1);
        String line;
        while ((line = f2.readLine()) != null) {
            //String[] l=line.split("@");
            // for(String data:l)
            ss.add(line);//read file and pass to array
        }

        for (int i = 0; i < ss.size(); i++)//search for id
        {
            if (ss.get(i).contains(Id_of_employee)) {
                ss.remove(ss.get(i));
            }

        }
        // System.out.println(ss);
        PrintWriter writer = new PrintWriter(f);//to clear file
        writer.print("");
        for (int i = 0; i < ss.size(); i++) {
            FileWriter f5 = new FileWriter(f, true);//to write again

            f5.write(ss.get(i) + "\n");
            f5.close();
            // System.out.println(ss.get(i));
        }

        f2.close();//close f2
        f1.close();//close f1
        writer.close();//close printwriter

    }

//Update
    public static void Updatelist() {
        //files work with gui
        //will show hint "updatet after every fun"
        System.out.println("updated");
    }

   //Searsh
    public void SearchEmployee(String name,String Type) throws FileNotFoundException, IOException {
        File f=new File(Type+".txt");
        FileReader f2=new FileReader(f);
        BufferedReader f3=new BufferedReader(f2);
        String line;
        while((line=f3.readLine())!=null)
        {
            if(line.contains(name))
            {
                String[] l=line.split("@");
                for(String data:l)
                System.out.println(data);
            }
            else
            {
                //System.out.println("not found");
            }
        }
    }


//list
     public void ListofEmployee(String Type) throws FileNotFoundException, IOException {
        File f=new File(Type+".txt");
        FileReader f1=new FileReader(f);
        BufferedReader f3=new BufferedReader(f1);
       String line;
       while((line=f3.readLine())!=null)
       {
           String[] l=line.split("@");
           for(String lists:l)
           {
            System.out.println(lists);   
           }
           
       }
        
    }
    
}