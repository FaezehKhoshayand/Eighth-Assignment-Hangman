package hangman;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class GameController implements Initializable {

    @FXML
    FlowPane alphabetBox;
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
    //Image image2 = new Image (Objects.requireNonNull (getClass ().getResourceAsStream ("mainMenuHangman.png")));
    String word = "AAAMN";
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
        AtomicInteger cnt = new AtomicInteger();
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
                if (word.contains(String.valueOf(button.getText().charAt(0)))) {
                    for (var c : wordBox.getChildren()) {
                        if (((Label) c).getText().charAt(0) == button.getText().charAt(0)) {
                            c.setVisible(true);
                        }
                    }
                } else {
                    cnt.getAndIncrement();
                    if (cnt.toString().equals("1")) {
                        img1.setVisible(true);
                    } else if (cnt.toString().equals("2")) {
                        img2.setVisible(true);
                    } else if (cnt.toString().equals("3")) {
                        img3.setVisible(true);
                    } else if (cnt.toString().equals("4")) {
                        img4.setVisible(true);
                    } else if (cnt.toString().equals("5")) {
                        img5.setVisible(true);
                    } else if (cnt.toString().equals("6")) {
                        img6.setVisible(true);
                        alphabetBox.setVisible(false);
                        wordBox.setVisible(false);
                        lineBox.setVisible(false);
                        Label lose = new Label();
                        lose.setText("You lost!");
                        lose.setPrefSize(100, 35);
                        lose.setStyle("-fx-background-color: white; -fx-border-color: white; -fx-border-width: 2px; -fx-text-fill: black; -fx-font-weight: bold; -fx-alignment: center;");
                        loseWin.getChildren().add(lose);

                    }

                }
                button.setVisible(false);
            });
        }
    }
}
