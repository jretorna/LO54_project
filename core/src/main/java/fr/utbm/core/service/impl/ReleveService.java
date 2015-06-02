package fr.utbm.core.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.utbm.core.dao.IDaoCRUD;
import fr.utbm.core.entity.Area;
import fr.utbm.core.entity.Sensor;
import fr.utbm.core.entity.Station;
import fr.utbm.core.entity.Temperature;
import fr.utbm.core.ressource.Releve;
import fr.utbm.core.service.IReleveService;

@Service
public class ReleveService implements IReleveService {
	
	private IDaoCRUD<Station, Integer> daoStation;
	private IDaoCRUD<Area, Integer> daoArea;
	private IDaoCRUD<Temperature, Integer> daoTemperature;
	private IDaoCRUD<Sensor, Integer> daoSensor;

	/**
	 * Getters setter daoStation
	 * @return
	 */

	public IDaoCRUD<Station, Integer> getDaoStation() {
		return daoStation;
	}

	@Autowired
	public void setDaoStation(IDaoCRUD<Station, Integer> daoStation) {
		this.daoStation = daoStation;
	}
	
	/**
	 * Getters setter daoArea
	 * @return
	 */

	public IDaoCRUD<Area, Integer> getDaoArea() {
		return daoArea;
	}
	
	@Autowired
	public void setDaoArea(IDaoCRUD<Area, Integer> daoArea) {
		this.daoArea = daoArea;
	}

	/**
	 * Getters setter daoTemperature
	 * @return
	 */
	public IDaoCRUD<Temperature, Integer> getDaoTemperature() {
		return daoTemperature;
	}

	@Autowired
	public void setDaoTemperature(IDaoCRUD<Temperature, Integer> daoTemperature) {
		this.daoTemperature = daoTemperature;
	}
	
	/**
	 * Getters setter daoSensor
	 * @return
	 */

	public IDaoCRUD<Sensor, Integer> getDaoSensor() {
		return daoSensor;
	}

	@Autowired
	public void setDaoSensor(IDaoCRUD<Sensor, Integer> daoSensor) {
		this.daoSensor = daoSensor;
	}

	@Override
	public void addArea(Area area) {
		daoArea.register(area);
	}

	@Override
	public void addStation(Station station) {
		daoStation.register(station);
	}

	@Override
	public void addSensor(Sensor sensor) {
		daoSensor.register(sensor);	
	}

	@Override
	public void addTemperature(Temperature temp) {
		daoTemperature.register(temp);
	}

	@Override
	public void deleteTemperature(Temperature temp) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 
	 * @param fileBytes
	 * @return
	 */
	public String saveFile(byte[] fileBytes) {
		
		try {
			
            // Creating the directory to store file
            String rootPath = System.getProperty("catalina.home");
            File dir = new File(rootPath + File.separator + "releves");
            if (!dir.exists())
                dir.mkdirs();
            
           DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd HH_mm_ss");
     	   //get current date time with Date()
     	   Date date = new Date();
     	   System.out.println();

            // Create the file on server
     	    String name = "releve_"+dateFormat.format(date)+".xml";
     	    
            File serverFile = new File(dir.getAbsolutePath()
                    + File.separator + name);
            
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
            
            stream.write(fileBytes);
            stream.close();

            //logger.info("Server File Location="+ serverFile.getAbsolutePath());

            return serverFile.getAbsolutePath();
            
        } catch (Exception e) {
            return "You failed to upload =>  "+ e.getMessage();
        }
	}
	
	public Releve jaxbGet(String releveXmlFileFullName) {
		
		try {
			 
			File file = new File(releveXmlFileFullName);
			JAXBContext jaxbContext = JAXBContext.newInstance(Releve.class);
	 
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			
			return (Releve) jaxbUnmarshaller.unmarshal(file);
			
	 
		  } catch (JAXBException e) {
			e.printStackTrace();
		  }
		
		return null;
	 
	}
	
	public String jaxbSerialiseReleve(Releve releve, String rootPath) {
		
		try {
			 
			File dir = new File(rootPath + File.separator + "releves");
			if (!dir.exists())
                dir.mkdirs();
			
			File file = new File(dir.getAbsolutePath()+ File.separator + "releve.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Releve.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	 
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	 
			jaxbMarshaller.marshal(releve, file);
			
			return file.getAbsolutePath();
	 
	      } catch (JAXBException e) {
	    	  e.printStackTrace();
	      }
		
		return "";
		
	}

	@Override
	public void registerReleve(Releve releve) {
		Area area = daoArea.get(Area.class, releve.getAreaId());
		if(area == null) {
			area = new Area();
			area.setAreLabel(releve.getAreaName());
			area.setAreRoad("");
			
			daoArea.register(area);
		}
		
		Station station = daoStation.get(Station.class, releve.getStaId());
		
		if(station == null) {
			
			station = new Station();
			
			station.setStaLabel(releve.getStaLabel());
			station.setArea(area);
			
			daoStation.register(station);
		}
		
		Sensor sensor = daoSensor.get(Sensor.class, releve.getSensorId());
		
		if(sensor == null) {
			
			sensor = new Sensor();
			
			sensor.setSenLabel(releve.getSensorName());
			sensor.setStation(station);
			
			daoSensor.register(sensor);
			
		}
		
		Temperature temp = new Temperature();
		temp.setTmpValue(releve.getTempVal());
		temp.setTmpDate(new Date());
		temp.setSensor(sensor);
		
		daoTemperature.register(temp);
		
		
	}

	
}
