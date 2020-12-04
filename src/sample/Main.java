package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    static Parent root;

    @Override
    public void start(Stage primaryStage) throws Exception {
        loadWindow("Landingpage.fxml", primaryStage);

    }

    public void loadWindow(String fxml, Stage ps) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            root = loader.load();
            ps.setTitle("Appurg");

            ps.setScene(new Scene(root, 1000, 600));
            ps.setResizable(false);
            ps.show();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
