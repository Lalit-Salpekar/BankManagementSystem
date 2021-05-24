package com.bms.registrationservice.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@CreationTimestamp
	@Column(name="created_on")
	protected LocalDateTime createdOn;

	@UpdateTimestamp
	@Column(name="updated_on")
	protected LocalDateTime updatedOn;

}
