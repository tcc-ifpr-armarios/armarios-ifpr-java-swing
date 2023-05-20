package br.edu.ifpr.paranavai.armarios.visao.tabela.acoes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Professor Marcelo Figueiredo Terenciani
 */
public class AcoesDoBotao extends JButton {

    private boolean mousePressionado;

    public AcoesDoBotao() {
        setContentAreaFilled(false);  // ícone com o fundo transparente
        setBorder(new EmptyBorder(3, 3, 3, 3));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mousePressionado = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mousePressionado = false;
            }

        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        int size = Math.min(width, height);

        int x = (width - size) / 2;
        int y = (height - size) / 2;

        if (mousePressionado) {
            g2.setColor(new Color(158, 158, 158));
        } else {
            g2.setColor(new Color(199, 199, 199));
        }

        g2.fill(new Ellipse2D.Double(x, y, size, size));
        g2.dispose();

        super.paintComponent(g);
    }

}
