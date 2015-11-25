package org.lukosan.salix;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public interface ResourceWriter {

	OutputStream getOutputStream() throws IOException;
	
	PrintWriter getWriter() throws IOException;

}
