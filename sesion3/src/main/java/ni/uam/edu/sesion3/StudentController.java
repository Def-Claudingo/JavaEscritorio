package ni.uam.edu.sesion3;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ni.uam.edu.sesion3.dao.StudentDAO;
import ni.uam.edu.sesion3.modelos.Student;

public class StudentController {
    StudentDAO studentDAO = new StudentDAO();
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtGrade;
    @FXML
     Label lblAvg;
    @FXML
    protected void saveBtnClicked(){
        readStudent();
        lblAvg.setText("Promedio: " + studentDAO.getAverage() );
    }
    private void readStudent(){
        String name = txtName.getText();
        int grade = Integer.parseInt(txtGrade.getText());
        Student student = new Student(name, grade);

        saveStudent(student);
    }
    private void saveStudent(Student student){
        studentDAO.add(student);
    }
}
