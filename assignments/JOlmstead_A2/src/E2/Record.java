package E2;

//Create Record.java class to store basic student info:


import java.util.ArrayList;

public class Record {
    //•String to store the name of the student
    String nameofStudent;
    //•int to store the grade of the student
    int grade;
    ArrayList grades;

    public Record(String nameofStudent, int grade){
       this.nameofStudent = nameofStudent;
       this.grade = grade;
       grades = new ArrayList(); //because people get CGPA and term GPA - possible for students to have more than one grade
       grades.add(grade);
    }


    //•Basic getters and setters
    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setNameofStudent(String nameofStudent) {
        this.nameofStudent = nameofStudent;
    }

    public void addGrade(int grade){
        grades.add(grade);
    }

    public String getNameofStudent(){
        return nameofStudent;
    }

    public int getGrade(){
        return grade;
    }
}
