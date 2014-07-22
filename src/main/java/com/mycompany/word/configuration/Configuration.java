/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.word.configuration;

import com.mycompany.word.filereader.Reader;
import com.mycompany.word.filewriter.Writer;
import com.mycompany.word.paths.Path;

/**
 *
 * @author rbley
 */
public interface Configuration {
    
    Reader getReader();
    Writer getWriter();
    Path getPath();
    void setReader(Reader reader);
    void setWriter(Writer writer);
    void setPath(Path path);
    
}
