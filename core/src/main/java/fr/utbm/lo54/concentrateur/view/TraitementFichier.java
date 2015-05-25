package fr.utbm.lo54.concentrateur.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class TraitementFichier {

	public void save(final Releve _rel) {
		FileWriter writer;
		try {
			String file = "C:\\Users\\Jeremy\\Documents\\releve.txt";
			writer = new FileWriter(file, true);
			int rowCount = getRowCount(file);
			if (rowCount != -95) {
				/*
				 * Si on a moins de 10 lignes dans le fichier, on ajoute à la
				 * suite, sinon on efface la premiere ligne, on remonte les 9
				 * autres d'une ligne et on ajoute le nouveau releve
				 */
				if (rowCount > 10) {
					removeFirstLineInFile(file);
				}
				/* On écrit */
				writer.write(_rel.getAreaId() + ";" + _rel.getAreaName() + ";"
						+ _rel.getSensorId() + ";" + _rel.getSensorName() + ";"
						+ _rel.getTempVal()
						+ System.getProperty("line.separator"));
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Releve> read(final String _file) {
		List<Releve> releveList = new ArrayList<Releve>();
		try {
			InputStream ips = new FileInputStream(_file);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne = br.readLine()) != null) {
				Releve rel = new Releve();
				if (releveList != null) {
					String[] tabChaine = ligne.split(";");
					rel.setAreaId(Integer.parseInt(tabChaine[0]));
					rel.setAreaName(tabChaine[1]);
					rel.setSensorId(Integer.parseInt(tabChaine[2]));
					rel.setSensorName(tabChaine[3]);
					rel.setTempVal(Float.parseFloat(tabChaine[4]));
					releveList.add(rel);
				}
				ligne = null;
				rel = null;
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
		return releveList;
	}
	/*-------------------------------------*/

	private int getRowCount(final String file) {
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			LineNumberReader l = new LineNumberReader(new BufferedReader(
					new InputStreamReader(fis)));
			int count = 0;
			while ((l.readLine()) != null) {
				count = l.getLineNumber();
			}
			return count;
		} catch (FileNotFoundException e1) {
			// TODO JR Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO JR Auto-generated catch block
			e.printStackTrace();
		}
		return -95; // Default value
	}

	private void removeFirstLineInFile(final String _file) {
		try {

			File file = new File(_file);
			RandomAccessFile tools = new RandomAccessFile(file, "rw"); // read-write
			tools.readLine(); // goto second line
			long length = tools.length() - tools.getFilePointer(); // except
																	// first
																	// line
			byte[] nexts = new byte[(int) length];
			tools.readFully(nexts); // read the others
			tools.seek(0); // return to start
			tools.write(nexts); // insert just 1 line before
			tools.setLength(nexts.length); // truncate the last duplicated line
			tools.close(); // flush all

		} catch (Exception error) {
			error.printStackTrace();
		}
	}
}