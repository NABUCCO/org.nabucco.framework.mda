/*
 * Copyright 2012 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.framework.mda.mda.logger;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.nabucco.framework.mda.logger.MdaLogger;
import org.nabucco.framework.mda.logger.MdaLoggingFactory;

/**
 * MdaLoggerFactoryTest
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class MdaLoggerFactoryTest {

    private static MdaLogger logger = MdaLoggingFactory.getInstance().getLogger(
            MdaLoggerFactoryTest.class);

    @BeforeClass
    public static void beforeClass() {
        Assert.assertNotNull(logger);
    }

    @Test
    public void testLoggerInfo() throws Exception {
        logger.info("info-", "test");
    }

    @Test
    public void testLoggerTrace() throws Exception {
        logger.trace("trace-", "test");
    }
}
