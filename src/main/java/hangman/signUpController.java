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

public class signUpController {
    @FXML
    private Button backBtn;
    @FXML
    private TextField nametxt;

    @FXML
    private TextField passwordtxt;

    @FXML
    private TextField usernametxt;
    @FXML
    protected void onBackBtnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load (getClass ().getResource ("hangman-view.fxml"));
        Stage window = (Stage) ((Node) event.getSource ()).getScene ().getWindow ();
        window.setScene (new Scene(parent, 600, 400));
    }
    @FXML
    void onSubmitBtnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass ().getResource ("mainMenu.fxml"));
        Stage window = (Stage) ((Node) event.getSource ()).getScene ().getWindow ();
        window.setScene (new Scene(parent, 600, 400));
        String name = nametxt.getText();
        String username = usernametxt.getText();
        String password = passwordtxt.getText();
    }
}
