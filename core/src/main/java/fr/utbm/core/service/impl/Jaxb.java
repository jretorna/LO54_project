package fr.utbm.core.service.impl;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

@Service
public class Jaxb<C> implements IJaxb<C> {
	
	@SuppressWarnings("unchecked")
	@Override
	public C jaxbGet(String releveXmlFileFullName, Class<C> className) {
		
		try {
			 
			File file = new File(releveXmlFileFullName);
			JAXBContext jaxbContext = JAXBContext.newInstance(className);
	 
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			
			return (C) jaxbUnmarshaller.unmarshal(file);
			
	 
		  } catch (JAXBException e) {
			e.printStackTrace();
		  }
		
		return null;
	 
	}
	
	/* (non-Javadoc)
	 * @see fr.utbm.core.service.impl.IJaxB#jaxbSerialiseReleve(fr.utbm.core.ressource.Releve, java.lang.String)
	 */
	@Override
	public String jaxbSerialiseObject(C objClass, Class<C> className, String dirPath, String fileName) {
		
		try {
			 
			File dir = new File(dirPath); //new File(rootPath + File.separator + "releves");
			
			if (!dir.exists())
                dir.mkdirs();
			
			File file = new File(dir.getAbsolutePath()+ File.separator + fileName +".xml");//new File(dir.getAbsolutePath()+ File.separator + "releve.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(className);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	 
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	 
			jaxbMarshaller.marshal(objClass, file);
			
			return file.getAbsolutePath();
	 
	      } catch (JAXBException e) {
	    	  e.printStackTrace();
	      }
		
		return "";
		
	}
}

