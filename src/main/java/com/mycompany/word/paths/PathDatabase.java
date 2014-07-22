/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.word.paths;

import org.springframework.stereotype.Service;

/**
 *
 * @author rbley
 */
@Service
public class PathDatabase implements Path{

    @Override
    public String getFilepath() {
        return null;
    }

    @Override
    public String getFilename() {
        return null;
    }

    @Override
    public void setFilename(String filename) {
    }

    @Override
    public String getFiledirectory() {
        return null;
    }

    @Override
    public void setFiledirectory(String filepath) {
    }
    
}
