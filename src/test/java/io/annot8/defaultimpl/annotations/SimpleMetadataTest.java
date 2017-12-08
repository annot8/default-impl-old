package io.annot8.defaultimpl.annotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import io.annot8.core.annotations.Metadata;

public class SimpleMetadataTest {
	@Test
	public void test() {
		Metadata md1 = new SimpleMetadata();
		md1.setKey("test_key_1");
		md1.setValue(Integer.valueOf(42));
		assertNotNull(md1.getId());
		assertEquals("test_key_1", md1.getKey());
		assertEquals(42, md1.getValue());
		
		Metadata md2 = new SimpleMetadata("test_key_2", "Hello, World!");
		assertNotNull(md2.getId());
		assertEquals("test_key_2", md2.getKey());
		assertEquals("Hello, World!", md2.getValue());
		
		assertNotEquals(md1.getId(), md2.getId());
		
		Metadata md3 = new SimpleMetadata("test_key_1", Integer.valueOf(42));
		assertEquals(md1, md3);
		assertEquals(md1.hashCode(), md3.hashCode());
		
		assertFalse(md1.equals("Test"));
		assertNotEquals(new SimpleMetadata("test_key_1", 52), md1);
		assertNotEquals(new SimpleMetadata("test_key_3", 42), md1);
		assertNotNull(md1.toString());
	}
}
