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
import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.nabucco.framework.mda.logger.MdaLogger;
import org.nabucco.framework.mda.logger.MdaLoggingFactory;
import org.nabucco.framework.mda.model.ModelLoader;
import org.nabucco.framework.mda.model.uml.produce.UmlModelProducer;

/**
 * UmlModelLoader
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class UmlModelLoader extends ModelLoader<UmlModel, File> {

    private static final String NS_URI = "http://www.eclipse.org/uml2/2.0.0/UML";

    private static MdaLogger logger = MdaLoggingFactory.getInstance().getLogger(
            UmlModelLoader.class);

    @Override
    public UmlModel loadModel(File modelFile) throws UmlModelException {

        if (modelFile == null) {
            return new UmlModel(UmlModelProducer.getInstance().createUmlModel(null));
        }

        try {
            Model model = getUmlRootModel(modelFile);

            UmlModel umlModel = new UmlModel(model);

            return umlModel;

        } catch (IOException e) {
            logger.error(e, "Canot load Template " + modelFile.getName());
            throw new UmlModelException("Cannot load Template " + modelFile.getName(), e);
        } catch (RuntimeException re) {
            logger.error(re, "Canot load Template " + modelFile.getName());
            throw new UmlModelException("Cannot load Template " + modelFile.getName(), re);
        }
    }

    /**
     * Extracts the root UML {@link Model} of an UML/XMI file.
     * 
     * @param modelFile
     *            the file to parse
     * 
     * @return the extracted root {@link Model}
     * 
     * @throws IOException
     */
    private Model getUmlRootModel(File modelFile) throws IOException {

        URI uri = URI.createURI(modelFile.toURI().toString());
        registerPathmaps(uri);

        ResourceSet resourceSet = new ResourceSetImpl();
        registerResourceFactories(resourceSet);

        registerFileExtensions(resourceSet);

        Resource resource = resourceSet.getResource(uri, true);
        EcoreUtil.resolveAll(resource);

        EList<EObject> contents = resource.getContents();

        return (Model) EcoreUtil.getObjectByType(contents, UMLPackage.Literals.MODEL);
    }

    /**
     * Registers UML path maps. When loading resources externally from Eclipse, your application
     * needs to perform these registration
     * 
     * @param uri
     *            the {@link URI} to register the path maps for
     */
    private void registerPathmaps(URI uri) {

        URIConverter.URI_MAP.put(URI.createURI(UMLResource.LIBRARIES_PATHMAP),
                uri.appendSegment("libraries").appendSegment(""));

        URIConverter.URI_MAP.put(URI.createURI(UMLResource.METAMODELS_PATHMAP),
                uri.appendSegment("metamodels").appendSegment(""));

        URIConverter.URI_MAP.put(URI.createURI(UMLResource.PROFILES_PATHMAP),
                uri.appendSegment("profiles").appendSegment(""));

        // The last appendSegement("") statement appends a trailing slash to the URI.
    }

    /**
     * Registers the UML and EMF resource factories. When loading resources externally from Eclipse,
     * your application needs to perform these registration.
     * 
     * @param resourceSet
     *            the resourceSet to register the resource factories for
     */
    private void registerResourceFactories(ResourceSet resourceSet) {

        Registry packageRegistry = resourceSet.getPackageRegistry();

        // register the UML package from org.eclipse.uml2
        UMLPackage umlPackage = UMLPackage.eINSTANCE;

        umlPackage.setNsURI(NS_URI);
        packageRegistry.put(NS_URI, umlPackage);

        // register the Ecore package from org.eclipse.emf
        packageRegistry.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
    }

    /**
     * Registers known UML, XMI, etc. file extensions.
     * 
     * @param resourceSet
     *            the resourceSet to register the file extensions for
     */
    private void registerFileExtensions(ResourceSet resourceSet) {

        // *.uml -> native Eclipse/UML2 resource
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
                .put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
    }
}
