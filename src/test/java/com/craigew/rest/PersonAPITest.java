package com.craigew.rest;


import com.craigew.model.Person;
import junit.framework.Assert;
import org.junit.Test;

public class PersonAPITest {

    @Test
    public void should_return_a_greeting(){
        Assert.assertEquals("{\"greeting\":\"Hello world\"}",new PersonApi().sayHello().toString());
    }

    @Test
    public void should_return_a_greeting_to_someone(){
        Assert.assertEquals("Hello Craig", new PersonApi().sayHelloToSomeone("Craig").getResponse());
    }

    @Test
    public void should_create_a_person(){
        Person person=new Person();
        person.setName("Craig");
        person.setSurname("Williams");
        Assert.assertEquals("Craig Williams added to the database",new PersonApi().createAPerson(person).getResponse());
    }

    @Test
    public void should_update_a_person(){
        Person person=new Person();
        person.setName("Craig");
        person.setSurname("Williams");
        Assert.assertEquals("Craig Williams with id 1 updated in the database",new PersonApi().updateAPerson(1,person).getResponse());
    }

    @Test
    public void should_delete_a_person(){
         Assert.assertEquals("1 removed from the database",new PersonApi().removeAPerson(1).getResponse());
    }
}
