/**
 * Copyright 2021 Collins Aerospace. All Rights Reserved.
 */

package com.example;

import java.util.Arrays;
import java.util.List;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;

/**
 * Query resolver to get group info.
 * 
 * @author Steve Huston
 *
 */
@DgsComponent
public class GroupQuery {

	@DgsQuery
	public List<Group> groups() {
		DefinedGroup group = new DefinedGroup();
		group.setLabel("group-id");
		return Arrays.asList(group);
    }

}
