package sample.Login;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.Profile.ProfileController;
import sample.Register.RegisterController;
import sample.User;
import sample.UserPlaceholder;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {

    @FXML
    Button submit;

    @FXML
    Button moveToRegister;

    @FXML
    Text userName;

    @FXML
    Text password;

    @FXML
    TextField username;

    @FXML
    PasswordField pw;

    @FXML
    public void onLoginClick() {
        if (pwcontrol()) {
            load("/sample/Landing/Landingpage.fxml", submit);
        }
    }

    @FXML
    public void onRegisterClick() {
        load("/sample/Register/register.fxml", moveToRegister);
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
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Font gilRoy = Font.loadFont(getClass().getResourceAsStream("/sample/Gilroy-light.otf"), 14);
        submit.setFont(gilRoy);
        moveToRegister.setFont(gilRoy);
        userName.setFont(gilRoy);
        password.setFont(gilRoy);

    }

    public Boolean pwcontrol() {
        if (UserPlaceholder.getInstance().getUser() != null) {
            User user = UserPlaceholder.getInstance().getUser();
            if (user.getAnvNamn().equals(username.getText()) && user.getLosenord().equals(pw.getText()))
            {
                UserPlaceholder.getInstance().getUser().setLoginToken(true);
                return user.getAnvNamn().equals(username.getText()) && user.getLosenord().equals(pw.getText());
            }
            else
            {
                Alert loginAlert = new Alert(Alert.AlertType.INFORMATION);
                loginAlert.setHeaderText("Fel användarnamn och/eller lösenord");
                loginAlert.show();
                return false;
            }
        } else if (UserPlaceholder.getInstance().getUser() == null) {
            Alert accountAlert = new Alert(Alert.AlertType.INFORMATION);
            accountAlert.setHeaderText("No user account was found");
            accountAlert.show();
            return false;
        }
        return false;
    }
}