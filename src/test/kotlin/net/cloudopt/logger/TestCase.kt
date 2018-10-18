/*
 * Copyright 2017 Cloudopt.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *
 *  The Eclipse Public License is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  The Apache License v2.0 is available at
 *  http://www.opensource.org/licenses/apache2.0.php
 *
 *  You may elect to redistribute this code under either of these licenses.
 */
package net.cloudopt.logger

import org.junit.Test

/*
 * @author: Cloudopt
 * @Time: 2018/1/9
 * @Description: Test Case
 */
class TestCase {

    private val logger = Logger.getLogger(TestCase::class.java)

    @Test
    fun example1() {
        logger.debug("Start init....")
        logger.info("Operation successful!")
        logger.warn("The value must be not nul.")
        logger.error("Unable to acquire lock!")
    }

    @Test
    fun example2() {
        logger.info("Please Wait.... ${Colorer.blue("100")}")
        logger.info("Please Wait.... ${Colorer.yellow("200")}")
        logger.info("Please Wait.... ${Colorer.red("300")}")
    }
}
