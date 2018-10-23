package com.iase.pokemon.ui;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.iase.pokemon.base.Pokemon;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;

public class Vista {

	JFrame ventana;
	
	public JTextField tfNombre;
	public JTextField tfNivel;
	public JTextField tfPeso;
	public JComboBox<Pokemon.Tipo> cbTipo;
	public JButton btAnadir;
	public JScrollPane scrollPane;
	public JList<Pokemon> lPokemons;
	public DefaultListModel<Pokemon> mPokemons;
	public JLabel lbImagen;
	
	public Vista() {
		ventana= new JFrame();
		ventana.setBounds(100,100,506,368);
		ventana.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(40, 25, 46, 14);
		ventana.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo");
		lblNewLabel_1.setBounds(40, 50, 46, 14);
		ventana.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nivel");
		lblNewLabel_2.setBounds(40, 75, 46, 14);
		ventana.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Peso");
		lblNewLabel_3.setBounds(40, 100, 46, 14);
		ventana.getContentPane().add(lblNewLabel_3);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(96, 22, 86, 20);
		ventana.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		tfNivel = new JTextField();
		tfNivel.setBounds(96, 72, 86, 20);
		ventana.getContentPane().add(tfNivel);
		tfNivel.setColumns(10);
		
		tfPeso = new JTextField();
		tfPeso.setBounds(96, 97, 86, 20);
		ventana.getContentPane().add(tfPeso);
		tfPeso.setColumns(10);
		
		cbTipo = new JComboBox();
		cbTipo.setBounds(96, 47, 86, 20);
		ventana.getContentPane().add(cbTipo);
		
		btAnadir = new JButton("A\u00F1adir");
		btAnadir.setActionCommand("anadir");
		btAnadir.setBounds(93, 144, 89, 23);
		ventana.getContentPane().add(btAnadir);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(327, 25, 130, 154);
		ventana.getContentPane().add(scrollPane);
		
		
		mPokemons = new DefaultListModel<>();
		
		lPokemons = new JList<>();
		scrollPane.setViewportView(lPokemons);
		lPokemons.setModel(mPokemons);
		
		lbImagen = new JLabel("");
		lbImagen.setIcon(new ImageIcon("C:\\Users\\AlumnoT\\Desktop\\pikachu.png"));
		lbImagen.setBorder(new TitledBorder(null, "Imagen", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lbImagen.setBounds(213, 25, 104, 142);
		ventana.getContentPane().add(lbImagen);
		
		
		ventana.setLocationRelativeTo(null);
		ventana.repaint();
		ventana.setVisible(true);
		
		
		
		
		
		
		

	}
}
