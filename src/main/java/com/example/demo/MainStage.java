package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainStage {

    @FXML
    private Button InformationAnalysis;

    @FXML
    private Button InformationChange;

    @FXML
    private Button InformationEntry;

    @FXML
    private Button InformationInquiry;

    @FXML
    void AnalyzeInformation(ActionEvent event)
    {

    }

    @FXML
    void ChangeInformation(ActionEvent event) {

    }

    @FXML
    void EnterInformation(ActionEvent event)
    {

    }

    @FXML
    void InquireInformation(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InquireInformation.fxml"));
        Stage stage = new Stage();
        stage.setTitle("查询信息");
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
    }

}
