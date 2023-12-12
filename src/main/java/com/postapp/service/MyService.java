package com.postapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    private static final Logger logger = LoggerFactory.getLogger(MyService.class);

    public void myMethod() {
        logger.debug("Ceci est un message de débogage.");
        logger.info("Ceci est un message d'information.");
        logger.error("Ceci est un message d'erreur.");
    }
}
