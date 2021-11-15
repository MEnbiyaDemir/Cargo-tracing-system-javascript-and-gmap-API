package kargo_dagitim_sistemi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;



public class Kargo extends JFrame implements ActionListener{

	

	JButton kargoEkle;
	JButton kargoSil;
	JTable table;
	JScrollPane sp;
	JPanel panel_table;
	JPanel panel_buttons;
	JLabel isim;
	String isim_String;
	
	 String data[][]={};    
String column[]={"EKLENME SIRASI","TESLÝMAT SIRASI","ADRES","TESLÝM DURUMU"};   
	

	public Kargo() {
		super();
		setLocation(120, 100);
		//setSize(1000, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new BorderLayout());
		 
		
	     isim = new JLabel("ÝSÝM SOYÝSÝM");
	     isim.setFont(new Font("times new roman",Font.BOLD,30));
	     isim.setForeground(new Color(255, 0, 0));
	     add(isim,BorderLayout.BEFORE_FIRST_LINE); 
	     
		 panel_table = new JPanel();
		 panel_buttons = new JPanel();
		 panel_table.setOpaque(true);
		 panel_buttons.setOpaque(true);
		 //setContentPane(panel);
		
		 table = new JTable(data,column);
		// table.setBounds(0,0,panel.getWidth(),100);


	
		 
		  table.setAutoResizeMode(JTable.WIDTH);
		  table.setDefaultEditor(Object.class, null); // hucrelerin icindeki yazilari degistirmeyi onler
		  
	     sp = new JScrollPane(table);
	     add(sp, BorderLayout.CENTER);
	     add(panel_table, BorderLayout.NORTH);
		
	 
		
		 
	     kargoEkle = new JButton("Kargo Ekle"); kargoEkle.addActionListener(this);
	     panel_buttons.add(kargoEkle,BorderLayout.SOUTH);	
		 
		 kargoSil = new JButton("Kargo Ýptal"); 
		 panel_buttons.add(kargoSil,BorderLayout.SOUTH);	

		 add(panel_buttons, BorderLayout.SOUTH);
		 
		
		 
		 table.setRowHeight(30);
		 table.getColumnModel().getColumn(0).setPreferredWidth(100);
		 table.getColumnModel().getColumn(1).setPreferredWidth(100);
		 table.getColumnModel().getColumn(2).setPreferredWidth(300);
		 table.getColumnModel().getColumn(3).setPreferredWidth(100);
		 
		
		
		
		 pack();
		

	}

	public String getIsim_String() {
		return isim_String;
	}


	public void setIsim_String(String isim_String) {
		this.isim_String = isim_String;
		isim.setText(isim_String);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Kargo Ekle"))
		{ 
	
			
			
		}
		
	}
	
}
