package uk.ac.manchester.cs.owl.semspreadsheets.export;

import java.net.URI;

import uk.ac.manchester.cs.owl.semspreadsheets.DocumentsCatalogue;

public class CSVExporterXLSTest extends GeneralCSVExporterTests {

	@Override
	protected URI twoOntologiesWorkbookURI() throws Exception {
		return DocumentsCatalogue.twoOntologiesWorkbookURI();
	}

}