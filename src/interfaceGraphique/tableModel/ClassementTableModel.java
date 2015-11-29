package interfaceGraphique.tableModel;

import java.util.ArrayList;

import interfaceGraphique.view.VuePersonnage;
import serveur.element.Caracteristique;

/**
 * TableModel du classement a la fin de la partie. 
 *
 */
public class ClassementTableModel extends AbstractElementTableModel<VuePersonnage> {

	private static final long serialVersionUID = -476363672825620047L;
	
	public ClassementTableModel() {
		colonnes = new ArrayList<InformationColonne<VuePersonnage>>();
		indexNom = 1;
		
		// position dans le classement
		colonnes.add(new InformationColonne<VuePersonnage>("Classmt", 60, Integer.class, 
				new IValeurColonne<VuePersonnage>() {
					@Override
					public Object valeurColonne(int rowIndex, VuePersonnage vue) {
						return rowIndex + 1;
					}
				}
		)); 
		
		// nom du personnage (index 1)
		colonnes.add(new InformationColonne<VuePersonnage>("Nom", 0, String.class, new ValeurColonneNom()));
		
		// groupe du personnage
		colonnes.add(new InformationColonne<VuePersonnage>("Groupe", 0, String.class, new ValeurColonneGroupe()));
		
		// caracteristiques
		for(Caracteristique car : Caracteristique.values()) {
			colonnes.add(new InformationColonne<VuePersonnage>(car.toString(), 40, Integer.class, new ValeurColonneCaract(car)));
		}
		
		// leader du personnage
		colonnes.add(new InformationColonne<VuePersonnage>("Leader", 47, String.class, new ValeurColonneLeader())); 
		
		// equipe du personnage
		colonnes.add(new InformationColonne<VuePersonnage>("Equipe", 150, String.class, new ValeurColonneEquipe())); 
	}
}
