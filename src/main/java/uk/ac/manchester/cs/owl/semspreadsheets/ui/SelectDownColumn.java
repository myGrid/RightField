/*******************************************************************************
 * Copyright (c) 2009, 2017, The University of Manchester
 *
 * Licensed under the New BSD License.
 * Please see LICENSE file that is distributed with the source code
 *  
 *******************************************************************************/
package uk.ac.manchester.cs.owl.semspreadsheets.ui;

import java.awt.event.ActionEvent;

import uk.ac.manchester.cs.owl.semspreadsheets.model.Range;
import uk.ac.manchester.cs.owl.semspreadsheets.model.WorkbookManager;
import uk.ac.manchester.cs.owl.semspreadsheets.ui.action.SpreadSheetAction;

/**
 * @author Stuart Owen
 * @author Matthew Horridge
 */
@SuppressWarnings("serial")
public class SelectDownColumn extends SpreadSheetAction {

    public SelectDownColumn(WorkbookManager workbookManager, WorkbookFrame workbookFrame) {
        super("Select column", workbookManager, workbookFrame);
    }

    /**
     * Invoked when an action occurs.
     */
    public void actionPerformed(ActionEvent e) {
        Range range = getSpreadSheetManager().getSelectionModel().getSelectedRange();
        if(range == null || !range.isCellSelection()) {
            return;
        }
        int fromCol = range.getFromColumn();
        int fromRow = range.getFromRow();

        Range selRange = new Range(range.getSheet(), fromCol, fromRow, fromCol, range.getSheet().getMaxRows() - 1);
        getSpreadSheetManager().getSelectionModel().setSelectedRange(selRange);
    }
}
