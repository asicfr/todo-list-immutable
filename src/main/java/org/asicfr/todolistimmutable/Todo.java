package org.asicfr.todolistimmutable;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import javax.annotation.Nonnull;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.jcabi.aspects.Immutable;

/**
 * The todo simple implementation
 * @author slabbe
 */
@Immutable
public final class Todo {
	
	/**
	 * The title of todo
	 */
	private final String title;

	/**
	 * If the todo is done or not
	 */
	private final boolean done;
	
	/**
	 * All events of the todo
	 */
	private final List<Event> historics;

	/**
	 * Todo constructor
	 * @param title The title of todo - cannot be null or empty
	 * @param done If the todo is done or not
	 * @param historics All events of the todo - cannot be null
	 */
	public Todo(final String title, final boolean done, final List<Event> historics) {
		super();
		
		// Assertion - Defensive programming to avoid null
		checkArgument((Strings.isNullOrEmpty(title) == false), "The title cannot be null or empty");
		checkNotNull(historics, "The historics list cannot be null");
		
		// Direct assignment of immutable properties
		this.title = title;
		this.done = done;
		
		// Defensive copy of the list to avoid side effect
		// Each of the Guava immutable collection implementations rejects null values
		this.historics = ImmutableList.copyOf(historics);
	}

	/**
	 * Get the title
	 * @return the title
	 */
	@Nonnull
	public String getTitle() {
		return this.title;
	}

	/**
	 * Getif the todo is done or not
	 * @return if the todo is done or not
	 */
	@Nonnull
	public boolean isDone() {
		return this.done;
	}

	/**
	 * Get all events of the todo
	 * @return all events of the todo
	 */
	@Nonnull
	public List<Event> getHistorics() {
		// Defensive copy of the list to avoid side effect
		return ImmutableList.copyOf(this.historics); // TODO pas necessaire ???
	}
	
}
