package com.store.service;

import com.store.controller.PersonController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductControllerTest {

    @Autowired
    private PersonController personController;
}
