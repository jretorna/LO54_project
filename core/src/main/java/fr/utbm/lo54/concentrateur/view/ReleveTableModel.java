package fr.utbm.lo54.concentrateur.view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * @version 01.00.00
 *
 * @author Jeremy - V01.00.00
 * @date 25 mai 2015<br>
 *
 */
public class ReleveTableModel extends AbstractTableModel {

	/*------------------*/
	private static final long serialVersionUID = 1L;
	private final String[] entetes = {"areaId", "areaName", "sensorId",
			"sensorName", "temperature"};
	private ReleveService releveService;
	private List<Releve> mapReleve;
	/*------------------*/

	public ReleveTableModel() {
		releveService = ReleveService.getInstance();
		mapReleve = releveService.findLastReleve();
	}

	public List<Releve> getReleves() {
		return mapReleve;
	}

	@Override
	public int getColumnCount() {
		return entetes.length;
	}

	@Override
	public String getColumnName(final int columnIndex) {
		return entetes[columnIndex];
	}

	@Override
	public int getRowCount() {
		return mapReleve.size();
	}
	@Override
	public Object getValueAt(final int rowIndex, final int columnIndex) {
		switch (columnIndex) {
		/* areaId */
			case 0 :
				return mapReleve.get(rowIndex).getAreaId();
				/* areaName */
			case 1 :
				return mapReleve.get(rowIndex).getReleve().getAreaName();
				/* sensorId */
			case 2 :
				return mapReleve.get(rowIndex).getReleve().getSensorId();
				/* sensorName */
			case 3 :
				return mapReleve.get(rowIndex).getReleve().getSensorName();
				/* temperature value */
			case 4 :
				return mapReleve.get(rowIndex).getReleve().getTempVal();
			default :
				throw new IllegalArgumentException();
		}
	}

}
