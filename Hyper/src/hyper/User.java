/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyper;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fady Fayek
 */
public class User  {

   
    public User() {
    }

    public void login(int id,String password) throws IOException
    {
        BufferedReader f2=null;
        try {
            File f=new File(id+".txt");
            f2 = new BufferedReader(new FileReader(f));
            String line;
            while((line=f2.readLine())!=null)
            {
                if(line.contains(password))
                {
                    if(line.contains("Admin"))
                    {
                        //OPEN FRAME OF ADMIN
                        ShowMyInfo(id);
                        System.out.println("hello admin");
                    }
                    else if(line.contains("Inventory Employee"))
                    {
                        //OPEN FRAME OF Inventory Employee
                        ShowMyInfo(id);
                        System.out.println("Inventory Employee");
                    }
                    else if(line.contains("Seller Employee"))
                    {
                        //OPEN FRAME OF Seller Employee
                        ShowMyInfo(id);
                        System.out.println("Seller Employee");
                    }
                    else if(line.contains("Marketing Employee"))
                    {
                        //OPEN FRAME OF Marketing Employee
                        ShowMyInfo(id);
                        System.out.println("Marketing Employee");
                    }
                    else 
                    {
                        //kill him
                        System.out.println("Sorry not sorry");
                    }
                    
                    
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                f2.close();
            } catch (IOException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public void ShowMyInfo(int id) throws IOException
    {
        File f=new File(id+".txt");
        try {
            BufferedReader f2=new BufferedReader(new FileReader(f));
            String line;
            while((line=f2.readLine())!=null)
            {
                String[] s=line.split("@");
                for(String ss:s)
                {
                    System.out.println(ss);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    //Update
    public  void UpdateInfo(String id,String type,String newname,String newphone,String newpassword) {
        File f = new File(id + ".txt");
        
        try {
            
            if (f.exists()) {
                FileWriter f1 = new FileWriter(f);                
                f1.write(newname + "@");
                f1.write(type + "@");
                f1.write(id + "@");
                f1.write(newpassword + "@");
                f1.write(newphone + "@");
                
               
                
                f1.close();
                
                cupdate(id,type);
                
            } else {
                System.out.println("is not found");
            }
            
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }

      
    }

     public int cupdate(String oldid,String Type) throws IOException
   {
                  ArrayList<String> ss = new ArrayList<>();
                  ArrayList<String> nss = new ArrayList<>();
                  File f=new File(Type+".txt");
                  FileReader f2=new FileReader(f);
                  BufferedReader f3=new BufferedReader(f2);
                  String line;
                  while((line=f3.readLine())!=null)
                  {
                      ss.add(line);
                  }
                  for (int i = 0; i < ss.size(); i++)
                    {
                         if (ss.get(i).contains("@"+oldid+"@")) {
                              ss.remove(ss.get(i));
                        }
                      
                    }
                 
                    PrintWriter writer = new PrintWriter(f);
                    writer.print("");
                    for (int i = 0; i < ss.size(); i++) {
                        FileWriter f5 = new FileWriter(f, true);

                        f5.write(ss.get(i) + "\n");
                        f5.close();
                        
                    }
                    
                    f2.close();
                    f3.close();
                    writer.close();
                    File nfile=new File(oldid+".txt");
                    FileReader nfile2=new FileReader(nfile);
                    BufferedReader filereader=new BufferedReader(nfile2);
                    String nline;
                    while((nline=filereader.readLine())!=null)
                    {
                        nss.add(nline);
                       
                    }
                    
                    File ff=new File(Type+".txt");                    
                    FileWriter f5 = new FileWriter(ff, true);
                    f5.write(nss.get(0)+ "\n");
                    f5.close();
                        
                    
                  nfile2.close();
                  filereader.close();
                  return 1;
   }
   
    
}
