package io.annot8.defaultimpl.annotations;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import io.annot8.core.annotations.Span;

/**
 * Simple implementation of the {@link Span} annotation, storing everything memory and
 * using a {@link HashMap} to store the properties. 
 */
public class SimpleSpan extends AbstractAnnotation implements Span{
	private String type;
	private int begin = 0;
	private int end = 0;
	
	private Map<String, Object> properties = new HashMap<>();
	
	/**
	 * Default (empty) constructor)
	 */
	public SimpleSpan() {
		//Empty constructor
	}
	
	/**
	 * Construct a new annotation with the given type
	 */
	public SimpleSpan(String type) {
		this.type = type;
	}
	
	/**
	 * Construct a new annotation with the given begin and end offsets
	 */
	public SimpleSpan(int begin, int end) {
		this.begin = begin;
		this.end = end;
	}
	
	/**
	 * Construct a new annotation with the given type and offsets
	 */
	public SimpleSpan(String type, int begin, int end) {
		this.type = type;
		this.begin = begin;
		this.end = end;
	}
	
	/**
	 * Return the Span type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Set the Span type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Return the begin offset
	 */
	public int getBegin() {
		return begin;
	}

	/**
	 * Set the begin offset
	 */
	public void setBegin(int begin) {
		this.begin = begin;
	}

	/**
	 * Return the end offset
	 */
	public int getEnd() {
		return end;
	}

	/**
	 * Set the end offset
	 */
	public void setEnd(int end) {
		this.end = end;
	}
	
	/**
	 * Returns true if the Span has a property with the given key
	 */
	public boolean hasProperty(String key) {
		return properties.containsKey(key);
	}

	/**
	 * Return the property value for the specified key
	 */
	public Object getProperty(String key) {
		return properties.get(key);
	}
	
	/**
	 * Return the property value for the specified key, or a default value if the key doesn't have a stored value
	 */
	public Object getPropertyOrDefault(String key, Object defaultValue) {
		return properties.getOrDefault(key, defaultValue);
	}

	/**
	 * Set the property value for the specified key
	 */
	public void setProperty(String key, Object value) {
		properties.put(key, value);
	}

	/**
	 * Remove the property for the specified key, and return it's object
	 */
	public Object removeProperty(String key) {
		return properties.remove(key);
	}

	/**
	 * List the property keys currently set on this span
	 */
	public Set<String> listPropertyKeys() {
		return properties.keySet();
	}

	/**
	 * Return the underlying properties map
	 */
	public Map<String, Object> getProperties() {
		return properties;
	}

	/**
	 * Set the underlying properties map
	 */
	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}

	/**
	 * Add all properties from the given map to the existing map,
	 * overwriting values where they clash.
	 */
	public void addProperties(Map<String, Object> properties) {
		this.properties.putAll(properties);
	}

	/**
	 * Remove all properties that match keys in the given set of keys
	 */
	public void removeProperties(Set<String> keys) {
		keys.forEach(s -> properties.remove(s));
	}
	
	@Override
	public String toString() {
		return "Span ("+type+"; "+begin+"->"+end+")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Span))
				return false;
		
		Span s = (Span) obj;
		return Objects.equals(type, s.getType()) && begin == s.getBegin() && end == s.getEnd() && Objects.equals(properties, s.getProperties()); 
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(type, begin, end, properties);
	}
}
