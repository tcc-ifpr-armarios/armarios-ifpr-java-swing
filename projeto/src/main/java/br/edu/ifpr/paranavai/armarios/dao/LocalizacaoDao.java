package br.edu.ifpr.paranavai.armarios.dao;

import java.util.List;
import br.edu.ifpr.paranavai.armarios.modelo.Localizacao;

public interface LocalizacaoDao {

    public List<Localizacao> buscarTodos();

    public Localizacao buscarPorId(Integer inteiro);

    public void atualizar(Localizacao localizacao);

    public void excluir(Localizacao localizacao);

    public void inserir(Localizacao localizacao);
}
