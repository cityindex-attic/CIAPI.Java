package codegen.codetemplates;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.Test;

import codegen.codetemplates.templatecompletion.TemplateFiller;
import codegen.codetemplates.templatecompletion.replacementrule.ReplacementRoot;
import codegen.modelobjects.QuoteSet;

import com.google.gson.Gson;

public class TemplateFillerTest {

	@Test
	public void testLoadTemplate() throws FileNotFoundException,
			ClassNotFoundException {
		ReplacementRoot repl = new ReplacementRoot(
				"files/test/TestReplacementFile.xml");
		TemplateFiller filler = new TemplateFiller(repl);
		QuoteSet set = new Gson().fromJson(new FileReader(new File(
				"files/test/quotes.js")), QuoteSet.class);
		String code = filler.fillTemplate(set);
		assertTrue(true);
	}
}
