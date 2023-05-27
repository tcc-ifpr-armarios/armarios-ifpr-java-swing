package br.edu.ifpr.paranavai.armarios.visao.combobox;

import br.edu.ifpr.paranavai.armarios.modelo.Estudante;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author professor Marcelo Figueiredo Terenciani
 */
public class EstudanteComboBoxModel extends AbstractListModel implements ComboBoxModel {

    private List<Estudante> listaDeEstudantes;
    private Estudante cursoSelecionado;

    public EstudanteComboBoxModel() {
        listaDeEstudantes = new ArrayList<Estudante>();
    }

    @Override
    public int getSize() {
        return listaDeEstudantes.size();
    }

    @Override
    public Object getElementAt(int index) {
        return listaDeEstudantes.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        if (anItem instanceof Estudante) {
            this.cursoSelecionado = (Estudante) anItem;
            fireContentsChanged(this.cursoSelecionado, 0, this.getSize());
        }
    }

    @Override
    public Object getSelectedItem() {
        return this.cursoSelecionado;
    }

    public void addEstudante(Estudante curso) {
        this.listaDeEstudantes.add(curso);
    }

    public void reset() {
        this.listaDeEstudantes.clear();
    }
}
