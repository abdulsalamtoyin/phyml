
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class for implementing all "Optimise Tree Topology" and "Starting tree"
 * components as well as setting their size and location.
 * 
 * @author Christoph Knapp
 * 
 */

public class OptTopologyAndStartingTree extends JPanel implements
		ActionListener {
	/**
	 * default id
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox optTopBox;
	private JComboBox staTreBox;
	private String[] staTreArr1;
	private String[] staTreArr2;
	private String userDefStartTreePath;

	/**
	 * Constructor to instatiate all components and setting their size and
	 * location.
	 */
	public OptTopologyAndStartingTree() {
		userDefStartTreePath = "";
		optTopBox = new JComboBox(new String[] { "yes", "no" });
		optTopBox.addActionListener(this);
		staTreArr1 = new String[] { "BioNJ", "parsimony", "user tree" };
		staTreArr2 = new String[] { "BioNJ", "user tree" };
		staTreBox = new JComboBox(staTreArr1);
		staTreBox.addActionListener(this);
		CustomGridLayout layout = new CustomGridLayout();
		setLayout(layout);
		layout.setDimensions(1, 0.1);
		add(new JPanel());
		layout.setDimensions(0.01, 0.8);
		add(new JPanel());
		layout.setDimensions(0.44, 0.8);
		JPanel p1 = new JPanel();
		add(p1);
		layout.setDimensions(0.1, 0.8);
		add(new JPanel());
		layout.setDimensions(0.44, 0.8);
		JPanel p2 = new JPanel();
		add(p2);
		layout.setDimensions(0.01, 0.8);
		add(new JPanel());
		layout.setDimensions(1, 0.1);
		add(new JPanel());
		CustomGridLayout lO1 = new CustomGridLayout();
		p1.setLayout(lO1);
		lO1.setDimensions(0.62, 1);
		p1.add(new JLabel("Optimise Tree Topology"));
		lO1.setDimensions(0.1, 1);
		p1.add(new JLabel());
		lO1.setDimensions(0.28, 1);
		p1.add(optTopBox);
		CustomGridLayout lO2 = new CustomGridLayout();
		p2.setLayout(lO2);
		lO2.setDimensions(0.62, 1);
		p2.add(new JLabel("Starting Tree"));
		lO2.setDimensions(0.1, 1);
		p2.add(new JLabel());
		lO2.setDimensions(0.28, 1);
		p2.add(staTreBox);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == optTopBox) {
			int index = staTreBox.getSelectedIndex();
			if (optTopBox.getSelectedItem().toString().equals("no")) {
				staTreBox.setModel(new DefaultComboBoxModel(staTreArr2));
				if (index == 1) {
					staTreBox.setSelectedIndex(0);
				} else if (index == 2) {
					staTreBox.setSelectedIndex(1);
				}
				PhymlPanel.tS.setOptBraLenToYes(false);
			} else {
				staTreBox.setModel(new DefaultComboBoxModel(staTreArr1));
				if (index == 1) {
					staTreBox.setSelectedIndex(2);
				}
				PhymlPanel.tS.setOptBraLenToYes(true);
			}
		} else if (e.getSource() == staTreBox) {
			if (staTreBox.getSelectedItem().toString().equals("user tree")) {
				JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new File(System.getProperty("user.dir")));
				int returnVal = fc.showOpenDialog(this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					userDefStartTreePath = fc.getSelectedFile()
							.getAbsolutePath();
				}
				if (userDefStartTreePath.equals("")) {
					staTreBox.setSelectedIndex(0);
				}
			} else {
				userDefStartTreePath = "";
			}
		}
	}

	/**
	 * What starting tree to use.
	 * 
	 * @return 
	 * String : "" if BioNJ or a user tree is selected, "parsimony"
	 * parsimony is selected.
	 */
	public String getStartTree() {
		if (staTreBox.getSelectedIndex() == 0
				|| staTreBox.getSelectedIndex() == 2) {
			return "";
		}
		return staTreBox.getSelectedItem().toString();
	}

	/**
	 * Retrieves the path to the user tree file.
	 * 
	 * @return 
	 * String : full path to the user defined starting tree file.
	 */
	public String getTreeFile() {
		if (staTreBox.getSelectedIndex() > 1) {
			return userDefStartTreePath;
		}
		return "";
	}

	/**
	 * Whether the tree topology should be optimised or not.
	 * 
	 * @return 
	 * boolean : true if the tree toplogy is supposed to be optimised,
	 * otherwise false.
	 */
	public boolean isOptimiseTreeTopology() {
		if (optTopBox.getSelectedItem().toString().equals("yes")) {
			return true;
		}
		return false;
	}
}