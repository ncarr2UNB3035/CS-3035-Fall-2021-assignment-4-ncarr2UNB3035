package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 */
public class Main extends Application {
    public static final Model model = new Model(6);
    public static final View view = new View();

    @Override
    public void start(Stage primaryStage){
        Scene scene = new Scene(view);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}