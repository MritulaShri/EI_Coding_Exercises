package CreationalPattern;

//Product interface
interface Document {
 void open();
}

//Concrete products
class WordDocument implements Document {
 @Override
 public void open() {
     System.out.println("Opening Word document.");
 }
}

class PDFDocument implements Document {
 @Override
 public void open() {
     System.out.println("Opening PDF document.");
 }
}

class ExcelDocument implements Document {
 @Override
 public void open() {
     System.out.println("Opening Excel document.");
 }
}

//Factory
class DocumentFactory {
 public static Document createDocument(String type) {
     switch (type.toLowerCase()) {
         case "word":
             return new WordDocument();
         case "pdf":
             return new PDFDocument();
         case "excel":
             return new ExcelDocument();
         default:
             throw new IllegalArgumentException("Unknown document type");
     }
 }
}

//Usage
public class FactoryPattern {
 public static void main(String[] args) {
     Document doc1 = DocumentFactory.createDocument("word");
     Document doc2 = DocumentFactory.createDocument("pdf");
     Document doc3 = DocumentFactory.createDocument("excel");

     doc1.open();
     doc2.open();
     doc3.open();
 }
}

