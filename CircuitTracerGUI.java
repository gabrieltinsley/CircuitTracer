import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A GUI for displaying CircuitTracer solutions.
 * @author Gabriel Tinsley
 */
public class CircuitTracerGUI {
    private JButton[][] buttons; 
    private ArrayList<TraceState> paths;
    private int rows;
    private int cols;

    /**
     * Create a new CircuitTracerGUI with the given paths.
     * @param paths the paths to display
     */
    public CircuitTracerGUI(ArrayList<TraceState> paths, int rows, int cols) {
        this.paths = paths;
        this.rows = rows;
        this.cols = cols;

        JFrame frame = new JFrame("Circuit Tracer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(paths.size(), 1));

        // Initialize the buttons for each solution
        for (int i = 0; i < paths.size(); i++) {
            JButton button = new JButton("Solution " + (i + 1));
            button.setName(i + "");
            button.addActionListener(new SolutionButtonActionListener());
            buttonPanel.add(button);
        }
        panel.add(buttonPanel, BorderLayout.EAST);

        // Initialize the grid of solutions
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(rows, cols));
        buttons = new JButton[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                buttons[row][col] = new JButton();
                gridPanel.add(buttons[row][col]);
            }
        }
        panel.add(gridPanel, BorderLayout.CENTER);

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
            int pathIndex = Integer.parseInt(b.getName());
            TraceState path = paths.get(pathIndex);
            CircuitBoard board = path.getBoard();
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if(board.charAt(row, col) == 'T') {
                        buttons[row][col].setForeground(Color.RED);
                        buttons[row][col].setText(board.charAt(row, col) + "");
                        buttons[row][col].setFont(new Font("Arial", Font.BOLD, 20));
                    } else {
                        buttons[row][col].setForeground(Color.BLACK);
                        buttons[row][col].setText(board.charAt(row, col) + "");
                        buttons[row][col].setFont(new Font("Arial", Font.PLAIN, 20));
                    }
                }
            }
        }
    }
}

