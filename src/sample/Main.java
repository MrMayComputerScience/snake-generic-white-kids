package sample;
import mayflower.*;
import mayflower.test.TestWorld;
import mayflower.test.astar.MyWorld;

public class Main{
    public static void main(String[] args){

    }

<<<<<<< HEAD
=======
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
>>>>>>> parent of a284853... Re-init

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
