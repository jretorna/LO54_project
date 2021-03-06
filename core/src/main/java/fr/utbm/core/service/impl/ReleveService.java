package fr.utbm.core.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.utbm.core.dao.IDaoCRUD;
import fr.utbm.core.dao.TemperatureDao;
import fr.utbm.core.entity.Area;
import fr.utbm.core.entity.Sensor;
import fr.utbm.core.entity.Station;
import fr.utbm.core.entity.Temperature;
import fr.utbm.core.ressource.Releve;
import fr.utbm.core.ressource.ReleveParameter;
import fr.utbm.core.ressource.ReleveQueryResult;
import fr.utbm.core.service.IReleveService;

@Service
public class ReleveService implements IReleveService {

	private static String rootPathParam = "/Users/mac/Desktop";

	private IDaoCRUD<Station, Integer> daoStation;
	private IDaoCRUD<Area, Integer> daoArea;
	private TemperatureDao daoTemperature;
	private IDaoCRUD<Sensor, Integer> daoSensor;
	private IJaxb<Releve> jaxbService;
	private IJaxb<ReleveParameter> jaxbParamService;

	public IJaxb<ReleveParameter> getJaxbParamService() {
		return jaxbParamService;
	}

	@Autowired
	public void setJaxbParamService(final IJaxb<ReleveParameter> jaxbParamService) {
		this.jaxbParamService = jaxbParamService;
	}

	public IJaxb<Releve> getJaxbService() {
		return jaxbService;
	}

	@Autowired
	public void setJaxbService(final IJaxb<Releve> jaxbService) {
		this.jaxbService = jaxbService;
	}

	/**
	 * Getters setter daoStation
	 * 
	 * @return
	 */

	public IDaoCRUD<Station, Integer> getDaoStation() {
		return daoStation;
	}

	@Autowired
	public void setDaoStation(final IDaoCRUD<Station, Integer> daoStation) {
		this.daoStation = daoStation;
	}

	/**
	 * Getters setter daoArea
	 * 
	 * @return
	 */

	public IDaoCRUD<Area, Integer> getDaoArea() {
		return daoArea;
	}

	@Autowired
	public void setDaoArea(final IDaoCRUD<Area, Integer> daoArea) {
		this.daoArea = daoArea;
	}

	/**
	 * Getters setter daoTemperature
	 * 
	 * @return
	 */
	public IDaoCRUD<Temperature, Integer> getDaoTemperature() {
		return daoTemperature;
	}

	@Autowired
	public void setDaoTemperature(final TemperatureDao daoTemperature) {
		this.daoTemperature = daoTemperature;
	}

	/**
	 * Getters setter daoSensor
	 * 
	 * @return
	 */

	public IDaoCRUD<Sensor, Integer> getDaoSensor() {
		return daoSensor;
	}

	@Autowired
	public void setDaoSensor(final IDaoCRUD<Sensor, Integer> daoSensor) {
		this.daoSensor = daoSensor;
	}

	@Override
	public void addArea(final Area area) {
		daoArea.register(area);
	}

	@Override
	public void addStation(final Station station) {
		daoStation.register(station);
	}

	@Override
	public void addSensor(final Sensor sensor) {
		daoSensor.register(sensor);
	}

	@Override
	public void addTemperature(final Temperature temp) {
		daoTemperature.register(temp);
	}

	@Override
	public void deleteTemperature(final Temperature temp) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * @param fileBytes
	 * @return
	 */
	public String saveFile(final byte[] fileBytes) {

		try {

			// Creating the directory to store file
			String rootPath = System.getProperty("catalina.home");
			File dir = new File(rootPath + File.separator + "releves");
			if (!dir.exists())
				dir.mkdirs();

			DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd HH_mm_ss");
			// get current date time with Date()
			Date date = new Date();
			// Create the file on server
			String name = "releve_" + dateFormat.format(date) + ".xml";

			File serverFile = new File(dir.getAbsolutePath() + File.separator
					+ name);

			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(serverFile));

			stream.write(fileBytes);
			stream.close();

			// logger.info("Server File Location="+
			// serverFile.getAbsolutePath());

			return serverFile.getAbsolutePath();

		} catch (Exception e) {
			return "You failed to upload =>  " + e.getMessage();
		}
	}

	@Override
	public void registerReleve(final Releve releve) {

		String rootPath = System.getProperty("catalina.home");

		ReleveParameter param = jaxbParamService.jaxbGet(rootPath
				+ File.separator + "param/param.xml", ReleveParameter.class);

		Temperature temp = releve.getTemperature();
		if (!isCorrectTemperature(temp.getTmpValue(), param.getTempMin(),
				param.getTempMax())) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd HH_mm_ss");
			jaxbService.jaxbSerialiseObject(releve, Releve.class, rootPath
					+ File.separator + "relevesOut",
					"releve" + dateFormat.format(new Date()));
		} else {

			Area area = daoArea.get(Area.class, releve.getArea().getAreId());

			if (area == null) {
				area = releve.getArea();

				daoArea.register(area);
			}

			Station station = daoStation.get(Station.class,
					releve.getStation().getStaId());

			if (station == null) {

				station = releve.getStation();

				station.setArea(area);

				daoStation.register(station);
			}

			Sensor sensor = daoSensor.get(Sensor.class,
					releve.getSensor().getSenId());

			if (sensor == null) {

				sensor = releve.getSensor();

				sensor.setStation(station);

				daoSensor.register(sensor);

			}

			temp.setTmpDate(new Date());
			temp.setSensor(sensor);

			daoTemperature.register(temp);

		}

	}

	@Override
	public List<ReleveQueryResult> listReleve() {
		// TODO Auto-generated method stub
		return daoTemperature.listFullTemperatureCollect();
	}

	@Override
	public List<ReleveQueryResult> listReleveByFilter(	final Float flt_min,
														final Float flt_max,
														final String date_deb,
														final String date_fin,
														final String station,
														final String area,
														final String capteur) {
		// TODO Auto-generated method stub
		return daoTemperature.listTemperatureByFilter(flt_min, flt_max,
				date_deb, date_fin, station, area, capteur);
	}

	@Override
	public Releve jaxbGet(final String releveXmlFileFullName) {

		return jaxbService.jaxbGet(releveXmlFileFullName, Releve.class);
	}

	@Override
	public String jaxbSerialiseReleve(final Releve releve, final String rootPath) {
		// TODO Auto-generated method stub
		return jaxbService.jaxbSerialiseObject(releve, Releve.class, rootPath
				+ File.separator + "releves", "releve");

	}

	@Override
	public String jaxbSerialiseParam(final ReleveParameter releveParam) {

		return jaxbParamService.jaxbSerialiseObject(releveParam,
				ReleveParameter.class, rootPathParam, "param");

	}

	public boolean isCorrectTemperature(final float tmp,
										final int tmpMin,
										final int tmpMax) {
		return tmp > tmpMin && tmp < tmpMax;
	}

}
