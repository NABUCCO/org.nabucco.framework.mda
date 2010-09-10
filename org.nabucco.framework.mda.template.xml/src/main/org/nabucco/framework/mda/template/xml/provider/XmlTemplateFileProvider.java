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
package org.nabucco.framework.mda.template.xml.provider;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.nabucco.framework.mda.model.ModelException;
import org.nabucco.framework.mda.model.xml.XmlModel;
import org.nabucco.framework.mda.model.xml.XmlModelLoader;
import org.nabucco.framework.mda.template.xml.XmlTemplate;
import org.nabucco.framework.mda.template.xml.XmlTemplateException;

/**
 * XmlTemplateProvider
 * 
 * @author Nicolas Moser
 */
public class XmlTemplateFileProvider implements XmlTemplateProvider {

    private String searchRoot;

    private XmlModelLoader xmlLoader;

    private final Map<String, String> templateFileMap = new HashMap<String, String>();

    /**
     * Creates a new XML template provider instance.
     * 
     * @param root
     *            the search root either a directory or a zip file.
     * 
     * @throws XmlTemplateException
     */
    public XmlTemplateFileProvider(String root) throws XmlTemplateException {
        this.searchRoot = root;
        this.xmlLoader = new XmlModelLoader();

        this.initTemplateFiles();
    }

    /**
     * Initializes the template files.
     * 
     * @throws XmlTemplateException
     */
    private void initTemplateFiles() throws XmlTemplateException {

        File rootFile = new File(this.searchRoot);

        if (!rootFile.isDirectory() && !XmlTemplateFileFilter.getInstance().isArchive(rootFile)) {
            throw new XmlTemplateException(
                    "Cannot initialize XML template provider. Root is not a directory.");
        }

        XmlTemplateFileVisitor fileVisitor = new XmlTemplateFileVisitor(this.templateFileMap);
        try {
            fileVisitor.visit(rootFile, XmlTemplateFileFilter.getInstance());
        } catch (IOException e) {
            throw new XmlTemplateException("Error collecting XML templates.", e);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.nabucco.framework.mda.template.xml.provider.XmlTemplateProvider#provideTemplate(java.lang
     * .String)
     */
    @Override
    public XmlTemplate provideTemplate(String id) throws XmlTemplateException {

        String content = this.templateFileMap.get(id);

        if (content == null) {
            throw new XmlTemplateException("XML Template does not exist: " + id);
        }

        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(content.getBytes());
            XmlModel model = this.xmlLoader.loadModel(bais);
            return new XmlTemplate(model);
        } catch (ModelException me) {
            throw new XmlTemplateException("Error loading XML model ", me);
        }
    }

}
