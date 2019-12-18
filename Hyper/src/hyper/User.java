package hyper;

import GUI.InventoryFrame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class User  {
    public static ArrayList<String> infoofemployee=new ArrayList<>();
   public static String finaltype;
    public User() {
    }
 
    public  int login(String id,String password) throws IOException
    {
         int ssid = Integer.parseInt(id);
        BufferedReader f2=null;
        ArrayList<String> info=new ArrayList<>();
        try {
            File f=new File(id+".txt");
            f2 = new BufferedReader(new FileReader(f));
            String line;
            while((line=f2.readLine())!=null)
            {
                String[] ss=line.split("@");
                for(String l:ss)
                {
                    info.add(l);
                }
          
            }
            if (info.get(3).equals(password))
            {
               if(info.get(1).equals("Admin"))
                    {
                        
                        Admin_Gui admin_Gui=new Admin_Gui();
                        admin_Gui.setVisible(true);
                        JOptionPane.showMessageDialog(null,"Hello,Admin.");
                        finaltype="Admin";
                        return  1;
                        
                    }
                    else if(info.get(1).equals("Inventory Employee"))
                    {
                   try {
                       InventoryFrame invf=new InventoryFrame();
                       JOptionPane.showMessageDialog(null,"Hello,Inventory Employee."); 
                       finaltype="Inventory Employee";
                       return  1;
                   } catch (ParseException ex) {
                       Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                   }
                       
                        
                    }
                    else if(info.get(1).equals("Seller Employee"))
                    {
                        //OPEN FRAME OF Seller Employee
                       
                        SalesGUI salesGUI=new SalesGUI();
                        JOptionPane.showMessageDialog(null,"Hello,Seller Employee.");
                        finaltype="Seller Employee";
                        
                        return  1;
                       
                    }
                    else if(info.get(1).equals("Marketing Employee"))
                    {
                        //OPEN FRAME OF Marketing Employee
                      
                      JOptionPane.showMessageDialog(null,"Hello,Marketing Employee");
                      return  1;
                      
                    }
                    else 
                    {
                        //kill him
                        JOptionPane.showMessageDialog(null,"Bad information");
                        
                      
                    }
                    
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Bad information");
            }
         
        } catch (FileNotFoundException ex) {
           JOptionPane.showMessageDialog(null,"Bad information");
            //Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                f2.close();
            } catch (IOException ex) {
               JOptionPane.showMessageDialog(null,"Bad information");
                //Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
        return 0; 
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
                    infoofemployee.add(ss);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex+"");            
//Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    //Update
    public  void UpdateInfo(int  id,String type,String newname,String newphone,String newpassword) {
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
                JOptionPane.showMessageDialog(null,"Update done");

                cupdate(id,type);
                
            } else {
                System.out.println("is not found");
            }
            
        } catch (IOException ex) {
                System.out.println(ex+"");            
//Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }

      
    }

     public int cupdate(int oldid,String Type) throws IOException
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
