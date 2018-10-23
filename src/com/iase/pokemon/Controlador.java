package com.iase.pokemon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.iase.pokemon.base.Pokemon;
import com.iase.pokemon.base.Pokemon.Tipo;
import com.iase.pokemon.ui.Vista;
import com.iase.pokemon.util.Util;



public class Controlador implements ActionListener, MouseListener {

	private Modelo modelo;
	private Vista vista;
	private String nombreImagen;
	private File ficheroSeleccionado;

	public Controlador(Vista vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;

		addListeners();
		poblarTiposPokemon();
		refrescarLista();
		
	}
	private void refrescarLista() {
		
		vista.mPokemons.removeAllElements();
		for (Pokemon pokemon: modelo.getPokemones()) {
			vista.mPokemons.addElement(pokemon);
		}
	}
	
	
	private void poblarTiposPokemon() {
		for(Tipo tipo : Tipo.values())
			vista.cbTipo.addItem(tipo);
	}
	

	public void addListeners() {

		vista.btAnadir.addActionListener(this);
		vista.lbImagen.addMouseListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		
		switch(e.getActionCommand()) {
			case "anadir":
				
				if (vista.tfNombre.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "el campo es obligatorio", "error",JOptionPane.ERROR_MESSAGE );
					return;
				}
				if (vista.tfNivel.getText().equals(""))
					vista.tfNivel.setText("0");
				if (vista.tfPeso.getText().equals(""))
					vista.tfPeso.setText("0");
				
				if(!vista.tfNivel.getText().matches("[0-9]*")) {
					JOptionPane.showMessageDialog(null,"El nivel tiene que ser un numerico", "Error", JOptionPane.ERROR_MESSAGE);
					vista.tfNivel.selectAll();
					vista.tfNivel.requestFocus();
					return;
				}
				
				
				
				
				String nombre = vista.tfNombre.getText();
				Tipo tipo = (Tipo) vista.cbTipo.getSelectedItem();
				int nivel = Integer.parseInt(vista.tfNivel.getText());
				float peso = Float.parseFloat(vista.tfPeso.getText());
				
				if(ficheroSeleccionado != null)
					nombreImagen = ficheroSeleccionado.getName();
				else
					nombreImagen = "nopicture.png";
				
				Pokemon pokemon = new Pokemon();
				pokemon.setNombre(nombre);
				pokemon.setTipo(tipo);
				pokemon.setNivel(nivel);
				pokemon.setPeso(peso);
				//pokemon.setImagen();
				pokemon.setImagen(nombreImagen);
				
				
				try {
				modelo.guardar(pokemon);
				
				
				
				try {
					Util.copiarImagen(ficheroSeleccionado.getAbsolutePath(),nombreImagen);
					
				}catch(IOException ioe) {
					ioe.printStackTrace();
				}
				
				
				vista.mPokemons.addElement(pokemon);
				}catch(IOException ioe){
					ioe.printStackTrace();
					JOptionPane.showMessageDialog(null, "error al guardar", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				break;
			default:
				break;
		}
		
		}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		JFileChooser jfc = new JFileChooser();
		if(jfc.showOpenDialog(null) == JFileChooser.CANCEL_OPTION)
			return;
		
		ficheroSeleccionado = jfc.getSelectedFile();
		vista.lbImagen.setIcon(new ImageIcon(ficheroSeleccionado.getAbsolutePath()));
		
		
		
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
	
		
	}
	@Override
	public void mousePressed(MouseEvent e) {//pulsar
		
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {//soltar
		
		
	}
	}

