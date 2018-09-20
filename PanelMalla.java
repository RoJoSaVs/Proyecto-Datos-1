package dots;



import javax.swing.*;

import java.awt.*;

import java.awt.geom.*;




class PanelMalla extends JPanel{
	public PanelMalla() {
	}

	public void paintComponent(Graphics g) {

		Constructor Malla = new Constructor();
		Malla.Matriz(10);

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

				Rectangle2D rectangulo = new Rectangle2D.Double(D, C, 8, 8);

				Ellipse2D ovalo = new Ellipse2D.Double();

				ovalo.setFrame(rectangulo);

				g2.draw(ovalo);

				C+=50;
			}


		}

	}

}
