package sample.Error_Procedures;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.util.Pair;
import sample.Machine;
import sample.Work_Procedures.WorkProcedure;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ErrorProcedureController implements Initializable {

    Machine machine = new Machine();

    ArrayList<ErrorProcedure> felprocedurInfo = new ArrayList<>();
    ArrayList<String> epList = new ArrayList<>();

    @FXML
    TextField maskin;

    @FXML
    TextFlow textFlow;

    @FXML
    Button newProcedure;

    @FXML
    ImageView profile;

    @FXML
    ImageView landing;

    @FXML
    ListView<String> ErrorProcedures;

    @FXML
    ListView<String> felprocedurer;

    @FXML
    ListView<String> WorkProcedures;

    @FXML
    Accordion accordion;

    @FXML
    TitledPane titledPaneEP;

    @FXML
    public void addNew() {
        // Create the custom dialog.
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Felprocedur");
        dialog.setHeaderText("Ny Felprocedur");

        // Set the button types.
        ButtonType submitErrorProcedure = new ButtonType("Lägg till", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(submitErrorProcedure, ButtonType.CANCEL);

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
            if (dialogButton == submitErrorProcedure) {
                felprocedurer.getItems().clear();
                String selectedMachine = ErrorProcedures.getSelectionModel().getSelectedItem();
                ErrorProcedure newFelprocedur = new ErrorProcedure(title.getText(), tf.getText(), selectedMachine);

                felprocedurInfo.add(newFelprocedur);
                Alert addedProcedure = new Alert(Alert.AlertType.INFORMATION);
                addedProcedure.setHeaderText("La till felprocedur " + title.getText());
                addedProcedure.show();

                epList.add(newFelprocedur.getTitle());

                for (int i = 0; i < epList.size(); i++) {
                    felprocedurer.getItems().add(epList.get(i));
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

    @FXML
    public void goToWorkprocedures() {
        load("/sample/Work_Procedures/workProcedures.fxml", WorkProcedures);
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
        accordion.setExpandedPane(titledPaneEP);
        maskin.setStyle("-fx-text-fill: white");
        maskin.setStyle("-fx-background-color:  rgb(23,97,160)");
        for (String s : machine.machineList) {
            ErrorProcedures.getItems().add(s);
            WorkProcedures.getItems().add(s);
        }

        try {
            felprocedurer.setOnMouseClicked(event ->
            {
                textFlow.getChildren().clear();
                try {
                    String selection = felprocedurer.getSelectionModel().getSelectedItem();
                    for (ErrorProcedure e : felprocedurInfo) {
                        if (e.getTitle().equals(selection)) {
                            textFlow.setPadding(new Insets(5, 5, 5, 5));
                            Text newTitle = new Text();
                            Text newInfo = new Text();
                            newTitle.setText("Titel " + "\n" + e.getTitle() + "\n" + "\n");
                            newInfo.setText("Info " + "\n" + e.getInfo());
                            textFlow.getChildren().addAll(newTitle, newInfo);
                        }
                    }
                } catch (Exception e) {

                }
            });
            ErrorProcedures.setOnMouseClicked(event ->
            {
                maskin.setText(ErrorProcedures.getSelectionModel().getSelectedItem());
            });
        } catch (Exception e) {

        }

    }
}
