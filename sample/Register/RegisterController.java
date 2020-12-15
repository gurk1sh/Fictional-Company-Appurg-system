package sample.Register;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.Login.LoginController;
import sample.User;
import sample.UserPlaceholder;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class RegisterController implements Initializable {

    @FXML
    Button registerButton;

    @FXML
    Button backButton;

    @FXML
    TextField namn;

    @FXML
    TextField email;

    @FXML
    PasswordField pw;

    @FXML
    TextField arbetsID;

    @FXML
    TextField userName;

    @FXML
    TextField telephone;

    @FXML
    ChoiceBox<String> Position;

    @FXML
    Label name;

    @FXML
    Label mail;

    @FXML
    Label pass;

    @FXML
    Label ID;

    @FXML
    Label user;

    @FXML
    Label tp;

    @FXML
    Label pos;

    User newUser;

    @FXML
    public void registerUser() {
        try {
            if (Position.getSelectionModel().getSelectedItem() != null) {
                newUser = new User(namn.getText(), userName.getText(), pw.getText(), email.getText(), Integer.parseInt(arbetsID.getText()), Position.getSelectionModel().getSelectedItem(), telephone.getText());
                UserPlaceholder.getInstance().setUser(newUser);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Skapade ett nytt konto");
                alert.setContentText("Ditt användarnamn: " + newUser.getAnvNamn());
                alert.show();
            }
            else
            {
                Alert positionAlert = new Alert(Alert.AlertType.INFORMATION);
                positionAlert.setHeaderText("Du har inte valt en position");
                positionAlert.show();
            }
        } catch (Exception e) {
            Alert warning = new Alert(Alert.AlertType.INFORMATION);
            warning.setHeaderText("Något gick fel, se till att alla textfält är korrekt ifyllda");
            warning.show();
        }
    }

    @FXML
    public void moveBack() {
        load("/sample/Login/login.fxml", backButton);
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
        Font gilRoy = Font.loadFont(getClass().getResourceAsStream("/sample/Gilroy-light.otf"), 14); //
        name.setFont(gilRoy);
        mail.setFont(gilRoy);
        pass.setFont(gilRoy);
        ID.setFont(gilRoy);
        user.setFont(gilRoy);
        tp.setFont(gilRoy);
        pos.setFont(gilRoy);

        Position.getItems().addAll("Montör", "Packare", "Maskinoperatör");

    }
}