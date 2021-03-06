/*******************************************************************************
 * Copyright (c) 2009-2012, University of Manchester
 * 
 * Licensed under the New BSD License. 
 * Please see LICENSE file that is distributed with the source code
 ******************************************************************************/
package uk.ac.manchester.cs.owl.semspreadsheets;

import uk.ac.manchester.cs.owl.semspreadsheets.listeners.WorkbookManagerListener;

/**
 * 
 * @author Stuart Owen
 *
 */
public class DummyWorkbookManagerListener implements
		WorkbookManagerListener {
	public boolean workbookLoadedFired = false;
	public boolean workbookChangedFired = false;
	public boolean validationAppliedFired = false;
	
	public boolean workbookSavedFired = false;
	
	public DummyWorkbookManagerListener() {
		reset();
	}
	
	//resets the state of all flags
	public void reset() {
		workbookLoadedFired = false;
		workbookChangedFired = false;
		validationAppliedFired = false;		
	}
	
	public boolean isWorkbookLoadedFired() {
		return workbookLoadedFired;
	}

	public boolean isWorkbookChangedFired() {
		return workbookChangedFired;
	}

	public boolean isValidationAppliedFired() {
		return validationAppliedFired;
	}	
	
	public boolean isWorkbookSavedFired() {
		return workbookSavedFired;
	}

	@Override
	public void workbookLoaded() {
		workbookLoadedFired=true;
	}

	@Override
	public void workbookCreated() {
		workbookChangedFired=true;
	}

	@Override
	public void validationAppliedOrCancelled() {
		validationAppliedFired=true;
	}	

	@Override
	public void workbookSaved() {
		workbookSavedFired=true;		
	}
	
}
