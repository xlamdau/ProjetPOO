package interfaceGraphique.uiSimple.components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import serveur.element.Caracteristique;

public class DetailCaracteristique extends JPanel {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Barre de la caractéristique
	 */
	private Barre barre;
	/**
	 * Label de la caracteristique
	 */
	private JLabel label;
	

	public DetailCaracteristique(Caracteristique caract, int valeur, Color color) {
		
		Color couleur = color;
		int valeurUtilisee = valeur; // cette valeur sert à ramener toutes les valeurs sur 100 pour que les barres chargent à la même vitesse
		switch(caract){
			case FORCE : couleur = Color.RED; 
					     break;
			case VIE : couleur = Color.GREEN; 
					   break;
			case VITESSE : couleur = Color.ORANGE;
						   valeurUtilisee = 25 * valeur; // on ramène à 100
						   break;
			case INITIATIVE : couleur = Color.CYAN;
							  valeurUtilisee = valeur / 10; // on ramène à 100
							  break;
			case ARGENT : couleur = Color.YELLOW; 
						  valeurUtilisee = valeur / 10; // on ramène à 100
						  break;
		}
		
		barre = new Barre(valeurUtilisee, couleur);		
		barre.setMaximum(100);
		barre.setMinimum(caract.min);
        barre.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        barre.setPreferredSize(new Dimension(250,20));
        label = new JLabel();
        
        label.setText(caract.fullName()+" : " + valeur + "/"+caract.max);
        label.setPreferredSize(new Dimension(150,20));
        
        this.add(barre);
        this.add(label);
		
	}

	public void go() {
		barre.smoothLoad();
	}
}
