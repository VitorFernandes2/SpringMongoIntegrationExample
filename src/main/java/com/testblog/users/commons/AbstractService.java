package com.testblog.users.commons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
}
