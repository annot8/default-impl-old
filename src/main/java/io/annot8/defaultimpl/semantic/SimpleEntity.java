package io.annot8.defaultimpl.semantic;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import io.annot8.core.annotations.Mention;
import io.annot8.core.semantic.Entity;

/**
 * Simple implementation of the {@link Entity} class, storing everything memory
 */
public class SimpleEntity implements Entity {
	private Set<Mention> mentions = new HashSet<>();
	private Map<String, Object> properties = new HashMap<>();
	private String type;
	private Object value;
	
	@Override
	public void addMention(Mention mention) {
		mentions.add(mention);
	}

	@Override
	public boolean removeMention(Mention mention) {
		return mentions.remove(mention);
	}

	@Override
	public Set<Mention> getMentions() {
		return mentions;
	}

	@Override
	public void setMentions(Set<Mention> mentions) {
		this.mentions = mentions;
	}

	@Override
	public void addMentions(Collection<Mention> mentions) {
		this.mentions.addAll(mentions);
	}

	@Override
	public void removeMentions(Collection<Mention> mentions) {
		this.mentions.removeAll(mentions);
	}

	@Override
	public boolean hasProperty(String key) {
		return properties.containsKey(key);
	}

	@Override
	public Optional<Object> getProperty(String key) {
		return Optional.ofNullable(properties.get(key));
	}

	@Override
	public Object getPropertyOrDefault(String key, Object defaultValue) {
		return properties.getOrDefault(key, defaultValue);
	}

	@Override
	public void setProperty(String key, Object value) {
		properties.put(key, value);
	}

	@Override
	public Optional<Object> removeProperty(String key) {
		return Optional.ofNullable(properties.remove(key));
	}

	@Override
	public Set<String> listPropertyKeys() {
		return properties.keySet();
	}

	@Override
	public Map<String, Object> getProperties() {
		return properties;
	}

	@Override
	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}

	@Override
	public void addProperties(Map<String, Object> properties) {
		this.properties.putAll(properties);
	}

	@Override
	public void removeProperties(Collection<String> keys) {
		keys.forEach(s -> properties.remove(s));
	}

	@Override
	public Optional<String> getType() {
		return Optional.ofNullable(type);
	}

	@Override
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public Optional<Object> getValue() {
		return Optional.ofNullable(value);
	}

	@Override
	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if(type != null)
			sb.append(type +"; ");
		if(value != null)
			sb.append(value +"; ");
		
		return "Entity ("+sb.toString() + mentions.size() + " mentions)";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Entity))
			return false;
	
		Entity e = (Entity) obj;
		return Objects.equals(type, e.getType().orElseGet(null)) &&
				Objects.equals(value, e.getValue().orElseGet(null)) &&
				Objects.equals(mentions, e.getMentions()) &&
				Objects.equals(properties, e.getProperties()); 
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(type, value, mentions, properties);
	}
}
