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
package org.nabucco.framework.mda.template.java;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

import org.nabucco.framework.mda.logger.MdaLogger;
import org.nabucco.framework.mda.logger.MdaLoggingFactory;
import org.nabucco.framework.mda.model.MdaModelType;
import org.nabucco.framework.mda.model.java.JavaModel;
import org.nabucco.framework.mda.template.MdaTemplateLoader;
import org.nabucco.framework.mda.template.java.provider.JavaTemplateProvider;

/**
 * JavaTemplateLoader
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class JavaTemplateLoader extends MdaTemplateLoader<JavaModel> implements
        JavaTemplateConstants {

    private static MdaLogger logger = MdaLoggingFactory.getInstance().getLogger(
            JavaTemplateLoader.class);

    /** Template provider must be exchangable for different executors */
    private static JavaTemplateProvider templateProvider;

    /** Cached templates */
    private final Map<String, SoftReference<JavaTemplate>> templateMap = new HashMap<String, SoftReference<JavaTemplate>>();

    /**
     * Singleton instance.
     */
    private static JavaTemplateLoader instance = new JavaTemplateLoader();

    /**
     * Private constructor.
     */
    private JavaTemplateLoader() {
        super(MdaModelType.JAVA);
    }

    /**
     * Singleton access.
     * 
     * @return the JavaTemplateLoader instance.
     */
    public static JavaTemplateLoader getInstance() {
        return instance;
    }

    @Override
    public synchronized JavaTemplate loadTemplate(String templateName) throws JavaTemplateException {

        if (this.templateMap.get(templateName) == null
                || this.templateMap.get(templateName).get() == null) {

            if (templateProvider == null) {
                logger.error("Java template provider is not configured!");
                return null;
            }

            JavaTemplate template = templateProvider.provideTemplate(templateName);
            SoftReference<JavaTemplate> reference = new SoftReference<JavaTemplate>(template);
            this.templateMap.put(templateName, reference);
        }

        return this.templateMap.get(templateName).get();
    }

    /**
     * Sets the template provider instace for the template loader.
     * 
     * @param templateProvider
     *            the Java template provider
     */
    public void setTemplateProvider(JavaTemplateProvider templateProvider) {
        if (templateProvider != null) {
            JavaTemplateLoader.templateProvider = templateProvider;
            JavaTemplateLoader.getInstance().clearCache();
        }
    }

    private void clearCache() {
        for (SoftReference<JavaTemplate> reference : this.templateMap.values()) {
            reference.clear();
        }
        this.templateMap.clear();
    }

}
