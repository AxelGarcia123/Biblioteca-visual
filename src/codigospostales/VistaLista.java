package codigospostales;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.util.List;
import javax.swing.JLabel;
import java.awt.Font;

public class VistaLista extends JFrame{

	private JPanel contentPane;
	private JScrollPane scpCodigo;
	private JScrollPane scpColonia;
	private JList<String> listaCodigos;
	private JList<String> listaColonias;
	private DefaultListModel< String> modeloCodigo;
	private DefaultListModel< String> modeloColonia;
	private JTextField cajaEstado;
	private JTextField cajaCiudad;
	private CodigosPostales codigosPostales;
	private String codigoPostal;
	private String coloniax;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JLabel label;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaLista frame = new VistaLista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VistaLista() {
		codigosPostales=DAOCodigoPostal.getCodigos("C:\\Users\\bryangarcia\\Desktop\\POO\\Eclipse\\Código postal Zitácuaro.txt");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 331);
		contentPane = new JPanel();
		
		modeloCodigo=new DefaultListModel<>();
		
		
		modeloColonia= new DefaultListModel<>();
		agragarCodigos();
		listaCodigos=new JList<>(modeloCodigo);
		listaCodigos.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				
				if (modeloColonia!=null) {
					modeloColonia.removeAllElements();
					cajaCiudad.setText("");
					cajaEstado.setText("");
				}
				
				JList listaCodigos=(JList) e.getSource();
				String codigo=(String) listaCodigos.getSelectedValue();
				agragarColonias(codigo);
				codigoPostal=codigo;
			}
		});
		listaColonias= new JList<>(modeloColonia);
		listaColonias.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated met
				JList listaColonias=(JList) e.getSource();
				String col=(String) listaColonias.getSelectedValue();
				coloniax=col;
				CodigoPostal cp=codigosPostales.getElemento(new CodigoPostal(codigoPostal));
				cajaEstado.setText(cp.getEstado().get(0));
				cajaCiudad.setText(cp.getCiudad().get(0));
				repaint();
			}
		});
		
		scpCodigo=new JScrollPane(listaCodigos);
		scpCodigo.setBounds(17, 5, 258, 130);
		scpColonia=new JScrollPane(listaColonias);
		scpColonia.setBounds(280, 5, 258, 130);
		setContentPane(contentPane);
		cajaEstado= new JTextField();
		cajaEstado.setBounds(75, 140, 200, 50);
		cajaEstado.setPreferredSize(new Dimension(200, 50));
		cajaCiudad=new JTextField();
		cajaCiudad.setBounds(290, 140, 200, 50);
		cajaCiudad.setPreferredSize(new Dimension(200, 50));
		contentPane.setLayout(null);
		contentPane.add(scpCodigo);
		contentPane.add(scpColonia);
		contentPane.add(cajaEstado);
		contentPane.add(cajaCiudad);
		
		label = new JLabel("");
		label.setBounds(442, 165, 0, 0);
		contentPane.add(label);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancelar.setBounds(305, 226, 137, 34);
		btnCancelar.setBackground(new Color(0, 112, 192));
		contentPane.add(btnCancelar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGuardar.setBounds(138, 226, 137, 34);
		btnGuardar.setBackground(new Color(0, 112, 192));
		contentPane.add(btnGuardar);
	}
	
	private void agragarCodigos() {
		for (String  codigo : codigosPostales.getCodigosPostales()) {
			modeloCodigo.addElement(codigo);
		}
	}
	
	private void agragarColonias(String codigo) {
		List<String> colonias=codigosPostales.getColonias(codigo);
		
		for (String  colonia:colonias ) {
			if(!modeloColonia.contains(colonia))
			    modeloColonia.addElement(colonia);
		}
	}
	
	public void limpiarVentana() {
		this.dispose();
	}
	
	public JButton getBotonGuardar() {
		return btnGuardar;
	}
	
	public JButton getBotonCancelar() {
		return btnCancelar;
	}
	
	public String getCodigoPostal() {
		return codigoPostal;
	}
	
	public String getColonia() {
		return coloniax;
	}
	
	public String getCiudad() {
		return cajaCiudad.getText();
	}
	
	public String getEstado() {
		return cajaEstado.getText();
	}
}