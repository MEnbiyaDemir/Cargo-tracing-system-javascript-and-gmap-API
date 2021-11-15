package kargo_dagitim_sistemi;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.*;


public class Login extends JPanel implements FocusListener, MouseListener, ActionListener{

	static String url="jdbc:mysql://cargodb190202.mysql.database.azure.com:3306/cargodb?useSSL=true";
	static String userName="cagkanenbiya";
	static String password="Cagkan190202enbiya";
	
	
	JTextField loginEmail;
	JTextField loginSifre;
	JTextField registerSifre;
	JTextField registerEmail;
	JTextField registerIsim;
	JTextField fake;
	
	JLabel lb;
	JLabel lb1;
	JLabel lbDurum;
	
	JButton giris;
	JButton uyeOl;
	
	BufferedImage image;
	BufferedImage image1;
	BufferedImage offset;
	BufferedImage onset;
	BufferedImage mouseclick;

	JFrame frame;
	public Login() {
		super();
		
	
		
		
		//setFont(new Font("Arial",Font.PLAIN,50));
		resimYukle();
		setLayout(null);
	//	fake =  new JTextField("",0); add(fake);
		loginEmail = new JTextField("Email",25); 				add(loginEmail);	 loginEmail.setBounds(700, 200, 200, 30); 	loginEmail.addFocusListener(this);
		loginSifre = new JTextField("Þifre",25); 				add(loginSifre);  	 loginSifre.setBounds(700, 300, 200, 30);	loginSifre.addFocusListener(this);
		registerSifre = new JTextField("Þifre",25);				add(registerSifre);	 registerSifre.setBounds(200, 300, 200, 30);registerSifre.addFocusListener(this);
		registerEmail = new JTextField("Email",25);				add(registerEmail);	 registerEmail.setBounds(200, 200, 200, 30);registerEmail.addFocusListener(this);
		registerIsim = new JTextField("Ýsim ve Soyisim",25);	add(registerIsim);	 registerIsim.setBounds(200, 400, 200, 30);	registerIsim.addFocusListener(this);
		
		lb = new JLabel("KAYIT OL!"); add(lb); lb.setBounds(230, 100, 300,80);
		lb1 = new JLabel("GÝRÝÞ YAP!"); add(lb1); lb1.setBounds(730, 100, 300,80);
		lb.setFont(new Font("SansSerif",Font.PLAIN,32));
		lb1.setFont(new Font("SansSerif",Font.PLAIN,32));
		
		lbDurum = new JLabel(""); add(lbDurum); lbDurum.setBounds(450, 510, 370,80);
		lbDurum.setFont(new Font("SansSerif",Font.BOLD,22));
		lbDurum.setForeground(new Color(255, 255, 255));
		
		giris = new JButton("GÝRÝÞ"); add(giris);	 giris.setBounds(750, 450, 100, 50);
		uyeOl = new JButton("KAYIT"); add(uyeOl);	 uyeOl.setBounds(250, 450, 100, 50);
		giris.setIcon(new ImageIcon(offset)); giris.addFocusListener(this); giris.addMouseListener(this); giris.addActionListener(this);
		uyeOl.setIcon(new ImageIcon(offset)); uyeOl.addFocusListener(this); uyeOl.addMouseListener(this);uyeOl.addActionListener(this);
		
		
		
		repaint();
		
		
	}
	


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image,0,0,null);
		g.drawImage(image1,160,110,null);
		g.drawImage(image1,660,110,null);
	}


	public void resimYukle() {
		try {
			image = ImageIO.read(new File("loginresim.jpg"));
			image1 = ImageIO.read(new File("bg_transparent.png"));
			offset = ImageIO.read(new File("offset.png"));
			onset = ImageIO.read(new File("onset.png"));
			mouseclick = ImageIO.read(new File("mouseclick.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public void focusGained(FocusEvent e) {
		if(loginEmail.isFocusOwner() && (loginEmail.getText().isBlank() || loginEmail.getText().equals("Email")))
			loginEmail.setText("");
		if(loginSifre.isFocusOwner() && (loginSifre.getText().isBlank() || loginSifre.getText().equals("Þifre")))
			loginSifre.setText("");
		if(registerEmail.isFocusOwner() && (registerEmail.getText().isBlank() || registerEmail.getText().equals("Email")))
			registerEmail.setText("");
		if(registerSifre.isFocusOwner() && (registerSifre.getText().isBlank() || registerSifre.getText().equals("Þifre")))
			registerSifre.setText("");
		if(registerIsim.isFocusOwner() && (registerIsim.getText().isBlank() || registerIsim.getText().equals("Ýsim ve Soyisim")))
			registerIsim.setText("");
	
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(!loginEmail.isFocusOwner() && (loginEmail.getText().isBlank() || loginEmail.getText().equals("Email")))
			loginEmail.setText("Email");
		if(!loginSifre.isFocusOwner() && (loginSifre.getText().isBlank() || loginSifre.getText().equals("Þifre")))
			loginSifre.setText("Þifre");
		if(!registerEmail.isFocusOwner() && (registerEmail.getText().isBlank() || registerEmail.getText().equals("Email")))
			registerEmail.setText("Email");
		if(!registerSifre.isFocusOwner() && (registerSifre.getText().isBlank() || registerSifre.getText().equals("Þifre")))
			registerSifre.setText("Þifre");
		if(!registerIsim.isFocusOwner() && (registerIsim.getText().isBlank() || registerIsim.getText().equals("Ýsim ve Soyisim")))
			registerIsim.setText("Ýsim ve Soyisim");
	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource().equals(giris))
		giris.setIcon(new ImageIcon(mouseclick));
		if(e.getSource().equals(uyeOl))
		uyeOl.setIcon(new ImageIcon(mouseclick));
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource().equals(giris))
		giris.setIcon(new ImageIcon(onset));
		if(e.getSource().equals(uyeOl))
		uyeOl.setIcon(new ImageIcon(onset));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource().equals(giris))
		giris.setIcon(new ImageIcon(offset));
		if(e.getSource().equals(uyeOl))
		uyeOl.setIcon(new ImageIcon(offset));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("GÝRÝÞ"))
		{ 
		
			
			if(loginEmail.getText()!="Email"&& loginSifre.getText()!="Þifre")
			{
				Connection myDbConn=null;

				PreparedStatement statement1=null;
				PreparedStatement statement2=null;
				PreparedStatement statement3=null;
				
				
				boolean emailonay=false,sifreonay=false;

				ResultSet resultSet1;
				ResultSet resultSet2;
				ResultSet resultSet3;
				try{
					// connection = DriverManager.getConnection(url,userName,password);
					myDbConn= DriverManager.getConnection(url, userName, password);
					statement1=myDbConn.prepareStatement("SELECT user_email FROM usertable");
					resultSet1 = statement1.executeQuery();
					while (resultSet1.next()){
						if (resultSet1.getString("user_email").equals(loginEmail.getText())){System.out.println("email dogru"); emailonay=true;}
					}
					statement2=myDbConn.prepareStatement("SELECT user_password FROM usertable");
					resultSet2 = statement2.executeQuery();
					while (resultSet2.next()){
						if (resultSet2.getString("user_password").equals(loginSifre.getText())){System.out.println("sif dogru"); sifreonay=true;}
					}

					if (sifreonay==true && emailonay==true){System.out.println("GIRIS YAPILDI"); lbDurum.setText("GIRIS YAPILDI");
					Kargo kargosistemi = new Kargo();
					Map googlemap = new Map();
					
					String emailxx = loginEmail.getText();
					String sifrexx = loginSifre.getText();
					
					statement3=myDbConn.prepareStatement("SELECT * FROM usertable WHERE user_email='"+emailxx+"' AND user_password='"+sifrexx+"'");
					resultSet3 = statement3.executeQuery();
					while (resultSet3.next()){
						kargosistemi.setIsim_String(resultSet3.getString("user_name")); 
					}
					
					frame.dispose();
					}
					else if(sifreonay==false || emailonay==false){System.out.println("GIRIS HATALI"); lbDurum.setText("GIRIS HATALI");}

					System.out.println("Baglanti olustu.");
				}catch (SQLException exception){System.out.println("Hata: " +exception);}
				finally {
					try {
						statement1.close();
						myDbConn.close();
					} catch (SQLException exception) {
						exception.printStackTrace();
					}
				}
			}
		}
		
		else if(e.getActionCommand().equals("KAYIT"))
		{ 
			
			if(registerEmail.getText()!="" && registerIsim.getText()!="" && registerSifre.getText()!=""){

				Connection myDbConn=null;

				PreparedStatement preparedStatement=null;
				ResultSet resultSet;
				try{
					// connection = DriverManager.getConnection(url,userName,password);
					myDbConn= DriverManager.getConnection(url, userName, password);
					preparedStatement=myDbConn.prepareStatement("insert into usertable (user_name,user_email,user_password) values(?,?,?)");
					preparedStatement.setString(1,registerIsim.getText());
					preparedStatement.setString(2,registerEmail.getText());
					preparedStatement.setString(3,registerSifre.getText());
					preparedStatement.executeUpdate();

					System.out.println("Kayýt olundu.");
					lbDurum.setText("BASARIYLA KAYIT OLUNDU.");
				}catch (SQLException exception){System.out.println("Hata: " +exception);}
				finally {
					try {
						preparedStatement.close();
						myDbConn.close();
					} catch (SQLException exception) {
						exception.printStackTrace();
					}
				}

			}

		}
	}



	public JFrame getFrame() {
		return frame;
	}



	public void setFrame(JFrame frame) {
		this.frame = frame;
	}



}
