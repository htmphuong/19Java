package ReadWriteFile;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class GiaiThuaSwing extends JFrame {

	private JPanel contentPane;
	private JTextField txtSoN;
	private JTextField txtKQ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaiThuaSwing frame = new GiaiThuaSwing();
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
	public GiaiThuaSwing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("S\u1ED1 N");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(42, 41, 93, 29);
		contentPane.add(lblNewLabel);
		
		txtSoN = new JTextField();
		txtSoN.setBounds(157, 38, 180, 47);
		contentPane.add(txtSoN);
		txtSoN.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("K\u1EBFt qu\u1EA3");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(42, 123, 93, 29);
		contentPane.add(lblNewLabel_1);
		
		txtKQ = new JTextField();
		txtKQ.setBounds(157, 120, 180, 38);
		contentPane.add(txtKQ);
		txtKQ.setColumns(10);
		
		JButton btnTinh = new JButton("T\u00EDnh giai th\u1EEBa");
		btnTinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//int so =Integer.parseInt(txtSoN.getText());
							 
				try {
					Socket skClient  = new Socket("localhost",7500);
					System.out.println("Connecting");
					String chuoi =txtSoN.getText();	
					DataOutputStream output = new DataOutputStream(skClient.getOutputStream());
					output.writeBytes(chuoi+"\n");
					output.flush();	
					
					DataInputStream input = new DataInputStream(skClient.getInputStream());
					String tich =input.readLine();
					System.out.println("Tich="+tich);
					txtKQ.setText(tich);
					input.close();
					output.close();
					skClient.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnTinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTinh.setBounds(157, 188, 181, 29);
		contentPane.add(btnTinh);
	}
}
