package uptc.edu.logica;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.SwingConstants;

import uptc.edu.run.Main;

import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * Esta clase define los metodos utilizado Grapics con el que podemos hacer la
 * interfaz animada junto con los Threads
 * 
 * @author: Ronaldo
 * 
 * @version: 07/09/2020/A
 * 
 * 
 */

@SuppressWarnings("serial")
public class Interfaz extends JFrame {

	// Campos de la clase
	double x = 0;

	public Interfaz() {

		super("Transporte");

		getContentPane().add(new PanelOverDraw());

		JButton theButton = new JButton("Ingresar Nueva Ruta :");
		JPanel flowPanel = new JPanel(new FlowLayout());
		flowPanel.add(theButton);
		getContentPane().add(BorderLayout.SOUTH, flowPanel);
		theButton.setBackground(Color.red);

		theButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main in = new Main();
				in.frame.setVisible(true);
				dispose();

			}
		});

		this.setSize(810, 550);

		this.setVisible(true);
	}

	public class PanelOverDraw extends JPanel implements Runnable {

		// Campos de la clase
		private BufferedImage img = null;
		Graphics2D g2d;
		int x;
		int y;
		Thread hilo;
		Main in = new Main();

		public PanelOverDraw() {

			// Campos de la clase
			x = 0;
			y = 2;
			hilo = new Thread(this);
			hilo.start();

			/**
			 * 
			 * Metodo para implementar la imagen de fondo para la animacion
			 * 
			 * @param numeroItems El parámetro img es el nombre de la variable donde se
			 *                    guarda la imagen
			 * 
			 */
			try {
				img = ImageIO.read(new FileInputStream("Imagen (1).jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.setPreferredSize(new Dimension(484, 409));
		}

		@Override
		public void paint(Graphics g) {

			if (in.getCiudad().get(0).toString().equals("Bogota")
					&& in.getLlegada().get(0).toString().equals("Paris")) {

				g2d = (Graphics2D) g;
				g2d.drawImage(img, 0, 0, null);
				g2d.setStroke(new BasicStroke(1));
				g2d.setColor(Color.RED);
				g2d.fillRect(((208 + x) + 85), 242 - y, 20, 20);
				g2d.setStroke(new BasicStroke(1));
				g2d.setColor(Color.BLACK);
				g2d.fillRect(208, 242, 10, 10);
				g2d.drawLine(((208 + x) + 85), 242 - y, 208, 242);
			} else if (in.getCiudad().get(0).toString().equals("Bogota")
					&& in.getLlegada().get(0).toString().equals("Madrid"))

			{
				g2d = (Graphics2D) g;
				g2d.drawImage(img, 0, 0, null);
				g2d.setStroke(new BasicStroke(1));
				g2d.setColor(Color.RED);
				g2d.fillRect(((208 + x) + 98), 242 - y, 10, 10);
				g2d.setStroke(new BasicStroke(1));
				g2d.setColor(Color.black);
				g2d.fillRect(208, 242, 10, 10);
				g2d.drawLine(((208 + x) + 85), 242 - y, 208, 242);
			} else if (in.getCiudad().get(0).toString().equals("Bogota")
					&& in.getLlegada().get(0).toString().equals("Lima"))

			{
				g2d = (Graphics2D) g;
				g2d.drawImage(img, 0, 0, null);
				g2d.setStroke(new BasicStroke(1));
				g2d.setColor(Color.RED);
				g2d.fillRect(208, (242 + y) + 10, 10, 10);
				g2d.setStroke(new BasicStroke(1));
				g2d.setColor(Color.black);
				g2d.fillRect(208, 242, 10, 10);
				g2d.drawLine(((208 + x) + 85), 242 - y, 208, 242);
			} else if (in.getCiudad().get(0).toString().equals("Madrid")
					&& in.getLlegada().get(0).toString().equals("Bogota"))

			{
				g2d = (Graphics2D) g;
				g2d.drawImage(img, 0, 0, null);
				g2d.setStroke(new BasicStroke(1));
				g2d.setColor(Color.RED);
				g2d.fillRect(440 - x, 112 + y, 10, 10);
				g2d.setStroke(new BasicStroke(1));
				g2d.setColor(Color.black);
				g2d.fillRect(440, 112, 10, 10);
				g2d.drawLine(440 - x, 112 + y, 440, 112);
			} else if (in.getCiudad().get(0).toString().equals("Madrid")
					&& in.getLlegada().get(0).toString().equals("Paris"))

			{
				g2d = (Graphics2D) g;
				g2d.drawImage(img, 0, 0, null);
				g2d.setStroke(new BasicStroke(1));
				g2d.setColor(Color.RED);
				g2d.fillOval(440 + x, 112 - y, 10, 10);
				g2d.setStroke(new BasicStroke(1));
				g2d.setColor(Color.black);
				g2d.fillOval(440, 112, 10, 10);
				g2d.drawLine(440 - x, 112 - y, 440, 112);
			} else if (in.getCiudad().get(0).toString().equals("Paris")
					&& in.getLlegada().get(0).toString().equals("Madrid"))

			{
				g2d = (Graphics2D) g;
				g2d.drawImage(img, 0, 0, null);
				g2d.setStroke(new BasicStroke(1));
				g2d.setColor(Color.RED);
				g2d.fillOval(467 - x, 72 + 2 * y, 10, 10);
				g2d.setStroke(new BasicStroke(1));
				g2d.setColor(Color.black);
				g2d.fillOval(467, 72, 10, 10);
				g2d.drawLine(467 - x, 72 + 2 * y, 467, 72);
			} else if (in.getCiudad().get(0).toString().equals("Lima")
					&& in.getLlegada().get(0).toString().equals("Bogota"))

			{
				g2d = (Graphics2D) g;
				g2d.drawImage(img, 0, 0, null);
				g2d.setStroke(new BasicStroke(1));
				g2d.setColor(Color.RED);
				g2d.fillOval(200, 298 - y, 10, 10);
				g2d.setStroke(new BasicStroke(1));
				g2d.setColor(Color.black);
				g2d.fillOval(200, 298, 10, 10);
				g2d.drawLine(200, 298 - y, 200, 298);
			} else if (in.getCiudad().get(0).toString().equals("Lima")
					&& in.getLlegada().get(0).toString().equals("Paris"))

			{
				g2d = (Graphics2D) g;
				g2d.drawImage(img, 0, 0, null);
				g2d.setStroke(new BasicStroke(1));
				g2d.setColor(Color.RED);
				g2d.fillOval(200 + (2 * x) + 15, 298 - (2 * y) + 15, 10, 10);
				g2d.setStroke(new BasicStroke(1));
				g2d.setColor(Color.black);
				g2d.fillOval(200, 298, 10, 10);
				g2d.drawLine(200 + (2 * x) + 15, 298 - (2 * y), 200, 298);
			} else if (in.getCiudad().get(0).toString().equals("Lima")
					&& in.getLlegada().get(0).toString().equals("Santiago de Chile"))

			{
				g2d = (Graphics2D) g;
				g2d.drawImage(img, 0, 0, null);
				g2d.setStroke(new BasicStroke(1));
				g2d.setColor(Color.RED);
				g2d.fillOval(215, 298 + y, 10, 10);
				g2d.setStroke(new BasicStroke(1));
				g2d.setColor(Color.black);
				g2d.fillOval(200, 298, 10, 10);
				g2d.drawLine(215, 298 + y, 200, 298);
			} else if (in.getCiudad().get(0).toString().equals("Santiago de Chile")
					&& in.getLlegada().get(0).toString().equals("Bogota"))

			{
				g2d = (Graphics2D) g;
				g2d.drawImage(img, 0, 0, null);
				g2d.setStroke(new BasicStroke(1));
				g2d.setColor(Color.RED);
				g2d.fillOval(215, 380 - y, 10, 10);
				g2d.setStroke(new BasicStroke(1));
				g2d.setColor(Color.black);
				g2d.fillOval(215, 380, 10, 10);
				g2d.drawLine(215, 380 - y, 215, 380);
			} else if (in.getCiudad().get(0).toString().equals("Santiago de Chile")
					&& in.getLlegada().get(0).toString().equals("Lima"))

			{
				g2d = (Graphics2D) g;
				g2d.drawImage(img, 0, 0, null);
				g2d.setStroke(new BasicStroke(1));
				g2d.setColor(Color.RED);
				g2d.fillOval(208, 380 - y, 10, 10);
				g2d.setStroke(new BasicStroke(1));
				g2d.setColor(Color.black);
				g2d.fillOval(215, 380, 10, 10);
				g2d.drawLine(208, 380 - y, 208, 380);
			}

		}

		@Override
		public void run() {

			if (in.getCiudad().get(0).toString().equals("Bogota")
					&& in.getLlegada().get(0).toString().equals("Paris")) {
				long start = System.currentTimeMillis();
				double end = start + 8 * 1000;
				while (System.currentTimeMillis() < end) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					x += 1;

					y += 1;
					repaint();
				}
				JOptionPane.showMessageDialog(null, "Su destino Bogota - Madrid ha finalizado");
			} else if (in.getCiudad().get(0).toString().equals("Bogota")
					&& in.getLlegada().get(0).toString().equals("Madrid")) {
				long start = System.currentTimeMillis();
				double end = start + 10 * 1000;
				while (System.currentTimeMillis() < end) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					x += 1;

					y += 1;
					repaint();
				}
				JOptionPane.showMessageDialog(null, "Su destino Bogota - Madrid ha finalizado");
			} else if (in.getCiudad().get(0).toString().equals("Bogota")
					&& in.getLlegada().get(0).toString().equals("Lima")) {
				long start = System.currentTimeMillis();
				double end = start + 2 * 1000;
				while (System.currentTimeMillis() < end) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					x += 1;

					y += 1;
					repaint();
				}
				JOptionPane.showMessageDialog(null, "Su destino Bogota - Lima ha finalizado");
			} else if (in.getCiudad().get(0).toString().equals("Madrid")
					&& in.getLlegada().get(0).toString().equals("Bogota")) {
				long start = System.currentTimeMillis();
				double end = start + 9 * 1000;
				while (System.currentTimeMillis() < end) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					x += 2;

					y += 1;
					repaint();
				}
				JOptionPane.showMessageDialog(null, "Su destino Madrid - Bogota ha finalizado");
			} else if (in.getCiudad().get(0).toString().equals("Madrid")
					&& in.getLlegada().get(0).toString().equals("Paris")) {
				long start = System.currentTimeMillis();
				double end = start + 2 * 1000;
				while (System.currentTimeMillis() < end) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					x += 1;

					y += 1;
					repaint();
				}
				JOptionPane.showMessageDialog(null, "Su destino Madrid - Paris ha finalizado");
			} else if (in.getCiudad().get(0).toString().equals("Paris")
					&& in.getLlegada().get(0).toString().equals("Madrid")) {
				long start = System.currentTimeMillis();
				double end = start + 2 * 1000;
				while (System.currentTimeMillis() < end) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					x += 1;

					y += 1;
					repaint();
				}
				JOptionPane.showMessageDialog(null, "Su destino Paris - Madrid ha finalizado");
			} else if (in.getCiudad().get(0).toString().equals("Lima")
					&& in.getLlegada().get(0).toString().equals("Bogota")) {
				long start = System.currentTimeMillis();
				double end = start + 3 * 1000;
				while (System.currentTimeMillis() < end) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					x += 1;

					y += 1;
					repaint();
				}
				JOptionPane.showMessageDialog(null, "Su destino Lima - Bogota ha finalizado");
			} else if (in.getCiudad().get(0).toString().equals("Lima")
					&& in.getLlegada().get(0).toString().equals("Paris")) {
				long start = System.currentTimeMillis();
				double end = start + 9 * 1000;
				while (System.currentTimeMillis() < end) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					x += 1;

					y += 1;
					repaint();
				}
				JOptionPane.showMessageDialog(null, "Su destino Lima - Paris ha finalizado !");
			} else if (in.getCiudad().get(0).toString().equals("Lima")
					&& in.getLlegada().get(0).toString().equals("Santiago de Chile")) {
				long start = System.currentTimeMillis();
				double end = start + 6 * 1000;
				while (System.currentTimeMillis() < end) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					x += 1;

					y += 1;
					repaint();
				}
				JOptionPane.showMessageDialog(null, "Su destino Lima - Santiago de chile ha finalizado !");
			} else if (in.getCiudad().get(0).toString().equals("Santiago de Chile")
					&& in.getLlegada().get(0).toString().equals("Bogota")) {
				long start = System.currentTimeMillis();
				double end = start + 10 * 1000;
				while (System.currentTimeMillis() < end) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					x += 1;

					y += 1;
					repaint();
				}
				JOptionPane.showMessageDialog(null, "Su destino Santiago de Chile - Bogota ha finalizado !");
			} else if (in.getCiudad().get(0).toString().equals("Santiago de Chile")
					&& in.getLlegada().get(0).toString().equals("Lima")) {
				long start = System.currentTimeMillis();
				double end = start + 6 * 1000;
				while (System.currentTimeMillis() < end) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					x += 1;

					y += 1;
					repaint();
				}
				JOptionPane.showMessageDialog(null, "Su destino Satiango de Chile - Lima ha finalizado");
			}

		}

	}
}
