package com.iase.pokemon;

import java.io.IOException;

import javax.swing.JOptionPane;

import com.iase.pokemon.ui.Vista;

public class Aplicacion {

	public static void main(String[] args) {
		
		Vista vista = new Vista();
		try {
			Modelo modelo= new Modelo();
			Controlador controlador = new Controlador(vista,modelo);
		}catch(IOException ioe){
			JOptionPane.showMessageDialog(null, "no se puede leer de discon no se puede iniciar", "Error", JOptionPane.ERROR_MESSAGE);
		}catch(ClassNotFoundException cnfe){
			JOptionPane.showMessageDialog(null, "El formato de datos no es correcto", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}

}
