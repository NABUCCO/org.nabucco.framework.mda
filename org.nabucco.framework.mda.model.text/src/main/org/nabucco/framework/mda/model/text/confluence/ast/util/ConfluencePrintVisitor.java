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
package org.nabucco.framework.mda.model.text.confluence.ast.util;

import org.nabucco.framework.mda.model.text.confluence.ast.ConfluenceVisitor;
import org.nabucco.framework.mda.model.text.confluence.ast.format.ConfluenceLine;
import org.nabucco.framework.mda.model.text.confluence.ast.format.ConfluenceSeparator;
import org.nabucco.framework.mda.model.text.confluence.ast.heading.ConfluenceHeading;
import org.nabucco.framework.mda.model.text.confluence.ast.link.ConfluenceExternalLink;
import org.nabucco.framework.mda.model.text.confluence.ast.link.ConfluenceLink;
import org.nabucco.framework.mda.model.text.confluence.ast.link.ConfluenceLocalAnchor;
import org.nabucco.framework.mda.model.text.confluence.ast.metadatalist.ConfluenceMetadataList;
import org.nabucco.framework.mda.model.text.confluence.ast.metadatalist.ConfluenceMetadataListContent;
import org.nabucco.framework.mda.model.text.confluence.ast.metadatalist.ConfluenceMetadataListElement;
import org.nabucco.framework.mda.model.text.confluence.ast.table.ConfluenceTable;
import org.nabucco.framework.mda.model.text.confluence.ast.table.ConfluenceTableRow;
import org.nabucco.framework.mda.model.text.confluence.ast.table.ConfluenceTableRowContent;
import org.nabucco.framework.mda.model.text.confluence.ast.text.ConfluenceText;

/**
 * ConfluencePrintVisitor
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class ConfluencePrintVisitor extends ConfluenceVisitor<StringBuilder> {

    private static final String LINE_SEPARATOR = "\r\n";

    private static final String TOKEN_SEPARATOR = " ";

    private static final String POINT_SEPARATOR = ".";

    private static final String ESCAPE = "\\";

    private static final String SQUARE_BRACKET_LEFT = "[";

    private static final String SQUARE_BRACKET_RIGHT = "]";

    private static final String CURLY_BRACKET_LEFT = "{";

    private static final String CURLY_BRACKET_RIGHT = "}";

    private static final String LOCALLINKSYMBOL = "#";

    private static final String ANCHOR = "anchor";

    private static final String PIPE_SEPARATOR = "|";

    private static final String NAMESPACE_SEPARATOR = ":";

    private static final String METADATALIST = "{metadata-list}";

    private static final String LINE = "----";

    @Override
    public void visit(ConfluenceHeading heading, StringBuilder argument) {

        argument.append(LINE_SEPARATOR);

        argument.append(ConfluenceHeading.LITERAL);
        argument.append(heading.getSize().getValue());
        argument.append(POINT_SEPARATOR);
        argument.append(TOKEN_SEPARATOR);

        super.visit(heading, argument);

        argument.append(LINE_SEPARATOR);
    }

    @Override
    public void visit(ConfluenceText text, StringBuilder argument) {

        // Miltiplicity escape to prevent that the content would be interpreted as a link
        if (text.getValue().contains(SQUARE_BRACKET_LEFT)) {
            String row = text.getValue();
            row = row.replace(SQUARE_BRACKET_LEFT, ESCAPE + SQUARE_BRACKET_LEFT);
            text.setValue(row);
        }

        if (text.getEffectType() == null) {
            argument.append(text);
        } else {
            argument.append(text.getEffectType().getStartLiteral());
            argument.append(text);
            argument.append(text.getEffectType().getEndLiteral());
            argument.append(TOKEN_SEPARATOR);
        }
    }

    @Override
    public void visit(ConfluenceLink link, StringBuilder argument) {
        argument.append(SQUARE_BRACKET_LEFT);

        // Check if the link is a local one than the local links have another syntax
        if (link.getAnchor() == null) {
            if (link.getAlias() != null) {
                argument.append(link.getAlias());
                argument.append(PIPE_SEPARATOR);
            }

            if (link.getNamespace() != null) {
                argument.append(link.getNamespace());
                argument.append(NAMESPACE_SEPARATOR);
            }
            argument.append(link.getPagetitle());

            if (link.getTip() != null) {
                argument.append(PIPE_SEPARATOR);
                argument.append(link.getTip());
            }
        } else {
            argument.append(LOCALLINKSYMBOL);
            argument.append(link.getAnchor().getAnchorName());
        }

        argument.append(SQUARE_BRACKET_RIGHT);
    }

    @Override
    public void visit(ConfluenceExternalLink link, StringBuilder argument) {
        argument.append(SQUARE_BRACKET_LEFT);

        if (link.getLabel() != null) {
            argument.append(link.getLabel());
            argument.append(PIPE_SEPARATOR);
        }

        if (link.getUrl() != null) {
            argument.append(link.getUrl());
        }

        argument.append(SQUARE_BRACKET_RIGHT);
    }

    @Override
    public void visit(ConfluenceLocalAnchor link, StringBuilder argument) {
        argument.append(CURLY_BRACKET_LEFT);

        if (link.getAnchorName() != null) {
            argument.append(ANCHOR);
            argument.append(NAMESPACE_SEPARATOR);
            argument.append(link.getAnchorName());
        }

        argument.append(CURLY_BRACKET_RIGHT);
    }

    @Override
    public void visit(ConfluenceMetadataList metadataList, StringBuilder argument) {

        argument.append(METADATALIST);
        argument.append(LINE_SEPARATOR);
        super.visit(metadataList, argument);
        argument.append(METADATALIST);

        argument.append(LINE_SEPARATOR);
    }

    @Override
    public void visit(ConfluenceMetadataListElement metadataListelement, StringBuilder argument) {
        argument.append(PIPE_SEPARATOR);
        super.visit(metadataListelement, argument);
        argument.append(PIPE_SEPARATOR);
        argument.append(PIPE_SEPARATOR);
        argument.append(LINE_SEPARATOR);
    }

    @Override
    public void visit(ConfluenceMetadataListContent text, StringBuilder argument) {
        argument.append(PIPE_SEPARATOR);
        super.visit(text, argument);
    }

    @Override
    public void visit(ConfluenceTable table, StringBuilder argument) {
        super.visit(table, argument);
        argument.append(LINE_SEPARATOR);
    }

    @Override
    public void visit(ConfluenceTableRow row, StringBuilder argument) {

        super.visit(row, argument);
        argument.append(PIPE_SEPARATOR);
        if (row.isHeader()) {
            argument.append(PIPE_SEPARATOR);
        }
        argument.append(LINE_SEPARATOR);
    }

    @Override
    public void visit(ConfluenceTableRowContent rowtext, StringBuilder argument) {
        argument.append(PIPE_SEPARATOR);
        if (rowtext.isHeader()) {
            argument.append(PIPE_SEPARATOR);
        }
        super.visit(rowtext, argument);
    }

    @Override
    public void visit(ConfluenceLine line, StringBuilder argument) {
        argument.append(LINE_SEPARATOR);
        argument.append(LINE);
        argument.append(LINE_SEPARATOR);
    }

    @Override
    public void visit(ConfluenceSeparator line, StringBuilder argument) {
        argument.append(LINE_SEPARATOR);
    }

}
