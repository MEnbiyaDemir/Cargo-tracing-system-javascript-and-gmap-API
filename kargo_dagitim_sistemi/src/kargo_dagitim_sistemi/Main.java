package kargo_dagitim_sistemi;

import javax.swing.JFrame;

public class Main extends JFrame{

	private static int ekranX = 1080;
	private static int ekranY = 620;
	public static void main(String[] args) {
		Main loginEkrani = new Main();
		loginEkrani.setSize(ekranX, ekranY);
		loginEkrani.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginEkrani.setLocationRelativeTo(null);
		

		
		Login login = new Login();
		loginEkrani.add(login);
		loginEkrani.setVisible(true);
		
	
		loginEkrani.getContentPane().requestFocusInWindow(); // jpanele olan auto focusu engellemek icin odagi jframe'e odakliyoruz
		
		login.setFocusable(true);
		login.requestFocus();
		login.setFrame(loginEkrani);
	
	}

}
