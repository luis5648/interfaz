package servidor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.Difference;
import org.custommonkey.xmlunit.DifferenceListener;
import org.custommonkey.xmlunit.ElementQualifier;
import org.custommonkey.xmlunit.IgnoreTextAndAttributeValuesDifferenceListener;
import org.custommonkey.xmlunit.XMLUnit;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class xml {

    static String origin = " <abc>    attr=\"value1\" title=\"something\">     </abc>  ";
    static String target = "<abc> attr=\"value1\" title=\"something\"></abc>";

    public static void main(String[] args) throws Exception {
        xml x = new xml();
        boolean d = x.testCompareToSkeletonXML(origin, target);
        //System.out.println(d);
        System.out.println(x.optenerValidacion("C:\\Users\\Alan gonzalez\\Desktop\\cfdi_incorrecto_02.xml"));
        //System.out.println(leerArchivos("/home/luis/Escritorio/Servidor/xmlTrue/origen.xml"));
    }

    public static String leerArchivos(String ruta) {
        String c;
        String contenido = "";

        try {
            File inputFile = new File(ruta);
            FileInputStream fis = new FileInputStream(inputFile);

            BufferedReader dis = new BufferedReader(new InputStreamReader(fis));
            while ((c = dis.readLine()) != null) //ta.setText(ta.getText()+c+"\n");
            {
                contenido += c + "\n";
            }

            dis.close();
            fis.close();

        } catch (FileNotFoundException e) {
            System.err.println("Error" + e);
        } catch (IOException e) {
            System.err.println("Error" + e);
        }
        return contenido;

    }

    public boolean comparar(String r1, String r2) {
        XMLUnit.setIgnoreWhitespace(true);
        XMLUnit.setIgnoreAttributeOrder(true);
        XMLUnit.setIgnoreDiffBetweenTextAndCDATA(true);
        XMLUnit.setIgnoreComments(true);

        DetailedDiff comparacion = null;
        List<?> diferencias = null;
        try {
            comparacion = new DetailedDiff(XMLUnit.compareXML(r1, r2));
        } catch (SAXException ex) {

            System.out.println("El archivo xml está mal escrito: " + ex);

        } catch (IOException ex) {

            System.out.println("Archivo no valido: " + ex);

        }

        diferencias = comparacion.getAllDifferences();

        if (diferencias.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    public boolean testCompareToSkeletonXML(String prueba, String estandar) throws Exception {
        //String myControlXML = "<location><street-address>22 any street</street-address><postcode>XY00 99Z</postcode></location>";
        //String myTestXML = "<location><street-address>20 east cheap</street-address><postcode>EC3M 1EB</postcode></location>";

        DifferenceListener myDifferenceListener = new IgnoreTextAndAttributeValuesDifferenceListener();

        Diff myDiff = new Diff(prueba, estandar);

        myDiff.overrideDifferenceListener(myDifferenceListener);
        System.out.println("los xml son:" + myDiff.similar());
        boolean va = myDiff.similar();
        return va;
    }

    public  Boolean optenerValidacion(String ruta) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        Boolean validar1 = false, validar2 = false, validar3 = false, validar4 = false, validarFinal = false;
        String ruta_Archivo = ruta;
        File inputFile = new File(ruta_Archivo);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(inputFile);
        document.getDocumentElement().normalize();
        XPath xPath = XPathFactory.newInstance().newXPath();
        NodeList nodeList = (NodeList) xPath.compile("//*").evaluate(
                document, XPathConstants.NODESET);
        //System.out.println(nodeList.getLength());
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nNode = nodeList.item(i);
            //  System.out.println("\nCurrent Element :" + nNode.getNodeName());
            Element eElement1 = (Element) nNode;
            if ("cfdi:Comprobante".equals(nNode.getNodeName())) {

                System.out.println("\nCurrent Element : " + nNode.getNodeName());
                System.out.println("validacion 1: " + validar1);
                validar1 = true;
                System.out.println("validacion 2: " + validar1);

            }
            if ("cfdi:Emisor".equals(nNode.getNodeName())) {
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                System.out.println("validacion 1: " + validar2);
                validar2 = true;
                System.out.println("validacion 2: " + validar2);

            }
            if ("cfdi:Receptor".equals(nNode.getNodeName())) {
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                System.out.println("validacion 1: " + validar3);
                validar3 = true;
                System.out.println("validacion 2: " + validar3);
            }
            if ("cfdi:Impuestos".equals(nNode.getNodeName())) {
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                System.out.println("validacion 1: " + validar4);
                validar4 = true;
                System.out.println("validacion 2: " + validar4);

            }
        }
        if (validar1.equals(true) && validar2.equals(true) && validar3.equals(true) && validar4.equals(true)) {

            validarFinal = true;
        }
        return validarFinal;
    }
}
