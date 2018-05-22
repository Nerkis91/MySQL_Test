package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TableView<Student> studentTableView;
    @FXML
    private TableColumn<Student, Integer> idTableColumn;
    @FXML
    private TableColumn<Student, String> nameTableColumn;
    @FXML
    private TableColumn<Student, String> lastNameTableColumn;
    @FXML
    private TableColumn<Student, String> emailTableColumn;
    @FXML
    private TableColumn<Student, String> phoneTableColumn;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Connection connection = MyDbUnits.createConnection();
        if (connection != null){
            List<Student> student = getStudents(connection);
            idTableColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
            nameTableColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
            lastNameTableColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("lastName"));
            emailTableColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));
            phoneTableColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("phone"));

            studentTableView.setItems(FXCollections.observableList(student));

            /*Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Prisijungeme " + student.size());
            alert.show();*/
        }
    }
    private List<Student> getStudents(Connection connection){
        List<Student> students = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT  * FROM student");
            while   (resultSet.next()){
                Student student = new Student (resultSet.getInt("ID"), resultSet.getString("Name"),
                        resultSet.getString("LastName"), resultSet.getString("email"),
                        resultSet.getString("phone"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
