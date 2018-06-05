package cc.code;

import cc.code.ValidationHaduken.Pessoa;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ValidationHadukenTest {

	ValidationHaduken validation;
	
	@Before
	public void setUp() throws Exception {
		validation = new ValidationHaduken();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void validaPessoaNula() {
		Pessoa pessoaNula = null;
		List<String> listaAtual = validation.validaPessoa(pessoaNula);
		assertEquals(1, listaAtual.size());
		assertEquals("Erro - deveria ter uma pessoa", listaAtual.get(0));
	}
	
	@Test
	public void validaSeCPFNulo() {
		Pessoa cpfPessoa = validation.p;
				
		List<String> listaAtual = validation.validaPessoa(cpfPessoa);
		assertEquals(1, listaAtual.size());
		assertEquals("Erro - deveria ter cpf definido", listaAtual.get(0));
	}
	
	@Test
	public void validaPessoaComCPF() {
		Pessoa pessoa = validation.p;
		pessoa.cpf = "123456";
		
		List<String> listaAtual = validation.validaPessoa(pessoa);
		assertEquals(1, listaAtual.size());
		assertNotEquals("Erro - deveria ter cpf definido", listaAtual.get(0));
		assertEquals("Erro - deveria ter nome definido", listaAtual.get(0));
	}
	
	@Test
	public void validaPessoaComNome() {
		Pessoa pessoa = validation.p;
		pessoa.cpf = "123456";
		pessoa.name = "batata";
		
		List<String> listaAtual = validation.validaPessoa(pessoa);
		assertEquals(1, listaAtual.size());
		assertEquals("Erro - deveria ter pelo menos um telefone", listaAtual.get(0));
		assertNotEquals("Erro - deveria ter nome definido", listaAtual.get(0));
	}
	
	@Test
	public void validaPessoaComNomeNulo() {
		Pessoa pessoa = validation.p;
		pessoa.cpf = "123456";
		
		List<String> listaAtual = validation.validaPessoa(pessoa);
		assertEquals(1, listaAtual.size());
		assertNotEquals("Erro - deveria ter cpf definido", listaAtual.get(0));
		assertEquals("Erro - deveria ter nome definido", listaAtual.get(0));
	}
}
