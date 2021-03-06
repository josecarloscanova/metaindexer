package org.nanotek.lucene.util;


import java.io.IOException;
import java.io.OutputStream;

/**
 * This class extends the OutputStream class to allow output to be printed
 * to a StringBuffer ...
 */
public class StringBufferOutputStream extends OutputStream 
{
	
  private StringBuffer strBuffer;
  private boolean closed = false;

  public StringBufferOutputStream (StringBuffer strBuffer) 
  {
    super ();
    this.strBuffer = strBuffer;
  }
  
  /** method to write a char */
  public void write (int i)
       throws IOException
  {
    if (closed)
      return;
    strBuffer.append ( (char) i);    
  }

  /** write an array of bytes */
  public void write (byte[] b, int offset, int length) 
       throws IOException
  {
    if (closed)
      return;

    if (b == null)
      throw new NullPointerException ("The byte array is null");
    if (offset < 0 || length < 0 || (offset+length) > b.length)
      throw new IndexOutOfBoundsException ("offset and length are negative or extend outside array bounds");
    
    String str = new String (b, offset, length);
    strBuffer.append (str);
  }
  
  public void close () 
  {
    strBuffer = null;
    closed = true;
  }
}
