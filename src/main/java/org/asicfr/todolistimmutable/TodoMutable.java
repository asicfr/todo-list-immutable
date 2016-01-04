package org.asicfr.todolistimmutable;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.base.Strings;
import com.jcabi.aspects.Immutable;

/**
 * The todo simple mutable implementation
 * @author slabbe
 */
@Immutable
public final class TodoMutable {
	
	/**
	 * The title of todo
	 */
	private String title;

	/**
	 * Todo constructor
	 * @param title The title of todo - cannot be null or empty
	 */
	public TodoMutable(final String title) {
		super();
		
		// Assertion - Defensive programming to avoid null
		checkArgument((Strings.isNullOrEmpty(title) == false), "The title cannot be null or empty");
		
		// Direct assignment of immutable properties
		this.title = title;
	}

	/**
	 * Get the title
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}


	/**
	 * Set the title
	 * @param title the title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
}
