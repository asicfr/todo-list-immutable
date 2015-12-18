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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test class of TodoList.
 */
@RunWith(MockitoJUnitRunner.class)
public class TodoListTest {

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
    }

    @Test
    public void testTodoListImmutablity_shouldSucceed() {
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
    }
    
    
    // TODO verifier les asserts ...
    
    // TODO verifier l'immutabilité
    
}
