package codegen.codetemplates;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

import codegen.codetemplates.templatecompletion.replacementrule.Replacement;
import codegen.codetemplates.templatecompletion.replacementrule.ReplacementRoot;

public class ReplacementStuff {
	@Test
	public void testReplSomething() throws ClassNotFoundException,
			FileNotFoundException {
		ReplacementRoot root = new ReplacementRoot(
				"files/test/TestReplacementFile.xml");
		for (Replacement r : root) {
			Assert.assertNotNull(r.getTemplateName());
		}
	}
}
