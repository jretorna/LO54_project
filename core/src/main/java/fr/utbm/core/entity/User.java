package fr.utbm.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements java.io.Serializable {
	/*--------------*/
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false)
	private Long userId;
	@Column(name = "username")
	private String userName;
	@Column(name = "active")
	private Boolean active;

	/*--------------*/

	/**
	 * Default Constructor
	 */
	public User() {
		// Do nothing
	}

	/**
	 * Constructor
	 */
	public User(final Long userId, final String userName, final Boolean active) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.active = active;
	}

	/*------- Getters & Setters ------*/

	public Long getUserId() {
		return userId;
	}

	public void setUserId(final Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(final String userName) {
		this.userName = userName;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(final Boolean active) {
		this.active = active;
	}

}
