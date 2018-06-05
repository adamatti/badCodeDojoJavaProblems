package cc.code;

import java.util.ArrayList;
import java.util.List;

public class ValidationHaduken {

	public List<String> validaPessoa(Pessoa pessoa) {
		
		List<String> constraints = new ArrayList<String>();
		if (pessoa == null) {
			constraints.add("Erro - deveria ter uma pessoa");
			return constraints;
		}

		if (pessoa.cpf == null) {
			constraints.add("Erro - deveria ter cpf definido");
			return constraints;
		}

		if (pessoa.name == null) {
			constraints.add("Erro - deveria ter nome definido");
			return constraints;
		}

		if (validaTelefone(pessoa, constraints)) return constraints;

		return constraints;
	}

	private boolean validaTelefone(Pessoa pessoa, List<String> constraints) {
		if (pessoa.telefonesFixos == null) {
			constraints.add("Erro - deveria ter pelo menos um telefone");
			return true;
		}

		for (String telefone : pessoa.telefonesFixos) {
			if (
				telefone == null ||
				telefone.isEmpty() ||
				telefone.length() < 7
			) {
				constraints.add("Erro - Telefone inválido");
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ValidationHaduken vh = new ValidationHaduken();
		Pessoa p = new Pessoa();
		p.cpf = "111";
		p.name = "name";
		p.telefonesFixos = null;
		
		List<String> retorno = vh.validaPessoa(p);
		System.out.println(retorno.toString());
		
	}

}

