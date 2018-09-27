package dots;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class FrameJuego extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameJuego frame = new FrameJuego();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameJuego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		PanelInfo panelInfo = new PanelInfo();
		panelInfo.setForeground(new Color(0, 153, 102));
		panelInfo.setBackground(new Color(32, 178, 170));
		panelInfo.setBounds(0, 0, 225, 561);
		contentPane.add(panelInfo);

		PanelMalla panelMalla = new PanelMalla();
		panelMalla.setBounds(235, 11, 639, 539);
		contentPane.add(panelMalla);
	}
}
