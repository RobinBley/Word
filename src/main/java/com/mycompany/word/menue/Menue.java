/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.word.menue;

import com.mycompany.word.filereader.Reader;
import com.mycompany.word.filewriter.Writer;
import com.mycompany.word.paths.Path;
import java.util.ArrayList;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author rbley
 */
@Service
public class Menue {

    @Value("${filedirectory}")
    private String filedirectory;
    @Autowired
    private Reader reader;
    @Autowired
    private Writer writer;
    @Autowired
    Path path;

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public String getFiledirectory() {
        return filedirectory;
    }

    public void setFiledirectory(String filedirectory) {
        this.filedirectory = filedirectory;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    protected void showFiles(Scanner scan) {
        final ArrayList<String> files = getReader().showFiles(path.getFiledirectory());
        int counter = 0;
        System.out.println("choose file:");

        for (String file : files) {
            System.out.println(counter + "= " + file);
            counter++;
        }
        System.out.println("else= break");

        boolean run = true;
        while (run) {
            final int input = scan.nextInt();
            if (input <= files.size() - 1) {
                path.setFilename("/" + files.get(input));
                run = false;

            } else {
                System.out.println("Falsche Eingabe");
                run = false;

            }
        }
    }

    protected void readFile() {
        System.out.println("\n" + getReader().readFile(getPath().getFilepath()));
    }

    protected void writeFrile(final Scanner scan) {
        try {
            System.out.println("output");
            String output = scan.next();
            System.out.println("Append?(boolean):");
            boolean flag = scan.nextBoolean();
            getWriter().writeInFile(getPath().getFilepath(), output, flag);
        } catch (Exception e) {
            System.out.println("Falsche Eingabe");
        }

    }

    public void showMenue() {
        boolean run = true;

        while (run) {

            final Scanner scan = new Scanner(System.in);

            try {
                showFiles(scan);

                System.out.println("\n0=read file \n1=write into file\nelse=break");

                final int input = scan.nextInt();

                switch (input) {
                    case 0:
                        readFile();
                        break;
                    case 1:
                        writeFrile(scan);
                        break;
                    default:
                        run = false;
                        break;
                }
            } catch (Exception e) {
                run = false;

            }

        }
    }

}
