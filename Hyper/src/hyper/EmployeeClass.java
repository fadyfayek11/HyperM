/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyper;




/*employee class */
public class EmployeeClass {
   

   private String phonenumber;
   private String password;
   private String name;
   private String type;
   private int id_of_employee;

   
/* main constractor*/
    public EmployeeClass(int id_of_employee,String phonenumber, String password, String name, String type) {
       /*password*/
        if(password.length()<8)
        {
            System.out.println("the password should be more than 8 char");
        }
        else
        {
            this.password = password;
        }
        /*phone number*/
        if(phonenumber.length()<11)
        {
            System.out.println("incorrect phone number");
        }
        else
        {
            this.phonenumber = phonenumber;
        }

         
        /*set type*/
       if(type=="Marketing Employee")
        {
            this.type = type;
        }
        else if(type=="Inventory Employee")
        {
            this.type = type;
        }
        else if(type=="Seller Employee")
        {
            this.type = type;
        }
         else if(type=="Admin")
        {
            this.type = type;
        }
        
        else
        {
            System.out.println("please enter the type 'Admin-Marketing Employee-Inventory Employee-Seller Employee' ");
        }
         
         this.name = name;
        this.id_of_employee=id_of_employee;
       }
        
    
        
        
   
/*empty constructor*/
    public EmployeeClass() {
    }
    
/*phonenubmer of employee*/
    public String getNumber() {
        return phonenumber;
    }
/*phone number*/
    public void setNumber(String phonenumber) {
        if(phonenumber.length()<11)
        {
            System.out.println("incorrect phone number");
        }
        else
        {
            this.phonenumber = phonenumber;
        }
      
        
    }
/*password of employee*/
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password.length()<8)
        {
            System.out.println("the password should be more than 8 char");
        }
        else
        {
            this.password = password;
        }
    }

    public String getName() {
        return name;
    }
/*name of employee*/
    public void setName(String name) {
        this.name = name;
    }
/*type of employee*/
    public String getType() {
        return type;
    }

    public void setType(String type) {
        if(type=="Marketing Employee")
        {
            this.type = type;
        }
        else if(type=="Inventory Employee")
        {
            this.type = type;
        }
        else if(type=="Seller Employee")
        {
            this.type = type;
        }
        else if(type=="Admin")
        {
            this.type = type;
        }
        else
        {
            System.out.println("please enter the type 'Admin-Marketing Employee-Inventory Employee-Seller Employee' ");
        }
       }

    

    public int getId_of_employee() {
        return id_of_employee;
    }

    public void setId_of_employee(int id_of_employee) {
        this.id_of_employee = id_of_employee;
    }
   

    
}
