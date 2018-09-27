package dots;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelInfo extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelInfo() {
		setBackground(new Color(32, 178, 170));
		setBorder(new LineBorder(new Color(192, 192, 192), 5, true));
		setLayout(null);

		JLabel label = new JLabel("");
		label.setBackground(new Color(102, 255, 0));
		label.setBounds(30, 23, 31, 28);
		add(label);

		JLabel lblJugador1 = new JLabel("Jugador 1");
		lblJugador1.setForeground(new Color(255, 255, 255));
		lblJugador1.setFont(new Font("Burbank Big Cd Bd", Font.BOLD, 26));
		lblJugador1.setBounds(74, 23, 105, 28);
		add(lblJugador1);

		JLabel lblPuntos1 = new JLabel("Puntos: ");
		lblPuntos1.setForeground(new Color(255, 255, 255));
		lblPuntos1.setFont(new Font("Burbank Big Cd Bd", Font.BOLD, 26));
		lblPuntos1.setBounds(30, 62, 70, 25);
		add(lblPuntos1);

		JLabel lbCant_Pts1 = new JLabel("###");
		lbCant_Pts1.setForeground(new Color(255, 255, 0));
		lbCant_Pts1.setFont(new Font("Burbank Big Cd Bd", Font.BOLD, 26));
		lbCant_Pts1.setBounds(110, 62, 70, 25);
		add(lbCant_Pts1);

		JLabel label_2 = new JLabel("");
		label_2.setBounds(29, 125, 31, 28);
		add(label_2);

		JLabel lblJugador2 = new JLabel("Jugador 2");
		lblJugador2.setForeground(new Color(255, 255, 255));
		lblJugador2.setFont(new Font("Burbank Big Cd Bd", Font.BOLD, 26));
		lblJugador2.setBounds(73, 125, 105, 28);
		add(lblJugador2);

		JLabel lbPuntos2 = new JLabel("Puntos: ");
		lbPuntos2.setForeground(new Color(255, 255, 255));
		lbPuntos2.setFont(new Font("Burbank Big Cd Bd", Font.BOLD, 26));
		lbPuntos2.setBounds(29, 164, 70, 25);
		add(lbPuntos2);

		JLabel lbCant_Pts2 = new JLabel("###");
		lbCant_Pts2.setForeground(new Color(255, 255, 0));
		lbCant_Pts2.setFont(new Font("Burbank Big Cd Bd", Font.BOLD, 26));
		lbCant_Pts2.setBounds(109, 164, 70, 25);
		add(lbCant_Pts2);

	}
}
