import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.asicfr.todolistimmutable.Event;
import org.asicfr.todolistimmutable.Event.TypeEvent;
import org.asicfr.todolistimmutable.SimpleTodosContainer;
import org.asicfr.todolistimmutable.Todo;
import org.asicfr.todolistimmutable.TodoMutable;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test class of TodoList.
 */
@RunWith(MockitoJUnitRunner.class)
public class TodoListTest {

    @Test
    public void testTodoMutableWithImmutableAnnotation_shouldFailed() {
    	try {
    		TodoMutable todoM = new TodoMutable("todo1");
			Assert.fail("Il devrait etre impossible d'instancier cette classe taguée avec l'annotation immutable");
		} catch (IllegalStateException e) {
			// we must have an exception
			e.printStackTrace();
		}

    	
    }

    @Test
    public void testTodoListBasicBehavior_shouldSucceed() {
    	Date now = new Date();
    	Event event = new Event("me", TypeEvent.CREATION, now);
    	List<Event> events = new ArrayList<>();
    	events.add(event);
    	
    	Todo todo1 = new Todo("todo1", false, events);
    	Todo todo2 = new Todo("todo2", true, events);
    	Todo todo3 = new Todo("todo3", false, Collections.EMPTY_LIST);
    	List<Todo> todos = Arrays.asList(todo1, todo2, todo3);
    	SimpleTodosContainer container = new SimpleTodosContainer(todos);
    	assertTrue("comportement normal avec 3 todo dans la liste", container.getTodosList().size() == 3);
    	
    	/*
    	 l'utilisation est plus simple car tous les objets etant immutables, on peut prendre 
    	 des raccourcis, notamment sur l'evenement de creation, identique quelque soit les todos.
    	 on est sur de ne pas avoir d'effet de bord en partageant le meme objet.
    	 */
    }

    @Test
    public void testEventImmutablity_shouldSucceed() {
    	final Date now = new Date();
    	final long nowTime = now.getTime();
    	final long timeOther = 1450450000000l;

    	Event event = new Event("me", TypeEvent.CREATION, now);
    	assertTrue("la date de l'evenement est celle passée en parametre", event.getDateEvent().getTime() == nowTime);
    	
    	// modify the now argument after creation
		now.setTime(timeOther);
    	assertTrue("la date de l'evenement est toujours celle passée en parametre", event.getDateEvent().getTime() == nowTime);
    	
    	// try to hack the date of the event
    	event.getDateEvent().setTime(timeOther);
    	assertTrue("la date de l'evenement est toujours celle passée en parametre", event.getDateEvent().getTime() == nowTime);
    }

    @Test
    public void testTodoImmutablity_shouldSucceed() {
    	Date now = new Date();
    	Event event = new Event("me", TypeEvent.CREATION, now);
    	List<Event> events = new ArrayList<>();
    	events.add(event);
    	Todo todo = new Todo("todo1", false, events);
    	
    	assertTrue("comportement normal avecun todo et un event", todo.getHistorics().size() == 1);
    	
    	try {
			Event event2 = new Event("me2", TypeEvent.CREATION, now);
			todo.getHistorics().add(event2);
			Assert.fail("Il devrait etre impossible de modifier la liste des events apres creation");
		} catch (UnsupportedOperationException e) {
			// we must have an exception
		}
    }

    @Test
    public void testTodosListImmutablity_shouldSucceed() {
    	Date now = new Date();
    	Event event = new Event("me", TypeEvent.CREATION, now);
    	List<Event> events = new ArrayList<>();
    	events.add(event);
    	
    	Todo todo1 = new Todo("todo1", false, events);
    	Todo todo2 = new Todo("todo2", true, events);
    	Todo todo3 = new Todo("todo3", false, Collections.EMPTY_LIST);
    	List<Todo> todos = Arrays.asList(todo1, todo2, todo3);
    	SimpleTodosContainer container = new SimpleTodosContainer(todos);
    	assertTrue("comportement normal avec 3 todo dans la liste", container.getTodosList().size() == 3);
    	
    	try {
    		Todo todoOther = new Todo("todo1", false, events);
    		container.getTodosList().add(todoOther);
			Assert.fail("Il devrait etre impossible de modifier la liste des todos apres creation");
		} catch (UnsupportedOperationException e) {
			// we must have an exception
		}
    }
    
    
    
    
    
    // TODO verifier les asserts ...
    
    // TODO verifier l'immutabilité
    
}
