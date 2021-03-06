package dots;



import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



/**
 * Clase: PanelMalla
 * @author Jose
 * @version 1.10.2018
 */

class PanelMalla extends JPanel implements MouseListener{

	private Constructor Malla = new Constructor(10);

	private LinkedList listaG = Malla.getLista();
	
	private boolean pto_inicial = false;
	
	private Punto inicial_tmp;
	
	private LinkedList coords_tmp = new LinkedList();
	
	private int JugadorC = 0;
        
    private Figura f_temp = new Figura();
        
    private LinkedList fg= new LinkedList();
        
    private LinkedList rec= new LinkedList();
    
    private Jugador J1 = new Jugador();
    
    private Jugador J2 = new Jugador();
	
    /**
     * M�todo constructor de la clase "PanelMalla".
     */
	public PanelMalla() {
	}
	
	/**
	 * Obtiene el puntaje de los jugadores seg�n el valor que se le solicite.
	 * @param n
	 * @return J2.getPuntaje()
	 */
	public int getPtje(int n) {
		if (n == 1) {
			return this.J1.getPuntaje(); 
		} else {
			return this.J2.getPuntaje();
		}
	}
	
	/**
	 * Maneja el trazado de puntos y lineas.
	 * @param g
	 */
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
	
	/**
	 * Detecci�n cuando el mouse es accionado.
	 * @param e
	 */
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
								if (inicial_tmp.puedeEnlazar(pto_temp)) {

									
									Graphics g = getGraphics();
									
									if (JugadorC % 2 == 0) {
										g.setColor(Color.green);
									}else {
										g.setColor(Color.yellow);
									}
				
									Graphics2D g2 = (Graphics2D) g;
									g2.setStroke(new BasicStroke(6));
									g2.drawLine(DX+10, DY+10, CX+10, CY+10);
									
									inicial_tmp.enlazar(pto_temp);
									pto_temp.enlazar(inicial_tmp);
									
                                    if(f_temp.cierraFig(inicial_tmp, pto_temp, inicial_tmp, pto_temp.getAux(), fg, pto_temp.getAux().size()-1, rec)) {
                                    	System.out.println("k");
                                    	LinkedList rellenar = f_temp.getUltimaFig();
                                    	
                                    	int []x = new int[rellenar.size()];
                                    	
                                    	int []y = new int[rellenar.size()];
                                    	
                                    	int s = rellenar.size();
                                    	System.out.println(s);
                                    	for (int n=0; n<rellenar.size(); n++) {
                                    		
                                    		Punto pto_rell = (Punto) rellenar.recorrer(n);
                                    		
                                    		LinkedList rect_rell = pto_rell.getRect();

                            				Object Xr = rect_rell.recorrer(0);
                            				int XR = (int) Xr;
                            				x[n] = XR+10;

                            				Object Yr = rect_rell.recorrer(1);
                            				int YR = (int) Yr;
                            				y[n] = YR+10;
                                    		
                                    	}
                                    	System.out.println("k");
                                    	g.fillPolygon(x, y, s);
                                    	
                                    	if ((JugadorC % 2) == 0) {
                                    		J2.setPuntos(100);
                                    	} else {
                                    		J1.setPuntos(100);
                                    	}
                                    }
									
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

									JLabel lbladv = new JLabel("Movimiento no v�lido");
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
	
	/**
	 * Detecta cuando el cursor entra al componente.
	 * @param arg0
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) { //No se hace uso de este m�todo, mas se debe incluir debido a que se est� haciendo un "implements".
		// TODO Auto-generated method stub

	}
	/**
	 * Detecta cuando el cursor sale del componente.
	 * @param arg0
	 */
	@Override
	public void mouseExited(MouseEvent arg0) { //No se hace uso de este m�todo, mas se debe incluir debido a que se est� haciendo un "implements".
		// TODO Auto-generated method stub

	}
	/**
	 * Detecta cuando el mouse se encuentra presionado.
	 * @param arg0
	 */
	@Override
	public void mousePressed(MouseEvent arg0) { //No se hace uso de este m�todo, mas se debe incluir debido a que se est� haciendo un "implements".
		// TODO Auto-generated method stub

	}
	/**
	 * Detecta cuando el mouse deja de estar presionado.
	 * @param arg0
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) { //No se hace uso de este m�todo, mas se debe incluir debido a que se est� haciendo un "implements".
		// TODO Auto-generated method stub

	}

}
