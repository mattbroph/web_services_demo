package com.mattbroph.persistence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwapiDaoTest {

    @Test
    void getPlanet() {

        SwapiDao swapiDao = new SwapiDao();

        assertEquals("Tatooine", swapiDao.getPlanet().getName());



    }
}