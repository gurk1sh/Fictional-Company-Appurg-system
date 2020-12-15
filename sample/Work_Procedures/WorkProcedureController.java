package sample.Work_Procedures;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.util.Pair;
import sample.Machine;

    /*
    FIXA SÅ ATT DE OLIKA MASKINERNA
    HAR INDIVIDUELLA LISTVIEWS MED
    ARBETSPROCEDURER OCH INFO KRING DEM
    GÖR NÅGOT MED MASKINNAMNET MED ONCLICK I VÄNSTRA MENYN
    */

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class WorkProcedureController implements Initializable {

    ArrayList<WorkProcedure> arbetsprocedurInfo = new ArrayList<>();
    ArrayList<String> wpList = new ArrayList<>();
    Machine machine = new Machine();

    @FXML
    TextField maskin;

    @FXML
    ImageView profile;

    @FXML
    ImageView landing;

    @FXML
    ListView<String> arbetsprocedurer;

    @FXML
    TextFlow textFlow;

    @FXML
    Button newProcedure;

    @FXML
    ListView<String> WorkProcedures;

    @FXML
    ListView<String> ErrorProcedures;

    @FXML
    Accordion accordion;

    @FXML
    TitledPane titledPaneWP;

    @FXML
    public void goToErrorProcedures()
    {
        load("/sample/Error_Procedures/errorProcedures.fxml", ErrorProcedures);
    }

    @FXML
    public void addNew() {
        // Create the custom dialog.
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Arbetsprocedur");
        dialog.setHeaderText("Ny arbetsprocedur");

        // Set the button types.
        ButtonType submitWorkProcedure = new ButtonType("Lägg till", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(submitWorkProcedure, ButtonType.CANCEL);

        // Create the username and password labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        ScrollPane scrollPane = new ScrollPane();

        TextField title = new TextField();
        TextArea tf = new TextArea();
        tf.setPrefWidth(400);
        tf.setWrapText(true);

        scrollPane.setContent(tf);
        scrollPane.setFitToWidth(true);

        grid.add(new Label("Titel:"), 0, 0);
        grid.add(title, 1, 0);
        grid.add(new Label("Text:"), 0, 1);
        grid.add(scrollPane, 1, 1);

        dialog.getDialogPane().setContent(grid);
        dialog.show();

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == submitWorkProcedure) {
                arbetsprocedurer.getItems().clear();
                String selectedMachine = WorkProcedures.getSelectionModel().getSelectedItem();
                WorkProcedure newArbetsprocedur = new WorkProcedure(title.getText(), tf.getText(), selectedMachine);
                arbetsprocedurInfo.add(newArbetsprocedur);
                Alert addedProcedure = new Alert(Alert.AlertType.INFORMATION);
                addedProcedure.setHeaderText("La till arbetsprocedur " + title.getText());
                addedProcedure.show();

                wpList.add(newArbetsprocedur.getTitle());

                for (int i = 0; i < wpList.size(); i++) {
                    arbetsprocedurer.getItems().add(wpList.get(i));
                }
            }
            return null;
        });
    }

    @FXML
    public void onLandingClick() {
        load("/sample/Landing/landingpage.fxml", landing);
    }

    @FXML
    public void onProfileClick() {
        load("/sample/Profile/profile.fxml", profile);
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
        accordion.setExpandedPane(titledPaneWP);
        maskin.setStyle("-fx-text-fill: white");
        maskin.setStyle("-fx-background-color:  rgb(23,97,160)");
        for (String s : machine.machineList) {
            WorkProcedures.getItems().add(s);
            ErrorProcedures.getItems().add(s);
        }
        try {
            arbetsprocedurer.setOnMouseClicked(event ->
            {
                textFlow.getChildren().clear();
                try {
                    String selection = arbetsprocedurer.getSelectionModel().getSelectedItem();
                    for (WorkProcedure a : arbetsprocedurInfo) {
                        if (a.getTitle().equals(selection)) {
                            textFlow.setPadding(new Insets(5, 5, 5, 5));
                            Text newTitle = new Text();
                            Text newInfo = new Text();
                            newTitle.setText("Titel " + "\n" + a.getTitle() + "\n" + "\n");
                            newInfo.setText("Info " + "\n" + a.getInfo());
                            textFlow.getChildren().addAll(newTitle, newInfo);
                        }
                    }
                } catch (Exception e) {

                }
            });
            WorkProcedures.setOnMouseClicked(event ->
            {
                maskin.setText(WorkProcedures.getSelectionModel().getSelectedItem());
            });
        } catch (Exception e) {

        }

    }
}
