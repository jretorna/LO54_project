package fr.utbm.core.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
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
	
	@SuppressWarnings("unchecked")
	public List<ReleveQueryResult> listTemperatureByFilter(Float flt_min, 
															Float flt_max,
															String date_deb,
															String date_fin,
															String station,
															String area,
															String capteur) {
		
		List<ReleveQueryResult> listReleve = null;
		
		Session session = this.getSessionFactory().openSession();
		
		try {
			
			session.beginTransaction();
			
			Query reqList;
			
			Boolean siAddWhere = false;
			
			String reqHSQL = "Select "
					+ "	are.areLabel as areaName,  are.areId as areaId,"
					+ " sta.staId as staId, sta.staLabel as staLabel,"
					+ " sen.senId as sensorId, sen.senLabel as sensorName,"
					+ " temp.tmpValue as tempVal"
					+ " from Temperature temp "
					+ "	inner join temp.sensor as sen"
					+ "	inner join sen.station as sta"
					+ "	inner join sta.area as are ";
			
			
			/**
			 * Filtrage par temperature min et max
			 */
			if(flt_max != null && flt_min != null) {
				
				if(!siAddWhere) reqHSQL += " where ";
				else reqHSQL += " and ";
				
				reqHSQL += " temp.tmpValue between :tmp_min and :tmp_max ";
				
			}
			
			/**
			 * Filtrage par date de collecte
			 */
			if(!date_deb.isEmpty() && !date_fin.isEmpty()) {
				
				if(!siAddWhere) reqHSQL += " where ";
						else reqHSQL += " and ";
				
				reqHSQL += " temp.tmpDate between :date_deb and :date_fin ";
				
			}
			
			/**
			 * Filtrage par station area capteur
			 */
			
			if(!station.isEmpty()) {
				
				if(!siAddWhere) reqHSQL += " where ";
				else reqHSQL += " and ";
				
				reqHSQL += " sta.staLabel = :station ";
				
			}
			
			if(!area.isEmpty()) {
				
				if(!siAddWhere) reqHSQL += " where ";
				else reqHSQL += " and ";
				
				reqHSQL += " are.areLabel = :area ";
				
			}
			
			if(!capteur.isEmpty()) {
				
				if(!siAddWhere) reqHSQL += " where ";
				else reqHSQL += " and ";
				
				reqHSQL += " sen.senLabel = :capteur ";
				
			}
			
			reqList = session.createQuery(reqHSQL);
			
			if(flt_max != null && flt_min != null) {
				reqList.setParameter("tmp_min", flt_min);
				reqList.setParameter("tmp_max", flt_max);
			}
			
			if(!date_deb.isEmpty() && !date_fin.isEmpty()) {
				
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	     	   
	     	    try {
	     	    	
	     	    	reqList.setParameter("date_deb", dateFormat.parse(date_deb));
					reqList.setParameter("date_fin", dateFormat.parse(date_fin));
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		     	    
				
			}
			
			if(!station.isEmpty()) {
				
				reqList.setParameter("station", station);
				
			}
			
			if(!area.isEmpty()) {
				
				reqList.setParameter("area", area);
				
			}
			
			if(!capteur.isEmpty()) {
				
				reqList.setParameter("capteur", capteur);
				
			}
					
					
			
			listReleve = reqList.setResultTransformer(Transformers.aliasToBean(ReleveQueryResult.class)).list();
			
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
