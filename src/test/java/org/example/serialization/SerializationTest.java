package org.example.serialization;

import org.example.protobuf.AddressBookProtos;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SerializationTest {

    @Test
    void test() {
        AddressBookProtos.Person person1 = AddressBookProtos.Person.newBuilder()
                .setEmail("truongvantuan@outlook.com.vn")
                .setName("Tuan")
                .setId(8989)
                .addNumbers("0973949816")
                .build();

        AddressBookProtos.Person person2 = AddressBookProtos.Person.newBuilder()
                .setEmail("truongvantuan@outlook.com.vn")
                .setName("EmTai")
                .setId(6666)
                .addNumbers("0973949866")
                .build();

        AddressBookProtos.AddressBook addressBook = AddressBookProtos.AddressBook.newBuilder()
                .addPerson(person1)
                .addPerson(person2)
                .build();


        FileOutputStream fos = null;

        File outputFile = new File(System.getProperty("user.dir") + "/fileoutput/fileoutputstream.txt");

        try {
            fos = new FileOutputStream(outputFile);
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }

        try {
            person1.writeTo(fos);
            addressBook.writeTo(fos);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
