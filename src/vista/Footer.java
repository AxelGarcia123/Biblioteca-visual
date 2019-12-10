package vista;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Footer extends JPanel {

	public Footer() {
		setBackground(SystemColor.activeCaption);
		
		JLabel lblTecnmInstitutoTecnolgico = new JLabel("TecNM. Instituto Tecnol\u00F3gico de Zit\u00E1cuaro, Co.");
		lblTecnmInstitutoTecnolgico.setForeground(Color.BLACK);
		lblTecnmInstitutoTecnolgico.setFont(new Font("Tahoma", Font.ITALIC, 10));
		add(lblTecnmInstitutoTecnolgico);
	}
}
