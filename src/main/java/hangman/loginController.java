package hangman;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class loginController {

    @FXML
    private Button backBtn;

    @FXML
    private TextField password;

    @FXML
    private Button submitBtn;

    @FXML
    private TextField username;

    @FXML
    void onBackBtnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass ().getResource ("hangman-view.fxml"));
        Stage window = (Stage) ((Node) event.getSource ()).getScene ().getWindow ();
        window.setScene (new Scene(parent, 600, 400));
    }

    @FXML
    void onSubmitBtnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass ().getResource ("mainMenu.fxml"));
        Stage window = (Stage) ((Node) event.getSource ()).getScene ().getWindow ();
        window.setScene (new Scene(parent, 600, 400));
    }

}
