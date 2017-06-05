package clientServerStarter;

import javax.swing.*;

import server.ChatServer;
import client.ChatClientModel;

public class ClientServerStarter {
	
	/**
	 * 
	 */
	public static void main(String args[]){
		
		Object[] selectionValues = { "Server","Client"};
		String initialSection = "Server";
		
		Object selection = JOptionPane.showInputDialog(null, "Login as : ", "MyChatApp", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSection);
		if(selection.equals("Server")){
			//Start as a server
			startAsServer();
		}else if(selection.equals("Client")){
			//start as a client
			startAsClient();
		}
	}
	
	/**
	 * Starts this 
	 * @param port
	 */
	private static void startAsServer(){
		ChatServer server;
		
		int port = -1;

		port = Integer.parseInt(JOptionPane.showInputDialog("Enter the Server port number"));
		
		while(port < 1024 || port > 65535){
			port = Integer.parseInt(JOptionPane.showInputDialog(port + " is an invalid port number. Enter the Server port number"));
		}
		
		server = new ChatServer(port);
		
		server.startServer();
	}
	
	private static void startAsClient(){
		String serverIP = JOptionPane.showInputDialog("Enter the Server ip adress");
		int serverPort = Integer.parseInt(JOptionPane.showInputDialog("Enter the Server port number"));
		
		ChatClientModel client = new ChatClientModel(serverIP, serverPort);
		client.setupClient();
	}
	
}
