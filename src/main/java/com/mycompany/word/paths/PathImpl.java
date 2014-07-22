package com.mycompany.word.paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author rbley
 */
@Service
public class PathImpl implements Path {
    
    @Value("${filedirectory}")
    private String filedirectory;
    @Value("${filename}")
    private String filename;

    @Override
    public String getFilepath() {
        return filedirectory + filename;
    }
    @Override
    public String getFilename() {
        return filename;
    }

    @Override
    public void setFilename(String filename) {
        this.filename = filename;
    }
    @Override
    public String getFiledirectory() {
        return filedirectory;
    }

    @Override
    public void setFiledirectory(String filedirectory) {
        this.filedirectory = filedirectory;
    }



}
