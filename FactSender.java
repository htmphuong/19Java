package demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.awt.event.ActionEvent;

public class FactSender extends JFrame {

	private JPanel contentPane;
	private JTextField tfSoN;
	private JTextField tfKQ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FactSender frame = new FactSender();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FactSender() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("So N");
		lblNewLabel.setBounds(53, 31, 46, 14);
		contentPane.add(lblNewLabel);
		
		tfSoN = new JTextField();
		tfSoN.setBounds(147, 28, 221, 32);
		contentPane.add(tfSoN);
		tfSoN.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ket qua");
		lblNewLabel_1.setBounds(53, 120, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		tfKQ = new JTextField();
		tfKQ.setBounds(147, 117, 221, 32);
		contentPane.add(tfKQ);
		tfKQ.setColumns(10);
		
		JButton btnGT = new JButton("Giai Thua");
		btnGT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
						DatagramSocket skSender = new DatagramSocket(7500);
						String n =tfSoN.getText();
						byte[] gui = n.getBytes();
						int len =gui.length;
						int port =7000;
						InetAddress add = InetAddress.getByName("localhost");
						DatagramPacket pSender = new DatagramPacket(gui, len,add,port);
						skSender.send(pSender);
						//nhan packet
						
						byte[] nhan = new byte[1024];
						int leng = nhan.length;
						DatagramPacket pRei = new DatagramPacket(nhan, leng);
						skSender.receive(pRei);
						

						byte[] kq = pRei.getData();//lay du lieu trong packet ra
						String num = (new String(kq,kq.length)).trim();
						tfKQ.setText(num);
						skSender.close();
					
					
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
		btnGT.setBounds(147, 189, 89, 23);
		contentPane.add(btnGT);
	}
}
