package fr.utbm.core.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.txw2.annotation.XmlElement;

@Entity
@Table(name="area")
@XmlRootElement
public class Area implements java.io.Serializable {

	/*--------------*/
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Are_Id")
	private int areId;
	@Column(name = "Are_Label")
	private String areLabel;
	@Column(name = "Are_Road")
	private String areRoad;
	@OneToMany(mappedBy = "area", targetEntity = Station.class,fetch=FetchType.LAZY)
	private List<Station> stations;
	/*--------------*/
	/**
	 * Défault constructor
	 */
	public Area() {
		// Do nothing
	}

	/**
	 * Constructor
	 * 
	 * @param _areId
	 * @param _areLabel
	 * @param _areRoad
	 */
	public Area(final int _areId, final String _areLabel, final String _areRoad) {
		areId = _areId;
		areLabel = _areLabel;
		areRoad = _areRoad;
	}

	/*--------- Getters & Setters ---------*/

	public int getAreId() {
		return areId;
	}
	
	@XmlElement
	public void setAreId(final int areId) {
		this.areId = areId;
	}

	public String getAreLabel() {
		return areLabel;
	}

	@XmlElement
	public void setAreLabel(final String areLabel) {
		this.areLabel = areLabel;
	}

	public String getAreRoad() {
		return areRoad;
	}

	@XmlElement
	public void setAreRoad(final String areRoad) {
		this.areRoad = areRoad;
	}

}
