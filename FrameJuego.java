package dots;

import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
/**
 * Clase: FrameJuego
 * @author Jose
 * @version 1.10.2018
 */
public class FrameJuego extends JFrame implements MouseListener {

	private JPanel contentPane;
	private PanelInfo panelInfo = new PanelInfo();
	private PanelMalla panelMalla = new PanelMalla();

	/**
	 * Inicia el marco
	 */
	public void Interfaz() {
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
	 * Crea el marco.
	 */
	public FrameJuego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelInfo.setForeground(new Color(0, 153, 102));
		panelInfo.setBackground(new Color(32, 178, 170));
		panelInfo.setBounds(0, 0, 225, 561);
		contentPane.add(panelInfo);

		panelMalla.setBounds(235, 11, 639, 539);
		contentPane.add(panelMalla);
		panelMalla.addMouseListener(this);
		
	}
	/**
	 * Detección cuando el mouse es accionado.
	 * @param arg0
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Detecta cuando el cursor entra al componente.
	 * @param arg0
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Detecta cuando el cursor sale del componente.
	 * @param arg0
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Detecta cuando el mouse se encuentra presionado.
	 * @param arg0
	 */
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Detecta cuando el mouse deja de estar presionado.
	 * @param arg0
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		panelInfo.ref_puntos(panelMalla.getPtje(1), panelMalla.getPtje(2));
//		System.out.println("aca");
	}
}
