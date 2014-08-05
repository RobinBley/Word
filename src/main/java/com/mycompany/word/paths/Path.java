package com.mycompany.word.paths;

/**
 *
 * @author rbley
 * @see Liefert den Pfad fuer ein Medium
 */
public interface Path {

    String getFilepath();

    String getFilename();

    void setFilename(String filename);

    String getFiledirectory();

    void setFiledirectory(String filepath);

}
