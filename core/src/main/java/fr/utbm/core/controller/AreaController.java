package fr.utbm.core.controller;

import fr.utbm.core.service.AreaService;

public class AreaController implements AreaControllerInterface {

	/*---------------------*/
	private AreaService areas;
	/*---------------------*/

	@Override
	public void setParameterDirectly() {

	}

	public AreaService getAreas() {
		return areas;
	}

	public void setAreas(final AreaService areas) {
		this.areas = areas;
	}
}
