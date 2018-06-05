package cc.code;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PessoaTest {

	private Pessoa pessoa;

	@Before
	public void setUp() throws Exception {
		pessoa = new Pessoa();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void deveCriarUmaPessoaValida(){
		Pessoa daniel = new Pessoa("Daniel", "123", "9999999");

		assertEquals(0,daniel.isValid().size());
	}


}
