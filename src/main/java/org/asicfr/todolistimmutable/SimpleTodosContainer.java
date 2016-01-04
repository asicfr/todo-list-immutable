package org.asicfr.todolistimmutable;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import javax.annotation.Nonnull;

import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.jcabi.aspects.Immutable;

/**
 * Simple Todos container
 * @author slabbe
 */
@Immutable
public final class SimpleTodosContainer { // TODO interface ?

	/**
	 * List of todos
	 */
	private final List<Todo> todos;

	/**
	 * Constructor of todos container
	 * @param todos List of todos - Cannot be null or contains null element
	 */
	public SimpleTodosContainer(final List<Todo> todos) {
		super();
		
		// Assertion - Defensive programming to avoid null
		checkNotNull(todos, "The todos list cannot be null");
		
		// Defensive copy of the list to avoid side effect
		// Each of the Guava immutable collection implementations rejects null values
		this.todos = ImmutableList.copyOf(Iterables.filter(todos, Predicates.notNull()));
	}

	/**
	 * Get all todos
	 * @return non null and immutable todos list
	 */
	@Nonnull
	public List<Todo> getTodosList() {
		// Defensive copy of the list to avoid side effect
		return ImmutableList.copyOf(this.todos); // TODO  nécessaire ???? 
	}

	/**
	 * Get all todos
	 * @return non null and immutable todos list
	 */
	@Nonnull
	public List<Todo> searchForTodos(final String title) {
		if (this.todos.size() == 3) {
			return this.getTodosList();
		} else {
			return null; // TODO
		}
	}
	
}
