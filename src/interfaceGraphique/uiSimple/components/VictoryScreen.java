package interfaceGraphique.uiSimple.components;

import interfaceGraphique.view.VueElement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Panel de victoire
 *
 */
public class VictoryScreen extends JPanel {

	private static final long serialVersionUID = 1L;

	private String nom;

	private Color color;

	public VictoryScreen(VueElement vue) {
		nom = vue.getNom();
		color = vue.getColor();
	}

	public void paintComponent(Graphics g) {
		// Dessine un rectangle noir transparent de la taille de la fenêtre
		g.setColor(new Color(0, 0, 0, 0.5f));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		// Dessine le disque de la couleur du gagnant puis ajoute l'image par dessus
		g.setColor(new Color(color.getRGB(), false));
		g.fillOval(240, 160, 200, 200);
		Image logo;
		try {
			logo = ImageIO.read(new File("src/Images/WinScreen.png"));
			g.drawImage(logo, 50, 0, null);

		} catch (IOException e) {
			e.printStackTrace();
		}

		// Ajuste l'emplacement et la taille du nom en fonction du nombre de caractères.
		Font of = g.getFont();
		g.setColor(new Color(250, 179, 98));
		if (nom.length() >= 7) {
			g.setFont(new Font("Helvetica", Font.BOLD, 75));
			g.drawString(nom, 325 - (nom.length() * 18), 450);
		} else {
			g.setFont(new Font("Helvetica", Font.BOLD, 100));
			g.drawString(nom, 325 - (nom.length() * 25), 450);
			g.setFont(of);
		}
	}
}
