package guiLayer;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import appLayer.CommandFactory;
import appLayer.Invoker;
import appLayer.Drawing.DrawingPanel;

public class MainDisplay {
	private JFrame frame;
	private JPanel buttonsPanel;
	private DrawingPanel drawingPanel = new DrawingPanel();
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem nMenu, sMenu, lMenu, uMenu, rMenu;
	private JButton classButton, binButton, depButton, gsButton, aggButton, compButton; 
	private Invoker invoker = new Invoker();
	private Point startingPoint;
    private PossibleModes mode = PossibleModes.None;
    private String filename;
	
	private enum PossibleModes
    {
        None,
        BinaryLine,
        AggregationLine,
        CompositionLine,
        GenSpeLine,
        DependencyLine,
        ClassBox,
    };
	
	public MainDisplay(){
		initializeGUI();
		CommandFactory.getInstance().invoker = this.invoker;
		CommandFactory.getInstance().drawingPanel = this.drawingPanel;
	}
	
	private void initializeGUI(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("New UML Diagram");
		frame.setSize(1000,600);
		frame.setLocationRelativeTo(null);
		
		createMenuBar(frame);
		
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.PAGE_AXIS));
		buttonsPanel.setBackground(Color.GRAY);
		buttonsPanel.setLocation(0,0);
		buttonsPanel.setSize(200, 600);
		
		createButtons(buttonsPanel);

		drawingPanel.setBackground(Color.WHITE);
		drawingPanel.setLocation(200, 0);
		drawingPanel.setSize(800, 600);
		
		drawingPanel.addMouseListener(new MouseAdapter() {
		    @Override
            public void mousePressed(MouseEvent e) {
		    	startingPoint = e.getPoint();
            }
		});
		
		drawingPanel.addMouseListener(new MouseAdapter() {
		    @Override
            public void mouseReleased(MouseEvent e) {
		    	switch (mode)
	            {
	                case ClassBox:
                    	CommandFactory.getInstance().CreateAndDo("ADDC", e.getPoint());
                    	mode = PossibleModes.None;
                        break;
	                case BinaryLine:
	                    CommandFactory.getInstance().CreateAndDo("ADDR", "bin", startingPoint, e.getPoint());
	                    break;
	                case AggregationLine:
	                    CommandFactory.getInstance().CreateAndDo("ADDR", "agg", startingPoint, e.getPoint());
	                    break;
	                case CompositionLine:
	                    CommandFactory.getInstance().CreateAndDo("ADDR", "comp", startingPoint, e.getPoint());
	                    break;
	                case GenSpeLine:
	                    CommandFactory.getInstance().CreateAndDo("ADDR", "genspe", startingPoint, e.getPoint());
	                    break;
	                case DependencyLine:
	                    CommandFactory.getInstance().CreateAndDo("ADDR", "dep", startingPoint, e.getPoint());
	                    break;  
	                default:
	                	break;
	            }
            }
		});

		frame.add(drawingPanel);
		frame.add(buttonsPanel);
		frame.setVisible(true);
		
	}
	
	private void createButtons(JPanel panel){
		
		classButton = new JButton("New Class");
		panel.add(classButton);
		classButton.addMouseListener(new MouseAdapter() {
		    @Override
            public void mouseReleased(MouseEvent e) {
            	mode = PossibleModes.ClassBox;
            }
        });
		
		binButton = new JButton("New Binary Association");
		panel.add(binButton);
		binButton.addMouseListener(new MouseAdapter() {
		    @Override
            public void mouseReleased(MouseEvent e) {
            	mode = PossibleModes.BinaryLine;
            }
        });
		
		depButton = new JButton("New Dependency");
		panel.add(depButton);
		depButton.addMouseListener(new MouseAdapter() {
		    @Override
            public void mouseReleased(MouseEvent e) {
            	mode = PossibleModes.DependencyLine;
            }
        });
		
		gsButton = new JButton("New Gen/Spec");
		panel.add(gsButton);
		gsButton.addMouseListener(new MouseAdapter() {
		    @Override
            public void mouseReleased(MouseEvent e) {
            	mode = PossibleModes.GenSpeLine;
            }
        });
		
		aggButton = new JButton("New Aggregation");
		panel.add(aggButton);
		aggButton.addMouseListener(new MouseAdapter() {
		    @Override
            public void mouseReleased(MouseEvent e) {
            	mode = PossibleModes.AggregationLine;
            }
        });
		
		compButton = new JButton("New Composition");
		panel.add(compButton);
		compButton.addMouseListener(new MouseAdapter() {
		    @Override
            public void mouseReleased(MouseEvent e) {
            	mode = PossibleModes.CompositionLine;
            }
        });
		
	}
	
	private void createMenuBar(JFrame frame){
		menuBar = new JMenuBar();
		
		menu = new JMenu("Settings");
		menuBar.add(menu);
		
		nMenu = new JMenuItem("New");
		menu.add(nMenu);
		nMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	CommandFactory.getInstance().CreateAndDo("new", drawingPanel);
            }
        });
		
		sMenu = new JMenuItem("Save");
		menu.add(sMenu);
		sMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JFileChooser fileChooser = new JFileChooser();
            	if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            	  File file = fileChooser.getSelectedFile();
            	  filename = file.getAbsolutePath();
            	}
            	CommandFactory.getInstance().CreateAndDo("save", filename);
            }
        });
		
		lMenu = new JMenuItem("Load");
		menu.add(lMenu);
		lMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JFileChooser fileChooser = new JFileChooser();
            	if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            	  File file = fileChooser.getSelectedFile();
            	  filename = file.getAbsolutePath();
            	}
            	CommandFactory.getInstance().CreateAndDo("load", filename);
            }
        });
		
		uMenu = new JMenuItem("Undo");
		uMenu.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		menu.add(uMenu);
		uMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	invoker.undo();
            }
        });
		
		rMenu = new JMenuItem("Redo");
		rMenu.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		menu.add(rMenu);
		rMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	invoker.redo();
            }
        });
		
		frame.setJMenuBar(menuBar);
	}

}
