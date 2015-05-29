package fr.utbm.core.controller;

import fr.utbm.core.service.TemperatureService;

public class TemperatureController implements TemperatureControllerInterface {

	/*------------------------*/
	private TemperatureService temperatures;
	/*------------------------*/

	public TemperatureService getTemperaturec() {
		return temperatures;
	}

	public void setTemperaturec(final TemperatureService temperatures) {
		this.temperatures = temperatures;
	}

	@Override
	public void setParameterDirectly() {
		// TODO Auto-generated method stub

	}

}
