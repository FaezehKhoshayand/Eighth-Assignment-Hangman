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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class loginController {
    private DatabaseManager databaseManager;

    @FXML
    private Button backBtn;
    @FXML
    private Label errorLabel;


    @FXML
    private TextField passwordtxt;

    @FXML
    private Button submitBtn;

    @FXML
    private TextField usernametxt;

    @FXML
    void onBackBtnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass ().getResource ("hangman-view.fxml"));
        Stage window = (Stage) ((Node) event.getSource ()).getScene ().getWindow ();
        window.setScene (new Scene(parent, 600, 400));
    }

    @FXML
    void onSubmitBtnClick(ActionEvent event) throws IOException {
        String username = usernametxt.getText();
        String password = passwordtxt.getText();
        Account account = DatabaseManager.findUser(username, password);
        GameController.user = username;
        if(account != null) {
            if (account.getUsername() != null) {
                if(Objects.equals(account.getUsername(), username) && Objects.equals(account.getPassword(), password)) {
                    Parent parent = FXMLLoader.load(getClass ().getResource ("mainMenu.fxml"));
                    Stage window = (Stage) ((Node) event.getSource ()).getScene ().getWindow ();
                    window.setScene (new Scene(parent, 600, 400));
                }
                else {
//                    Label errorLabel = new Label();
//                    errorLabel.setText("The username is not found");
//                    errorLabel.setPrefSize(100, 35);
//                    errorLabel.setStyle("-fx-background-color: black; -fx-border-color: red; -fx-border-width: 2px; -fx-text-fill: red; -fx-font-weight: bold; -fx-alignment: center;");
//                    error.getChildren().add(errorLabel);
                }
            }
        }

    }

}
