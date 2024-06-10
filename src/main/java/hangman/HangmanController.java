package hangman;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class HangmanController {

    @FXML
    private Button loginBtn;

    @FXML
    private Button signupBtn;
    public static Account user;
    @FXML
    protected void onLoginBtnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load (getClass ().getResource ("login-view.fxml"));
        Stage window = (Stage) ((Node) event.getSource ()).getScene ().getWindow ();
        window.setTitle("Login Menu");
        window.setScene (new Scene(parent, 600, 400));
    }
    @FXML
   protected void onSignUpBtnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load (getClass ().getResource ("signUp-view.fxml"));
        Stage window = (Stage) ((Node) event.getSource ()).getScene ().getWindow ();
        window.setTitle("Sign-Up Menu");
        window.setScene (new Scene(parent, 600, 400));
    }
}