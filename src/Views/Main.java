package Views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("SoapDetailsView.fxml"));//set fxml to load

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Soap Options");
        primaryStage.show();
    }
}
