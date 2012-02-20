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
package org.nabucco.framework.mda.template.xml;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

import org.nabucco.framework.mda.logger.MdaLogger;
import org.nabucco.framework.mda.logger.MdaLoggingFactory;
import org.nabucco.framework.mda.model.MdaModelType;
import org.nabucco.framework.mda.model.xml.XmlModel;
import org.nabucco.framework.mda.template.MdaTemplateLoader;
import org.nabucco.framework.mda.template.xml.provider.XmlTemplateProvider;

/**
 * XmlTemplateLoader
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class XmlTemplateLoader extends MdaTemplateLoader<XmlModel> implements XmlTemplateConstants {

    private static MdaLogger logger = MdaLoggingFactory.getInstance().getLogger(
            XmlTemplateLoader.class);

    /** Template provider must be exchangeable for different executors */
    private static XmlTemplateProvider templateProvider;

    /** Cached templates */
    private final Map<String, SoftReference<XmlTemplate>> templateMap = new HashMap<String, SoftReference<XmlTemplate>>();

    /**
     * Singleton instance.
     */
    private static XmlTemplateLoader instance = new XmlTemplateLoader();

    /**
     * Private constructor.
     */
    private XmlTemplateLoader() {
        super(MdaModelType.XML);
    }

    /**
     * Singleton access.
     * 
     * @return the XmlTemplateLoader instance.
     */
    public static XmlTemplateLoader getInstance() {
        return instance;
    }

    @Override
    public synchronized XmlTemplate loadTemplate(String templateName) throws XmlTemplateException {

        if (this.templateMap.get(templateName) == null
                || this.templateMap.get(templateName).get() == null) {

            if (templateProvider == null) {
                logger.error("XML template provider is not configured!");
                return null;
            }

            XmlTemplate template = templateProvider.provideTemplate(templateName);
            SoftReference<XmlTemplate> reference = new SoftReference<XmlTemplate>(template);
            this.templateMap.put(templateName, reference);
        }

        return this.templateMap.get(templateName).get();
    }

    /**
     * Sets the template provider instance for the template loader.
     * 
     * @param templateProvider
     *            the XML template provider
     */
    public void setTemplateProvider(XmlTemplateProvider templateProvider) {
        if (templateProvider != null) {
            XmlTemplateLoader.templateProvider = templateProvider;
            XmlTemplateLoader.getInstance().clearCache();
        }
    }

    private void clearCache() {
        for (SoftReference<XmlTemplate> reference : this.templateMap.values()) {
            reference.clear();
        }
        this.templateMap.clear();
    }

}
