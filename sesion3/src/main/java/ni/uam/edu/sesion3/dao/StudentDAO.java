package ni.uam.edu.sesion3.dao;

import ni.uam.edu.sesion3.modelos.Student;

import java.util.*;

public class StudentDAO {
    private List<Student> students;


    public StudentDAO(){
        students = new ArrayList<Student>();
    }
    public void add(Student student){
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }
    public double getAverage(){
        double averagueGrade= 0;
        return students.stream().mapToDouble(Student::getGrade).average().getAsDouble();

    }
}

