/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Blue
 */
public class TCPServer {
    public static void main(String[] args) throws Exception {
        String clientSentecce;
        String returnSentece;
        
        ServerSocket welcomeSocket=new ServerSocket(6789);
        while(true){
            //wait on 
            Socket connectionSocket =welcomeSocket.accept();
            BufferedReader inFromClient= new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            
            //create oupt stream
            DataOutputStream outToClient=new DataOutputStream(connectionSocket.getOutputStream());
            clientSentecce=inFromClient.readLine();
            returnSentece="Hello "+clientSentecce+"\n";
            System.out.println(returnSentece);
            outToClient.writeBytes(returnSentece);
         
        }
        
        
    }
    
    
    
    
}
