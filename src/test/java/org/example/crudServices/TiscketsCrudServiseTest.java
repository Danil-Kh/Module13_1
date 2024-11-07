package org.example.crudServices;

import org.example.PlanetNullExceptions;
import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.entity.Ticket;
import org.hibernate.PropertyValueException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;


import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;


class TiscketsCrudServiseTest {
    TiscketsCrudServise ticketsCrudServise = new TiscketsCrudServise();
    Client client;
    Timestamp timestamp;
    ClientCrudService clientCrudService;
    PlanetCrudService planetCrudService;
    Ticket ticketExpected;
    Ticket ticket;
    Calendar calendar;
    @BeforeEach
    void setUp(){
        calendar = Calendar.getInstance();
        timestamp = new Timestamp(calendar.getTimeInMillis() / 1000 * 1000);
        planetCrudService = new PlanetCrudService();
        ticketExpected =new Ticket();
        client = new Client();
        clientCrudService = new ClientCrudService();
    }


    @Test
    void readPlanetSuccessfullyTest(){ //TO DO: Дописать медот обработки даты
        int id = 10;
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.NOVEMBER, 7, 22, 9, 54);
        Timestamp timestamp = new Timestamp(calendar.getTimeInMillis() / 1000 * 1000);

        client = clientCrudService.getClient(10);

        ticket = ticketsCrudServise.readTicket(id);
        ticketExpected.setTicketId(10);
        ticketExpected.setCreatedAt(timestamp);
        ticketExpected.setClient(client);
        ticketExpected.setToPlanetId(planetCrudService.getPlanetName("MAKEMAKE1"));
        ticketExpected.setFromPlanet(planetCrudService.getPlanetName("HAUMEA1"));

        Assertions.assertNotNull(ticket);
        Assertions.assertEquals(ticketExpected, ticket);
    }

    @Test
    void updatePlanetSuccessfullyTest(){
            int id = 11;

            calendar.set(2024, Calendar.NOVEMBER, 7, 22, 9, 54);
            client = clientCrudService.getClient(11);

            ticketExpected.setTicketId(11);
            ticketExpected.setCreatedAt(timestamp);
            ticketExpected.setClient(client);
            ticketExpected.setToPlanetId(planetCrudService.getPlanetName("MAKEMAKE1"));
            ticketExpected.setFromPlanet(planetCrudService.getPlanetName("HAUMEA1"));

            ticketsCrudServise.updateTicket(ticketExpected);

            ticket = ticketsCrudServise.readTicket(id);

            Assertions.assertNotNull(ticket);
            Assertions.assertEquals(ticketExpected, ticket);


    }
    @Test
    void deletePlanetSuccessfullyTest(){
        int id = 12;
        Assertions.assertDoesNotThrow(() -> ticketsCrudServise.deleteTicket(id));
    }
    @Test
    void createTicketSuccessfullyTest(){
        client = clientCrudService.getClient(11);

        ticketExpected.setCreatedAt(timestamp);
        ticketExpected.setClient(client);
        ticketExpected.setToPlanetId(planetCrudService.getPlanetName("MAKEMAKE1"));
        ticketExpected.setFromPlanet(planetCrudService.getPlanetName("HAUMEA1"));


        Assertions.assertDoesNotThrow(() -> ticketsCrudServise.createTicket(ticketExpected));


    }
    @Test
    void notCreateTicketNullClient(){
        ticketExpected.setCreatedAt(timestamp);
        ticketExpected.setClient(null);
        ticketExpected.setToPlanetId(planetCrudService.getPlanetName("MAKEMAKE1"));
        ticketExpected.setFromPlanet(planetCrudService.getPlanetName("HAUMEA1"));

        Assertions.assertThrows(PropertyValueException.class, () -> ticketsCrudServise.createTicket(ticketExpected));

    }
    @Test
    void notCreateTicketNullPlanet(){
        client = clientCrudService.getClient(11);
        ticketExpected.setCreatedAt(timestamp);
        ticketExpected.setClient(client);
        ticketExpected.setToPlanetId(null);
        ticketExpected.setFromPlanet(null);

       Assertions.assertThrows(PlanetNullExceptions.class, () -> ticketsCrudServise.createTicket(ticketExpected));

    }
}