package util;

import java.io.File;

public class EstensioneFile {
    public final static String jpeg = "jpeg";
    public final static String jpg = "jpg";
    public final static String gif = "gif";
    public final static String tiff = "tiff";
    public final static String tif = "tif";
    public final static String png = "png";
    public final static String doc = "doc";
    public final static String docx = "docx";
    public final static String ppt = "ppt";
    public final static String pptx = "pptx";
    public final static String xls = "xls";
    public final static String xlsx = "xlsx";
    public final static String pdf = "pdf";
    public final static String txt = "txt";
    public final static String rtf = "rtf";
    public final static String ods = "ods";
    public final static String odp = "odp";
    public final static String odt = "odt";
    public final static String rar = "rar";
    public final static String zip = "zip";
    public final static String sevenZip = "7z";

    /*
     * Get the extension of a file.
     */  
    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
    
    /*
     * Get the extension of a file.
     */  
    public static String getExtension(String s) {
        String ext = null;
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
    
    /*
     * Get the extension of a file.
     */  
    public static String addRandToFileName(String name) {
        String ext = null;
        String noExt = null;
        String newName = "";
        int i = name.lastIndexOf('.');
        if (i > 0 &&  i < name.length() - 1) {
            ext = name.substring(i+1).toLowerCase();
            noExt = name.substring(0, i);
            RandomString rand = new RandomString(5);
            newName = newName.concat(noExt+"_"+rand.nextString()+"."+ext);
        }
        
        return newName;
    }
}
