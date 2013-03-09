package util;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class GUIConfig {

	public static int loadXMLInt(String name, String type) {
		  try {
			  File file = new File("bin/settings/gui.xml");
			  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			  DocumentBuilder db = dbf.newDocumentBuilder();
			  Document doc = db.parse(file);
			  doc.getDocumentElement().normalize();
			  NodeList nodeLst = doc.getElementsByTagName(type);
			  for (int s = 0; s < nodeLst.getLength(); s++) {
				  Node fstNode = nodeLst.item(s);
				  if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
				      Element fstElmnt = (Element) fstNode;
				      NodeList fstNmElmntLst = fstElmnt.getElementsByTagName(name);
				      Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
				      NodeList fstNm = fstNmElmnt.getChildNodes();
				      return Integer.parseInt(((Node) fstNm.item(0)).getNodeValue());
				  }
			  }
			  } catch (Exception e) {
				  return 0;
			  }
      return 0;
	}
	
}
