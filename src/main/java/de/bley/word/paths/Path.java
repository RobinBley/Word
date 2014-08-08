package de.bley.word.paths;

/**
 * Liefert den Pfad fuer ein Medium.
 *
 * @author rbley
 */
public interface Path {

    String getFilepath();

    String getFilename();

    void setFilename(String filename);

    String getFiledirectory();

    void setFiledirectory(String filepath);

}
