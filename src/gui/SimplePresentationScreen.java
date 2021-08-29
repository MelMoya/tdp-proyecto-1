package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Label;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JFrame frame;
	private JLabel lblImage;
	private JTextField textField;
	private JTextField textField_Github;
	private JTextField textField_Email;
	private JTextField textField_Nombre;
	private JTextField textField_Apellido;
	private JTextField textField_LU;

	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 235));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(240, 240, 240));
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		tabInformation.setLayout(null);

		
		JLabel lblLU = new JLabel("LU");
		lblLU.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLU.setBounds(10, 11, 81, 20);
		tabInformation.add(lblLU);
		
		textField_LU = new JTextField();
		textField_LU.setColumns(10);
		textField_LU.setBounds(95, 12, 320, 19);
		textField_LU.setText(String.valueOf(studentData.getId()));
		tabInformation.add(textField_LU);
		contentPane.add(tabbedPane, BorderLayout.WEST);
		
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApellido.setBounds(10, 38, 81, 20);
		tabInformation.add(lblApellido);
		
		textField_Apellido = new JTextField();
		textField_Apellido.setColumns(10);
		textField_Apellido.setBounds(95, 38, 320, 19);
		textField_Apellido.setText(studentData.getLastName());
		tabInformation.add(textField_Apellido);
		
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setBounds(10, 66, 81, 20);
		tabInformation.add(lblNombre);
		
		textField_Nombre = new JTextField();
		textField_Nombre.setColumns(10);
		textField_Nombre.setBounds(95, 66, 320, 19);
		textField_Nombre.setText(studentData.getFirstName());
		tabInformation.add(textField_Nombre);
		
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(10, 95, 81, 20);
		tabInformation.add(lblEmail);
		
		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(95, 95, 320, 19);
		textField_Email.setText(studentData.getMail());
		tabInformation.add(textField_Email);
		
		
		JLabel lblGithubUrl = new JLabel("Github URL");
		lblGithubUrl.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGithubUrl.setBounds(10, 123, 81, 20);
		tabInformation.add(lblGithubUrl);
		
		textField_Github = new JTextField();
		textField_Github.setBounds(95, 124, 320, 19);
		textField_Github.setColumns(10);	
		textField_Github.setText(studentData.getGithubURL());
		tabInformation.add(textField_Github);	
		
		
		lblImage = new JLabel("");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon image = null;
		try {
			image = new ImageIcon(new URL(studentData.getPathPhoto()));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		Image size = image.getImage().getScaledInstance(150, 200, Image.SCALE_DEFAULT);
		lblImage.setIcon(new ImageIcon(size));
		contentPane.add(lblImage, BorderLayout.CENTER);
		
		
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter hora = DateTimeFormatter.ofPattern("HH:mm:ss");
		JLabel lblNFecha = new JLabel("Esta ventana fue generada el: " + fecha.format(LocalDateTime.now()) + " a las: " + hora.format(LocalDateTime.now()));
		lblNFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblNFecha, BorderLayout.SOUTH);
	}
}
