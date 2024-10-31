package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClientCrudServiceTest {

    private ClientCrudService service;
    private Client clientExpected;

    @BeforeEach
    void setUp(){
        service = new ClientCrudService();
        clientExpected = new Client();
    }
    @Test
    void readClientSuccessfullyTest(){
        Client clientInput;
        clientExpected.setId(10);
        clientExpected.setName("Jack White");
        clientInput = service.getClient(10);

        Assertions.assertNotNull(clientExpected);
        Assertions.assertEquals(clientExpected, clientInput);
    }
    @Test
    void CreateClientSuccessfullyTest(){
        clientExpected.setName("Danil");
        Assertions.assertDoesNotThrow(() -> service.creatClient(clientExpected));

    }
    @Test
    void UpdateClientSuccessfullyTest(){
        clientExpected.setId(11);
        clientExpected.setName("Danil Urus");
        Assertions.assertDoesNotThrow(() -> service.updatePlanet(clientExpected));
        Assertions.assertEquals(clientExpected, service.getClient(11));

    }
    @Test
    void DeleteClientSuccessfullyTest(){
        clientExpected.setName("TestFor");

        Assertions.assertDoesNotThrow(() -> service.deleteClient(12));

    }
}