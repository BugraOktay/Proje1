package yazlab1;

import java.sql.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.StreamCorruptedException;
import java.security.PublicKey;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JProgressBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;



import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;

public class Arayuz extends JFrame {
    static Connection con;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField O_sil;
	private JTextField textField_8;
	private JTextField textField_12;
	private JTextField O_no;
	private JTextField O_Ad;
	private JTextField O_ilgi;
	private JTextField O_anlasma;
	private JTextField O_Agno;
	private JTextField H_sicil;
	private JTextField H_ad;
	private JTextField H_kontenjan;
	private JTextField H_Kriterders;
	private JTextField H_sil;
	private JTable table;
	private JTextField textField_7;
	private JComboBox comboBox_ders1;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		connectToDb();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Arayuz frame = new Arayuz();
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
	public Arayuz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1209, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		
			
		
		JPanel Giris = new JPanel();
		Giris.setBackground(new Color(255, 250, 205));
		Giris.setBounds(279, 144, 675, 474);
		contentPane.add(Giris);
		Giris.setVisible(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(0, 0, 1195, 713);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnY = new JButton("YÖNETİCİ");
		btnY.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		btnY.setBounds(137, 329, 232, 98);
		panel.add(btnY);
		
		JButton btnH = new JButton("HOCA");
		btnH.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		btnH.setBounds(462, 329, 232, 98);
		panel.add(btnH);
		
		JButton btnO = new JButton("ÖĞRENCİ");
		btnO.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		btnO.setBounds(812, 329, 232, 98);
		panel.add(btnO);
		
		JLabel lblNewLabel = new JLabel("Ders Kayıt Sistemi");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 43));
		lblNewLabel.setBounds(421, 66, 345, 77);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(10, 10, 488, 48);
		panel.add(lblNewLabel_3);
		Giris.setLayout(null);
		
		
		JButton btnNewButton4 = new JButton("GERİ");
		btnNewButton4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton4.setBounds(166, 323, 118, 29);
		Giris.add(btnNewButton4);
		
		JButton btnNewButton5 = new JButton("Giriş Yap");
		btnNewButton5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton5.setBounds(371, 323, 118, 29);
		Giris.add(btnNewButton5);
		
		textField = new JTextField();
		textField.setToolTipText("Kullanıcı Adı");
		textField.setBounds(185, 142, 293, 29);
		Giris.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Şifre");
		textField_1.setColumns(10);
		textField_1.setBounds(185, 181, 293, 29);
		Giris.add(textField_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(132, 28, 394, 64);
		Giris.add(lblNewLabel_1);
							
							JPanel ogrenci_1 = new JPanel();
							ogrenci_1.setBackground(Color.CYAN);
							ogrenci_1.setBounds(0, 0, 1195, 713);
							contentPane.add(ogrenci_1);
							ogrenci_1.setLayout(null);
							
							JPanel panel_ogr_bil = new JPanel();
							panel_ogr_bil.setBackground(new Color(255, 255, 0));
							panel_ogr_bil.setBounds(0, 26, 1195, 687);
							ogrenci_1.add(panel_ogr_bil);
							panel_ogr_bil.setLayout(null);
							
							JLabel lblNewLabel_5 = new JLabel("- Öğrenci Numarası :");
							lblNewLabel_5.setForeground(new Color(128, 0, 0));
							lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_5.setBounds(46, 40, 196, 26);
							panel_ogr_bil.add(lblNewLabel_5);
							
							JLabel lblNewLabel_5_1 = new JLabel("- Ad/Soyad :");
							lblNewLabel_5_1.setForeground(new Color(128, 0, 0));
							lblNewLabel_5_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_5_1.setBounds(46, 82, 196, 26);
							panel_ogr_bil.add(lblNewLabel_5_1);
							
							JLabel lblNewLabel_5_2 = new JLabel("- Ders Bilgilerim :");
							lblNewLabel_5_2.setForeground(new Color(128, 0, 0));
							lblNewLabel_5_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_5_2.setBounds(46, 276, 196, 26);
							panel_ogr_bil.add(lblNewLabel_5_2);
							
							JLabel O_no_1 = new JLabel("45131212");
							O_no_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							O_no_1.setBounds(231, 40, 196, 26);
							panel_ogr_bil.add(O_no_1);
							
							JLabel O_ad = new JLabel("Oktay Ateş");
							O_ad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							O_ad.setBounds(231, 82, 196, 26);
							panel_ogr_bil.add(O_ad);
							
							JLabel lblNewLabel_5_1_1 = new JLabel("- İlgi Alanları :");
							lblNewLabel_5_1_1.setForeground(new Color(128, 0, 0));
							lblNewLabel_5_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_5_1_1.setBounds(46, 129, 196, 26);
							panel_ogr_bil.add(lblNewLabel_5_1_1);
							
							JLabel O_ilgialan = new JLabel("45131212");
							O_ilgialan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							O_ilgialan.setBounds(231, 129, 196, 26);
							panel_ogr_bil.add(O_ilgialan);
							
							JLabel O_anlasmasyaisi = new JLabel("45131212");
							O_anlasmasyaisi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							O_anlasmasyaisi.setBounds(231, 181, 196, 26);
							panel_ogr_bil.add(O_anlasmasyaisi);
							
							JLabel lblNewLabel_5_1_1_1 = new JLabel("- Anlaşma Sayısı :");
							lblNewLabel_5_1_1_1.setForeground(new Color(128, 0, 0));
							lblNewLabel_5_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_5_1_1_1.setBounds(46, 181, 196, 26);
							panel_ogr_bil.add(lblNewLabel_5_1_1_1);
							
							JLabel lblNewLabel_5_1_1_1_1 = new JLabel("- AGNO :");
							lblNewLabel_5_1_1_1_1.setForeground(new Color(128, 0, 0));
							lblNewLabel_5_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_5_1_1_1_1.setBounds(46, 221, 196, 26);
							panel_ogr_bil.add(lblNewLabel_5_1_1_1_1);
							
							JLabel O_Agno_1 = new JLabel("45131212");
							O_Agno_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							O_Agno_1.setBounds(231, 221, 196, 26);
							panel_ogr_bil.add(O_Agno_1);
							
							JScrollBar scrollBar = new JScrollBar();
							scrollBar.setBounds(659, 451, -63, 48);
							panel_ogr_bil.add(scrollBar);
							
							JScrollBar scrollBar_1 = new JScrollBar();
							scrollBar_1.setBounds(1168, 221, 17, 48);
							panel_ogr_bil.add(scrollBar_1);
							
							table_1 = new JTable();
							
							table_1.setBounds(46, 323, 916, 176);
							panel_ogr_bil.add(table_1);
							panel_ogr_bil.setVisible(false);
							
							JPanel panel_ogr_msj = new JPanel();
							panel_ogr_msj.setBackground(new Color(255, 255, 0));
							panel_ogr_msj.setBounds(0, 26, 1195, 687);
							ogrenci_1.add(panel_ogr_msj);
							panel_ogr_msj.setLayout(null);
							
							JLabel lblNewLabel_4_5 = new JLabel("- Gönderilecek Hoca :");
							lblNewLabel_4_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_4_5.setBounds(53, 51, 228, 39);
							panel_ogr_msj.add(lblNewLabel_4_5);
							
							JComboBox comboBox_1 = new JComboBox();
							
							comboboxaHocaKoy(comboBox_1);
							comboBox_1.setBounds(279, 58, 317, 28);
							panel_ogr_msj.add(comboBox_1);
							
							JLabel lblNewLabel_4_1_1 = new JLabel("- Gönderilecek Mesaj :");
							lblNewLabel_4_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_4_1_1.setBounds(53, 112, 228, 39);
							panel_ogr_msj.add(lblNewLabel_4_1_1);
							
							JTextArea textArea_1 = new JTextArea();
							textArea_1.setBounds(279, 112, 510, 173);
							panel_ogr_msj.add(textArea_1);
							
							JButton btnOgren_msj = new JButton("GÖNDER");
							
							btnOgren_msj.setFont(new Font("Times New Roman", Font.PLAIN, 15));
							btnOgren_msj.setBounds(832, 257, 110, 28);
							panel_ogr_msj.add(btnOgren_msj);
							
							JLabel lblNewLabel_4_2_1 = new JLabel("- Gelen Mesajlar :");
							lblNewLabel_4_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_4_2_1.setBounds(53, 341, 194, 39);
							panel_ogr_msj.add(lblNewLabel_4_2_1);
							
							JLabel O_gelen_msj1 = new JLabel("");
							O_gelen_msj1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							O_gelen_msj1.setBounds(53, 390, 902, 39);
							panel_ogr_msj.add(O_gelen_msj1);
							
							JLabel O_gelen_msj2 = new JLabel("");
							O_gelen_msj2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							O_gelen_msj2.setBounds(53, 441, 889, 39);
							panel_ogr_msj.add(O_gelen_msj2);
							
							JLabel O_gelen_msj3 = new JLabel("");
							O_gelen_msj3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							O_gelen_msj3.setBounds(53, 489, 902, 39);
							panel_ogr_msj.add(O_gelen_msj3);
							
							JLabel O_gelen_msj4 = new JLabel("");
							O_gelen_msj4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							O_gelen_msj4.setBounds(53, 547, 902, 39);
							panel_ogr_msj.add(O_gelen_msj4);
							
							JLabel O_gelen_msj5 = new JLabel("");
							O_gelen_msj5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							O_gelen_msj5.setBounds(53, 600, 902, 39);
							panel_ogr_msj.add(O_gelen_msj5);
							
							JButton btnOgren_msj_goster = new JButton("GÖSTER");
							
							btnOgren_msj_goster.setFont(new Font("Times New Roman", Font.PLAIN, 15));
							btnOgren_msj_goster.setBounds(230, 347, 110, 28);
							panel_ogr_msj.add(btnOgren_msj_goster);
							panel_ogr_msj.setVisible(false);
							
							JMenuBar menuBar = new JMenuBar();
							menuBar.setBounds(0, 0, 1195, 28);
							ogrenci_1.add(menuBar);
							
							JMenu mnNewMenu = new JMenu("Ana Sayfa");
							mnNewMenu.setForeground(new Color(0, 0, 0));
							mnNewMenu.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
							mnNewMenu.setFont(new Font("Times New Roman", Font.PLAIN, 22));
							menuBar.add(mnNewMenu);
							
							JMenuItem mnıtmNewMenuItem_3 = new JMenuItem("Anasayfa");
							
							mnNewMenu.add(mnıtmNewMenuItem_3);
							
							JMenu mnNewMenu_1 = new JMenu("Bilgilerim");
							mnNewMenu_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
							mnNewMenu_1.setForeground(new Color(0, 0, 0));
							mnNewMenu_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
							menuBar.add(mnNewMenu_1);
							
							JMenuItem mnıtmNewMenuItem_4 = new JMenuItem("Bilgilerim");
							
							mnNewMenu_1.add(mnıtmNewMenuItem_4);
							
							JMenu mnNewMenu_2 = new JMenu("Ders Seçimi");
							mnNewMenu_2.setForeground(Color.BLACK);
							mnNewMenu_2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
							mnNewMenu_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
							menuBar.add(mnNewMenu_2);
							
							JMenuItem mnıtmNewMenuItem_7 = new JMenuItem("Ders Seçimi");
							
							mnNewMenu_2.add(mnıtmNewMenuItem_7);
							
							JMenu mnIletiim = new JMenu("İletişim");
							mnIletiim.setForeground(Color.BLACK);
							mnIletiim.setFont(new Font("Times New Roman", Font.PLAIN, 22));
							mnIletiim.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
							menuBar.add(mnIletiim);
							
							JMenuItem mnıtmNewMenuItem_2 = new JMenuItem("İletişim");
							
							mnIletiim.add(mnıtmNewMenuItem_2);
							
							
							
							
							
							
							
							
							
							
							
							JPanel panel_ogr_talep = new JPanel();
							panel_ogr_talep.setBackground(new Color(255, 255, 0));
							panel_ogr_talep.setBounds(0, 26, 1195, 687);
							ogrenci_1.add(panel_ogr_talep);
							panel_ogr_talep.setLayout(null);
							
							JLabel ders1 = new JLabel("Ders 1");
							ders1.setVisible(false);
							ders1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							ders1.setBounds(32, 71, 103, 52);
							panel_ogr_talep.add(ders1);
							
							JLabel ders2 = new JLabel("Ders 1");
							ders2.setVisible(false);
							ders2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							ders2.setBounds(32, 133, 103, 52);
							panel_ogr_talep.add(ders2);
							
							JLabel ders3 = new JLabel("Ders 1");
							ders3.setVisible(false);
							ders3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							ders3.setBounds(32, 195, 103, 52);
							panel_ogr_talep.add(ders3);
							
							JLabel ders4 = new JLabel("Ders 1");
							ders4.setVisible(false);
							ders4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							ders4.setBounds(32, 267, 103, 52);
							panel_ogr_talep.add(ders4);
							
							comboBox_ders1 = new JComboBox();
							comboBox_ders1.setModel(new DefaultComboBoxModel(new String[] {"hh"}));
							comboBox_ders1.setVisible(false);
							comboBox_ders1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
							comboBox_ders1.setBounds(262, 88, 145, 21);
							panel_ogr_talep.add(comboBox_ders1);
							
							JComboBox comboBox_ders2 = new JComboBox();
							comboBox_ders2.setVisible(false);
							comboBox_ders2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
							comboBox_ders2.setBounds(262, 150, 145, 21);
							panel_ogr_talep.add(comboBox_ders2);
							
							JComboBox comboBox_ders3 = new JComboBox();
							comboBox_ders3.setVisible(false);
							comboBox_ders3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
							comboBox_ders3.setBounds(262, 212, 145, 21);
							panel_ogr_talep.add(comboBox_ders3);
							
							JComboBox comboBox_ders4 = new JComboBox();
							comboBox_ders4.setVisible(false);
							comboBox_ders4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
							comboBox_ders4.setBounds(262, 284, 145, 21);
							panel_ogr_talep.add(comboBox_ders4);
							
							JButton Ders_onayla = new JButton("Onayla\r\n");
							
							
							Ders_onayla.setFont(new Font("Times New Roman", Font.PLAIN, 15));
							Ders_onayla.setBounds(627, 548, 119, 33);
							panel_ogr_talep.add(Ders_onayla);
							
							JLabel ders5 = new JLabel("Ders 1");
							ders5.setVisible(false);
							ders5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							ders5.setBounds(32, 329, 103, 52);
							panel_ogr_talep.add(ders5);
							
							JLabel ders6 = new JLabel("Ders 1");
							ders6.setVisible(false);
							ders6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							ders6.setBounds(32, 391, 103, 52);
							panel_ogr_talep.add(ders6);
							
							JLabel ders7 = new JLabel("Ders 1");
							ders7.setVisible(false);
							ders7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							ders7.setBounds(32, 463, 103, 52);
							panel_ogr_talep.add(ders7);
							
							JLabel ders8 = new JLabel("Ders 1");
							ders8.setVisible(false);
							ders8.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							ders8.setBounds(32, 537, 103, 52);
							panel_ogr_talep.add(ders8);
							
							JComboBox comboBox_ders5 = new JComboBox();
							comboBox_ders5.setVisible(false);
							comboBox_ders5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
							comboBox_ders5.setBounds(262, 347, 145, 21);
							panel_ogr_talep.add(comboBox_ders5);
							
							JComboBox comboBox_ders6 = new JComboBox();
							comboBox_ders6.setVisible(false);
							comboBox_ders6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
							comboBox_ders6.setBounds(262, 409, 145, 21);
							panel_ogr_talep.add(comboBox_ders6);
							
							JComboBox comboBox_ders7 = new JComboBox();
							comboBox_ders7.setVisible(false);
							comboBox_ders7.setFont(new Font("Times New Roman", Font.PLAIN, 15));
							comboBox_ders7.setBounds(262, 481, 145, 21);
							panel_ogr_talep.add(comboBox_ders7);
							
							JComboBox comboBox_ders8 = new JComboBox();
							comboBox_ders8.setVisible(false);
							comboBox_ders8.setFont(new Font("Times New Roman", Font.PLAIN, 15));
							comboBox_ders8.setBounds(262, 555, 145, 21);
							panel_ogr_talep.add(comboBox_ders8);
							
							JPanel panel_ogr_ana = new JPanel();
							panel_ogr_ana.setBackground(new Color(255, 255, 0));
							panel_ogr_ana.setBounds(0, 26, 1195, 687);
							ogrenci_1.add(panel_ogr_ana);
							panel_ogr_ana.setLayout(null);
							
							JButton btnNewButton3 = new JButton("GERİ");
							
							btnNewButton3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
							btnNewButton3.setBounds(10, 633, 127, 44);
							panel_ogr_ana.add(btnNewButton3);
							
							JButton btnNewButton = new JButton("Onayla");
							
							
							btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							btnNewButton.setBounds(749, 72, 146, 33);
							panel_ogr_ana.add(btnNewButton);
							
							JLabel lblNewLabel_2 = new JLabel("Transkript Yükle/Güncelle : ");
							lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_2.setBounds(43, 66, 237, 44);
							panel_ogr_ana.add(lblNewLabel_2);
							
							textField_7 = new JTextField();
							textField_7.setBounds(290, 72, 406, 28);
							panel_ogr_ana.add(textField_7);
							textField_7.setColumns(10);
							
							btnNewButton3.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									panel.setVisible(true);
									ogrenci_1.setVisible(false);
								}
							});
							panel_ogr_talep.setVisible(false);
							
							
							
							
							
							
							
							
							
							
	
							btnOgren_msj.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									String gonderen_no = "0";
									// öğrenciye Hocanın göndereceği mesaj
									String mesaj = textArea_1.getText();
								    
								    
									int alici_no = Integer.valueOf((String) comboBox_1.getSelectedItem());
									try {
										Statement st = con.createStatement();
										String query = "INSERT INTO mesajlar VALUES('"+J.no+"',"+alici_no+","+"'"+mesaj+"')";
										System.out.println(query);
										st.executeUpdate(query);
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									
									
									
								}
							});
							
							
							btnOgren_msj_goster.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									//Öğrenciye Gelen mesajlar
									JLabel lbl[]= new JLabel[] {O_gelen_msj1,O_gelen_msj2,O_gelen_msj3,O_gelen_msj4,O_gelen_msj5};
									
										try {
											Statement st = con.createStatement();
											String query = "SELECT mesaj,gönderen_no FROM mesajlar WHERE alıcı_no='"+J.no+"';";
											System.out.println(query);
											ResultSet set =st.executeQuery(query);
											
											int i=0;
											while (set.next()) {
												lbl[i].setVisible(true);
												lbl[i].setText(set.getString(2)+" Nolu Hocadan Mesaj: " +set.getString(1));
												i++;
												
											}
											
											
											
											} catch (SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
									
									
									
									
								}
							});
							
							
							
							
								
								ogrenci_1.setVisible(false);
								
								
								mnıtmNewMenuItem_3.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										panel_ogr_ana.setVisible(true);
										panel_ogr_msj.setVisible(false);
										panel_ogr_bil.setVisible(false);
										panel_ogr_talep.setVisible(false);
									}
								});
								
								mnıtmNewMenuItem_2.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										panel_ogr_ana.setVisible(false);
										panel_ogr_msj.setVisible(true);
										panel_ogr_bil.setVisible(false);
										panel_ogr_talep.setVisible(false);
									}
								});
								
								mnıtmNewMenuItem_4.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										panel_ogr_ana.setVisible(false);
										panel_ogr_bil.setVisible(true);
										panel_ogr_talep.setVisible(false);
										panel_ogr_msj.setVisible(false);
									}
								});
								
								
								mnıtmNewMenuItem_7.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										panel_ogr_ana.setVisible(false);
										panel_ogr_bil.setVisible(false);
										panel_ogr_msj.setVisible(false);
										panel_ogr_talep.setVisible(true);
										
									}
								});
							
							JLabel dersisimleri[]= new JLabel[] {ders1,ders2,ders3,ders4,ders5,ders6,ders7,ders8};
							
							JPanel hoca = new JPanel();
							hoca.setBackground(Color.YELLOW);
							hoca.setBounds(0, 0, 1195, 713);
							contentPane.add(hoca);
							hoca.setVisible(false);
							hoca.setLayout(null);
							
							JPanel panel_hoca_ana = new JPanel();
							panel_hoca_ana.setBackground(new Color(255, 255, 0));
							panel_hoca_ana.setBounds(0, 26, 1195, 687);
							hoca.add(panel_hoca_ana);
							panel_hoca_ana.setLayout(null);
							
							JPanel panel_talep = new JPanel();
							panel_talep.setBounds(34, 358, 1110, 272);
							panel_hoca_ana.add(panel_talep);
							panel_talep.setLayout(null);
							panel_talep.setVisible(false);
							
							JLabel lblNewLabel_2_1_6_5 = new JLabel("-- Öğrenci Bilgileri -- ");
							lblNewLabel_2_1_6_5.setForeground(new Color(255, 0, 0));
							lblNewLabel_2_1_6_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_2_1_6_5.setBounds(452, 10, 176, 33);
							panel_talep.add(lblNewLabel_2_1_6_5);
							
							JLabel lblNewLabel_2_1_6_6 = new JLabel("- Okul Numarası : ");
							lblNewLabel_2_1_6_6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
							lblNewLabel_2_1_6_6.setBounds(22, 54, 154, 44);
							panel_talep.add(lblNewLabel_2_1_6_6);
							
							JLabel lblNewLabel_2_1_6_7 = new JLabel("- İsim/Soyisim : ");
							lblNewLabel_2_1_6_7.setFont(new Font("Times New Roman", Font.PLAIN, 18));
							lblNewLabel_2_1_6_7.setBounds(22, 95, 134, 44);
							panel_talep.add(lblNewLabel_2_1_6_7);
							
							JLabel lblNewLabel_2_1_6_6_1 = new JLabel("- Ders Talep Bilgisi : ");
							lblNewLabel_2_1_6_6_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
							lblNewLabel_2_1_6_6_1.setBounds(22, 160, 167, 44);
							panel_talep.add(lblNewLabel_2_1_6_6_1);
							
							JLabel O_numara = new JLabel("New label");
							O_numara.setFont(new Font("Times New Roman", Font.PLAIN, 18));
							O_numara.setBounds(166, 54, 224, 44);
							panel_talep.add(O_numara);
							
							JLabel O_ads = new JLabel("New label");
							O_ads.setFont(new Font("Times New Roman", Font.PLAIN, 18));
							O_ads.setBounds(166, 95, 224, 44);
							panel_talep.add(O_ads);
							
							JLabel lbl_isim = new JLabel("Buğra Oktay Ateş");
							lbl_isim.setFont(new Font("Times New Roman", Font.PLAIN, 18));
							lbl_isim.setBounds(191, 160, 141, 44);
							panel_talep.add(lbl_isim);
							
							JButton btntaleponayla = new JButton("ONAYLA");
							
							btntaleponayla.setFont(new Font("Times New Roman", Font.PLAIN, 15));
							btntaleponayla.setBounds(786, 167, 103, 33);
							panel_talep.add(btntaleponayla);
							
							JButton btnNewButton_2_1 = new JButton("REDDET");
							btnNewButton_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
							btnNewButton_2_1.setBounds(899, 167, 103, 33);
							panel_talep.add(btnNewButton_2_1);
							
							JButton btnNewButton_2_3 = new JButton(" Öğrenciye Bu Dersi Alması İçin Talep Gönder  ");
							btnNewButton_2_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							btnNewButton_2_3.setBounds(201, 214, 480, 33);
							panel_talep.add(btnNewButton_2_3);
							
							JComboBox comboBox_2 = new JComboBox();
							comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Ders A", "Ders B"}));
							comboBox_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							comboBox_2.setBounds(22, 214, 167, 33);
							panel_talep.add(comboBox_2);
							
							JLabel lblNewLabel_3_1_1_1 = new JLabel("sizden                                           dersini istiyor.");
							lblNewLabel_3_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
							lblNewLabel_3_1_1_1.setBounds(330, 160, 386, 44);
							panel_talep.add(lblNewLabel_3_1_1_1);
							
							JComboBox comboBox_hocanındersleri = new JComboBox();
							comboBox_hocanındersleri.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							comboBox_hocanındersleri.setBounds(383, 166, 208, 34);
							panel_talep.add(comboBox_hocanındersleri);
							
							
							
							
							
							
							JButton btnNewButton2_1 = new JButton("GERİ");
							
							btnNewButton2_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
							btnNewButton2_1.setBounds(22, 633, 127, 44);
							panel_hoca_ana.add(btnNewButton2_1);
							
							JLabel lblNewLabel_2_1_6_8 = new JLabel("- İlgi Alanları Ekle/Güncelle : ");
							lblNewLabel_2_1_6_8.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_2_1_6_8.setBounds(37, 53, 252, 44);
							panel_hoca_ana.add(lblNewLabel_2_1_6_8);
							
							textField_9 = new JTextField();
							textField_9.setColumns(10);
							textField_9.setBounds(372, 61, 208, 34);
							panel_hoca_ana.add(textField_9);
							
							JComboBox comboBox_ders_talebi_ogrenciler = new JComboBox();
							comboBox_ders_talebi_ogrenciler.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							comboBox_ders_talebi_ogrenciler.setBounds(372, 286, 208, 34);
							panel_hoca_ana.add(comboBox_ders_talebi_ogrenciler);
							
							JLabel lblNewLabel_2_1_6_1_1 = new JLabel("- Ders Talebinde Bulunan Öğrenciler : ");
							lblNewLabel_2_1_6_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_2_1_6_1_1.setBounds(35, 281, 328, 44);
							panel_hoca_ana.add(lblNewLabel_2_1_6_1_1);
							
							JLabel lblNewLabel_2_1_6_2_1 = new JLabel("- Tüm Öğrenciler : ");
							lblNewLabel_2_1_6_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_2_1_6_2_1.setBounds(37, 224, 252, 44);
							panel_hoca_ana.add(lblNewLabel_2_1_6_2_1);
							
							JComboBox comboBox_1_1 = new JComboBox();
							
							comboBox_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							comboBox_1_1.setBounds(372, 229, 208, 34);
							panel_hoca_ana.add(comboBox_1_1);
							
							JLabel lblNewLabel_2_1_6_3_1 = new JLabel("- Öğrenci Puanlama Dersleri  : ");
							lblNewLabel_2_1_6_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_2_1_6_3_1.setBounds(37, 107, 252, 44);
							panel_hoca_ana.add(lblNewLabel_2_1_6_3_1);
							
							JLabel lblNewLabel_2_1_6_4_1 = new JLabel("- Öğrenci Puanlama Katsayıları : ");
							lblNewLabel_2_1_6_4_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_2_1_6_4_1.setBounds(37, 161, 273, 44);
							panel_hoca_ana.add(lblNewLabel_2_1_6_4_1);
							
							textField_10 = new JTextField();
							textField_10.setColumns(10);
							textField_10.setBounds(372, 169, 208, 34);
							panel_hoca_ana.add(textField_10);
							
							textField_11 = new JTextField();
							textField_11.setColumns(10);
							textField_11.setBounds(372, 115, 208, 34);
							panel_hoca_ana.add(textField_11);
							
							JButton btnNewButton_2_2_5 = new JButton("ONAYLA");
							btnNewButton_2_2_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
							btnNewButton_2_2_5.setBounds(625, 63, 103, 34);
							panel_hoca_ana.add(btnNewButton_2_2_5);
							
							JButton btnNewButton_2_2_6 = new JButton("ONAYLA");
							btnNewButton_2_2_6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
							btnNewButton_2_2_6.setBounds(625, 117, 103, 34);
							panel_hoca_ana.add(btnNewButton_2_2_6);
							
							JButton btnNewButton_2_2_7 = new JButton("ONAYLA");
							btnNewButton_2_2_7.setFont(new Font("Times New Roman", Font.PLAIN, 15));
							btnNewButton_2_2_7.setBounds(625, 167, 103, 34);
							panel_hoca_ana.add(btnNewButton_2_2_7);
							
							JButton btnNewButton_2_2_8 = new JButton("SEÇ");
							
							btnNewButton_2_2_8.setFont(new Font("Times New Roman", Font.PLAIN, 15));
							btnNewButton_2_2_8.setBounds(625, 230, 103, 34);
							panel_hoca_ana.add(btnNewButton_2_2_8);
							
							JButton Taleplerigosterhoca = new JButton("SEÇ");
							
							Taleplerigosterhoca.setFont(new Font("Times New Roman", Font.PLAIN, 15));
							Taleplerigosterhoca.setBounds(625, 287, 103, 34);
							panel_hoca_ana.add(Taleplerigosterhoca);
							
							btnNewButton2_1.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									hoca.setVisible(false);
									panel.setVisible(true);
									panel_talep.setVisible(false);
								}
							});
							
							btnNewButton_2_2_8.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									
									panel_talep.setVisible(true);
								}
							});
							
							JPanel panel_hoca_msj = new JPanel();
							panel_hoca_msj.setBackground(new Color(255, 255, 0));
							panel_hoca_msj.setBounds(0, 26, 1195, 687);
							hoca.add(panel_hoca_msj);
							panel_hoca_msj.setLayout(null);
							
							JLabel lblNewLabel_4 = new JLabel("- Gönderilecek Öğrenci :");
							lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_4.setBounds(52, 49, 228, 39);
							panel_hoca_msj.add(lblNewLabel_4);
							
							JComboBox comboBox = new JComboBox();
							comboBox.setBounds(280, 56, 317, 28);
							panel_hoca_msj.add(comboBox);
							comboboxaOgrenciKoy(comboBox);
							
							JLabel lblNewLabel_4_1 = new JLabel("- Gönderilecek Mesaj :");
							lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_4_1.setBounds(52, 113, 228, 39);
							panel_hoca_msj.add(lblNewLabel_4_1);
							
							JTextArea textArea = new JTextArea();
							textArea.setBounds(280, 113, 508, 171);
							panel_hoca_msj.add(textArea);
							
							JButton btnHoca_msj = new JButton("GÖNDER");
							
							btnHoca_msj.setFont(new Font("Times New Roman", Font.PLAIN, 15));
							btnHoca_msj.setBounds(832, 256, 110, 28);
							panel_hoca_msj.add(btnHoca_msj);
							
							JLabel lblNewLabel_4_2 = new JLabel("- Gelen Mesajlar :");
							lblNewLabel_4_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_4_2.setBounds(52, 340, 194, 39);
							panel_hoca_msj.add(lblNewLabel_4_2);
							
							JLabel H_gelen_msj1 = new JLabel("");
							H_gelen_msj1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							H_gelen_msj1.setBounds(52, 389, 901, 39);
							panel_hoca_msj.add(H_gelen_msj1);
							
							JLabel H_gelen_msj2 = new JLabel("");
							H_gelen_msj2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							H_gelen_msj2.setBounds(52, 438, 901, 39);
							panel_hoca_msj.add(H_gelen_msj2);
							
							JLabel H_gelen_msj3 = new JLabel("");
							H_gelen_msj3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							H_gelen_msj3.setBounds(52, 478, 901, 39);
							panel_hoca_msj.add(H_gelen_msj3);
							
							JLabel H_gelen_msj4 = new JLabel("");
							H_gelen_msj4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							H_gelen_msj4.setBounds(52, 527, 901, 39);
							panel_hoca_msj.add(H_gelen_msj4);
							
							JLabel H_gelen_msj5 = new JLabel("");
							H_gelen_msj5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							H_gelen_msj5.setBounds(52, 576, 901, 39);
							panel_hoca_msj.add(H_gelen_msj5);
							
							JButton btnHoca_msj_goster = new JButton("GÖSTER");
							
							btnHoca_msj_goster.setFont(new Font("Times New Roman", Font.PLAIN, 15));
							btnHoca_msj_goster.setBounds(240, 346, 110, 28);
							panel_hoca_msj.add(btnHoca_msj_goster);
							panel_hoca_msj.setVisible(false);
							
							JMenuBar menuBar_2 = new JMenuBar();
							menuBar_2.setBounds(0, 0, 1195, 28);
							hoca.add(menuBar_2);
							
							JMenu mnNewMenu_4 = new JMenu("Ana Sayfa");
							mnNewMenu_4.setForeground(Color.BLACK);
							mnNewMenu_4.setFont(new Font("Times New Roman", Font.PLAIN, 22));
							mnNewMenu_4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
							menuBar_2.add(mnNewMenu_4);
							
							JMenuItem mnıtmNewMenuItem_1 = new JMenuItem("Ana Menü");
							mnıtmNewMenuItem_1.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									panel_hoca_ana.setVisible(true);
									panel_hoca_msj.setVisible(false);
								}
							});
							mnNewMenu_4.add(mnıtmNewMenuItem_1);
							
							JMenu mnIletiim_2 = new JMenu("İletişim");
							
							
							mnIletiim_2.setForeground(Color.BLACK);
							mnIletiim_2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
							mnIletiim_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
							menuBar_2.add(mnIletiim_2);
							
							JMenuItem mnıtmNewMenuItem = new JMenuItem("İletişim");
							mnıtmNewMenuItem.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									panel_hoca_ana.setVisible(false);
									panel_hoca_msj.setVisible(true);
									
								}
							});
							mnIletiim_2.add(mnıtmNewMenuItem);
							
							
							
							
							
							
							
							
							JPanel yonetici = new JPanel();
							yonetici.setBackground(Color.ORANGE);
							yonetici.setBounds(0, 0, 1195, 713);
							contentPane.add(yonetici);
							yonetici.setLayout(null);
							
							
							
							yonetici.setVisible(false);
							
							JPanel panel_yonetici_ana = new JPanel();
							panel_yonetici_ana.setBackground(new Color(255, 255, 0));
							panel_yonetici_ana.setBounds(0, 26, 1195, 687);
							yonetici.add(panel_yonetici_ana);
							panel_yonetici_ana.setLayout(null);
							
							JButton btnNewButton1 = new JButton("GERİ");
							
							btnNewButton1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
							btnNewButton1.setBounds(10, 633, 127, 44);
							panel_yonetici_ana.add(btnNewButton1);
							
							JLabel lblNewLabel_2_1 = new JLabel("- Öğrencinin bir ders için talep oluşturma sayısı : ");
							lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_2_1.setBounds(23, 38, 399, 44);
							panel_yonetici_ana.add(lblNewLabel_2_1);
							
							textField_2 = new JTextField();
							textField_2.setColumns(10);
							textField_2.setBounds(432, 53, 96, 19);
							panel_yonetici_ana.add(textField_2);
							
							JLabel lblNewLabel_2_1_1 = new JLabel("- Mesajlaşmadaki toplam karakter sayısı : ");
							lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_2_1_1.setBounds(23, 92, 399, 44);
							panel_yonetici_ana.add(lblNewLabel_2_1_1);
							
							textField_3 = new JTextField();
							textField_3.setColumns(10);
							textField_3.setBounds(432, 107, 96, 19);
							panel_yonetici_ana.add(textField_3);
							
							JLabel lblNewLabel_2_1_2 = new JLabel("- Bir hocanın toplam kontenjan sayısı : ");
							lblNewLabel_2_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_2_1_2.setBounds(23, 152, 399, 44);
							panel_yonetici_ana.add(lblNewLabel_2_1_2);
							
							textField_4 = new JTextField();
							textField_4.setColumns(10);
							textField_4.setBounds(432, 167, 96, 19);
							panel_yonetici_ana.add(textField_4);
							
							JLabel lblNewLabel_2_1_3 = new JLabel("- Ders seçim süresi : ");
							lblNewLabel_2_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_2_1_3.setBounds(23, 206, 399, 44);
							panel_yonetici_ana.add(lblNewLabel_2_1_3);
							
							textField_5 = new JTextField();
							textField_5.setColumns(10);
							textField_5.setBounds(432, 221, 96, 19);
							panel_yonetici_ana.add(textField_5);
							
							JLabel lblNewLabel_2_1_4 = new JLabel("- 2. Aşama Atama İşlemleri : ");
							lblNewLabel_2_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_2_1_4.setBounds(23, 351, 399, 44);
							panel_yonetici_ana.add(lblNewLabel_2_1_4);
							
							JButton btnrasgele_at = new JButton("Rastgele Atama");
							btnrasgele_at.setFont(new Font("Times New Roman", Font.PLAIN, 15));
							btnrasgele_at.setEnabled(false);
							btnrasgele_at.setBounds(43, 405, 242, 35);
							panel_yonetici_ana.add(btnrasgele_at);
							
							JButton btnnota_gore_at = new JButton("Not Ortalamasına Göre Atama");
							btnnota_gore_at.setFont(new Font("Times New Roman", Font.PLAIN, 15));
							btnnota_gore_at.setEnabled(false);
							btnnota_gore_at.setBounds(43, 460, 242, 35);
							panel_yonetici_ana.add(btnnota_gore_at);
							
							JButton btnbelirli_dersler_at = new JButton("Belirli Derslere Göre Atama");
							btnbelirli_dersler_at.setFont(new Font("Times New Roman", Font.PLAIN, 15));
							btnbelirli_dersler_at.setEnabled(false);
							btnbelirli_dersler_at.setBounds(43, 514, 242, 35);
							panel_yonetici_ana.add(btnbelirli_dersler_at);
							
							JLabel lblNewLabel_2_1_5 = new JLabel("- Ögrenci birden fazla dersi sadece tek bir hocadan alabilir : ");
							lblNewLabel_2_1_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_2_1_5.setBounds(23, 260, 488, 44);
							panel_yonetici_ana.add(lblNewLabel_2_1_5);
							
							JCheckBox chckbxNewCheckBox = new JCheckBox("");
							chckbxNewCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							chckbxNewCheckBox.setBounds(524, 260, 21, 35);
							panel_yonetici_ana.add(chckbxNewCheckBox);
							
							JButton btnNewButton_2 = new JButton("Onayla");
							
							btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
							btnNewButton_2.setBounds(590, 220, 85, 21);
							panel_yonetici_ana.add(btnNewButton_2);
							
							
							
							btnNewButton1.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									yonetici.setVisible(false);
									panel.setVisible(true);
								}
							});
							
							JPanel panel_yonetici_ekle = new JPanel();
							panel_yonetici_ekle.setBackground(new Color(255, 255, 0));
							panel_yonetici_ekle.setBounds(0, 26, 1195, 687);
							yonetici.add(panel_yonetici_ekle);
							panel_yonetici_ekle.setLayout(null);
							
							JLabel lblNewLabel_6 = new JLabel("Adet Öğrenci Ekle");
							lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_6.setBounds(183, 510, 183, 38);
							panel_yonetici_ekle.add(lblNewLabel_6);
							
							JLabel lblNewLabel_6_1 = new JLabel("No lu Öğrenciyi Sil");
							lblNewLabel_6_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_6_1.setBounds(163, 454, 183, 38);
							panel_yonetici_ekle.add(lblNewLabel_6_1);
							
							textField_6 = new JTextField();
							textField_6.setBounds(36, 522, 117, 19);
							panel_yonetici_ekle.add(textField_6);
							textField_6.setColumns(10);
							
							O_sil = new JTextField();
							O_sil.setColumns(10);
							O_sil.setBounds(36, 466, 117, 19);
							panel_yonetici_ekle.add(O_sil);
							
							JButton btnNewButton_4 = new JButton("Ekle");
							btnNewButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
							btnNewButton_4.setBounds(344, 514, 91, 32);
							panel_yonetici_ekle.add(btnNewButton_4);
							
							JButton Ogrenci_sil = new JButton("Sil");
							
							Ogrenci_sil.setFont(new Font("Times New Roman", Font.PLAIN, 15));
							Ogrenci_sil.setBounds(344, 458, 91, 32);
							panel_yonetici_ekle.add(Ogrenci_sil);
							
							JLabel lblNewLabel_6_2 = new JLabel("- Öğrenci No :");
							lblNewLabel_6_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_6_2.setBounds(36, 47, 183, 38);
							panel_yonetici_ekle.add(lblNewLabel_6_2);
							
							JLabel lblNewLabel_6_3 = new JLabel("- Ad/Soyad :");
							lblNewLabel_6_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_6_3.setBounds(36, 103, 183, 38);
							panel_yonetici_ekle.add(lblNewLabel_6_3);
							
							JLabel lblNewLabel_6_4 = new JLabel("- İlgi Alanları :");
							lblNewLabel_6_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_6_4.setBounds(36, 170, 183, 38);
							panel_yonetici_ekle.add(lblNewLabel_6_4);
							
							JLabel lblNewLabel_6_5 = new JLabel("- Anlaşma Sayısı:");
							lblNewLabel_6_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_6_5.setBounds(36, 228, 183, 38);
							panel_yonetici_ekle.add(lblNewLabel_6_5);
							
							JLabel lblNewLabel_6_6 = new JLabel("- AGNO :");
							lblNewLabel_6_6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_6_6.setBounds(36, 290, 183, 38);
							panel_yonetici_ekle.add(lblNewLabel_6_6);
							
							O_no = new JTextField();
							O_no.setColumns(10);
							O_no.setBounds(249, 59, 117, 19);
							panel_yonetici_ekle.add(O_no);
							
							O_Ad = new JTextField();
							O_Ad.setColumns(10);
							O_Ad.setBounds(249, 115, 117, 19);
							panel_yonetici_ekle.add(O_Ad);
							
							O_ilgi = new JTextField();
							O_ilgi.setColumns(10);
							O_ilgi.setBounds(249, 182, 117, 19);
							panel_yonetici_ekle.add(O_ilgi);
							
							O_anlasma = new JTextField();
							O_anlasma.setColumns(10);
							O_anlasma.setBounds(249, 240, 117, 19);
							panel_yonetici_ekle.add(O_anlasma);
							
							O_Agno = new JTextField();
							O_Agno.setColumns(10);
							O_Agno.setBounds(249, 302, 117, 19);
							panel_yonetici_ekle.add(O_Agno);
							
							JLabel lblNewLabel_6_2_1 = new JLabel("- Sicil No :");
							lblNewLabel_6_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_6_2_1.setBounds(578, 47, 183, 38);
							panel_yonetici_ekle.add(lblNewLabel_6_2_1);
							
							JLabel lblNewLabel_6_2_2 = new JLabel("- Ad/Soyad :");
							lblNewLabel_6_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_6_2_2.setBounds(578, 118, 183, 38);
							panel_yonetici_ekle.add(lblNewLabel_6_2_2);
							
							JLabel lblNewLabel_6_2_3 = new JLabel("- Kontenjan :");
							lblNewLabel_6_2_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_6_2_3.setBounds(578, 182, 183, 38);
							panel_yonetici_ekle.add(lblNewLabel_6_2_3);
							
							JLabel lblNewLabel_6_2_4 = new JLabel("- Kriter Dersler :");
							lblNewLabel_6_2_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_6_2_4.setBounds(578, 243, 183, 38);
							panel_yonetici_ekle.add(lblNewLabel_6_2_4);
							
							H_sicil = new JTextField();
							H_sicil.setColumns(10);
							H_sicil.setBounds(723, 59, 117, 19);
							panel_yonetici_ekle.add(H_sicil);
							
							H_ad = new JTextField();
							H_ad.setColumns(10);
							H_ad.setBounds(723, 130, 117, 19);
							panel_yonetici_ekle.add(H_ad);
							
							H_kontenjan = new JTextField();
							H_kontenjan.setColumns(10);
							H_kontenjan.setBounds(723, 189, 117, 19);
							panel_yonetici_ekle.add(H_kontenjan);
							
							H_Kriterders = new JTextField();
							H_Kriterders.setColumns(10);
							H_Kriterders.setBounds(723, 255, 117, 19);
							panel_yonetici_ekle.add(H_Kriterders);
							
							JButton Hoca_Ekle = new JButton("Onayla");
							
							Hoca_Ekle.setFont(new Font("Times New Roman", Font.PLAIN, 15));
							Hoca_Ekle.setBounds(928, 294, 91, 32);
							panel_yonetici_ekle.add(Hoca_Ekle);
							
							JButton Ogrenci_Ekle = new JButton("Onayla");
							
							Ogrenci_Ekle.setFont(new Font("Times New Roman", Font.PLAIN, 15));
							Ogrenci_Ekle.setBounds(423, 294, 91, 32);
							panel_yonetici_ekle.add(Ogrenci_Ekle);
							
							H_sil = new JTextField();
							H_sil.setColumns(10);
							H_sil.setBounds(603, 466, 117, 19);
							panel_yonetici_ekle.add(H_sil);
							
							JLabel lblNewLabel_6_1_1 = new JLabel("No lu Hocayı Sil");
							lblNewLabel_6_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_6_1_1.setBounds(753, 454, 183, 38);
							panel_yonetici_ekle.add(lblNewLabel_6_1_1);
							
							JButton Hoca_Sil = new JButton("Sil");
							
							Hoca_Sil.setFont(new Font("Times New Roman", Font.PLAIN, 15));
							Hoca_Sil.setBounds(928, 453, 91, 32);
							panel_yonetici_ekle.add(Hoca_Sil);
							panel_yonetici_ekle.setVisible(false);
							
							JPanel panel_yonetici_talep = new JPanel();
							panel_yonetici_talep.setBackground(Color.RED);
							panel_yonetici_talep.setBounds(0, 26, 1195, 687);
							yonetici.add(panel_yonetici_talep);
							panel_yonetici_talep.setLayout(null);
							
							JLabel lblNewLabel_7 = new JLabel("Hoca-Öğrenci Talep Geçmişi");
							lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_7.setBounds(38, 302, 261, 52);
							panel_yonetici_talep.add(lblNewLabel_7);
							
							JLabel lblNewLabel_7_1 = new JLabel("No lu  Öğrenciye");
							lblNewLabel_7_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_7_1.setBounds(164, 65, 155, 39);
							panel_yonetici_talep.add(lblNewLabel_7_1);
							
							JLabel lblNewLabel_7_1_1 = new JLabel("No lu Hocadan Ders Ver");
							lblNewLabel_7_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
							lblNewLabel_7_1_1.setBounds(449, 65, 210, 39);
							panel_yonetici_talep.add(lblNewLabel_7_1_1);
							
							textField_8 = new JTextField();
							textField_8.setBounds(38, 77, 116, 19);
							panel_yonetici_talep.add(textField_8);
							textField_8.setColumns(10);
							
							textField_12 = new JTextField();
							textField_12.setColumns(10);
							textField_12.setBounds(323, 77, 116, 19);
							panel_yonetici_talep.add(textField_12);
							
							JButton btnNewButton_5 = new JButton("Onayla\r\n");
							btnNewButton_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
							btnNewButton_5.setBounds(701, 66, 97, 39);
							panel_yonetici_talep.add(btnNewButton_5);
							
							table = new JTable();
							table.setModel(new DefaultTableModel(
								new Object[][] {
									{null, null, null, null},
									{null, null, null, null},
									{null, null, null, null},
									{null, null, null, null},
								},
								new String[] {
									"New column", "New column", "New column", "New column"
								}
							));
							table.setBounds(90, 384, 882, 244);
							panel_yonetici_talep.add(table);
							panel_yonetici_talep.setVisible(false);
							
							JMenuBar menuBar_1 = new JMenuBar();
							menuBar_1.setBounds(0, 0, 1195, 28);
							yonetici.add(menuBar_1);
							
							JMenu mnNewMenu_3 = new JMenu("Ana Sayfa");
							mnNewMenu_3.setForeground(Color.BLACK);
							mnNewMenu_3.setFont(new Font("Times New Roman", Font.PLAIN, 22));
							mnNewMenu_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
							menuBar_1.add(mnNewMenu_3);
							
							JMenuItem mnıtmNewMenuItem_5 = new JMenuItem("Ana Sayfa");
							
							mnNewMenu_3.add(mnıtmNewMenuItem_5);
							
							JMenu mnNewMenu_1_1 = new JMenu("Hoca-Öğrenci Talep");
							mnNewMenu_1_1.setForeground(Color.BLACK);
							mnNewMenu_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
							mnNewMenu_1_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
							menuBar_1.add(mnNewMenu_1_1);
							
							JMenuItem mnıtmNewMenuItem_6 = new JMenuItem("Talepler");
							mnıtmNewMenuItem_6.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									panel_yonetici_ana.setVisible(false);
									panel_yonetici_ekle.setVisible(false);
									panel_yonetici_talep.setVisible(true);
								}
							});
							mnNewMenu_1_1.add(mnıtmNewMenuItem_6);
							
							JMenu mnNewMenu_2_1 = new JMenu("Kullanıcı Ekle/Sil");
							mnNewMenu_2_1.setForeground(Color.BLACK);
							mnNewMenu_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
							mnNewMenu_2_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
							menuBar_1.add(mnNewMenu_2_1);
							
							JMenuItem mnıtmNewMenuItem_2_1 = new JMenuItem("Kullanıcı Ekle/Sil");
							mnıtmNewMenuItem_2_1.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									panel_yonetici_ana.setVisible(false);
									panel_yonetici_talep.setVisible(false);
									panel_yonetici_ekle.setVisible(true);
									
								}
							});
							mnNewMenu_2_1.add(mnıtmNewMenuItem_2_1);
							
							
										
										
										
										
										mnıtmNewMenuItem_5.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								panel_yonetici_ana.setVisible(true);
								panel_yonetici_ekle.setVisible(false);
								panel_yonetici_talep.setVisible(false);
								
							}
										});
										
										
										Ogrenci_Ekle.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												String adsoyad = O_Ad.getText();
												String ilgialanlari = O_ilgi.getText();
												String anlasma = O_anlasma.getText();
												String agno = O_Agno.getText();
												String no = O_no.getText();
												String query = "INSERT INTO ogrenciler VALUES("+no+",'"+adsoyad+"',"+"'"+ilgialanlari+"',"+"'"+anlasma+"',"+"'"+agno+"'"+");";
												System.out.println(query);
												try {
													Statement statement = con.createStatement();
													statement.execute(query);
												} catch (SQLException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
												
											}
										});
										
										Hoca_Ekle.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												String adsoyad = H_ad.getText();
												String kontenjan = H_kontenjan.getText();
												String kriterdersler  = H_Kriterders.getText();
												String sicil_no = H_sicil.getText();
												String query = "INSERT INTO hocalar VALUES("+sicil_no+",'"+adsoyad+"',"+kontenjan+",'{"+kriterdersler+"}'"+");";
												System.out.println(query);
												try {
													Statement statement = con.createStatement();
													statement.execute(query);
												} catch (SQLException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
												
												
											}
										});
										
										Hoca_Sil.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												String query = "DELETE FROM hocalar WHERE sicil_no ="+ "'"+H_sil.getText()+"'";
												try {
													Statement statement = con.createStatement();
													statement.executeUpdate(query);
												} catch (SQLException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
												
												
											}
										});
										
										Ogrenci_sil.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												O_sil.getText();
												String query = "DELETE FROM ogrenciler WHERE ogrenci_no ="+ O_sil.getText();
												try {
													Statement statement = con.createStatement();
													statement.executeUpdate(query);
												} catch (SQLException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
											}
										});
										
										
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				saat_goster(lblNewLabel_3,Integer.parseInt(textField_5.getText()),mnıtmNewMenuItem_7,btnrasgele_at,btnbelirli_dersler_at,btnnota_gore_at);
				
				
				
						
					
					}
				});
							
							
													
							btnHoca_msj.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														String gonderen_no = "0";
														//Hocanın öğrenciye göndereceği mesaj
														String mesaj = textArea.getText();
									                     try {
									                    	 J.set.next();
															gonderen_no = J.set.getString(1);
														} catch (SQLException e1) {
															// TODO Auto-generated catch block
															e1.printStackTrace();
														}
									      
														int alici_no = Integer.valueOf((String) comboBox.getSelectedItem());
														try {
															Statement st = con.createStatement();
															String query = "INSERT INTO mesajlar VALUES("+gonderen_no+","+alici_no+","+"'"+mesaj+"')";
															st.executeUpdate(query);
														} catch (SQLException e1) {
															// TODO Auto-generated catch block
															e1.printStackTrace();
														}
													}
							});
							
							btnHoca_msj_goster.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									//Hocaya Gelen mesajlar
									JLabel lbl[]= new JLabel[]{H_gelen_msj1,H_gelen_msj2,H_gelen_msj3,H_gelen_msj4,H_gelen_msj5};
									
									try {
										Statement st = con.createStatement();
										String query = "SELECT mesaj,gönderen_no FROM mesajlar WHERE alıcı_no='"+J.H_no+"';";
										System.out.println(query);
										ResultSet set =st.executeQuery(query);
										
										int i=0;
										while (set.next()) {
											lbl[i].setVisible(true);
											lbl[i].setText(set.getString(2)+" Nolu Öğrenciden Mesaj: " +set.getString(1));
											i++;
											
										}
										
										
										
										} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}

									
								}
							});
							
							
							
							
							
							
							
							
							Taleplerigosterhoca.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									panel_talep.setVisible(true);
									Statement talep;
									String ogrenci= (String) comboBox_ders_talebi_ogrenciler.getSelectedItem();
									String[] dersler = new String[500];
									int i = 0;
									try {
										talep = con.createStatement();
										ResultSet talepler = talep.executeQuery("SELECT talep_ogr_no FROM talepler WHERE talep_hoca_no = '"+J.H_no+"'AND talep_ogr_adsoyad ='"
												+ogrenci +"'");
										 talepler.next();
										 
											lbl_isim.setText(ogrenci);
										    O_ads.setText(ogrenci);
										    O_numara.setText(talepler.getString(1));
										ResultSet ogrencitalep = talep.executeQuery("SELECT talep_edilen_ders FROM talepler WHERE talep_ogr_adsoyad='"+ogrenci+"' AND"
												+ " talep_hoca_no ='"
												+ J.H_no + "'");
										
										   
							            while(ogrencitalep.next()) {
							            	dersler[i++] = ogrencitalep.getString(1);
							            }
										comboBox_hocanındersleri.setModel(new DefaultComboBoxModel(dersler));
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}								
								}
							});
							
							
						
						
							JComboBox hocaisimleri[] = new JComboBox[] {comboBox_ders1,comboBox_ders2,comboBox_ders3,comboBox_ders4,comboBox_ders5,comboBox_ders6,comboBox_ders7,comboBox_ders8};
		
		
		
		ResultSet dersler = null;
		try {
			Statement stt = con.createStatement();
			dersler = stt.executeQuery("SELECT DISTINCT dersin_adi,katsayi FROM dersler");
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			while (dersler.next()) {
				try {
					dersisimleri[J.b].setText(dersler.getString(1));
					J.b++;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			J.b=0;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		for (int i = 0; i < 5; i++) {
		    int k = 0;
			String[] s = new String[15];
			try {
				Statement sttt = con.createStatement();
				ResultSet hocalar = sttt.executeQuery("SELECT dersin_hocasi FROM dersler WHERE dersin_adi = '"+dersisimleri[i].getText()+"'");
				while(hocalar.next()) {
				 s[k++] = hocalar.getString(1);
				}
				
				hocaisimleri[i].setModel(new DefaultComboBoxModel(s));
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		
		btnNewButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(J.Giris_tur=='Y') {
					yonetici.setVisible(true);
					Giris.setVisible(false);
					
				}
				else if(J.Giris_tur=='H') {
					
					hoca.setVisible(true);
					Giris.setVisible(false);
					String id = textField.getText(); //kullanıcı adı
					J.H_no=id;
					try {
						Statement st = con.createStatement();
						J.set = st.executeQuery("SELECT * FROM hocalar WHERE sicil_no ="+"'"+id+"'");
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					///////////////////////////////////////
					
					try {
						Statement talep = con.createStatement();
						ResultSet talepler = talep.executeQuery("SELECT * FROM talepler WHERE talep_hoca_no = '"+J.H_no+"'");
						String[] comboOgr = new String[500]; int i =0;
						while(talepler.next()) {
					
						comboOgr[i++] = talepler.getString(2);
						}
						i=0;
						comboBox_ders_talebi_ogrenciler.setModel(new DefaultComboBoxModel(comboOgr));
					    
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
					
				}
				else if(J.Giris_tur=='O') {
					
					
					ogrenci_1.setVisible(true);
					Giris.setVisible(false);
					String id = textField.getText(); //kullanıcı adı
					J.no=id;
					System.out.println(J.Giris_tur );
					Statement ste;
					try {
						ste = con.createStatement();
						ResultSet b = ste.executeQuery("SELECT adsoyad FROM ogrenciler WHERE ogrenci_no ='"+id+"'");
						b.next();
						J.adsoyad = b.getString(1);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					try {
						Statement st = con.createStatement();
						J.set = st.executeQuery("SELECT * FROM ogrenciler WHERE ogrenci_no ='"+id+"'");
						ResultSet labelInfoResultSet = J.set;
						
						
						while(labelInfoResultSet.next()) {
							O_ad.setText(labelInfoResultSet.getString(2));
							O_ilgialan.setText(labelInfoResultSet.getString(3));
							
							int anlasmaString = labelInfoResultSet.getInt(4);
							O_anlasmasyaisi.setText(String.valueOf(anlasmaString));
							
							O_Agno_1.setText(labelInfoResultSet.getString(5));
							String ogrNo = String.valueOf(labelInfoResultSet.getInt(1));
							O_no_1.setText(ogrNo);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
					try {
						Statement st = con.createStatement();
						ResultSet sayi = st.executeQuery("SELECT COUNT(*) FROM dersler");
						sayi.next();
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					Ders_ekle(dersisimleri, hocaisimleri,8);
					
					
					////////////////////
					DefaultTableModel model = new DefaultTableModel();
			        model.addColumn("Ders Adı");
			        model.addColumn("Dersin Hocası");
			        model.addColumn("Notu");
			        model.addColumn("Harf Notu");
			        model.addRow(new Object[]{"DERS ADI","DERS HOCASI","NOTU","HARF NOTU" });
			        
					try {
						Statement sts = con.createStatement();
						
						ResultSet bilgi = sts.executeQuery("SELECT dersin_adi , dersin_hocasi,alinan_not,harf_notu FROM ogrenci_ders_bilgileri WHERE anlasma_durumu = 'ONAYLANDI' AND ogrenci_no = "+J.no);
						while(bilgi.next()) {
							model.addRow(new Object[]{bilgi.getString(1), bilgi.getString(2), bilgi.getString(3),bilgi.getString(4) });

					        }
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    
			        
			        
			        
			        

			        
					table_1.setModel(model);
					//////////////////////
					
					
					
				}
				else {
					System.out.println("Hata var lo..");
				}
			}
		});
		
		btnNewButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				Giris.setVisible(false);
			}
		});
		
		// Alt panellere geçiş geçiş.
		btnY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				J.Giris_tur='Y';
				panel.setVisible(false);
				Giris.setVisible(true);
				lblNewLabel_1.setText("YÖNETİCİ BİLGİ SİSTEMİ");
			}
		});
		
		btnH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				J.Giris_tur='H';
				panel.setVisible(false);
				Giris.setVisible(true);
				lblNewLabel_1.setText("HOCA BİLGİ SİSTEMİ");
			}
		});
	
		btnO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				J.Giris_tur='O';
				panel.setVisible(false);
				Giris.setVisible(true);
				lblNewLabel_1.setText("ÖĞRENCİ BİLGİ SİSTEMİ");
			}
		});
		
		
		Ders_onayla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Integer> katsyi = new ArrayList<>();
				int HocaNo = 0;
				try {
					Statement katsayilar = con.createStatement();
					ResultSet katSet = katsayilar.executeQuery("SELECT DISTINCT dersin_adi , katsayi FROM dersler");
					while(katSet.next()) {
						katsyi.add(katSet.getInt(2));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				for (int i = 0; i < katsyi.size(); i++) {
					try {
						PreparedStatement st = con.prepareStatement("INSERT INTO ogrenci_ders_bilgileri VALUES("+J.no+",'"+J.adsoyad+"',?,?,?,0,'FF','BEKLEMEDE')");
						st.setString(1, ""+(String) hocaisimleri[i].getSelectedItem()+"");
						st.setString(2,""+dersisimleri[i].getText()+"");
			                st.setInt(3,katsyi.get(i));
						st.executeUpdate();
						Statement W = con.createStatement();
						ResultSet hocano = W.executeQuery("SELECT hoca_no FROM dersler WHERE dersin_adi ='"+dersisimleri[i].getText()+"'AND dersin_hocasi='"+(String) hocaisimleri[i].getSelectedItem()+"'");
						hocano.next(); HocaNo = hocano.getInt(1);
						PreparedStatement talep = con.prepareStatement("INSERT INTO talepler VALUES("+J.no+",'"+J.adsoyad+"',"+HocaNo +",?,?)");
						talep.setString(1, ""+(String) hocaisimleri[i].getSelectedItem()+"");
						talep.setString(2,""+dersisimleri[i].getText()+"");
						talep.executeUpdate();
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
				}
				
				
				
				
			}
			});
		
		
		btntaleponayla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String adsoyad =   lbl_isim.getText();
			    String no =  O_numara.getText();
				String ders =  (String) comboBox_hocanındersleri.getSelectedItem();	
				try {
					Statement dersEkle = con.createStatement();
					dersEkle.executeUpdate("UPDATE ogrenci_ders_bilgileri SET anlasma_durumu = 'ONAYLANDI' WHERE ogrenci_no = "+no+" AND ogrenci_ad_soyad ='"+adsoyad+"'AND dersin_adi"
							+ "='"+ders+"'");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});	
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tableName = "dersler"; // Replace with your table name
              //  InsertOCRtextIntoDB(textField_7.getText(),",",tableName);
			}
		});
		
		
	}
	/*
	public static String InsertOCRtextIntoDB(String filepath, String delimiter, String tableName) {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("tessdata-main"); // Set the path to your Tesseract data directory
        String result = null;
        try {
            String imagePath = "images\\"+filepath; // Replace with the path to your image
            result = tesseract.doOCR(new File(imagePath));
            System.out.println("Recognized Text:\n" + result);
        } catch (TesseractException exp) {
            System.err.println("Error during OCR: " + exp.getMessage());
        }
        String[] lines = result.split("\n");
        String[] headers = lines[0].split(delimiter);
        StringBuilder sqlStatements = new StringBuilder();

        for (int i = 1; i < lines.length; i++) {
            String[] values = lines[i].split(delimiter);

            if (headers.length == values.length) {
                StringBuilder valuesString = new StringBuilder();

                for (int j = 0; j < headers.length; j++) {
                    if (j > 0) {
                        valuesString.append(", ");
                    }
                    if(j>1)
                        valuesString.append(values[j]);
                    else
                        valuesString.append("'" + values[j] + "'");
                }

                String sqlStatement = String.format(
                        "INSERT INTO %s (%s) VALUES (%s);",
                        tableName,
                        String.join(", ", headers),
                        valuesString.toString()
                );
                try {
                    Statement st = con.createStatement();
                    st.executeUpdate(sqlStatement);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                sqlStatements.append(sqlStatement).append("\n");
            }
        }

        return sqlStatements.toString();
    }
	*/
	public void saat_goster(JLabel lbl,int dk, JMenuItem item, JButton btn1, JButton btn2, JButton btn3) {
		J.saniye=dk*60;
		Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
            	lbl.setText("Kalan Saniye: " +  String.valueOf(J.saniye));
                J.saniye--;
                if(J.saniye==0) {
                	item.setEnabled(false);
                	btn1.setEnabled(true);
                	btn2.setEnabled(true);
                	btn3.setEnabled(true);
                }
            }
        }, 0, 1000);
        
	}
	
	
	public void Ders_ekle(JLabel lbl[], JComboBox box[], int i) {
		
		for (int j = 0; j < i; j++) {
			lbl[J.a].setVisible(true);
			box[J.a].setVisible(true);
			J.a++;
		}
		
		J.a=0;
		
	}
	@SuppressWarnings("unchecked")
	public void comboboxaHocaKoy(JComboBox<String> box) {
		String[] secenekler = new String[10];
		try {
			Statement st = con.createStatement();
			ResultSet hocaset = st.executeQuery("SELECT sicil_no FROM hocalar");
			int i = 0;
			while(hocaset.next()) {
				String ogr_no = String.valueOf(hocaset.getInt(1));
			    secenekler[i++] = ogr_no;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		box.setModel(new DefaultComboBoxModel(secenekler));
	
	}
	
	
	
	public void comboboxaOgrenciKoy(JComboBox<String> box) {
		String[] secenekler = new String[50];
		try {
			Statement st = con.createStatement();
			ResultSet hocaset = st.executeQuery("SELECT ogrenci_no FROM ogrenciler");
			int i = 0;
			while(hocaset.next()) {
			String ogr_no = String.valueOf(hocaset.getInt(1));
		     secenekler[i++] = ogr_no;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		box.setModel(new DefaultComboBoxModel(secenekler));
	
	}
	
	public static void connectToDb() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1452");
			if(con != null) {
				System.out.println("veritabanına bağlandı");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
