package org.asicfr.todolistimmutable;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Date;

import javax.annotation.Nonnull;

import com.google.common.base.Strings;
import com.jcabi.aspects.Immutable;

/**
 * Event on a todo
 * @author slabbe
 */
@Immutable
public final class Event { // TODO interface si besoin ???

	/**
	 * User responsible for the event
	 */
	private final String user;

	/**
	 * Type of the event
	 */
	private final TypeEvent typeEvent;
	
	/**
	 * Date of the event
	 */
	private final Date dateEvent;
	
	/**
	 * Event contructor
	 * @param user responsible for the event - cannot be null or empty
	 * @param typeEvent Type of the event - cannot be null
	 * @param dateEvent Date of the event - cannot be null
	 */
	public Event(final String user, final TypeEvent typeEvent, final Date dateEvent) {
		super();

		// Assertion - Defensive programming to avoid null
		checkArgument((Strings.isNullOrEmpty(user) == false), "The user cannot be null or empty");
		checkNotNull(typeEvent, "The type of the event cannot be null");
		checkNotNull(dateEvent, "The date of the event cannot be null");
		
		// Direct assignment of immutable properties
		this.user = user;
		this.typeEvent = typeEvent;
		
		// Defensive copy of the list to avoid side effect
		this.dateEvent = new Date(dateEvent.getTime());
	}

	/**
	 * Get the responsible for the event
	 * @return the responsible for the event
	 */
	@Nonnull
	public String getUser() {
		return this.user;
	}

	/**
	 * Get the type of the event
	 * @return the type of the event
	 */
	@Nonnull
	public TypeEvent getTypeEvent() {
		return this.typeEvent;
	}

	/**
	 * Get the date of the event
	 * @return the date of the event
	 */
	@Nonnull
	public Date getDateEvent() {
		// Defensive copy of the list to avoid side effect
		return new Date(this.dateEvent.getTime());
	}

	/**
	 * Enumeration of event types
	 * @author slabbe
	 */
	static public enum TypeEvent {
		CREATION,
		UPDATE,
		DONE;
	}
	
}
