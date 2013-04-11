package util;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class DocumentFilter extends FileFilter {

	@Override
	public boolean accept(File f) {
	    if (f.isDirectory()) {
	        return true;
	    }

	    String extension = EstensioneFile.getExtension(f);
	    if (extension != null) {
	        if (extension.equals(EstensioneFile.pdf) ||
	            extension.equals(EstensioneFile.doc) ||
	            extension.equals(EstensioneFile.docx) ||
	            extension.equals(EstensioneFile.ppt) ||
	            extension.equals(EstensioneFile.pptx) ||
	            extension.equals(EstensioneFile.xls) ||
	            extension.equals(EstensioneFile.xlsx)) {
	                return true;
	        } else {
	            return false;
	        }
	    }

	    return false;
	}

	@Override
	public String getDescription() {
		return "Solo documenti";
	}

}
