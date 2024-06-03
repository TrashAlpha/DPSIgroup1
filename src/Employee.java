import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Employee {
    public void createFile()
    {
        Scanner sc=new Scanner(System.in);

        EmployDetail emp=new EmployDetail();
        emp.getInfo();
        try{
            File f1=new File("file"+emp.employ_id+".txt");
            if(f1.createNewFile()){
                FileWriter myWriter = new FileWriter("file"+emp.employ_id+".txt");
                myWriter.write("Employee ID:"+emp.employ_id+"\n"+"Employee Name     :"+emp.name+"\n"+
                "Father's Name     :"+emp.father_name+"\n"+"Employee Contact  :"+emp.employ_contact+"\n"+
                "Email Information :"+emp.email+"\n"+"Employee position :"+emp.position+"\n"+
                "Employee Salary   :"+emp.employ_salary);
                myWriter.close();
                System.out.println("\nEmployee has been Added :)\n");

                System.out.print("\nPress Enter to Continue...");
                sc.nextLine();
            }
            else {
                System.out.println("\nEmployee already exists :(");
                System.out.print("\nPress Enter to Continue...");
                sc.nextLine();
            }
        }
        catch(Exception e){System.out.println(e);}
    }
    
    public void viewFile(String s) throws Exception
    {
    File file = new File("file"+s+".txt");
    Scanner sc = new Scanner(file);

    while (sc.hasNextLine())
     {
       System.out.println(sc.nextLine());
     }
    }

    public void updateFile(String s,String o,String n) throws IOException
    {
     File file = new File("file"+s+".txt");
     Scanner sc = new Scanner(file);
     String fileContext="";
     while (sc.hasNextLine())
         {
           fileContext =fileContext+"\n"+sc.nextLine();
         }
     FileWriter myWriter = new FileWriter("file"+s+".txt");
     fileContext = fileContext.replaceAll(o,n);
     myWriter.write(fileContext);
     myWriter.close();
  
    }

    public void removeFile(String ID)
    {

    File file = new File("file"+ID.toString()+".txt");
      if(file.exists())
       {
         if(file.delete());
         {
           System.out.println("\nEmployee has been removed Successfully");
         }
       }
      else
       {
            System.out.println("\nEmployee does not exists :( ");
       }
     }
}