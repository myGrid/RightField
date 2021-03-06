/*******************************************************************************
 * Copyright (c) 2009, 2017, The University of Manchester
 *
 * Licensed under the New BSD License.
 * Please see LICENSE file that is distributed with the source code
 *  
 *******************************************************************************/
package uk.ac.manchester.cs.owl.semspreadsheets.ui;

import java.util.ArrayList;
import java.util.List;

import uk.ac.manchester.cs.owl.semspreadsheets.listeners.CellSelectionListener;
import uk.ac.manchester.cs.owl.semspreadsheets.model.Range;

/**
 * @author Stuart Owen
 * @author Matthew Horridge
 */
public class CellSelectionModel {

    private List<CellSelectionListener> listeners = new ArrayList<CellSelectionListener>();

    private Range range;

    public CellSelectionModel() {
        
    }

    public void addCellSelectionListener(CellSelectionListener listener) {
        listeners.add(listener);
    }

    public void removeCellSelectionListener(CellSelectionListener listener) {
        listeners.remove(listener);
    }

    public void setSelectedRange(Range range) {
        this.range = range;
        for(CellSelectionListener listener : listeners) {
            listener.selectionChanged(range);
        }
    }

    public Range getSelectedRange() {
        return range;
    }
}
