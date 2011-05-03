package codegen.codetemplates.templatecompletion.replacementrule.xmlparsing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
	 * Super simple implementation of a NodeList that ignores my definition of whitespace nodes.
	 * 
	 * @author Justin Nelson
	 * 
	 */
	public class NdLst implements NodeList, Iterable<MyNd> {

		private List<MyNd> nodes;

		public NdLst(NodeList list) {
			nodes = new ArrayList<MyNd>();
			for (int i = 0; i < list.getLength(); i++) {
				if (!isWhitespaceNode(list.item(i))) {
					nodes.add(new MyNd(list.item(i)));
				}
			}
		}

		private NdLst(List<MyNd> nodes) {
			this.nodes = nodes;
		}

		public NdLst where(NodeFilter filter) {
			List<MyNd> filtered = new ArrayList<MyNd>();
			for (Node n : this) {
				if (filter.accept(n)) {
					filtered.add(new MyNd(n));
				}
			}
			return new NdLst(filtered);
		}

		public NdLst where(final String nodeName){
			return this.where(new NodeFilter() {
				@Override
				public boolean accept(Node n) {
					return n.getNodeName().equals(nodeName);
				}
			});
		}
		
		public MyNd single(NodeFilter filter) {
			NdLst filtered = this.where(filter);
			if (filtered.getLength() != 1)
				throw new IllegalArgumentException("The filter did not return a single result.");
			return new MyNd(filtered.item(0));
		}

		public MyNd single(String nodeName){
			NdLst filtered = this.where(nodeName);
			if (filtered.getLength() != 1)
				throw new IllegalArgumentException("The filter did not return a single result.");
			return new MyNd(filtered.item(0));
		}
		
		@Override
		public Node item(int index) {
			return nodes.get(index);
		}

		@Override
		public int getLength() {
			return nodes.size();
		}

		private static boolean isWhitespaceNode(Node n) {
			if (n.getNodeType() == Node.TEXT_NODE) {
				String val = n.getNodeValue();
				return val.trim().length() == 0;
			} else {
				return false;
			}
		}

		@Override
		public Iterator<MyNd> iterator() {
			return nodes.iterator();
		}
	}
