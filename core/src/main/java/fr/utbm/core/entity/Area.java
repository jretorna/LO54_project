package fr.utbm.core.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="area")
public class Area implements java.io.Serializable {

	/*--------------*/
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "Are_Id")
	private int areId;
	@Column(name = "Are_Label")
	private String areLabel;
	@Column(name = "Are_Road")
	private String areRoad;
	/*@OneToMany(mappedBy = "area", targetEntity = Station.class,fetch=FetchType.LAZY)
	private List<Station> stations;*/
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

	public void setAreId(final int areId) {
		this.areId = areId;
	}

	public String getAreLabel() {
		return areLabel;
	}

	public void setAreLabel(final String areLabel) {
		this.areLabel = areLabel;
	}

	public String getAreRoad() {
		return areRoad;
	}

	public void setAreRoad(final String areRoad) {
		this.areRoad = areRoad;
	}

}
