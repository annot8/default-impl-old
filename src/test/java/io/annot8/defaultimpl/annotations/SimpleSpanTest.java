package io.annot8.defaultimpl.annotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import io.annot8.core.annotations.Span;

public class SimpleSpanTest {
	@Test
	public void test() {
		Span s1 = new SimpleSpan();
		s1.setType("Test");
		s1.setBegin(5);
		s1.setEnd(10);
		
		Span s2 = new SimpleSpan(5, 10);
		s2.setType("Test");
		
		Span s3 = new SimpleSpan(5, 10, "Test");
		
		List<Span> spans = Arrays.asList(s1, s2, s3);
		for(Span s : spans) {
			assertNotNull(s.getId());
			assertEquals("Test", s.getType().get());
			assertEquals(5, s.getBegin());
			assertEquals(10, s.getEnd());
			
			assertEquals(s1, s);
			assertEquals(s1.hashCode(), s.hashCode());
		}
		
		assertNotEquals(s1.getId(), s2.getId());
		assertNotEquals(s1.getId(), s3.getId());

		assertNotEquals(new SimpleSpan(5, 10), s1);
		assertNotEquals(new SimpleSpan(5, 20, "Test"), s1);
		assertNotEquals(new SimpleSpan(0, 10, "Test"), s1);
		assertFalse(s1.equals("Test"));
		assertNotNull(s1.toString());
	}
	
	@Test
	public void testProperties() {
		Span s1 = new SimpleSpan();
		
		s1.setProperty("p1", Integer.valueOf(42));
		assertEquals(42, s1.getProperty("p1").get());
		assertTrue(s1.hasProperty("p1"));
		Set<String> keys = s1.listPropertyKeys();
		assertEquals(1, keys.size());
		assertTrue(keys.contains("p1"));
		assertEquals(42, s1.removeProperty("p1").get());
		assertFalse(s1.hasProperty("p1"));
		assertFalse(s1.getProperty("p1").isPresent());
		assertEquals(52, s1.getPropertyOrDefault("p1", Integer.valueOf(52)));
		assertTrue(s1.listPropertyKeys().isEmpty());
		
		s1.setProperty("p1", Integer.valueOf(1));
		Map<String, Object> newProps = new HashMap<>();
		newProps.put("p2", Integer.valueOf(2));
		newProps.put("p3", Integer.valueOf(3));
		newProps.put("p4", Integer.valueOf(4));
		
		s1.addProperties(newProps);
		
		assertEquals(4, s1.listPropertyKeys().size());
		assertTrue(s1.hasProperty("p1"));
		assertTrue(s1.hasProperty("p2"));
		assertTrue(s1.hasProperty("p3"));
		assertTrue(s1.hasProperty("p4"));
		
		Set<String> removeKeys = new HashSet<>();
		removeKeys.add("p2");
		removeKeys.add("p3");
		
		s1.removeProperties(removeKeys);
		
		assertEquals(2, s1.listPropertyKeys().size());
		assertTrue(s1.hasProperty("p1"));
		assertFalse(s1.hasProperty("p2"));
		assertFalse(s1.hasProperty("p3"));
		assertTrue(s1.hasProperty("p4"));
		
		s1.setProperties(newProps);
		assertFalse(s1.hasProperty("p1"));
		assertTrue(s1.hasProperty("p2"));
		assertTrue(s1.hasProperty("p3"));
		assertTrue(s1.hasProperty("p4"));
	}
}
