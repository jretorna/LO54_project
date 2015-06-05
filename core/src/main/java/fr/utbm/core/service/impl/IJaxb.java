package fr.utbm.core.service.impl;

public interface IJaxb <C> {

	public abstract C jaxbGet(String releveXmlFileFullName, Class<C> className);

	public abstract String jaxbSerialiseObject(C objClass, Class<C> className, String dirPath, String fileName);

}
