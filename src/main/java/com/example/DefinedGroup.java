/**
 * 
 */
package com.example;

import java.util.List;

/**
 * @author Steve Huston
 *
 */
public class DefinedGroup extends Group {

	private String name;
	private List<ItemRange> items;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ItemRange> getItems() {
		return items;
	}
	public void setItems(List<ItemRange> items) {
		this.items = items;
	}

}
