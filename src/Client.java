import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		//System.out.println("Hello world!");
		
		Socket svrSocket = null;
		
		PrintWriter out = null;
		BufferedReader in = null;

		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		
		String input;
		
		try {
			svrSocket = new Socket("localhost", 9999);
			out = new PrintWriter(svrSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(svrSocket.getInputStream()));
		}
		catch (UnknownHostException e) {
			System.err.println("Don't know host");
		}
		catch (IOException e) {
			System.err.println("Couldn't get I/O for connection");
		}
		
		if (svrSocket != null && out != null && in != null){
			try{
				System.out.print("input: ");
				while ((input = stdIn.readLine()) != null) {
					out.println(input);
					System.out.println("echo: " + in.readLine());
					
					if (input.equalsIgnoreCase("quit")){
						break;
					}
					
					System.out.print("input: ");
				}
				
				out.close();
				in.close();
				stdIn.close();
				svrSocket.close();
			}
			catch (UnknownHostException e){
				System.err.println("Unknown host");
			}
			catch (IOException e){
				System.err.println("IOException: " + e);
			}
		}
		
}
	
}
