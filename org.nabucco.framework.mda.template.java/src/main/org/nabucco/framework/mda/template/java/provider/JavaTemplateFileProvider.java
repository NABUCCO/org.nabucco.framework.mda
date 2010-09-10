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
package org.nabucco.framework.mda.template.java.provider;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.nabucco.framework.mda.model.ModelException;
import org.nabucco.framework.mda.model.java.JavaModel;
import org.nabucco.framework.mda.model.java.JavaModelLoader;
import org.nabucco.framework.mda.template.java.JavaTemplate;
import org.nabucco.framework.mda.template.java.JavaTemplateException;

/**
 * JavaTemplateProvider
 * 
 * @author Nicolas Moser PRODYNA AG
 */
public class JavaTemplateFileProvider implements JavaTemplateProvider {

    private String searchRoot;

    private JavaModelLoader javaLoader;

    private final Map<String, String> templateFileMap = new HashMap<String, String>();

    /**
     * Creates a new Java template provider instance.
     * 
     * @param root
     *            the search root either a directory or a zip file.
     * 
     * @throws JavaTemplateException
     */
    public JavaTemplateFileProvider(String root) throws JavaTemplateException {
        this.searchRoot = root;
        this.javaLoader = new JavaModelLoader();

        this.initTemplateFiles();
    }

    /**
     * Initializes the template files.
     * 
     * @throws JavaTemplateException
     */
    private void initTemplateFiles() throws JavaTemplateException {

        File root = new File(this.searchRoot);

        if (!root.isDirectory() && !JavaTemplateFileFilter.getInstance().isArchive(root)) {
            throw new JavaTemplateException(
                    "Cannot initialize Java template provider. Template directory does not exist or is no directory ["
                            + root + "].");
        }

        try {
            JavaTemplateFileVisitor fileVisitor = new JavaTemplateFileVisitor(this.templateFileMap);
            fileVisitor.visit(root, JavaTemplateFileFilter.getInstance());
        } catch (IOException e) {
            throw new JavaTemplateException("Error collecting java templates.", e);
        }
    }

    @Override
    public JavaTemplate provideTemplate(String id) throws JavaTemplateException {

        String content = this.templateFileMap.get(id);

        if (content == null) {
            throw new JavaTemplateException("Java Template does not exist: " + id);
        }

        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(content.getBytes());
            JavaModel model = this.javaLoader.loadModel(bais);
            return new JavaTemplate(model);
        } catch (ModelException me) {
            throw new JavaTemplateException("Error loading Java model ", me);
        }
    }
}
