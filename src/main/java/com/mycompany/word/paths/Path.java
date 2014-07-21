package com.mycompany.word.paths;

/**
 *
 * @author rbley
 */
public interface Path {
    

    public String getFilepath();

    public String getFilename();

    public void setFilename(String filename);
    public String getFiledirectory();
    public void setFiledirectory(String filepath);
}
