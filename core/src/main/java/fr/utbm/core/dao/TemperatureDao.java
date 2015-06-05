package fr.utbm.core.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;

import fr.utbm.core.entity.Temperature;
import fr.utbm.core.ressource.ReleveQueryResult;

@Service
public class TemperatureDao extends DaoCRUD<Temperature, Integer> {
	
	@SuppressWarnings("unchecked")
	public List<ReleveQueryResult> listFullTemperatureCollect() {
		
		List<ReleveQueryResult> listReleve = null;
		
		Session session = this.getSessionFactory().openSession();
		
		try {
			
			session.beginTransaction();
			
			/*listReleve = session.createQuery("Select "
					+ "	area.areId "
					+ " from Temperature temperature "
					+ "	inner join temperature.sensor as sensor"
					+ "	inner join sensor.station as station"
					+ "	inner join station.area as area").setResultTransformer(Transformers.aliasToBean(ReleveQueryResult.class)).list();
			*/
			
			listReleve = session.createQuery("Select "
					+ "	are.areLabel as areaName,  are.areId as areaId,"
					+ " sta.staId as staId, sta.staLabel as staLabel,"
					+ " sen.senId as sensorId, sen.senLabel as sensorName,"
					+ " temp.tmpValue as tempVal"
					+ " from Temperature temp "
					+ "	inner join temp.sensor as sen"
					+ "	inner join sen.station as sta"
					+ "	inner join sta.area as are").setResultTransformer(Transformers.aliasToBean(ReleveQueryResult.class)).list();
			
			
			session.getTransaction().commit();
			//session.close();
			
		} catch (HibernateException he) {
			
			he.printStackTrace();
			if (session.getTransaction() != null) {
				try {
					session.getTransaction().rollback();
				} catch (HibernateException he2) {
					he2.printStackTrace();
				}
			}
			
		} finally {
			
			if (session != null) {
				try {
					session.close();
				} catch (HibernateException he) {
					he.printStackTrace();
				}
			}
			
		}
		
		
		return listReleve;
	}
}
