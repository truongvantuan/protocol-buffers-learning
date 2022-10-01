package org.example;

import com.google.protobuf.UninitializedMessageException;
import org.example.protobuf.AddressBookProtos;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddressBookProtosTest {

    public static final String NAME = "TruongTuan";
    public static final int ID = 888;
    public static final String EMAIL = "truongvantuan@outlook.com.vn";
    private static AddressBookProtos.Person person;

    @BeforeClass
    public static void beforeClass() throws Exception {
         person = AddressBookProtos.Person.newBuilder()
                .setName(NAME)
                .setId(ID)
                .setEmail(EMAIL)
                .build();
    }

    @Test
    public void addressBookProtosTest() {
        AddressBookProtos.Person person = AddressBookProtos.Person.newBuilder()
                .setName(NAME)
                .setId(ID)
                .setEmail(EMAIL)
                .build();

        Assert.assertEquals(person.getName(), NAME);
        Assert.assertEquals(person.getId(), ID);
        Assert.assertEquals(person.getEmail(), EMAIL);
    }

    @Test
    public void initObjectWithoutRequiredField_thenShouldBeException() {
        AddressBookProtos.Person.newBuilder()
                .setEmail(EMAIL)
                .build();

        UninitializedMessageException exception = assertThrows(UninitializedMessageException.class,
                () -> AddressBookProtos.Person.newBuilder().build());

        assertTrue(exception.getMessage().contains("Message missing required fields"));
    }

    @Test
    public void testBookAddressProtos() {
        AddressBookProtos.AddressBook addressBook = AddressBookProtos.AddressBook.newBuilder()
                .addPerson(person)
                .build();

        assertEquals(addressBook.getPerson(0), person, "Person should be equals!");
    }
}
