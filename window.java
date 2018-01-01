import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class window {

	private JFrame frame;
	private JTextField textField;
	private Assigner assigner;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window window = new window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 516, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		assigner = new Assigner();
		
		JTextArea display = new JTextArea();
		display.setEditable(false);
		display.setText("Secret Santa Members:" + assigner.getMembers());
		
		JButton btnClear = new JButton("Return to list");
		btnClear.setEnabled(false);
		
		JButton btnAssignSantas = new JButton("Assign Santas");
		
		JButton btnAdd = new JButton("Add");
		
		JButton btnCheck = new JButton("Check");
		btnCheck.setEnabled(false);
		
		/**
		 * Sets the responses for the Check button	
		 */
		btnCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(btnCheck.isEnabled()) {
					String name = textField.getText();
					if(assigner.containsAssignment(name)) {
			            display.setText("You will get a gift for " + assigner.getAssignment(name) + ".");
			        	}
			       	else {
			            	display.setText("Type in your name.");
			            	btnClear.setEnabled(true);
			        	}
				 	btnClear.setEnabled(true);
				}
			}
		});
		
		
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		/**
		 * Sets the responses to the Add button
		 */
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(btnAdd.isEnabled()) {
					if (textField.getText().length() > 0 && ! assigner.containsUnassigned(textField.getText())) {
						assigner.addPerson(textField.getText());
						display.setText("Secret Santa Members: " + assigner.getMembers());
						textField.setText("");
					}
					else {
						display.setText("Please type in a name.");
						btnClear.setEnabled(true);
					}
				}
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		/**
		 * Sets the responses to the Assign Santas button
		 */
		btnAssignSantas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(btnAssignSantas.isEnabled()) {
					if(assigner.getUnassignedSize() > 1) {
						assigner.assignSecretSantas();
						btnCheck.setEnabled(true);
						btnAdd.setEnabled(false);
						btnAssignSantas.setEnabled(false);
						}
					else {
						display.setText("You need to add more people to this Secret Santa before \n assigning Santas.");
					}
				
				}
			}
		});
		
		/**
		 * Sets the responses to the Clear button.
		 */
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(btnClear.isEnabled()) {
					display.setText("Secret Santa Members: " + assigner.getMembers());
					textField.setText("");
					btnClear.setEnabled(false);
				}
			}
		});
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		/**
		 * Auto-generated, unedited code. 
		 */		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnCheck, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
								.addComponent(btnAdd, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(display, GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnClear, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnAssignSantas, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(display, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAssignSantas, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAdd)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCheck, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
