package student;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {

    private String name;
    private int grade;
    private ArrayList<String> courses = new ArrayList<>();


    public Student(String name, int grade, String courses) {
        this.name = name;
        this.grade = grade;
        this.courses.add(courses);
    }

    public String getName() {
        return this.name;
    }

    public int getGrade() {
        return this.grade;
    }

    public ArrayList<String> getCourses() {
        return this.courses;
    }

    public void addCourses(String course) {
        courses.add(course);
    }

    public void removeCourses(String course) {
        courses.remove(course);
    }

}
class StudentDetail{
    private ArrayList<Student> students;
    StudentDetail(){
        students = new ArrayList<>();
    }

    public void addStudents(Student st){
        students.add(st);
    }

    public void addCourse(String stName, String cName){
        for (Student st : students){
            if (st.getName().equalsIgnoreCase(stName)){
                st.addCourses(cName);
                System.out.println("added...");
            }
        }
        System.out.println("Student does not exist.");
    }

    public void removeCourse(String stName, String cName){
        for (Student st : students){
            if (st.getName().equalsIgnoreCase(stName)){
                for (String cour : st.getCourses()){
                    if (cour.equalsIgnoreCase(cName)){
                        if (st.getCourses().size() == 1){
                            st.addCourses("Null");
                        }
                        st.removeCourses(cour);
                        System.out.println("removed...");
                    }
                }
                System.out.println("Course does not exist.");
                break;
            }
        }
        System.out.println("Student does not exist.");
    }


    public void showDetails(){
        System.out.println("-------------------------------------------------------------");
        System.out.printf("| %-15s | %-15s | %-5s %n", "Name", "Grade", "Courses");
        System.out.println("-------------------------------------------------------------");
        for (Student s : students){
            System.out.printf("| %-15s | %-15s | %-5s %n", s.getName(),s.getGrade(), s.getCourses());
        }
        System.out.println("-------------------------------------------------------------");
    }
}
class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDetail studentDetail = new StudentDetail();

        while (true){
            System.out.println("1. Add Students.");
            System.out.println("2. Add Course.");
            System.out.println("3. Remove Course.");
            System.out.println("4. Show All Students.");
            System.out.println("5. For Exit.");

            int num = sc.nextInt();
            if (num == 5) {
                System.out.println("Thank You!");
                break;
            }

            switch (num){

                case 1 :
                    System.out.print("Enter Student Name : ");
                    String sName = sc.next();

                    System.out.print("Enter Student Grade : ");
                    int gd = sc.nextInt();

                    System.out.print("Enter course : ");
                    String courses = sc.next();

                    Student st = new Student(sName, gd, courses);
                    studentDetail.addStudents(st);

                    break;

                case 2 :
                    System.out.print("Enter Student Name : ");
                    String sn = sc.next();

                    System.out.print("Enter Course Name : ");
                    String cn = sc.next();

                    studentDetail.addCourse(sn,cn);

                    break;

                case 3 :
                    System.out.print("Enter Student Name : ");
                    String snam = sc.next();

                    System.out.print("Enter Course Name : ");
                    String cnam = sc.next();

                    studentDetail.removeCourse(snam,cnam);

                    break;

                case 4 :
                    studentDetail.showDetails();

                default:
                    System.out.println("Enter right input.");
                    break;
            }


        }
    }
}