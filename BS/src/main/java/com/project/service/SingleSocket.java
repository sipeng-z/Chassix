package com.project.service;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//for single socket blocked
public class SingleSocket {


    // no use it
    public  void plcSingleSocket(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(2828);
        Socket client = server.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream());
        while (true) {
            String str = in.readLine();
            System.out.println(str);
            out.println("has receive....");
            out.flush();
            if (str.equals("end"))
                break;
        }
        client.close();
    }




}
