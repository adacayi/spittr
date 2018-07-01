package com.sanver.trials.spittr;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Spitter {
	private static long lastId = 0;
	private static Object lockObject = new Object();
	private Long id;
	@NotNull
	@Size(min = 5, max = 16)
	private String username;
	@NotNull
	@Size(min = 5, max = 25)
	private String password;
	@NotNull
	@Size(min = 2, max = 30)
	private String firstName;
	@NotNull
	@Size(min = 2, max = 30)
	private String lastName;

	// We need this no argument constructor for Spring MVC to generate an instance
	// of it when trying to bind form value.
	public Spitter() {

	}

	public Spitter(String userName, String password, String firstName, String lastName) {
		synchronized (lockObject) {
			this.id = lastId;
			lastId++;
		}
		this.username = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Spitter(long id, String userName, String password, String firstName, String lastName) {
		this.id = id;
		this.username = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this, that, "id", "time");
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "id", "time");
	}
}