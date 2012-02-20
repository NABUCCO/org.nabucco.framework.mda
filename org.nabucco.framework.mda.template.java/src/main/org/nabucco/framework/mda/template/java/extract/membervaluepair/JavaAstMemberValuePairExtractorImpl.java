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
package org.nabucco.framework.mda.template.java.extract.membervaluepair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.MemberValuePair;
import org.eclipse.jdt.internal.compiler.ast.NormalAnnotation;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.nabucco.framework.mda.template.java.JavaTemplateException;
import org.nabucco.framework.mda.template.java.extract.JavaAstExtractorFactory;
import org.nabucco.framework.mda.template.java.extract.JavaAstMemberValuePairExtractor;

/**
 * JavaAstMemberValuePairExtractorImpl
 * 
 * @author Thomas Annen, PRODYNA AG
 */
class JavaAstMemberValuePairExtractorImpl implements JavaAstMemberValuePairExtractor {

    /**
     * Singleton instance.
     */
    private static JavaAstMemberValuePairExtractor instance = new JavaAstMemberValuePairExtractorImpl();

    /**
     * Private constructor.
     */
    private JavaAstMemberValuePairExtractorImpl() {
    }

    /**
     * Singleton access.
     * 
     * @return the JavaAstMemberValuePairExtractor instance.
     */
    public static JavaAstMemberValuePairExtractor getInstance() {
        return instance;
    }

    @Override
    public List<MemberValuePair> extractMemberValuePairs(NormalAnnotation annotation,
            BlockScope scope) throws JavaTemplateException {

        if (annotation == null) {
            return Collections.<MemberValuePair> emptyList();
        }

        List<MemberValuePair> memberValuePairList = new ArrayList<MemberValuePair>();

        for (MemberValuePair memberValuePair : annotation.memberValuePairs) {

            // 'Expression' is a 'Statement' so the 'JavaAstStatementExtractor' can be applied.
            Expression expression = JavaAstExtractorFactory.getInstance().getStatementExtractor()
                    .extractStatement(memberValuePair.value, scope);

            MemberValuePair memberValuePairCopy = new MemberValuePair(memberValuePair.name.clone(),
                    memberValuePair.sourceStart, memberValuePair.sourceEnd, expression);

            memberValuePairList.add(memberValuePairCopy);
        }

        return memberValuePairList;
    }
}
