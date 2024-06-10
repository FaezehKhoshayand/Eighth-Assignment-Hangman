package hangman;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class leaderboardController implements Initializable {
    @FXML
    private TableView<Game> table;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> items = FXCollections.observableArrayList(DatabaseManager.selectLeaderBoard());
        ListView<String> listView = new ListView<>(items);

    }

}
