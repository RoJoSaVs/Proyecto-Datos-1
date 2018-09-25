package dots;



import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;





class PanelMalla extends JPanel implements MouseListener{

	private Constructor Malla = new Constructor(10);

	private LinkedList listaG = Malla.getLista();

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

				Punto pto_temp = L2.recorrerL(j);

				pto_temp.setRect(D, C, 8, 8);



				Rectangle2D rectangulo = new Rectangle2D.Double(D, C, 8, 8);

				Ellipse2D ovalo = new Ellipse2D.Double();

				ovalo.setFrame(rectangulo);

				g2.draw(ovalo);

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

				Punto pto_temp = L2.recorrerL(j);

				LinkedList rect = pto_temp.getRect();

				Object X = rect.recorrer(0);
				int CX = (int) X;

				Object Y = rect.recorrer(1);
				int CY = (int) Y;

				if((e.getButton() == 1)
					&& (e.getX() >= CX && e.getX() <= CX+8 && e.getY() >= CY && e
					.getY() <= CY+8)) {


					Graphics g = getGraphics();
					g.setColor(Color.green);
					g.fillOval(CX-7, CY-7, 20, 20);


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
