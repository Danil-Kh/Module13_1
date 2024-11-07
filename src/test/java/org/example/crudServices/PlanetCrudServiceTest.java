package org.example.crudServices;

import org.example.entity.Planet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class PlanetCrudServiceTest {
    private PlanetCrudService service;
    private Planet planetExpected;

    @BeforeEach
    void setUp(){
        service = new PlanetCrudService();
        planetExpected = new Planet();
    }

    @Test
    void readPlanetSuccessfullyTest(){

        String id = "MARS1";
        planetExpected.setId(id);
        planetExpected.setName("Mars");

        Planet planetResult = service.getPlanetName(id);

        Assertions.assertNotNull(planetResult);
        Assertions.assertEquals(planetExpected, planetResult);
    }
    @Test
    void CreatePlanetSuccessfullyTest(){
        planetExpected.setId("MARSFGD1223");
        planetExpected.setName("Mars");
        Assertions.assertDoesNotThrow(() -> service.createPlanet(planetExpected));

    }
    @Test
    void UpdatePlanetSuccessfullyTest(){
        planetExpected.setId("MARS2");
        planetExpected.setName("Mars12");
        Assertions.assertDoesNotThrow(() -> service.updatePlanet(planetExpected));

    }
    @Test
    void DeletePlanetSuccessfullyTest(){
        planetExpected.setId("MAR123");
        planetExpected.setName("Mars");
        service.createPlanet(planetExpected);
        Assertions.assertDoesNotThrow(() -> service.deletePlanet(planetExpected.getId()));

    }



}