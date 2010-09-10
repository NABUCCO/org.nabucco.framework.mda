/*
 * Copyright 2010 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco-source.org/nabucco-license.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.framework.mda.model.uml;

import java.io.File;

import org.eclipse.uml2.uml.internal.impl.ModelImpl;
import org.junit.Assert;
import org.junit.Test;
import org.nabucco.framework.mda.model.ModelException;
import org.nabucco.framework.mda.model.uml.UmlModel;
import org.nabucco.framework.mda.model.uml.UmlModelLoader;

/**
 * UmlModelLoaderTest
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class UmlModelLoaderTest {

    @Test
    public void testLoadModel() throws ModelException {

        UmlModelLoader loader = new UmlModelLoader();

        UmlModel umlModel = loader.loadModel(new File("conf/template/uml/sample.uml"));

        Assert.assertNotNull(umlModel);
        Assert.assertNotNull(umlModel.getModel());
        Assert.assertSame(ModelImpl.class, umlModel.getModel().getClass());
    }

}
