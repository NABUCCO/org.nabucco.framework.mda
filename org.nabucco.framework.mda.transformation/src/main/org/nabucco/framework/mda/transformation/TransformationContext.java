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
package org.nabucco.framework.mda.transformation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.nabucco.framework.mda.template.MdaTemplate;
import org.nabucco.framework.mda.template.MdaTemplateException;

/**
 * TransformationContext
 * 
 * @author Frank Ratschinski, PRODYNA AG
 */
public class TransformationContext {

    private Map<String, MdaTemplate<?>> templateMap = new HashMap<String, MdaTemplate<?>>();

    /** Set of TransformationExceptions */
    private Set<TransformationException> exceptionSet = new HashSet<TransformationException>();

    private String rootDir;

    /**
     * Creates a transformation context with the root directory.
     * 
     * @param rootDir
     *            the component root directory
     */
    public TransformationContext(String rootDir) {
        this.rootDir = rootDir;
    }

    /**
     * Getter for the root directory.
     * 
     * @return Returns the rootDir.
     */
    public String getRootDir() {
        return this.rootDir;
    }

    /**
     * Adds a template to the context.
     * 
     * @param id
     *            the template id
     * @param template
     *            the template
     */
    public void putTemplate(String id, MdaTemplate<?> template) {
        this.templateMap.put(id, template);
    }

    /**
     * Getter for a template with the given id.
     * 
     * @param id
     *            the template id
     * 
     * @return the template
     */
    public MdaTemplate<?> getTemplate(String id) {
        return this.templateMap.get(id);
    }

    /**
     * Getter for the map of templates.
     * 
     * @return the template map
     */
    public Map<String, MdaTemplate<?>> getTemplateMap() {
        return new HashMap<String, MdaTemplate<?>>(this.templateMap);
    }

    /**
     * Adds an exception to the tranformation context. Exceptions during transformation should be
     * added here for synchonisation.
     * 
     * @param exception
     *            the exception to add
     */
    public void addException(TransformationException exception) {
        if (exception != null) {
            this.exceptionSet.add(exception);
        }
    }

    /**
     * Getter for the exceptionSet.
     * 
     * @return Returns the exceptionSet.
     */
    public Set<TransformationException> getException() {
        return new HashSet<TransformationException>(this.exceptionSet);
    }

    /**
     * Copy the transformation context.
     * 
     * @return the context copy
     * 
     * @throws TransformationException
     */
    public TransformationContext copyContext() throws TransformationException {
        TransformationContext copy = new TransformationContext(this.rootDir);

        try {
            for (Entry<String, MdaTemplate<?>> template : this.templateMap.entrySet()) {
                copy.putTemplate(template.getKey(), template.getValue().copyTemplate());
            }
        } catch (MdaTemplateException e) {
            throw new TransformationException("Error copying transformation context.");
        }

        return copy;
    }
}
