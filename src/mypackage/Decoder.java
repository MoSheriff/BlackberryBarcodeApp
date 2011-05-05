package mypackage;

import java.util.Enumeration;
import java.util.Hashtable;

public final class Decoder {

	  private Decoder() {
	  }

	  private static final Hashtable decodingMap;
	  static {
	    decodingMap = new Hashtable(37);
	    decodingMap.put("%21", "!");
	    decodingMap.put("%2A", "*");
	    decodingMap.put("%2a", "*");
	    decodingMap.put("%27", "'");
	    decodingMap.put("%28", "(");
	    decodingMap.put("%29", ")");
	    decodingMap.put("%3B", ";");
	    decodingMap.put("%3b", ";");
	    decodingMap.put("%3A", ":");
	    decodingMap.put("%3a", ":");
	    decodingMap.put("%40", "@");
	    decodingMap.put("%26", "&");
	    decodingMap.put("%3D", "=");
	    decodingMap.put("%3d", "=");
	    decodingMap.put("%3B", "+");
	    decodingMap.put("%3b", "+");
	    decodingMap.put("%24", "$");
	    decodingMap.put("%2C", "`");
	    decodingMap.put("%2c", "`");
	    decodingMap.put("%2F", "/");
	    decodingMap.put("%2f", "/");
	    decodingMap.put("%3F", "?");
	    decodingMap.put("%3f", "?");
	    decodingMap.put("%25", "%");
	    decodingMap.put("%23", "#");
	    decodingMap.put("%5B", "[");
	    decodingMap.put("%5b", "[");
	    decodingMap.put("%5D", "]");
	    decodingMap.put("%5d", "]");
	  }

	  public static String decode(String uri) {
	    if (uri.indexOf('%') >= 0) { // skip this if no encoded chars
	      Enumeration keys = decodingMap.keys();
	      while (keys.hasMoreElements()) {
	        String encodedChar = (String) keys.nextElement();
	        int encodedCharIndex = uri.indexOf(encodedChar);
	        while (encodedCharIndex != -1) {
	          uri = uri.substring(0, encodedCharIndex) + decodingMap.get(encodedChar) + uri.substring(encodedCharIndex + encodedChar.length());
	          encodedCharIndex = uri.indexOf(encodedChar, encodedCharIndex);
	        }
	      }
	    }
	    return uri;
	  }
	}
