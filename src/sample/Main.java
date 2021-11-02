package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Collection;
import java.util.Optional;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Casse tete");
        Group group = new Group();
        ChargementImage chargementImage = new ChargementImage();
        DimensionFenetre dimensionFenetre = new DimensionFenetre();
        Button mario = new Button("Casse tete de mario");
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        Group menuPrincipal = new Group();

        //menu

        Stage stage1 = new Stage();
        stage1.setTitle("Mario");

        //Les buttons

        mario.setTranslateY(100);
        mario.setTranslateX(180);
        mario.setScaleY(2);
        mario.setScaleX(2);


        mario.setOnAction(actionEvent -> {

            primaryStage.close();
            stage1.show();

            ChoiceDialog<String>choiceDialog = new ChoiceDialog<String>(
                    "Retour",
                    "Jouer"
            );
            choiceDialog.setTitle("Choix");
            choiceDialog.setContentText("Votre choix : ");
            String resultat = choiceDialog.showAndWait().get();


            if (resultat == "Retour"){
                stage1.close();
                primaryStage.show();
            }else if (resultat == "Jouer"){
                
            }



        });


        //La grille

        GridPane gridPane = new GridPane();
        gridPane.add(chargementImage.imageView1(), 0,0);
        gridPane.add(chargementImage.imageView2(), 1,0);
        gridPane.add(chargementImage.imageView3(), 2,0);
        gridPane.add(chargementImage.imageView4(), 0,1);
        gridPane.add(chargementImage.imageView5(), 1,1);
        gridPane.add(chargementImage.imageView6(), 2,1);
        gridPane.add(chargementImage.imageView7(), 0,2);
        gridPane.add(chargementImage.imageView8(), 1,2);
        gridPane.add(chargementImage.imageView9(), 2,2);

        //Les groupes
        menuPrincipal.getChildren().addAll(mario);
        group.getChildren().addAll(chargementImage.imageView10());

        //Stage
        stage1.setMaximized(true);
        stage1.setScene(new Scene(group));
        primaryStage.setScene(new Scene(menuPrincipal));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
