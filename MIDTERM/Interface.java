import java.util.Scanner;

class Student {

   String first_name;
   String middle_name;
   String last_name;
   String suffix;
   String full_name;

   public String getFirstName(){
      return first_name;
   }
   
   public String getMiddleName(){
      return middle_name;
   }
   
   public String getLastName(){
      return last_name;
   }
   
   public String getSuffix(){
      return suffix;
   }
   
   public String getFullName(){
      return first_name +" "+ middle_name +" "+ last_name +" "+ suffix;
   }
   
   public void setFirstName(String firstName){
      this.first_name = firstName;
   }
   
   public void setMiddleName(String middleName){
      this.middle_name = middleName;
   }
   
   public void setLastName(String lastName){
      this.last_name = lastName;
   }
   
   public void setSuffix(String suffix){
      this.suffix = suffix;
   }
}

public class Interface {
   public static void main (String [] args) {
   
   Scanner scan = new Scanner(System.in);
   
   Student student = new Student();
   
   System.out.println("Enter First Name: ");
   student.setFirstName(scan.nextLine());
   
   System.out.println("Enter Middle Name: ");
   student.setMiddleName(scan.nextLine());
   
   System.out.println("Enter Last Name: ");
   student.setLastName(scan.nextLine());
   
   System.out.println("Enter Suffix: ");
   student.setSuffix(scan.nextLine());
   
   System.out.println("");
   
   System.out.println("First name: " + student.getFirstName());
   System.out.println("Middle name: " + student.getMiddleName());
   System.out.println("Last name: "+ student.getLastName());
   System.out.println("Suffix: " + student.getSuffix());
   System.out.println("Full name: " + student.getFullName());
     
   }
}