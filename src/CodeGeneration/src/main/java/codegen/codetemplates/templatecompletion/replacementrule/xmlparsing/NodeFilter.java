package codegen.codetemplates.templatecompletion.replacementrule.xmlparsing;

import org.w3c.dom.Node;

public interface NodeFilter {
	public boolean accept(Node n); 
}
