package com.salesmore.yak.integration.shopee.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractModelTest {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    static {
        System.setProperty("log4j.configurationFile","./log4j.xml");
    }
}
