package wx.config.impl.util;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.softwareag.util.IDataMap;
// --- <<IS-END-IMPORTS>> ---

public final class file

{
	// ---( internal utility methods )---

	final static file _instance = new file();

	static file _newInstance() { return new file(); }

	static file _cast(Object o) { return (file)o; }

	// ---( server methods )---




	public static final void tokenizeFile (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(tokenizeFile)>> ---
		// @sigtype java 3.5
		// [i] field:0:required inString
		// [o] field:1:required valueList
		IDataMap pipeMap = new IDataMap(pipeline);
		String inString = pipeMap.getAsString("inString");
		if (inString == null) {
			throw new ServiceException("Missing input inString");
		} else {
			inString = inString.replace("\r", "");
			inString = inString.replace("\n\n", "\n");
			String[] valueList = inString.split("\\n");
			pipeMap.put("valueList", valueList);
		}
			
		// --- <<IS-END>> ---

                
	}
}

