package io.annot8.defaultimpl.annotations;

import java.util.UUID;

import io.annot8.core.annotations.Annotation;

/**
 * Abstract annotation class which implements ID assignation and retrieval
 */
public abstract class AbstractAnnotation implements Annotation{
	private final UUID id;
	
	/**
	 * Create a new AbstractAnnotation with a random UUID
	 */
	public AbstractAnnotation() {
		id = UUID.randomUUID();
	}
	
	/**
	 * Create a new AbstractAnnotation with a specified UUID
	 * 
	 * @param id
	 * 		The UUID to assign to this class
	 */
	public AbstractAnnotation(UUID id) {
		this.id = id;
	}
	
	@Override
	public UUID getId() {
		return id;
	}
}
