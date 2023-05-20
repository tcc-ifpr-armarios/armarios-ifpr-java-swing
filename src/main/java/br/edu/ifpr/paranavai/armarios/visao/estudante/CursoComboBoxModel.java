package br.edu.ifpr.paranavai.armarios.visao.estudante;

import br.edu.ifpr.paranavai.armarios.modelo.Curso;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author professor Marcelo Figueiredo Terenciani
 */
public class CursoComboBoxModel extends AbstractListModel implements ComboBoxModel {

    private List<Curso> listaDeCursos;
    private Curso cursoSelecionado;

    public CursoComboBoxModel() {
        listaDeCursos = new ArrayList<Curso>();
    }

    @Override
    public int getSize() {
        return listaDeCursos.size();
    }

    @Override
    public Object getElementAt(int index) {
        return listaDeCursos.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        if (anItem instanceof Curso) {
            this.cursoSelecionado = (Curso) anItem;
            fireContentsChanged(this.cursoSelecionado, 0, this.getSize());
        }
    }

    @Override
    public Object getSelectedItem() {
        return this.cursoSelecionado;
    }

    public void addCurso(Curso curso) {
        this.listaDeCursos.add(curso);
    }

    public void reset() {
        this.listaDeCursos.clear();
    }
}
