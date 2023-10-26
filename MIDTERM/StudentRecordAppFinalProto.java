import java.util.Scanner;

class Student {
    String student_ID;
    String first_name;
    String middle_name;
    String last_name;
    String suffix;
    int age;
    int yearLevel;
    String phoneNumber;
    String email;
    String courseName;
    String courseCode;
    String department;

    public String getStudentID() {
        return student_ID;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getMiddleName() {
        return middle_name;
    }

    public String getLastName() {
        return last_name;
    }

    public String getSuffix() {
        return suffix;
    }

    public int getAge() {
        return age;
    }

    public int getYearLevel() {
        return yearLevel;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setStudentID(String studentID) {
        this.student_ID = studentID;
    }

    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middle_name = middleName;
    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

public class StudentRecordAppFinalProto {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Selection Menu: ");
            System.out.println("1: Create Student Record");
            System.out.println("0: Exit");
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            scan.nextLine();

            if (choice == 1) {
                Student student = new Student();

                System.out.println("Enter Student ID: ");
                student.setStudentID(scan.nextLine());

                System.out.println("Enter First Name: ");
                student.setFirstName(scan.nextLine());

                System.out.println("Enter Middle Name: ");
                student.setMiddleName(scan.nextLine());

                System.out.println("Enter Last Name: ");
                student.setLastName(scan.nextLine());

                System.out.println("Enter Suffix: ");
                student.setSuffix(scan.nextLine());

                System.out.println("Enter Age: ");
                student.setAge(scan.nextInt());
                scan.nextLine();

                System.out.println("Enter Year Level: ");
                student.setYearLevel(scan.nextInt());
                scan.nextLine();

                System.out.println("Enter Phone Number: ");
                student.setPhoneNumber(scan.nextLine());

                System.out.println("Enter Email: ");
                student.setEmail(scan.nextLine());

                while (true) {
                    System.out.println("Selection: \n1: Update Student Profile Details \n2: Update Student Course Details \n3: Display Student Record \n0: Exit");
                    int choice2 = scan.nextInt();
                    scan.nextLine();  // Consume the newline character

                    if (choice2 == 1) {
                            System.out.println("What details do you want to update?");
                            System.out.println("1: Student ID");
                            System.out.println("2: First Name");
                            System.out.println("3: Middle Name");
                            System.out.println("4: Last Name");
                            System.out.println("5: Suffix");
                            System.out.println("6: Age");
                            System.out.println("7: Year Level");
                            System.out.println("8: Phone Number");
                            System.out.println("9: Email");
                            System.out.println("0: Back");
                            System.out.print("Enter your choice: ");
                            int updateChoice = scan.nextInt();
                            scan.nextLine();  // Consume the newline character

                            switch (updateChoice) {
                                case 1:
                                    System.out.println("Enter new Student ID: ");
                                    student.setStudentID(scan.nextLine());
                                    break;
                                case 2:
                                    System.out.println("Enter new First Name: ");
                                    student.setFirstName(scan.nextLine());
                                    break;
                                case 3:
                                    System.out.println("Enter new Middle Name: ");
                                    student.setMiddleName(scan.nextLine());
                                    break;
                                case 4:
                                    System.out.println("Enter new Last Name: ");
                                    student.setLastName(scan.nextLine());
                                    break;
                                case 5:
                                    System.out.println("Enter new Suffix: ");
                                    student.setSuffix(scan.nextLine());
                                    break;
                                case 6:
                                    System.out.println("Enter new Age: ");
                                    student.setAge(scan.nextInt());
                                    scan.nextLine();  // Consume the newline character
                                    break;
                                case 7:
                                    System.out.println("Enter new Year Level: ");
                                    student.setYearLevel(scan.nextInt());
                                    scan.nextLine();  // Consume the newline character
                                    break;
                                case 8:
                                    System.out.println("Enter new Phone Number: ");
                                    student.setPhoneNumber(scan.nextLine());
                                    break;
                                case 9:
                                    System.out.println("Enter new Email: ");
                                    student.setEmail(scan.nextLine());
                                    break;
                                case 0:
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please try again.");
                                    break;
                           
                        }
                    } else if (choice2 == 2) {
                        System.out.println("Select a Course:");
                        System.out.println("1: Bachelor of Science in Information Technology (BSIT)");
                        System.out.println("2: Bachelor of Science in Computer Science (BSCS)");
                        System.out.println("3: Associate of Computer Technology (ACT)");
                        System.out.println("4: Bachelor of Science in Mechanical Engineering (BSME)");
                        System.out.println("5: Bachelor of Science in Civil Engineering (BSCE)");

                        int courseChoice = scan.nextInt();
                        scan.nextLine();

                        switch (courseChoice) {
                            case 1:
                                student.setCourseName("Bachelor of Science in Information Technology");
                                student.setCourseCode("BSIT");
                                student.setDepartment("College of Computer Studies");
                                break;
                            case 2:
                                student.setCourseName("Bachelor of Science in Computer Science");
                                student.setCourseCode("BSCS");
                                student.setDepartment("College of Computer Studies");
                                break;
                            case 3:
                                student.setCourseName("Associate of Computer Technology");
                                student.setCourseCode("ACT");
                                student.setDepartment("College of Computer Studies");
                                break;
                            case 4:
                                student.setCourseName("Bachelor of Science in Mechanical Engineering");
                                student.setCourseCode("BSME");
                                student.setDepartment("Department of Mechanical Engineering");
                                break;
                            case 5:
                                student.setCourseName("Bachelor of Science in Civil Engineering");
                                student.setCourseCode("BSCE");
                                student.setDepartment("Department of Civil Engineering");
                                break;
                            default:
                                System.out.println("Invalid course choice. Please try again.");
                                break;
                        }
                    } else if (choice2 == 3) {
                        System.out.println("Student Profile Details: ");
                        System.out.println("Student ID no: " + student.getStudentID());
                        System.out.println("First name: " + student.getFirstName());
                        System.out.println("Middle name: " + student.getMiddleName());
                        System.out.println("Last name: " + student.getLastName());
                        System.out.println("Age: " + student.getAge());
                        System.out.println("Year Level: " + student.getYearLevel());
                        System.out.println("Phone Number: " + student.getPhoneNumber());
                        System.out.println("Email: " + student.getEmail());
                        
                        System.out.println("\n");
                        System.out.println("Student Course Details:");
                        System.out.println("Course Name: " + student.getCourseName());
                        System.out.println("Course Code: " + student.getCourseCode());
                        System.out.println("Department: " + student.getDepartment());
                        
                        System.out.println("\n");
                    } else if (choice2 == 0) {
                        break;
                    } else {
                        System.out.println("Invalid choice. Please try again.");
                    }
                }
            } else if (choice == 0) {
                System.out.println("Exiting the program.");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
