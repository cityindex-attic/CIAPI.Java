package codegen.codetemplates;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CodeTemplateTest {
	private CodeTemplate template;
	private static final String templateString = "<@@quotes@@><@quote@>: <@author@>\n<@@@@>";

	@Before
	public void setUp() throws FileNotFoundException {
		template = new CodeTemplate(templateString);
	}

	@After
	public void tearDown() {
		template = null;
	}

	@Test
	public void testLoadSimpleCodeTemplate() throws FileNotFoundException {
		template = CodeTemplate.loadTemplate(new File(
				"files/test/TestTemplate.jav"));
		Assert.assertTrue(true);
	}

	@Test
	public void testCodeTemplateStuff(){
		// Wow, this code sucks....
		CompoundCodeTemplate compound = (CompoundCodeTemplate) template.getTemplateEntry("quotes");
		CodeTemplate temp = compound.getEmptyTemplate().copyEmptyTemplate();
		temp.putNewTemplateDefinition("quote", "I smell sunshine!");
		temp.putNewTemplateDefinition("author", "A crazy person");
		compound.addMappingSet(temp);
		temp = compound.getEmptyTemplate().copyEmptyTemplate();
		temp.putNewTemplateDefinition("quote", "Whoop da whoop");
		temp.putNewTemplateDefinition("author", "Me!!");
		compound.addMappingSet(temp);
		String code =template.codeReplacement();
		System.out.println(code);
		Assert.assertTrue(true);
	}
}
