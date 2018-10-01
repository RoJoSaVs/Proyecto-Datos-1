package dots;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
/**
 * Clase: MarcoLog
 * @author Jose
 * @version 1.10.2018
 */
public class MarcoLog extends JFrame {

	private JPanel contentPane;
	private JTextField tfJugador;

	/**
	 * Inicia el marco.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarcoLog frame = new MarcoLog();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea el marco.
	 */
	public MarcoLog() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 270, 400, 160);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(32, 178, 170)));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[-2.00][71.00][][284.00]", "[43.00][28.00][71.00]"));

		JButton btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(WIDTH);
			}
		});
		btnX.setForeground(new Color(255, 255, 255));
		btnX.setBackground(new Color(95, 158, 160));
		btnX.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnX, "cell 3 0,alignx right");

		JLabel lblJugador = new JLabel("Jugador:");
		lblJugador.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblJugador, "cell 1 1");

		tfJugador = new JTextField();
		tfJugador.setBackground(new Color(230, 230, 250));
		tfJugador.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(tfJugador, "cell 3 1,grow");
		tfJugador.setColumns(10);

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setForeground(new Color(255, 255, 255));
		btnRegistrarse.setBackground(new Color(95, 158, 160));
		btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnRegistrarse, "cell 3 2,alignx center");
	}

}
