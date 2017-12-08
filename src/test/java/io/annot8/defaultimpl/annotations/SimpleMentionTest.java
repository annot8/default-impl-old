package io.annot8.defaultimpl.annotations;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import io.annot8.core.annotations.Mention;

public class SimpleMentionTest {
	@Test
	public void test() {
		Mention m = new SimpleMention();
		assertNotNull(m);
	}
}
