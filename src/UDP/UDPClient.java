/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Blue
 */
public class UDPClient {
    public static void main(String[] args) throws Exception{
        //create input stream
        BufferedReader inFromUser=new BufferedReader(new InputStreamReader(System.in));
        
        //create client socket
        DatagramSocket clientSocket= new DatagramSocket();
        
        //translate hostname to ip
        InetAddress IPAddress = InetAddress.getByName("localhost");
        
        byte[] sendData=new byte[1024];
        byte[] receiveData=new byte[1024];
        
        String sentence=inFromUser.readLine();
        sendData=sentence.getBytes();
        
        //create datagram
        DatagramPacket sendPacket=new DatagramPacket(sendData, sendData.length,IPAddress,9876);
        
        //send datagram to server
        clientSocket.send(sendPacket);
        
        DatagramPacket receivePacket= new DatagramPacket(receiveData, receiveData.length);
        
        //read datagram from server
        clientSocket.receive(receivePacket);
        //System.out.println(receivePacket.toString());
        
        
        String modifiedSentence= new String(receivePacket.getData());
        System.out.println("From server: "+modifiedSentence);
        clientSocket.close();


    }
    
}
