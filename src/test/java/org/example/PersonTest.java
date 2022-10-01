package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.example.protobuf.PersonOuterClass;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class PersonTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
       String name = "tuan";
        PersonOuterClass.Person person = PersonOuterClass.Person.newBuilder()
                .setName(name)
                .build();

        assertEquals(person.getName(), name);
    }
}
