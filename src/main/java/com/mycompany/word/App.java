package com.mycompany.word;

import com.mycompany.word.filereader.Reader;
import com.mycompany.word.filereader.ReaderImpl;
import com.mycompany.word.filewriter.Writer;
import com.mycompany.word.filewriter.WriterImpl;
import com.mycompany.word.paths.Path;
import com.mycompany.word.paths.PathImpl;
import java.util.Properties;
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

    public App()  {
//        try {
            ctx = new ClassPathXmlApplicationContext("application-context.xml");
            
            Path path = (Path) ctx.getBean(PathImpl.class);
            Writer writer = (Writer) ctx.getBean(WriterImpl.class);
            Properties props = new Properties();
            Reader reader = (Reader) ctx.getBean(ReaderImpl.class);
            System.out.println(reader.readFile());
//            File f = new File("app.properties");
//            props.load(new FileReader(f));
//            props.setProperty("filename", "test2");
//        } catch (IOException ex) {
//        }
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
//        int input = 0;
//        boolean run = false;
//
//        while (run) {
//            Scanner scan = new Scanner(System.in);
//            System.out.println("eingabe\n0=directory\n1=read\n2=write\nelse=break");
//            try {
//                input = scan.nextInt();
//            } catch (Exception e) {
//                run = false;
//            }
//
//            switch (input) {
//                case 0:
//                    break;
//                case 1:
//                    break;
//                case 2:
//                    System.out.println("filename:");
//                    String filename = scan.next();
//                    System.out.println("output");
//                    String output = scan.next();
//                    app.writer.writeInFile(output);
//                    break;
//                default:
//                    run = false;
//                    break;
//
//            }
//
//        }
    }

}
