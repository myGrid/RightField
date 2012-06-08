/*******************************************************************************
 * Copyright (c) 2009-2012, University of Manchester
 *  
 * Licensed under the New BSD License.
 * Please see LICENSE file that is distributed with the source code
 ******************************************************************************/

package uk.ac.manchester.cs.owl.semspreadsheets.export;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.net.URI;

import org.junit.Before;
import org.junit.Test;

import uk.ac.manchester.cs.owl.semspreadsheets.TestDocumentsCatalogue;

public class CSVExporterTest {

	Exporter exporter;
	
	@Before
	public void createExporter() throws Exception {
		URI uri =  TestDocumentsCatalogue.twoOntologiesWorkbookURI();
		exporter = new CSVExporter(uri);		
	}
	
	@Test
	public void testExportOutputStream() throws Exception {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		exporter.export(outStream);
		outStream.flush();
		String csv = outStream.toString();		
		assertEquals(expectedCSV(),csv);
	}
	
	@Test
	public void testExportString() throws Exception {			
		String csv = exporter.export();		
		assertEquals(expectedCSV(),csv);
	}
	
	private String expectedCSV() {
		String expected = "text, col, row, sheet, term uri, type, entity uri, ontology uri, ontology source\n";
		expected+="\"COSMIC\",3,2,\"Sheet0\",\"http://www.mygrid.org.uk/ontology/JERMOntology#COSMIC\",Direct instances,\"http://www.mygrid.org.uk/ontology/JERMOntology#Project\",\"http://www.mygrid.org.uk/ontology/JERMOntology\",\"http://rest.bioontology.org/bioportal/virtual/download/1488\"\n";
		expected+="\"mean and p values\",6,1,\"Sheet0\",\"http://mged.sourceforge.net/ontologies/MGEDOntology.owl#mean_and_p_values\",Instances,\"http://mged.sourceforge.net/ontologies/MGEDOntology.owl#DerivedBioAssayType\",\"http://mged.sourceforge.net/ontologies/MGEDOntology.owl\",\"http://rest.bioontology.org/bioportal/virtual/download/1131\"";
		
		return expected;
				
		

	}

}
