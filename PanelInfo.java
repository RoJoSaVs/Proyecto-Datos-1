package dots;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
/**
 * Clase: PanelInfo
 * @author Jose
 * @version 1.10.2018
 */
public class PanelInfo extends JPanel {
	
	private JLabel lbCant_Pts1= new JLabel("0");
	private JLabel lbCant_Pts2= new JLabel("0");

	/**
	 * Crea el panel
	 */
	public PanelInfo() {
		setBackground(new Color(32, 178, 170));
		setBorder(new LineBorder(new Color(192, 192, 192), 5, true));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(30, 23, 31, 28);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.YELLOW);
		panel_2.setBounds(0, 0, 31, 28);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(0, 0, 31, 28);
		panel_2.add(label);
		label.setBackground(Color.GREEN);

		JLabel lblJugador1 = new JLabel("Jugador 1");
		lblJugador1.setForeground(new Color(255, 255, 255));
		lblJugador1.setFont(new Font("Century Gothic", Font.BOLD, 26));
		lblJugador1.setBounds(71, 23, 126, 33);
		add(lblJugador1);

		JLabel lblPuntos1 = new JLabel("Puntos: ");
		lblPuntos1.setForeground(new Color(255, 255, 255));
		lblPuntos1.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblPuntos1.setBounds(30, 74, 80, 25);
		add(lblPuntos1);

		lbCant_Pts1.setForeground(new Color(255, 255, 0));
		lbCant_Pts1.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lbCant_Pts1.setBounds(120, 76, 70, 25);
		add(lbCant_Pts1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.YELLOW);
		panel_1.setBounds(29, 125, 31, 28);
		add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.GREEN);
		panel_3.setBounds(0, 0, 31, 28);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblH = new JLabel("");
		lblH.setBounds(0, 0, 31, 28);
		panel_3.add(lblH);
		lblH.setBackground(Color.YELLOW);

		JLabel lblJugador2 = new JLabel("Jugador 2");
		lblJugador2.setForeground(new Color(255, 255, 255));
		lblJugador2.setFont(new Font("Century Gothic", Font.BOLD, 26));
		lblJugador2.setBounds(71, 125, 126, 33);
		add(lblJugador2);

		JLabel lbPuntos2 = new JLabel("Puntos: ");
		lbPuntos2.setForeground(new Color(255, 255, 255));
		lbPuntos2.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lbPuntos2.setBounds(30, 174, 80, 25);
		add(lbPuntos2);

		lbCant_Pts2.setForeground(new Color(255, 255, 0));
		lbCant_Pts2.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lbCant_Pts2.setBounds(120, 176, 70, 25);
		add(lbCant_Pts2);

	}
	/**
	 * Cambia las etiquetas de puntaje del Panel.
	 * @param puntaje1
	 * @param puntaje2
	 */
	public void ref_puntos(int puntaje1, int puntaje2) {
		String p1 = Integer.toString(puntaje1);
		String p2 = Integer.toString(puntaje2);
		lbCant_Pts1.setText(p1);
		lbCant_Pts2.setText(p2);
	}
}
