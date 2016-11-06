/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Blue
 */
public class UDPServer {
    public static void main(String[] args) throws Exception {
        //create socket
        DatagramSocket serverSocket=new DatagramSocket(9876);
        
        byte[] receiveData=new byte[1024];
        byte[] sendData=new byte[1024];
        
        while(true){
            DatagramPacket receivePacket= new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence= new String(receivePacket.getData());
            //get IP and port
            InetAddress IPAddress= receivePacket.getAddress();
            int port=receivePacket.getPort();
            
            String returnSentence="Hello "+sentence+"\n";
            System.out.println(returnSentence);
            sendData=returnSentence.getBytes();
            
            
            DatagramPacket sendPacket=new DatagramPacket(sendData, sendData.length,IPAddress,port);
            //write datagram to socket
            serverSocket.send(sendPacket);
        }
    }
}
