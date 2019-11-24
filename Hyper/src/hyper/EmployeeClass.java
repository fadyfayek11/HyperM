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
/* main constractor*/
    public EmployeeClass(String phonenumber, String password, String name, String type) {
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
         if(type=="male")
        {
            this.type = type;
        }
        else if(type=="female")
        {
            this.type = type;
        }
        else
        {
            System.out.println("please enter the type 'male-female' ");
        }
        
       // this.phonenumber = phonenumber;
        //this.password = password;
        this.name = name;
        
    }
/*empty constructor*/
    public EmployeeClass() {
    }
    
/*nubmer of employee*/
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
        if(type=="male")
        {
            this.type = type;
        }
        else if(type=="female")
        {
            this.type = type;
        }
        else
        {
            System.out.println("please enter the type 'male-female' ");
        }

    }
   

    
}
