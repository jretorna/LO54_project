package fr.utbm.core.controller;

import fr.utbm.core.service.SensorService;

public class SensorController implements SensorControllerInterface {

	/*------------------*/
	private SensorService sensors;
	/*------------------*/

	@Override
	public void setParameterDirectly() {
		// TODO Auto-generated method stub

	}

	public SensorService getSensors() {
		return sensors;
	}

	public void setSensorc(final SensorService sensors) {
		this.sensors = sensors;
	}

}
