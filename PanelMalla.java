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

				if((b_temp == false) && (pto_inicial == false) && (e.getButton() == 1)
					&& (e.getX() >= CX && e.getX() <= CX+20 && e.getY() >= CY && e
					.getY() <= CY+20)) {


					Graphics g = getGraphics();
					g.setColor(Color.green);
					g.fillOval(CX, CY, 21, 21);
					pto_temp.setEstado();
					pto_inicial = true;
					coords_tmp.insertFirst(CY);
					coords_tmp.insertFirst(CX);
					inicial_tmp = pto_temp; 

				}else{
					if((b_temp == false) && (pto_inicial) && (e.getButton() == 1)
							&& (e.getX() >= CX && e.getX() <= CX+20 && e.getY() >= CY && e
							.getY() <= CY+20)) {
						Graphics g = getGraphics();
						g.setColor(Color.green);
						g.fillOval(CX, CY, 21, 21);
						
						
						Object X2 = coords_tmp.recorrer(0);
						int DX = (int) X2;
						
						Object Y2 = coords_tmp.recorrer(1);
						int DY = (int) Y2;
						
						Graphics2D g2 = (Graphics2D) g;
						g2.setStroke(new BasicStroke(6));
						g2.drawLine(DX+10, DY+10, CX+10, CY+10);
						
						coords_tmp.deleteFirst();
						coords_tmp.deleteFirst();
						inicial_tmp.setEstado();
						pto_inicial = false;
						

					}else{
						if((b_temp == true) && (e.getButton() == 1)
								&& (e.getX() >= CX && e.getX() <= CX+20 && e.getY() >= CY && e
								.getY() <= CY+20)) {
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
