package de.unitrier.st.fp.s23.blatt02;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Border;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.Label;



public class MineSweeperFX extends Application
{
    private Game game;
    @FXML Button restart2;
    @FXML MenuItem restart;
    @FXML MenuItem quit;
    @FXML MenuItem save;


    public void start(Stage stage) throws Exception
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sb.fxml"));
        fxmlLoader.setController(this);
        int columns = 15;
        int rows = 20;

        game = new Game(columns, rows);
        BorderPane borderPane = fxmlLoader.load();

        Scene scene = new Scene(borderPane);
        stage.setTitle(this.getClass().getSimpleName());
        stage.setScene(scene);

        restart.setOnAction(e->{ game = new Game(columns, rows);
            borderPane.setCenter(new MineSweeperPane(game));});

        restart2.setOnAction(e->{
            game = new Game(columns, rows);
            borderPane.setCenter(new MineSweeperPane(game));});

        quit.setOnAction( e ->{System.exit(0);});

        save.setOnAction(e -> {
        });

        MineSweeperPane mineSweeperPane = new MineSweeperPane(game);
        borderPane.setCenter(mineSweeperPane);
        mineSweeperPane.setLayoutY(100);

        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
