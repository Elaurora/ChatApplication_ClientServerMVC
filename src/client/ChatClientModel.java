package client;

import java.io.IOException;


// Class to manage Client chat Box.
public class ChatClientModel {
	
	private String serverIP;
	private int port;
	private ChatClientController access;
	
	private ChatClientView frame;
	
	/**
	 * @param serverIP - The IP of the server to connect to
	 * @param port - The port number of the server to communicate to
	 */
	public ChatClientModel(String serverIP, int port){
		this.serverIP = serverIP;
		this.port = port;
        this.access = new ChatClientController();
        
	}
	
	/**
	 * Initializes the GUI as well as the communication to the server
	 */
	public void setupClient(){
		generateGUI();
        
        try {
            access.InitSocket(serverIP, port);
        } catch (IOException ex) {
            System.out.println("Cannot connect to " + serverIP + ":" + port);
            ex.printStackTrace();
            System.exit(0);
        }
	}
	
	/**
	 * Initializes the GUI
	 */
	private void generateGUI(){
    	frame = new ChatClientView(access);
        frame.setupClientView(serverIP, port);
    }
}