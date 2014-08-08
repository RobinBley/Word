/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.bley.word.configuration;

import de.bley.word.filereader.Reader;
import de.bley.word.filewriter.Writer;
import de.bley.word.paths.Path;

/**
 *
 * @author rbley
 * @deprecated 
 */
public interface Configuration {
    
    Reader getReader();
    Writer getWriter();
    Path getPath();
    void setReader(Reader reader);
    void setWriter(Writer writer);
    void setPath(Path path);
    
}
