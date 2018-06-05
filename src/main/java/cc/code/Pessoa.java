package cc.code;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {

    public List<String> telefonesFixos;

    public String name;

    public String cpf;

    @Deprecated
    public Pessoa() { }

    public Pessoa(String name, String cpf, String telefone) {
        this.telefonesFixos = new ArrayList<>();
        this.telefonesFixos.add(telefone);
        this.name = name;
        this.cpf = cpf;
    }

    public List<String> isValid() {

        List<String> constraints = new ArrayList<String>();

        if (this.cpf == null) {
            constraints.add("Erro - deveria ter cpf definido");
            return constraints;
        }

        if (this.name == null) {
            constraints.add("Erro - deveria ter nome definido");
            return constraints;
        }

        if (validaTelefone(constraints)) {
            return constraints;
        }

        return constraints;
    }

    private boolean validaTelefone(List<String> constraints) {
        if (telefonesFixos == null) {
            constraints.add("Erro - deveria ter pelo menos um telefone");
            return true;
        }

        for (String telefone : telefonesFixos) {
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
}
