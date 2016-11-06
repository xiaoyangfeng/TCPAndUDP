/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.net.ssl.SSLSocket;

/**
 *
 * @author Blue
 */
public class TCPClient {
    public static void main(String[] args) throws Exception {
        String sentence;
        String modifiedSentence;
        
        //creat input stream
        BufferedReader inFromUser=new BufferedReader(new InputStreamReader(System.in));
        //create socket
        Socket clientSocket=new Socket("localhost", 6789);
        
        //careat output stream
        DataOutputStream outToServer=new DataOutputStream(clientSocket.getOutputStream());
        
        //input stream form sever
        BufferedReader inFromServer= new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        sentence=inFromUser.readLine();
        //System.out.println(sentence);
        
        //send line to server("\n" is a must!!!!!!)
        outToServer.writeBytes(sentence+"\n");
        
        //read line from sever
        modifiedSentence=inFromServer.readLine();
        System.out.println("From Server:"+ modifiedSentence);
        
        clientSocket.close();

        
    }
}
