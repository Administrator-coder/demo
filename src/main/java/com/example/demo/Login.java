package com.example.demo;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Login extends Application
{
    @FXML
    private Button login;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;
    void loginRequest(String user, String pass) throws Exception
    {
        try
        {
            Main.connect.sendMessage("login");
            Main.connect.sendMessage(user);
            Main.connect.sendMessage(pass);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    boolean getRequest() throws Exception
    {
        return Main.connect.getMessage().equals("true");
    }
    @FXML
    void onLogin(ActionEvent event)
    {
        String user = username.getText();
        String pass = password.getText();
        System.out.println(user + " " + pass);
        try
        {
            loginRequest(user, pass);
            if (getRequest())
            {
                System.out.println("Login successful");
            }
            else
            {
                System.out.println("Login failed");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void start(Stage stage) throws Exception
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
        stage.setScene(new Scene(fxmlLoader.load(), 600, 400));
        stage.setTitle("Login");
        stage.show();
    }
    public static void main(String[] args)
    {
        launch(args);
    }
}
