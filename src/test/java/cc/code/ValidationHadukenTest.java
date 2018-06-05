package cc.code;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ValidationHadukenTest {

	private ValidationHaduken validation;

	private Pessoa pessoa;

	@Before
	public void setUp() throws Exception {
		validation = new ValidationHaduken();
		pessoa = new Pessoa();
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
		List<String> listaAtual = validation.validaPessoa(pessoa);
		assertEquals(1, listaAtual.size());
		assertEquals("Erro - deveria ter cpf definido", listaAtual.get(0));
	}
	
	@Test
	public void validaPessoaComCPF() {
		pessoa.cpf = "123456";
		
		List<String> listaAtual = validation.validaPessoa(pessoa);
		assertEquals(1, listaAtual.size());
		assertNotEquals("Erro - deveria ter cpf definido", listaAtual.get(0));
		assertEquals("Erro - deveria ter nome definido", listaAtual.get(0));
	}
	
	@Test
	public void validaPessoaComNome() {
		pessoa.cpf = "123456";
		pessoa.name = "batata";
		
		List<String> listaAtual = validation.validaPessoa(pessoa);
		assertEquals(1, listaAtual.size());
		assertEquals("Erro - deveria ter pelo menos um telefone", listaAtual.get(0));
		assertNotEquals("Erro - deveria ter nome definido", listaAtual.get(0));
	}
	
	@Test
	public void validaPessoaComNomeNulo() {
		pessoa.cpf = "123456";
		
		List<String> listaAtual = validation.validaPessoa(pessoa);
		assertEquals(1, listaAtual.size());
		assertNotEquals("Erro - deveria ter cpf definido", listaAtual.get(0));
		assertEquals("Erro - deveria ter nome definido", listaAtual.get(0));
	}

	@Test
	public void validaListaDeTelefonesVaziaParaPessoa(){
		pessoa.name = "Adamatti";
		pessoa.cpf = "123";
		List<String> listaAtual = validation.validaPessoa(pessoa);

		assertEquals(1, listaAtual.size());
		assertEquals("Erro - deveria ter pelo menos um telefone",listaAtual.get(0));

	}

	@Test
	public void deveCriarUmaPessoaValida(){
		pessoa.name= "Daniel";
		pessoa.cpf = "123";
		pessoa.telefonesFixos = Arrays.asList("9999999");

		List<String> listaAtual = validation.validaPessoa(pessoa);
		assertEquals(0, listaAtual.size());

	}

	@Test
	public void validaTelefoneInvalido() {
		pessoa.name= "Daniel";
		pessoa.cpf = "123";
		List<String> telefones = new ArrayList<>();
		telefones.add(null);
		pessoa.telefonesFixos = telefones;

		List<String> listaAtual = validation.validaPessoa(pessoa);
		assertEquals(1, listaAtual.size());
		assertEquals("Erro - Telefone inválido",listaAtual.get(0));

		// Scenario 2
		pessoa.telefonesFixos = Arrays.asList("");
		listaAtual = validation.validaPessoa(pessoa);

		assertEquals(1, listaAtual.size());
		assertEquals("Erro - Telefone inválido",listaAtual.get(0));

		// Scenario 3
		pessoa.telefonesFixos = Arrays.asList("123");
		listaAtual = validation.validaPessoa(pessoa);

		assertEquals(1, listaAtual.size());
		assertEquals("Erro - Telefone inválido",listaAtual.get(0));
	}
}
