package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    //Temporary user object, should be created through login page
    User user = new User("Stefan", "Stefan505",  "abc123", "Stefan@live.se", 505, "Chef" , "0730819523");

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { //Sets the text in the textfields (to the right in the scene) to the user attributes
        String workID = Integer.toString(user.getArbetsId());
        namn.setText(user.getNamn());
        anvnamn.setText(user.getAnvNamn());
        email.setText(user.getEmail());
        workid.setText(workID);
        position.setText(user.getPosition());
        telephone.setText(user.getTelephone());
    }
}
