package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Connection connection = MyDbUnits.createConnection();
        if (connection != null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Prisijungeme");
            alert.show();
        }
    }

    private List<Student> getStudents(Connection connection){
        List<Student> students = new ArrayList<>();

        Statement statement = connection.createStatement();

        return students;
    }
}
