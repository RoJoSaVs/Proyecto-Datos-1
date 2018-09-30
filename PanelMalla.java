package dots;



import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;





class PanelMalla extends JPanel implements MouseListener{

	private Constructor Malla = new Constructor(10);

	private LinkedList listaG = Malla.getLista();
	
	private boolean pto_inicial = false;
	
	private Punto inicial_tmp;
	
	private LinkedList coords_tmp = new LinkedList();
	
	private int JugadorC = 0;


	public PanelMalla() {
	}

	public void paintComponent(Graphics g) {

		LinkedList listaG = Malla.getLista();


		super.paintComponents(g);

		Graphics2D g2 = (Graphics2D) g;

		Color COLOR1 = new Color(0, 0, 0);

		g2.setColor(COLOR1);

		g2.setStroke(new BasicStroke(8));

		int D=0;

		for(int i=0; i<listaG.size(); i++) {

			Object L1 = listaG.recorrer(i);

			LinkedList L2 = (LinkedList) L1;

			D+=50;

			int C = 50;

			for (int j=0; j<L2.size(); j++) {

				Punto pto_temp = (Punto) L2.recorrer(j);

				pto_temp.setRect(D, C, 20, 20);

				g2.fillOval(D, C, 20, 20);

				C+=50;
			}


		}
		this.addMouseListener(this);


	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i=0; i<listaG.size(); i++) {

			Object L1 = listaG.recorrer(i);

			LinkedList L2 = (LinkedList) L1;

			for (int j=0; j<L2.size(); j++) {

				Punto pto_temp = (Punto) L2.recorrer(j);

				LinkedList rect = pto_temp.getRect();

				boolean b_temp = pto_temp.getEstado();

				Object X = rect.recorrer(0);
				int CX = (int) X;

				Object Y = rect.recorrer(1);
				int CY = (int) Y;
				
				if((e.getButton() == 1) && (e.getX() >= CX && e.getX() <= CX+20 && e.getY() >= CY 
						&& e.getY() <= CY+20)) {
					
					if((b_temp == false) && (pto_inicial == false)) {

							Graphics g = getGraphics();
							if (JugadorC % 2 == 0) {
								g.setColor(Color.green);
							}else {
								g.setColor(Color.yellow);
							}
							g.fillOval(CX, CY, 21, 21);
							pto_temp.setEstado();
							pto_inicial = true;
							coords_tmp.insertFirst(CY);
							coords_tmp.insertFirst(CX);
							inicial_tmp = pto_temp; 

						}else{
							if((b_temp == false) && (pto_inicial)) {
								
								Object X2 = coords_tmp.recorrer(0);
								int DX = (int) X2;
								
								Object Y2 = coords_tmp.recorrer(1);
								int DY = (int) Y2;
								
								if ((Math.abs(CX-DX) < 60) && (Math.abs(CY-DY) < 60 )) {
									
									Graphics g = getGraphics();
									
									if (JugadorC % 2 == 0) {
										g.setColor(Color.green);
									}else {
										g.setColor(Color.yellow);
									}
				
									Graphics2D g2 = (Graphics2D) g;
									g2.setStroke(new BasicStroke(6));
									g2.drawLine(DX+10, DY+10, CX+10, CY+10);
									
									g.setColor(Color.black);
									g.fillOval(CX, CY, 21, 21);
									g.fillOval(DX, DY, 21, 21);
									
									coords_tmp.deleteFirst();
									coords_tmp.deleteFirst();
									inicial_tmp.setEstado();
									pto_inicial = false;
									JugadorC ++;
								}else {
									JFrame advertencia = new JFrame();
									advertencia.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
									advertencia.setBounds(550, 450, 400, 115);
									advertencia.setResizable(false);
									advertencia.setVisible(true);
									advertencia.setLayout(null);

									JLabel lbladv = new JLabel("Movimiento no válido");
									lbladv.setFont(new Font("Tahoma", Font.BOLD, 14));
									lbladv.setBounds(141, 34, 158, 14);
									advertencia.add(lbladv);
									
									JLabel lblimg = new JLabel("");
									lblimg.setIcon(new ImageIcon("C:\\Users\\andre\\eclipse-workspace\\Hola mundo\\advertencia.png"));
									lblimg.setBounds(58, 22, 56, 32);
									advertencia.add(lblimg);
								}

							}else{
								if(b_temp == true) {
									
									Graphics g = getGraphics();
									g.setColor(Color.black);
									g.fillOval(CX, CY, 21, 21);
									pto_temp.setEstado();
									pto_inicial = false;
									coords_tmp.deleteFirst();
									coords_tmp.deleteFirst();
								}
							
							}

						}
				}

			}

		}
				
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
