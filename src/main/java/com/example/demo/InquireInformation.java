package com.example.demo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class InquireInformation
{

    @FXML
    private TextField date;

    @FXML
    private TextField month;

    @FXML
    private Button search;

    @FXML
    private TextField year;

    @FXML
    void OnSearch(ActionEvent event)
    {
        String year = this.year.getText();
        String month = this.month.getText();
        String date = this.date.getText();
        System.out.println(year + " " + month + " " + date);
        try
        {
            Main.connect.sendMessage("searchRequest");
            Main.connect.sendMessage(year);
            Main.connect.sendMessage(month);
            Main.connect.sendMessage(date);
            String result = Main.connect.getMessage();
            System.out.println(result);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
