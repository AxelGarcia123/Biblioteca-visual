package vista;

import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Font;

@SuppressWarnings("serial")
public class MenuLateral extends JPanel {
	private JButton botonRegistrar;
	private JButton botonConsultar;
	private JButton botonModificar;
	private JButton botonEliminar;
	private JButton botonOrdenar;

	public MenuLateral() {
		setBackground(new Color(240, 240, 240));
		setLayout(new GridLayout(5, 1, 0, 100));
		
		botonRegistrar = new JButton("Registrar");
		botonRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonRegistrar.setMnemonic(KeyEvent.VK_R);
		botonRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonRegistrar.setToolTipText("Registrar libro");
		botonRegistrar.setBackground(new Color(1, 112, 192));
		botonRegistrar.setForeground(Color.WHITE);
		botonRegistrar.setHorizontalTextPosition(SwingConstants.CENTER);
		add(botonRegistrar);
		
		botonConsultar = new JButton("Consultar");
		botonConsultar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonConsultar.setForeground(Color.WHITE);
		botonConsultar.setBackground(new Color(1, 112, 192));
		botonConsultar.setHorizontalTextPosition(SwingConstants.CENTER);
		add(botonConsultar);
		
		botonModificar = new JButton("Modificar");
		botonModificar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonModificar.setForeground(Color.WHITE);
		botonModificar.setBackground(new Color(1, 112, 192));
		botonModificar.setHorizontalTextPosition(SwingConstants.CENTER);
		add(botonModificar);
		
		botonEliminar = new JButton("Eliminar");
		botonEliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonEliminar.setForeground(Color.WHITE);
		botonEliminar.setBackground(new Color(1, 112, 192));
		botonEliminar.setHorizontalTextPosition(SwingConstants.CENTER);
		add(botonEliminar);
		
		botonOrdenar = new JButton("Ordenar");
		botonOrdenar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonOrdenar.setForeground(Color.WHITE);
		botonOrdenar.setBackground(new Color(1, 112, 192));
		botonOrdenar.setHorizontalTextPosition(SwingConstants.CENTER);
		add(botonOrdenar);
	}

	public JButton getBotonRegistrar() {
		return botonRegistrar;
	}

	public JButton getBotonConsultar() {
		return botonConsultar;
	}

	public JButton getBotonModificar() {
		return botonModificar;
	}

	public JButton getBotonEliminar() {
		return botonEliminar;
	}

	public JButton getBotonOrdenar() {
		return botonOrdenar;
	}
}
