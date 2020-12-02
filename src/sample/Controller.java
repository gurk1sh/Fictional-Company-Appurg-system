package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    //Temporary user object, should be created through login page
    User user = new User("Stefan", "Stefan505",  "abc123", "Stefan@live.se", 505, "Chef" , "0730819523");
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

    public void setTextFields()
    {
        String workID = Integer.toString(user.getArbetsId());
        namn.setText(user.getNamn());
        anvnamn.setText(user.getAnvNamn());
        email.setText(user.getEmail());
        workid.setText(workID);
        position.setText(user.getPosition());
        telephone.setText(user.getTelephone());
    }

    public void setArbetsprocedurer()
    {
        Text txt = new Text();
        txt.setText(arbProcedurer.getInfo());
        arbetsprocedurer.getChildren().addAll(txt);
        maskin.setText(arbProcedurer.getTitle());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { //Sets the text in the textfields (to the right in the scene) to the user attributes
        try
        {
            setArbetsprocedurer();
            setTextFields();
        }
        catch (Exception e)
        {

        }
    }
}
