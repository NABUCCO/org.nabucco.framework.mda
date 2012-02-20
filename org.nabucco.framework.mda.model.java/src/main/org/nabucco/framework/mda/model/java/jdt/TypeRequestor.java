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
package org.nabucco.framework.mda.model.java.jdt;

import org.eclipse.jdt.internal.compiler.env.AccessRestriction;
import org.eclipse.jdt.internal.compiler.env.IBinaryType;
import org.eclipse.jdt.internal.compiler.env.ICompilationUnit;
import org.eclipse.jdt.internal.compiler.env.ISourceType;
import org.eclipse.jdt.internal.compiler.impl.ITypeRequestor;
import org.eclipse.jdt.internal.compiler.lookup.PackageBinding;

/**
 * TypeRequestor
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class TypeRequestor implements ITypeRequestor {

    @Override
    public void accept(ICompilationUnit arg0, AccessRestriction arg1) {
    }

    @Override
    public void accept(IBinaryType arg0, PackageBinding arg1, AccessRestriction arg2) {
    }

    @Override
    public void accept(ISourceType[] arg0, PackageBinding arg1, AccessRestriction arg2) {
    }

}
