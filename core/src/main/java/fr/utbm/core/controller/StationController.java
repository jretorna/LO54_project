package fr.utbm.core.controller;

import fr.utbm.core.service.StationService;

public class StationController implements StationControllerInterface {

	/*---------------------*/
	private StationService stations;
	/*---------------------*/

	public StationService getStations() {
		return stations;
	}

	public void setStationc(final StationService stations) {
		this.stations = stations;
	}

	@Override
	public void setParameterDirectly() {
		// TODO Auto-generated method stub

	}

}
