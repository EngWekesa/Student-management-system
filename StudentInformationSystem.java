import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//base class for student
  class Student{
    private String name;
    private int grade;
    private int attendance;

    public Student(String name,int grade,int attendance){
        this.name = name;
        this.grade = grade;
        this.attendance = attendance;
    }
    public String getName(){
        return name;
    }
    public int getGrade(){
        return grade;
    }
    public int getAttendance(){
        return attendance;
    }
    public void setGrade(int grade){
        this.grade=grade;
    }
    public void setAttendance(int attendance){
        this.attendance=attendance;
    }
    @Override
       public String toString(){
        return "Name:" + name +", Grade:" + grade + ", Attendance:" + attendance;
       }
  }
     //Teacher to handle student information
        class Teacher{
            private List<Student>students;

            public Teacher(){
                students = new ArrayList<>();
            }
            public void addStudent(Student student){
                students.add(student);
            }
            public void updateStudentGrade(String name,int newGrade){
                for(Student student:students){
                    if(student.getName().equals(name)){
                        student.setGrade(newGrade);
                        break;
                    }
                }
            }
            public void updateStudentAttendance(String name,int newAttendance){
                for(Student student:students){
                    if(student.getName().equals(name)){
                        student.setAttendance(newAttendance);
                        break;
                    }
                }
            }
            public void deleteStudent(String name){
                students.removeIf(student -> student.getName().equals(name));
            }
            public void generateHighGradesReport(){
                System.out.println("Students with high grades:");
                for(Student student:students){
                    if(student.getGrade() >=90) {
                        System.out.print(student);
                    }
                }
            }
            public void generatePoorAttendanceReport(){
                System.out.println("Students with poor Attendance:");
                for(Student student:students){
                    if(student.getAttendance()<75){
                        System.out.println(student);
                    }
                }
            }
            }
            public class StudentInformationSystem{
                public static void main(String[] args){
                    Scanner scanner = new Scanner(System.in);
                    Teacher teacher = new Teacher();

                    while(true){
                        System.out.println("\nStudent Information System");
                        System.out.println("1.Add Student");
                            System.out.println("2.Update Student Grade");
                                System.out.println("3.Update Student Attendance");
                                    System.out.println("4.Delete Student");
                                        System.out.println("5.Generate High Grades Report");
                                            System.out.println("6.Generate Poor Attendance Report");
                                                System.out.println("0.Exit");
                                                    System.out.println("Enter your Choice:");
                                                    int choice=scanner.nextInt();
                                                    scanner.nextLine();//consume the new line character

                                                    switch(choice){
                                                        case 1:
                                                        System.out.println("Enter student name:");
                                                        String name = scanner.nextLine();
                                                        System.out.println("Enter grade:");
                                                        int grade = scanner.nextInt();
                                                        System.out.println("Enter student attendance:");
                                                        int attendance = scanner.nextInt();
                                                        scanner.nextLine(); //consume the new line character
                                                        Student student = new Student(name,grade,attendance);
                                                        teacher.addStudent(student);
                                                        System.out.println("Student Added Succesfully");
                                                        break;

                                                        case 2:
                                                        System.out.println("Enter Student name:");
                                                        name=scanner.nextLine();
                                                        System.out.println("Enter new grade");
                                                        int newGrade = scanner.nextInt();
                                                        scanner.nextLine(); //consume the new line character
                                                        teacher.updateStudentGrade(name,newGrade);
                                                        System.out.println("Student grade Updated Succesfully");
                                                        break;

                                                        case 3:
                                                        System.out.println("Enter student name:");
                                                        name = scanner.nextLine();
                                                        System.out.println("Enter new attendance");
                                                        int newAttendance = scanner.nextInt();
                                                        scanner.nextLine(); //consume character on the new line
                                                        teacher.updateStudentAttendance(name,newAttendance);
                                                        System.out.println("Student attendance updated Successfully");
                                                        break;
                                case 4:
                           System.out.println("Enter student name:");
                           name = scanner.nextLine();
                           teacher.deleteStudent(name);
                           System.out.println("Student Deleted Successfully");
                           break;

                        case 5:
                        teacher.generateHighGradesReport();
                        break;
                        case 6:
                        teacher.generatePoorAttendanceReport();
                        break;
                        case 0:
                        System.out.println("Exiting...");
                        System.exit(0);
                        default:
                        System.out.println("Invalid choice.Please try Again.");
                        }
                    }
                }
            }
                
            

        
  