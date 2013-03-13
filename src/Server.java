import java.io.*;
import java.net.*;


public class Server {
	public static void main(String[] args){
		//System.out.println("Hello world!");
		
		
		ServerSocket echoServer = null;
		String line;
		DataInputStream is;
		PrintStream os;
		Socket clientSocket = null;
		
		try {
			echoServer = new ServerSocket(9999);
		}
		catch (IOException e){
			System.out.println(e);
		}
		
		try {
			clientSocket = echoServer.accept();
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			String input;
			
			while ((input = in.readLine()) != null ) {
				System.out.println("Server: " + input);
				out.println(input);
				
				if (input.equalsIgnoreCase("quit")){
					break;
				}
			}
		}
		catch (Exception e){
			System.err.println(e);
		}
			
	}
		
}
