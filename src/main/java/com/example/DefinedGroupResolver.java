/**
 * 
 */
package com.example;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;

/**
 * @author Steve Huston
 *
 */
@DgsComponent
public class DefinedGroupResolver {

	@Autowired
	private GroupService groupService;

	@DgsData(parentType = "DefinedGroup", field = "items")
	List<ItemRange> items(DgsDataFetchingEnvironment dfe) {
		DefinedGroup group = dfe.getSource();
		return groupService.findItemsForGroup(group.getLabel());
	}
}
