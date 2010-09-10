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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.nabucco.framework.mda.util.file.FileTreeVisitor;

/**
 * JavaTemplateFileVisitor
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
class JavaTemplateFileVisitor extends FileTreeVisitor {

    private Map<String, String> templateFileMap;

    public JavaTemplateFileVisitor(Map<String, String> templateFileMap) {
        this.templateFileMap = templateFileMap;
    }

    @Override
    protected void visitFile(File file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            String content = convertStream(fis);
            String name = file.getName().substring(0, file.getName().lastIndexOf('.'));

            if (this.templateFileMap.get(name) == null) {
                this.templateFileMap.put(name, content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void visitArchive(File zipFile) throws IOException {
        ZipFile zip = new ZipFile(zipFile);
        JavaTemplateFileFilter filter = JavaTemplateFileFilter.getInstance();
        Enumeration<? extends ZipEntry> entries = zip.entries();
        while (entries.hasMoreElements()) {
            ZipEntry nextElement = entries.nextElement();
            if (!nextElement.isDirectory() && filter.accept(nextElement)) {
                InputStream inputStream = zip.getInputStream(nextElement);
                String content = convertStream(inputStream);
                String name = nextElement.getName();
                int innerPath = name.lastIndexOf('/');
                if (innerPath > -1) {
                    name = name.substring(innerPath + 1);
                }
                name = name.substring(0, name.lastIndexOf('.'));
                if (this.templateFileMap.get(name) == null) {
                    this.templateFileMap.put(name, content);
                }
            }
        }
    }
}
