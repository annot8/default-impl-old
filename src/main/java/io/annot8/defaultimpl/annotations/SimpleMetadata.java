package io.annot8.defaultimpl.annotations;

import java.util.Objects;

import io.annot8.core.annotations.Metadata;

/**
 * Simple implementation of a {@link Metadata} annotation, storing the key and value in memory
 */
public class SimpleMetadata extends AbstractAnnotation implements Metadata {
	private String key;
	private Object value;

	/**
	 * Default (empty) constructor)
	 * 
	 * Use of this constructor should be avoided, as it is expected that
	 * they key and value will always be set.
	 * This is intended only for use when the annotation is being created
	 * via reflection.
	 */
	public SimpleMetadata() {
		//Empty constructor
	}
	
	/**
	 * Construct a new annotation with a given key and value
	 * 
	 * @param key
	 * 		Metadata key
	 * @param value
	 * 		Metadata value
	 */
	public SimpleMetadata(String key, Object value) {
		this.key = key;
		this.value = value;
	}
	
	/**
	 * Get the key for this annotation
	 */
	public String getKey() {
		return key;
	}
	/**
	 * Set the key for this annotation
	 * 
	 * @param key
	 * 		Metadata key
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Get the value for this annotation
	 */
	public Object getValue() {
		return value;
	}
	/**
	 * Set the value for this annotation
	 * 
	 * @param value
	 * 		Metadata value
	 */
	public void setValue(Object value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Metadata ("+key+" = "+value+")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Metadata))
				return false;
		
		Metadata md = (Metadata) obj;
		return Objects.equals(key,  md.getKey()) && Objects.equals(value, md.getValue());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(key, value);
	}
}
