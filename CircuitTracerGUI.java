import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A GUI for displaying CircuitTracer solutions.
 * @author Gabriel Tinsley
 */
public class CircuitTracerGUI {
    private JTextArea textArea;
    private ArrayList<TraceState> paths;

    /**
     * Create a new CircuitTracerGUI with the given paths.
     * @param paths the paths to display
     */
    public CircuitTracerGUI(ArrayList<TraceState> paths) {
        this.paths = paths;
        JFrame frame = new JFrame("Circuit Tracer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(paths.size(), 1));
        for(int i = 0; i < paths.size(); i++) {
            JButton button = new JButton("Solution " + (i + 1));
            button.setName(i + "");
            button.addActionListener(new SolutionButtonActionListener());
            buttonPanel.add(button, 0, i);
        }
        panel.add(buttonPanel, BorderLayout.EAST);
        textArea = (new JTextArea());
        panel.add(textArea, BorderLayout.CENTER);
        frame.add(panel);
        frame.setVisible(true);
    }
    
    /**
     * ActionListener for the solution buttons.
     */
    private class SolutionButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           JButton b = (JButton) e.getSource();
           textArea.setText(paths.get(Integer.parseInt(b.getName())).getBoard().toString());
        }
    }
}

