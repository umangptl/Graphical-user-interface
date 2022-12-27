import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import java.util.Map;
import java.util.TreeMap;

public class Main extends JFrame implements ComponentListener {

    private final JPanel contentPanel;
    private final JButton button;
    private final JComboBox dropdown;
    private final JSlider verticalSlider;
    private final JSlider horizontalSlider;
    private final Map<String, Color> colors;
    private static final int CircleRadius = 40;
    private boolean shown;

    public static void main(String[] args) {
        final Main main = new Main();
        SwingUtilities.invokeLater(() -> main.setVisible(true));
    }

    // calling all methods
    private Main() {
        frame();
        colors = ChangeColor();
        contentPanel = Canvas();
        button = putButton();
        dropdown = ComboBox();
        verticalSlider = vertSlider();
        horizontalSlider = horizSlider();
        shown = false;
    }

    // setting frame
    private void frame() {
        setTitle("CSC 420 Assignment 2");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100,100,600,500);
        setResizable(false);
        addComponentListener(this);
        setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
    }

    // setting colors
    private Map<String, Color> ChangeColor() {
        final Map<String, Color> colors = new TreeMap<>();
        colors.put("BLACK", Color.BLACK);
        colors.put("BLUE", Color.BLUE);
        colors.put("CYAN", Color.CYAN);
        colors.put("GREEN", Color.GREEN);
        colors.put("ORANGE", Color.ORANGE);
        colors.put("PINK", Color.PINK);
        colors.put("RED", Color.RED);
        colors.put("YELLOW", Color.YELLOW);
        return colors;
    }

    //setting the left scroll bar
    private JSlider vertSlider() {
        final JSlider leftSlider = new JSlider(JSlider.VERTICAL);
        leftSlider.setMinimum((CircleRadius/2));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(6, 6, 6, 6);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.VERTICAL;
        leftSlider.setInverted(true);
        leftSlider.addChangeListener(changeEvent -> contentPanel.repaint());
        add(leftSlider,constraints);

        return leftSlider;
    }

    //setting the bottom scroll bar
    private JSlider horizSlider() {
        final JSlider bottomSlider = new JSlider(JSlider.HORIZONTAL);
        bottomSlider.setMinimum((CircleRadius/2));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(6, 6, 6, 6);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(bottomSlider,constraints);
        bottomSlider.addChangeListener(e ->contentPanel.repaint());

        return bottomSlider;
    }

    // setting button show/hide
    private JButton putButton() {
        final JButton button = new JButton("SHOW");
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(6, 6, 6, 6);
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.fill = GridBagConstraints.BOTH;
        button.addActionListener(a -> {

            if(button.getText().equals("SHOW")) {
                button.setText("HIDE");
                dropdown.setEnabled(false);
                verticalSlider.setEnabled(false);
                horizontalSlider.setEnabled(false);
            } else {
                button.setText("SHOW");
                dropdown.setEnabled(true);
                verticalSlider.setEnabled(true);
                horizontalSlider.setEnabled(true);
            }
            contentPanel.repaint();
        });
        add(button,constraints);

        return button;
    }

    // setting scrollbar
    private JComboBox ComboBox() {
        final JComboBox comboBox = new JComboBox<>(colors.keySet().toArray());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(6, 6, 6, 6);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.fill = GridBagConstraints.BOTH;
        add(comboBox,constraints);

        return comboBox;
    }

    // setting the canvas
    private JPanel Canvas() {
        final JPanel canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                final int x = horizontalSlider.getValue();
                final int y = verticalSlider.getValue();
                final String buttonText = button.getText();
                if(buttonText.equals("SHOW")) {
                    g.drawLine(x, y - 5, x, y + 5);
                    g.drawLine(x - 5, y, x + 5, y);
                } else if(buttonText.equals("HIDE")) {
                    final int offset = CircleRadius / 2;
                    g.setColor(colors.get(dropdown.getSelectedItem()));
                    g.fillOval(x - offset, y - offset, CircleRadius,CircleRadius);
                }
            }
        };

        canvas.setBackground(Color.WHITE);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(6, 6, 6, 6);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.BOTH;
        add(canvas, constraints);

        return canvas;
    }

    @Override
    public void componentResized(ComponentEvent e) {
        if(shown) {
            verticalSlider.setMaximum(contentPanel.getHeight());
            horizontalSlider.setMaximum(contentPanel.getWidth());
        }
    }

    @Override
    public void componentMoved(ComponentEvent e) {}

    @Override
    public void componentShown(ComponentEvent e) {
        verticalSlider.setMaximum(contentPanel.getHeight() - (CircleRadius/2));
        verticalSlider.setValue(verticalSlider.getMaximum()/2);
        horizontalSlider.setMaximum(contentPanel.getWidth() - (CircleRadius/2));
        horizontalSlider.setValue(horizontalSlider.getMaximum()/2);
        shown = true;
    }

    @Override
    public void componentHidden(ComponentEvent e) {}
}
