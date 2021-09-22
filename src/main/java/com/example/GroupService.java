package com.example;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class GroupService {

	List<ItemRange> findItemsForGroup(String id) {
		ItemRange r1 = new ItemRange() {
			{
				name = "range 1";
				first = 1;
				last = 10;
			}
		};
		return Arrays.asList(r1);
	}
}
