package wx.config.impl.util;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.softwareag.util.IDataMap;
// --- <<IS-END-IMPORTS>> ---

public final class string

{
	// ---( internal utility methods )---

	final static string _instance = new string();

	static string _newInstance() { return new string(); }

	static string _cast(Object o) { return (string)o; }

	// ---( server methods )---




	public static final void matches (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(matches)>> ---
		// @sigtype java 3.5
		// [i] field:0:required inputString
		// [i] field:0:required regex
		// [o] field:0:required matches
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	inputString = IDataUtil.getString( pipelineCursor, "inputString" );
		String	regex = IDataUtil.getString( pipelineCursor, "regex" );
		pipelineCursor.destroy();
		
		Boolean matches = Boolean.FALSE;
		
		if (inputString != null && regex != null) {
			if (inputString.matches(regex)) {
				matches = Boolean.TRUE;
			}
		}
		
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "matches", matches.toString() );
		pipelineCursor_1.destroy();
			
		// --- <<IS-END>> ---

                
	}



	public static final void splitConfigLine (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(splitConfigLine)>> ---
		// @sigtype java 3.5
		// [i] field:0:required inString
		// [o] field:0:required key
		// [o] field:0:required value
		IDataMap pipeMap = new IDataMap(pipeline);
		String inString = pipeMap.getAsString("inString");
		
		if (inString == null) {
			throw new ServiceException("Missing input inString");
		} if (inString == "") {
			// do nothing
		} else {
			int index = inString.indexOf("=");
			if (index >= 1) {
				pipeMap.put("key", inString.substring(0,  index));
				pipeMap.put("value", inString.substring(index + 1, inString.length()));
			} else {
				// ignore:
				//throw new ServiceException("Broken config line: " + inString);
			}
		}
		// --- <<IS-END>> ---

                
	}
}

