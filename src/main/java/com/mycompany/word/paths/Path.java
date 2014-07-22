package com.mycompany.word.paths;

/**
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
