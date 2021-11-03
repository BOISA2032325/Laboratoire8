package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.*;
import java.util.List;

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
        GridPane gridPane = new GridPane();

        chargementImage.imageView1().setOnDragDetected(dragEvent->{
            Dragboard dragboard = chargementImage.imageView1().startDragAndDrop(TransferMode.COPY);
        });
        chargementImage.imageView1().setOnDragOver(dragEvent->{
            dragEvent.acceptTransferModes(TransferMode.COPY);
        });
        chargementImage.imageView1().setOnDragDropped(dragEvent -> {
            dragEvent.setDropCompleted(true);
        });

        //menu

        Stage stage1 = new Stage();
        stage1.setTitle("Mario");

        //La grille

        gridPane.add(chargementImage.imageView1(), (int)(Math.random()*3),(int)(Math.random()*3));
        gridPane.add(chargementImage.imageView2(), (int)(Math.random()*3),(int)(Math.random()*3));
        gridPane.add(chargementImage.imageView3(), (int)(Math.random()*3),(int)(Math.random()*3));
        gridPane.add(chargementImage.imageView4(), (int)(Math.random()*3),(int)(Math.random()*3));
        gridPane.add(chargementImage.imageView5(), (int)(Math.random()*3),(int)(Math.random()*3));
        gridPane.add(chargementImage.imageView6(), (int)(Math.random()*3),(int)(Math.random()*3));
        gridPane.add(chargementImage.imageView7(), (int)(Math.random()*3),(int)(Math.random()*3));
        gridPane.add(chargementImage.imageView8(), (int)(Math.random()*3),(int)(Math.random()*3));
        gridPane.add(chargementImage.imageView9(), (int)(Math.random()*3),(int)(Math.random()*3));

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
                stage1.setScene(new Scene(gridPane));
                stage1.show();
            }
        });

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
