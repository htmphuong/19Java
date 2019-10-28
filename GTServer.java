package ReadWriteFile;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GTServer {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket srvSK = new ServerSocket(7500);
			
			DataInputStream input;
			DataOutputStream output;
			while(true) {
				Socket skServer = srvSK.accept();
				System.out.println("Connected...");
				input= new DataInputStream(skServer.getInputStream());
				String soN = input.readLine();
				int n = Integer.parseInt(soN);
				System.out.println("n="+n);
				int tich=1;
				for(int i=2;i<=n;i++) tich=tich*i;
				output= new DataOutputStream(skServer.getOutputStream());
				System.out.println("tich="+tich);
				output.writeBytes(String.valueOf(tich));	
				output.flush();
				
				if(input.equals("quit")) {
					output.writeBytes("exit");
					output.flush();
					break;
				}
				input.close();
				output.close();
				skServer.close();
				srvSK.close();
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
