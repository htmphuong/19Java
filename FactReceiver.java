package demo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class FactReceiver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			while(true) {
				DatagramSocket skRei = new DatagramSocket(7000);
				byte[] nhan = new byte[1024];
				int len = nhan.length;
				DatagramPacket pRei = new DatagramPacket(nhan, len);
				skRei.receive(pRei);
				

				byte[] so = pRei.getData();//lay du lieu trong packet ra
				String n = (new String(so,so.length)).trim();
				System.out.println("n="+n);
				int num =Integer.parseInt(n);
				int tich=1;
				for(int i=2;i<=num;i++) tich =tich*i;
				
				byte[] kq = String.valueOf(tich).getBytes();
				int leng= kq.length;
				int port = pRei.getPort();
				InetAddress add = pRei.getAddress();
				DatagramPacket pSend = new DatagramPacket(kq, leng,add,port);
				skRei.send(pSend);
				skRei.close();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
