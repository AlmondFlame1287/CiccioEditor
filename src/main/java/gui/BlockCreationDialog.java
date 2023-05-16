package gui;

import blocks.Block;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BlockCreationDialog extends JDialog implements MouseListener {
    private static final int WIDTH = 512;
    private static final int HEIGHT = 700;
    private static final JTextField NEW_BLOCK_NAME_FIELD = new JTextField("Block name: ");
    private static final byte BRUSH_SIZE = 16;
    private Color colorChosen;
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton showDialog = new JButton("showdialog");
        BlockCreationDialog dialog = new BlockCreationDialog();

        panel.add(showDialog);
        showDialog.addActionListener(evt -> dialog.setVisible(true));
        dialog.setLocationRelativeTo(panel);

        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public BlockCreationDialog() {
        this.addMouseListener(this);
        this.setSize(WIDTH, HEIGHT);
        this.init();
    }

    private void init() {
        this.setLayout(null);
        this.initButtons();
    }

    private void initButtons() {
        final Dimension buttonSize = new Dimension(150, 25);
        final JButton done = new JButton("Done");
        final JButton changeColor = new JButton("Change color");

        done.addActionListener(evt -> this.setVisible(false));
        changeColor.addActionListener(evt -> this.colorChosen = JColorChooser.showDialog(this, "pick color", Color.WHITE));

        done.setBounds(0, HEIGHT - buttonSize.height, buttonSize.width, buttonSize.height);
        changeColor.setBounds(WIDTH - buttonSize.width, HEIGHT - buttonSize.height, buttonSize.width, buttonSize.height);

        this.add(done);
        this.add(changeColor);
    }

    private void drawColor(int x, int y, Color color) {
        if(colorChosen == null || y > WIDTH) return;

        int drawingX = x / BRUSH_SIZE * BRUSH_SIZE;
        int drawingY = y / BRUSH_SIZE * BRUSH_SIZE;

        this.getGraphics().setColor(color);
        this.getGraphics().fillRect(drawingX, drawingY, BRUSH_SIZE, BRUSH_SIZE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawLine(0, 512, 512, 512);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.drawColor(e.getX(), e.getY(), colorChosen);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
