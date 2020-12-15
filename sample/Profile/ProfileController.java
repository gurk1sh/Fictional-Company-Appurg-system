package sample.Profile;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.Machine;
import sample.User;
import sample.UserPlaceholder;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class ProfileController implements Initializable {

    Machine machine = new Machine();

    @FXML
    ListView<String> WorkProcedures;

    @FXML
    ListView<String> ErrorProcedures;

    @FXML
    Accordion accordion;

    @FXML
    public void goToErrorProcedures()
    {
        load("/sample/Error_Procedures/errorProcedures.fxml", ErrorProcedures);
    }

    @FXML
    public void goToWorkProcedures()
    {
        load("/sample/Work_Procedures/workProcedures.fxml", WorkProcedures);
    }

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
    ImageView landingClick;

    @FXML
    ImageView profileClick;

    @FXML
    Text appurg;

    public void setTextFields() {
        try {
            User user = UserPlaceholder.getInstance().getUser();
            String workID = Integer.toString(user.getArbetsId());
            namn.setText(user.getNamn());
            anvnamn.setText(user.getAnvNamn());
            email.setText(user.getEmail());
            workid.setText(workID);
            position.setText(user.getPosition());
            telephone.setText(user.getTelephone());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onLandingClick() {
        load("/sample/Landing/Landingpage.fxml", landingClick);
    }

    @FXML
    public void onProfileClick() {
        load("/sample/Profile/profile.fxml", profileClick);
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
        Font gilRoy = Font.loadFont(getClass().getResourceAsStream("/sample/Gilroy-light.otf"), 20);
        appurg.setFont(gilRoy);

        for (String s : machine.machineList) {
            WorkProcedures.getItems().add(s);
            ErrorProcedures.getItems().add(s);
        }

        if (UserPlaceholder.getInstance().getUser() != null && UserPlaceholder.getInstance().getUser().getLoginToken()) {
            setTextFields();
        }
    }
}