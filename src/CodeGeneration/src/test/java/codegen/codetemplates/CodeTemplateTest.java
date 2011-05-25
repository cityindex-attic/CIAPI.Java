package codegen.codetemplates;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CodeTemplateTest {
	private CodeTemplate template;

	@Before
	public void setUp() {
	}

	@After
	public void tearDOwn() {
		template = null;
	}

	@Test
	public void testLoadTemplate() throws FileNotFoundException {
		template = CodeTemplate.loadTemplate(new File("files/test/TestTemplate.jav"));
		CompoundCodeTemplate innerTemplate = (CompoundCodeTemplate) template.getTemplateEntry("quotes");
		for (int i = 0; i < 5; i++) {
			CodeTemplate innerTemplatePattern = innerTemplate.getEmptyTemplate();
			innerTemplatePattern.putNewTemplateDefinition("quote", "This is important quote number " + i);
			innerTemplatePattern.putNewTemplateDefinition("author", "Author number " + i);
			innerTemplate.addMappingSet(innerTemplatePattern);
		}
		System.out.println(template.codeReplacement());
		assertTrue(true);
	}
}
