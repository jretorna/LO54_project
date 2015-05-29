package fr.utbm.core;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.utbm.core.controller.UserControllerInterface;

public class MainClass {
	public static void main(final String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"contextApplication.xml");
		// AreaControllerInterface areac = (AreaControllerInterface)
		// context.getBean("areaController");
		// StationControllerInterface stationc = (StationControllerInterface)
		// context.getBean("stationController");
		// SensorControllerInterface sensorc = (SensorControllerInterface)
		// context.getBean("sensorController");
		// TemperatureControllerInterface temperaturec =
		// (TemperatureControllerInterface)
		// context.getBean("temperatureController");
		UserControllerInterface userc = (UserControllerInterface) context.getBean("userController");
		userc.setParameterDirectly();
		// areac.setParameterDirectly();
		// stationc.setParameterDirectly();
		// sensorc.setParameterDirectly();
		// temperaturec.setParameterDirectly();
	}
}
