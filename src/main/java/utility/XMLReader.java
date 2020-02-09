package utility;

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLReader {

	//getChildNodes = method used to get the list of child nodes ; returs NodeList object
	//NodeList = is a class
	//Node = class ; element of NodeList is a Node . 

	Document doc;
	private static DocumentBuilder dBuilder;
	public XMLReader(String path) {

		try {
			readDataFromXmlFile(path);
		}catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

	private Document readDataFromXmlFile(String path) throws Exception {
		try {
			File file = new File(path);
			dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			doc = dBuilder.parse(file);
		}
		catch(Exception e) {
			throw e;
		}

		return doc;
	}

	public List<Hashtable<String, String>> getDataAsList(String testName) {

		List<Hashtable<String, String>> list = new ArrayList<Hashtable<String, String>>();

		Hashtable<String, String> table = null;

		Node testCaseNode = this.getNode(testName);

		NodeList dataNodes = testCaseNode.getChildNodes();

		for (int count = 0; count < dataNodes.getLength(); count++){

			table = new Hashtable<String, String>();

			Node dataNode = dataNodes.item(count);

			if (dataNode.getNodeType() == Node.ELEMENT_NODE) {

				// System.out.println(dataNode.getNodeName());
				// System.out.println(dataNode.getTextContent());

				NodeList dataList = dataNode.getChildNodes();

				for (int c = 0; c < dataList.getLength(); c++) {

					Node data = dataList.item(c);

					if (data.getNodeType() == Node.ELEMENT_NODE) {

						// System.out.println(data.getNodeName() +" --- "+
						// data.getTextContent());

						table.put(data.getNodeName(), data.getTextContent());
					}
				}
				list.add(table);
			}
		}

		return list;
	}

	public Object[][] getDataAsArray(String testName) {

		List<Hashtable<String, String>> l = getDataAsList(testName);
		int rows = l.size();
		Hashtable<String, String> t = l.get(0);
		int cols = t.size();
		int rNum = 0;
		int cNum = 0;
		System.out.println(rows + "  - " + cols);
		Node testCaseNode = getNode(testName);
		NodeList dataNodes = testCaseNode.getChildNodes();
		Object[][] testData = new Object[rows][cols];

		for (int count = 0; count < dataNodes.getLength(); count++) {
			Node dataNode = dataNodes.item(count);

			if (dataNode.getNodeType() == Node.ELEMENT_NODE) {
				System.out.println(dataNode.getNodeName());
				// System.out.println(dataNode.getTextContent());

				NodeList dataList = dataNode.getChildNodes();
				cNum = 0;
				for (int c = 0; c < dataList.getLength(); c++) {
					Node data = dataList.item(c);
					if (data.getNodeType() == Node.ELEMENT_NODE) {
						System.out.println(data.getNodeName() + " --- " + data.getTextContent());
						testData[rNum][cNum] = data.getTextContent();
						cNum++;
					}

				}

				rNum++;
			}
		}
		return testData;

	}

	public Node getNode(String nodeName) {


		NodeList list = doc.getChildNodes();

		Node rootNode = list.item(0);

		NodeList testCasesList = rootNode.getChildNodes();

		for (int count = 0; count < testCasesList.getLength(); count++) {

			Node tempNode = testCasesList.item(count);

			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
				// System.out.println("Node Name is: "+tempNode.getNodeName());
				// System.out.println("context is "+ tempNode.getTextContent());
				if (nodeName.equals(tempNode.getNodeName())) {
					//System.out.println("context is "+ tempNode.getTextContent());
					return tempNode;
				}
			}
		}
		return null;
	}

}
