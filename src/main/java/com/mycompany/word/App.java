package com.mycompany.word;

import com.mycompany.word.filereader.Reader;
import com.mycompany.word.filereader.ReaderImpl;
import com.mycompany.word.filewriter.Writer;
import com.mycompany.word.filewriter.WriterImpl;
import com.mycompany.word.paths.Path;
import com.mycompany.word.paths.PathImpl;
import java.util.Scanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author rbley
 */
public class App {

    private ClassPathXmlApplicationContext ctx;
    private Path path;
    private Writer writer;
    private Reader reader;

    public App() {

        ctx = new ClassPathXmlApplicationContext("application-context.xml");

        path = (Path) ctx.getBean(PathImpl.class);
        writer = (Writer) ctx.getBean(WriterImpl.class);
        reader = (Reader) ctx.getBean(ReaderImpl.class);
        
    }

    public Path getPath() {
        return path;
    }

    public Writer getWriter() {
        return writer;
    }

    public Reader getReader() {
        return reader;
    }

    public static void main(String[] args) {
        App app = new App();

        int input = 5;
        boolean run = true;

        while (run) {
            Scanner scan = new Scanner(System.in);
            System.out.println("\n" + app.getPath().getFilepath() + "\neingabe:\n0=directory\n1=read\n2=write\n3=Change file\nelse=break");
            try {
                input = scan.nextInt();
            } catch (Exception e) {
                run = false;
            }

            switch (input) {
                case 0:
                    System.out.println("\n" + app.getReader().showFiles());
                    break;
                case 1:
                    System.out.println("\n" + app.getReader().readFile());
                    break;
                case 2:
                    try {
                        System.out.println("output");
                        String output = scan.next();
                        System.out.println("Append?(boolean):");
                        boolean flag = scan.nextBoolean();
                        app.writer.writeInFile(output, flag);
                    } catch (Exception e) {
                        System.out.println("Falsche Eingabe");
                        break;
                    }
                    break;
                case 3:
                    System.out.println("new filename:");
                    String newFilename = scan.next();
                    ChangeProperties.changePropertie("filename", newFilename);
                    break;
                default:
                    run = false;
                    break;

            }

        }
    }

}
