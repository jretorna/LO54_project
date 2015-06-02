package fr.utbm.lo54.concentrateur.view;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 01.00.00
 *
 * @author Jeremy - V01.00.00
 * @date 25 mai 2015<br>
 *
 */
public class ReleveService {
	/*-------------------------*/
	private static ReleveService instance;
	private List<Releve1> mapReleve;
	/*-------------------------*/

	private ReleveService() {

	}

	public static synchronized ReleveService getInstance() {
		if (instance == null) {
			instance = new ReleveService();
		}
		return instance;
	}

	public synchronized List<Releve1> findLastReleve() {
		chargerDatas();
		return mapReleve;
	}

	private void chargerDatas() {
		if (mapReleve != null) {
			return;
		}
		final TraitementFichier fileTraitement = new TraitementFichier();
		mapReleve = fileTraitement.read("C:\\Users\\Jeremy\\Documents\\releve.txt");

		/* ------ TESTS ------- */
		if (mapReleve == null) {
			mapReleve = new ArrayList<Releve1>();
		}

		Runnable run1 = new Runnable() {
			@Override
			public void run() {
				int i = 1;
				Float temp = 50.0f;
				Releve1 rel1 = new Releve1();
				while (true) {
					rel1.setAreaId(i);
					rel1.setAreaName("Super");
					rel1.setSensorId(i);
					rel1.setSensorName("SensorMM");
					rel1.setTempVal(temp);
					/*- Save -*/
					mapReleve.add(rel1);
					fileTraitement.save(rel1);
					/* - Increase variables - */
					i++;
					temp += 10.0f;
					/* - Wait 2 sec - */
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO JR Auto-generated catch block
						e.printStackTrace();
					}
					// TODO JR retirer ce com
					System.out.println("Nouveau relevé");
				}
			}
		};
		new Thread(run1, "lancement ajout Releve1").start();
		/*----------------------------*/
	}
}
