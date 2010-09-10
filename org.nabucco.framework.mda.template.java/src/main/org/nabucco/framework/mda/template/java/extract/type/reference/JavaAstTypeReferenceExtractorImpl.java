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
package org.nabucco.framework.mda.template.java.extract.type.reference;

import org.eclipse.jdt.internal.compiler.ast.ArrayQualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.ArrayTypeReference;
import org.eclipse.jdt.internal.compiler.ast.ParameterizedQualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.ParameterizedSingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.SingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.nabucco.framework.mda.model.java.util.AstUtil;
import org.nabucco.framework.mda.template.java.extract.JavaAstTypeReferenceExtractor;

/**
 * JavaAstTypeReferenceExtractorImpl
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
class JavaAstTypeReferenceExtractorImpl implements JavaAstTypeReferenceExtractor {

    /**
     * Singleton instance.
     */
    private static JavaAstTypeReferenceExtractor instance = new JavaAstTypeReferenceExtractorImpl();

    /**
     * Private constructor.
     */
    private JavaAstTypeReferenceExtractorImpl() {
    }

    /**
     * Singleton access.
     * 
     * @return the JavaAstTypeReferenceExtractor instance.
     */
    public static JavaAstTypeReferenceExtractor getInstance() {
        return instance;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends TypeReference> T extractTypeReference(T typeReference) {
        return (T) copyTypeReference(typeReference);
    }

    @Override
    public TypeReference[] extractTypeReferences(TypeReference[] typeReferences) {
        if (typeReferences == null) {
            return null;
        }

        TypeReference[] copiedTypeReferences = new TypeReference[typeReferences.length];
        for (int i = 0; i < typeReferences.length; i++) {
            copiedTypeReferences[i] = copyTypeReference(typeReferences[i]);
        }

        return copiedTypeReferences;
    }

    /**
     * TypeReference (Hierarchy level 0).
     * 
     * @param typeReference
     * @return
     */
    private TypeReference copyTypeReference(TypeReference typeReference) {
        if (typeReference == null) {
            return null;
        }

        TypeReference copy = null;

        if (typeReference instanceof SingleTypeReference) {
            copy = createTypeReference((SingleTypeReference) typeReference);
        } else if (typeReference instanceof QualifiedTypeReference) {
            copy = createTypeReference((QualifiedTypeReference) typeReference);
        } else {
            throw new IllegalArgumentException("TypeReference "
                    + typeReference.getClass() + " is not supported.");
        }

        return copy;
    }

    /**
     * SingleTypeReference (Hierarchy level 1).
     * 
     * @param typeReference
     * @return
     */
    private SingleTypeReference createTypeReference(SingleTypeReference typeReference) {
        SingleTypeReference copy = null;

        if (typeReference instanceof ArrayTypeReference) {
            copy = createTypeReference((ArrayTypeReference) typeReference);
        } else {
            // Default.
            copy = new SingleTypeReference(typeReference.token.clone(), 0);
        }

        return copy;
    }

    /**
     * QualifiedTypeReference (Hierarchy level 1).
     * 
     * @param typeReference
     * @return
     */
    private QualifiedTypeReference createTypeReference(QualifiedTypeReference typeReference) {
        QualifiedTypeReference copy = null;

        if (typeReference instanceof ArrayQualifiedTypeReference) {
            copy = createTypeReference((ArrayQualifiedTypeReference) typeReference);
        } else {
            // Default.
            copy = new QualifiedTypeReference(
                    AstUtil.copyTwoDimensionalCharArray(typeReference.tokens),
                    typeReference.sourcePositions.clone());
        }

        return copy;
    }

    /**
     * ArrayTypeReference (Hierarchy level 2).
     * 
     * @param typeReference
     * @return
     */
    private ArrayTypeReference createTypeReference(ArrayTypeReference typeReference) {
        ArrayTypeReference copy = null;

        if (typeReference instanceof ParameterizedSingleTypeReference) {
            copy = createTypeReference((ParameterizedSingleTypeReference) typeReference);
        } else {
            // Default.
            copy = new ArrayTypeReference(typeReference.token.clone(), typeReference.dimensions, 0);
        }

        return copy;
    }

    /**
     * ArrayQualifiedTypeReference (Hierarchy level 2).
     * 
     * @param typeReference
     * @return
     */
    private ArrayQualifiedTypeReference createTypeReference(
            ArrayQualifiedTypeReference typeReference) {
        ArrayQualifiedTypeReference copy = null;

        if (typeReference instanceof ParameterizedQualifiedTypeReference) {
            copy = createTypeReference((ParameterizedQualifiedTypeReference) typeReference);
        } else {
            // Default.
            copy = new ArrayQualifiedTypeReference(
                    AstUtil.copyTwoDimensionalCharArray(typeReference.tokens),
                    typeReference.dimensions(), typeReference.sourcePositions.clone());
        }

        return copy;
    }

    /**
     * ParameterizedSingleTypeReference (Hierarchy level 3).
     * 
     * @param typeReference
     * @return
     */
    private ParameterizedSingleTypeReference createTypeReference(
            ParameterizedSingleTypeReference typeReference) {
        ParameterizedSingleTypeReference copy = new ParameterizedSingleTypeReference(
                typeReference.token.clone(),
                // Recursive call.
                this.extractTypeReferences(typeReference.typeArguments), typeReference.dimensions,
                0);

        return copy;
    }

    /**
     * ParameterizedQualifiedTypeReference (Hierarchy level 3).
     * 
     * @param typeReference
     * @return
     */
    private ParameterizedQualifiedTypeReference createTypeReference(
            ParameterizedQualifiedTypeReference typeReference) {
        throw new IllegalArgumentException("TypeReference "
                + typeReference.getClass() + " is not supported.");
    }
}
