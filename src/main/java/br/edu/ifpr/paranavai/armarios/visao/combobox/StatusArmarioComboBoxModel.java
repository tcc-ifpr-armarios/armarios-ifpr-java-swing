package br.edu.ifpr.paranavai.armarios.visao.combobox;

import br.edu.ifpr.paranavai.armarios.modelo.StatusArmario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Ifpr
 */
public class StatusArmarioComboBoxModel extends AbstractListModel implements ComboBoxModel {

    private List<StatusArmario> statusArmarios;
    private StatusArmario statusSelecionado;

    public StatusArmarioComboBoxModel() {
        statusArmarios = new ArrayList<StatusArmario>();
    }

    @Override
    public int getSize() {
        return statusArmarios.size();
    }

    @Override
    public Object getElementAt(int index) {
        return statusArmarios.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        if (anItem instanceof StatusArmario) {
            this.statusSelecionado = (StatusArmario) anItem;
            fireContentsChanged(this.statusSelecionado, 0, this.getSize());
        }
    }

    @Override
    public Object getSelectedItem() {
        return this.statusSelecionado;
    }

    public void addStatusArmario(StatusArmario curso) {
        this.statusArmarios.add(curso);
    }

    public void reset() {
        this.statusArmarios.clear();
    }
}
