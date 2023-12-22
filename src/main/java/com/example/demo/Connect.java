package com.example.demo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Connect
{
    private Socket socket;
    private InputStream inFromServer;
    private OutputStream outToServer;
    private DataInputStream in;
    private DataOutputStream out;
    public void connect()
    {
        try
        {
            //创建等待连接页面
            Stage wait=new Stage();
            FXMLLoader loader =new FXMLLoader(getClass().getResource("WaitStage.fxml"));
            wait.setTitle("等待连接");
            wait.initStyle(StageStyle.UNDECORATED);
            wait.setScene(new Scene(loader.load()));
            wait.show();
            while (true)
            {
                try
                {
                    socket = new Socket("127.0.0.1", 9099);
                    break;
                }
                catch (Exception e)
                {
                    //System.out.println("连接失败");
                }
            }
            wait.close();
            inFromServer = socket.getInputStream();
            in = new DataInputStream(inFromServer);
            outToServer = socket.getOutputStream();
            out = new DataOutputStream(outToServer);
            loader = new FXMLLoader(getClass().getResource("ConnectSuccess.fxml"));
            Stage success = new Stage();
            success.setTitle("连接成功");
            success.setScene(new Scene(loader.load()));
            System.out.println("连接成功");
            success.show();//创建登录成功页面
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public Connect(){
        connect();
    }
    public void sendMessage(String message) throws Exception
    {
        out.writeUTF(message);
    }
    public String getMessage() throws Exception
    {
        return in.readUTF();
    }
}