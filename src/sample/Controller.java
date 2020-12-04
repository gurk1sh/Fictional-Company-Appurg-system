package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    ArrayList<User> userList = new ArrayList<>();

    //Temporary user object, should be created through login page
    User user = new User("Stefan", "Stefan505", "abc123", "Stefan@live.se", 505, "Chef", "0730819523");
    Arbetsprocedurer arbProcedurer = new Arbetsprocedurer("Press", "Ladda pressen med stål, tryck på den röda knappen och därefter den blåa för att köra igång den, akta fingrarna. Sist kommer biten ut på andra sidan");

    @FXML
    TextField namn;

    @FXML
    TextField anvnamn;

    @FXML
    TextField email;

    @FXML
    TextField workid;

    @FXML
    TextField position;

    @FXML
    TextField telephone;

    @FXML
    TextFlow arbetsprocedurer;

    @FXML
    Label maskin;

    public void setTextFields() {
        String workID = Integer.toString(user.getArbetsId());
        namn.setText(user.getNamn());
        anvnamn.setText(user.getAnvNamn());
        email.setText(user.getEmail());
        workid.setText(workID);
        position.setText(user.getPosition());
        telephone.setText(user.getTelephone());
    }

    public void setArbetsprocedurer() {
        Text txt = new Text();
        txt.setText(arbProcedurer.getInfo());
        arbetsprocedurer.getChildren().addAll(txt);
        maskin.setText(arbProcedurer.getTitle());
    }

    @FXML
    ImageView landingClick;

    @FXML
    public void onLandingClick() {
        load("Landingpage.fxml", landingClick);
    }

    @FXML
    Button submit;

    @FXML
    public void onLoginClick() {
        load("Landingpage.fxml", submit);
    }

    @FXML
    TextField uName;

    @FXML
    public void registerUser()
    {
        User user = new User(uName.getText());
        userList.add(user);
    }

    @FXML
    Button moveToRegister;

    @FXML
    public void onRegisterClick() {
        load("sample.fxml", moveToRegister);
    }

    private void load(String fxml, Node b) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Stage stage = (Stage) b.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { //Sets the text in the textfields (to the right in the scene) to the user attributes
        try {
            setArbetsprocedurer();
            setTextFields();

        } catch (Exception e) {

        }
    }
}
