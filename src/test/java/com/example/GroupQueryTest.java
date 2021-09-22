/**
 * 
 */
package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.jayway.jsonpath.DocumentContext;
import com.netflix.graphql.dgs.DgsQueryExecutor;
import com.netflix.graphql.dgs.autoconfig.DgsAutoConfiguration;


/**
 * @author Steve Huston
 *
 */

@SpringBootTest(classes = {
		DgsAutoConfiguration.class, GroupQuery.class, DefinedGroupResolver.class, GroupService.class
})
class GroupQueryTest {
	
	@Autowired
    private DgsQueryExecutor queryExecutor;

	@SuppressWarnings("unchecked")      // response.read() is an unchecked conversion
	@Test
	public void allGroups() throws Exception {
		final String query =
				"query {"
				+ "  groups {"
				+ "    __typename"
				+ "    label"
				+ "    ... on DefinedGroup { items { name first last } }"
				+ "  }"
				+ "}";

        DocumentContext response = queryExecutor.executeAndGetDocumentContext(query);
        assertNotNull(response);
        assertNull(response.read("errors"), "Errors present");
		List<Map<String, Object>> groups = response.read("data.groups", List.class);
        assertEquals(1, groups.size());

        List<Map<String, Object>> items = response.read("data.groups[0].items", List.class);
        assertEquals(1, items.size());
        assertEquals("10", (String)(items.get(0).get("first")));
        assertEquals("20", (String)(items.get(0).get("last")));
	}
}

