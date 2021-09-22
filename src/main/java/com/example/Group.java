/**
 * 
 */
package com.example;

/**
 * Group DTO
 * 
 * @author Steve Huston
 *
 */
public abstract class Group {

	/*
	 * These attributes are returned right out of the group service.
	 * They can be mapped directly between group DTO and this class.
	 */
	protected String label;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
