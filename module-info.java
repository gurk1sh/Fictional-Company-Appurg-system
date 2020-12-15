module projectScenebuilder {
    requires javafx.fxml;
    requires javafx.controls;

    opens sample;
    opens sample.Login;
    opens sample.Profile;
    opens sample.Register;
    opens sample.Landing;
    opens sample.Work_Procedures;
    opens sample.Error_Procedures;

}