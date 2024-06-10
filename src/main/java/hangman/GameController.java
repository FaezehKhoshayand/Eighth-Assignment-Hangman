package hangman;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class GameController implements Initializable {
    public DatabaseManager databaseManager;
    public static String user;
    @FXML
    FlowPane alphabetBox;
    @FXML
    private HBox back;
    @FXML
    private ImageView img1;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img3;

    @FXML
    private ImageView img4;

    @FXML
    private ImageView img5;

    @FXML
    private ImageView img6;

    @FXML
    private HBox wordBox;
    @FXML
    private HBox lineBox;
    @FXML
    private HBox loseWin;
    @FXML
    ImageView img;
    Game game;
    Timer time;
    //Image image2 = new Image (Objects.requireNonNull (getClass ().getResourceAsStream ("mainMenuHangman.png")));
    String word = "TURKEY";
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        game = new Game();
        time = new Timer();
        time = new Timer();
        time.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    game.setTime(game.getTime() + 1);
                });
            }
        }, 1000, 1000);
        displayWord();
        displayAlphabet();
    }
    @FXML
    public void displayWord() {
        wordBox.getChildren().clear();
        for (int i = 0; i < word.length(); i++) {
            Label label = new Label();
            label.getStyleClass().add("word");
            label.setVisible(false);
            label.setPrefSize(80, 100);
            label.setText(String.valueOf(word.charAt(i)));
            label.setId("word" + i);
            label.autosize();
            label.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px; -fx-text-fill: black; -fx-font-weight: bold; -fx-alignment: center;");
            wordBox.getChildren().add(label);
            Label letterPlaceholder = new Label();
            letterPlaceholder.setPrefSize(100, 100);
            letterPlaceholder.setVisible(true);
            letterPlaceholder.getStyleClass().add("letterPlaceHolder");
            letterPlaceholder.autosize();
            letterPlaceholder.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;");
            lineBox.getChildren().add(letterPlaceholder);
        }
    }
    @FXML
    public void displayAlphabet() {
        img1.setVisible(false);
        img2.setVisible(false);
        img3.setVisible(false);
        img4.setVisible(false);
        img5.setVisible(false);
        img6.setVisible(false);
        alphabetBox.getChildren().clear();
        for (int i = 0; i < 26; i++) {
            Button button = new Button();
            button.setText(Character.toString('A' + i));
            button.setVisible(true);
            button.setStyle("-fx-background-color: white");
            button.setStyle("-fx-border-color: black");
            button.setPrefSize(50, 50);
            button.autosize();
            alphabetBox.getChildren().add(button);
            button.setOnAction(actionEvent -> {
                game.setWin(true);
                if (word.contains(String.valueOf(button.getText().charAt(0)))) {
                    for (var c : wordBox.getChildren()) {
                        if (((Label) c).getText().charAt(0) == button.getText().charAt(0)) {
                            c.setVisible(true);
                        }
                    }
                } else {
                    game.setWrongGuesses(game.getWrongGuesses() + 1);
                    if (game.getWrongGuesses() == 1) {
                        img1.setVisible(true);
                    } else if (game.getWrongGuesses() == 2) {
                        img2.setVisible(true);
                    } else if (game.getWrongGuesses() == 3) {
                        img3.setVisible(true);
                    } else if (game.getWrongGuesses() == 4) {
                        img4.setVisible(true);
                    } else if (game.getWrongGuesses() == 5) {
                        img5.setVisible(true);
                    } else if (game.getWrongGuesses() == 6) {
                        img6.setVisible(true);
                        alphabetBox.setVisible(false);
                        wordBox.setVisible(false);
                        lineBox.setVisible(false);
                        lose();
                    }
                }
                for (var c : wordBox.getChildren()) {
                    if (!c.isVisible()) {
                        game.setWin(false);
                    }
                }
                if (game.isWin()) {
                    win();
                }
                button.setVisible(false);
            });
        }
    }
    public void win() {
        alphabetBox.setVisible(false);
        wordBox.setVisible(false);
        lineBox.setVisible(false);
        time.cancel();
        Label lose = new Label();
        lose.setText("You Won!");
        lose.setPrefSize(100, 35);
        lose.setStyle("-fx-background-color: white; -fx-border-color: white; -fx-border-width: 2px; -fx-text-fill: black; -fx-font-weight: bold; -fx-alignment: center;");
        loseWin.getChildren().add(lose);
        game.setUsername(user);
        game.setWin(true);
        game.setUsername(user);
        game.setWord(word);
        DatabaseManager.createGameInfo(game);
    }


    public void lose() {
        time.cancel();
        Label lose = new Label();
        lose.setText("You lost!");
        lose.setPrefSize(100, 35);
        lose.setStyle("-fx-background-color: white; -fx-border-color: white; -fx-border-width: 2px; -fx-text-fill: black; -fx-font-weight: bold; -fx-alignment: center;");
        loseWin.getChildren().add(lose);
        game.setUsername(user);
        game.setWin(false);
        game.setUsername(user);
        game.setWord(word);
        DatabaseManager.createGameInfo(game);
    }
}
