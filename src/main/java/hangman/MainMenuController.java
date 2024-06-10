package hangman;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    @FXML
    private Button leaderBoardBtn;

    @FXML
    private Button previousGameBtn;

    @FXML
    private Button startBtn;
    @FXML
    void onStartBtnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass ().getResource ("game.fxml"));
        Stage window = (Stage) ((Node) event.getSource ()).getScene ().getWindow ();
        window.setScene (new Scene(parent, 600, 400));
    }
    @FXML
    void onLeaderboardClick(ActionEvent event) {

    }

    @FXML
    void onPreviousGameClick(ActionEvent event) {

    }

}
