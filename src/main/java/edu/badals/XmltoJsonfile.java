package edu.badals;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class XmltoJsonfile {
    public static void main(String[] args) {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce la ruta del archivo xml: ");
            StringBuilder path = new StringBuilder();
                path.append("src/main/resources/");
                path.append(scanner.nextLine());
            JsonNode node = xmlMapper.readTree(new File(path.toString()));
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(path.toString().replace(".xml", ".json")),node);
        }catch (IOException e){
            System.out.println("No se ha encontrado el archivo, comprueba la ruta.");
        }
    }
}

