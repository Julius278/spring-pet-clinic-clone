package com.julius.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseEntityTest {

    BaseEntity base;

    @BeforeEach
    void setUp(){
        base = new BaseEntity();
    }

    @Test
    void getId() {
        Long id = 1234L;
        base.setId(id);

        assertEquals(base.getId(), id);
    }
}