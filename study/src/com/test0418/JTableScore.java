package com.test0418;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class JTableScore extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JTextField tf[] = new JTextField[4];
	private JButton but1, but2;

	private JTable table;
	private MyTableModel model;

	public JTableScore(String title) {
		// �������� Ÿ��Ʋ ����(���� setTitle("����")
		super(title);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//�⺻ BorderLayout�� ������. �������� ����
		setLayout(null);

		String caption[] = { "�̸� :", "���� :", "���� :", "���� :" };
		for (int i = 0; i < 4; i++) {
			JLabel lbl = new JLabel();
			lbl.setText(caption[i]);
			//������ġ�� ������Ʈ ����(x, y, ��, ����)
			lbl.setBounds(10, (i + 1) * 30, 50, 20);
			add(lbl); //�����ӿ� ����
			
			//�ݵ�� new �ؾ���
			tf[i] = new JTextField(); //���� �Է¸� ����			
			this.tf[i].setBounds(80, (i + 1) * 30, 70, 20);
			//�ؽ�Ʈ�ʵ��� Ű���� �̺�Ʈ ó��
			tf[i].addKeyListener(new KeyHandler());
			add(this.tf[i]);
		}

		but1 = new JButton("�߰�");
		but1.addActionListener(this);
		but1.addKeyListener(new KeyHandler());
		but1.setBounds(10, 160, 60, 20);
		add(but1);

		but2 = new JButton("����");
		but2.addActionListener(this);
		but2.setBounds(90, 160, 60, 20);
		add(but2);

		// ���̺� �߰�
		addTable();
		
		setResizable(false);
		setSize(550, 250);
		setVisible(true);
	}

	public static void main(String[] args) {
		new JTableScore("���� ó��");
	}

	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == but1) {
			insertData();
		} else if (evt.getSource() == but2) {
			System.exit(0);
		}
	}

	public void addTable() {
		String[] title = { "�̸�", "����", "����", "����", "����", "���" };
		model = new MyTableModel(title);
		table = new JTable(model);

		JScrollPane scrollPane = new JScrollPane(table);

		scrollPane.setBounds(160, 30, 355, 150);
		add(scrollPane);

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // �⺻���� �ڵ�ũ�⺯���� OFF
		for (int i = 0; i < 6; i++) { // �÷��� ����
			TableColumn col = table.getColumnModel().getColumn(i);
			col.setPreferredWidth(55); // ���� �÷��� ����
		}
		
		
		// ����
		MyTableCellRenderer render = new MyTableCellRenderer();
		table.setDefaultRenderer(table.getColumnClass(0), render);
	}

	public void insertData() {
		int i, tot;
		int score;
		String[] strData = new String[6];

		try {
			tot = 0;
			strData[0] = tf[0].getText();
			for (i = 1; i < 4; i++) {
				score = Integer.parseInt(tf[i].getText());
				strData[i] = tf[i].getText();

				tot += score;
			}

			strData[4] = Integer.toString(tot);
			strData[5] = String.format("%5.1f", (float) tot / 3);

			// ���̺� �ڷ� �߰�
			((MyTableModel) table.getModel()).addRow(strData);

			for (i = 0; i < 4; i++)
				tf[i].setText("");
			tf[0].requestFocus();
		} catch (Exception e) {

		}
	}
	
	//Ű���� �̺�Ʈ ó��
	class KeyHandler extends KeyAdapter {
		public void keyPressed(KeyEvent evt) {
			Component ob = (Component) evt.getSource();

			int keycode = evt.getKeyCode();

			if (ob instanceof JTextField) {
				if (keycode == KeyEvent.VK_ENTER) {

					for (int i = 0; i < 4; i++) {
						if (ob == tf[3] && i == 3) {
							but1.requestFocus();
						} else if (ob == tf[i]) {
							tf[i + 1].requestFocus();
						}
					}
				}
			}

			else if (ob instanceof JButton) {
				if (keycode == KeyEvent.VK_ENTER
						&& (JButton) evt.getSource() == but1) {
					insertData();
				}
			}
		} // keyPressed end
	}
}

// JTable �� Ŭ���� - DefaultTableModel : AbstractTableModel �߻� Ŭ������ ������ ���� Ŭ����
class MyTableModel extends DefaultTableModel {
	private static final long serialVersionUID = 2L;

	protected String title[]; // ���̺� ���

	public MyTableModel(String[] title) {
		this.title = title;
	}

	// �÷��� ����
	@Override
	public int getColumnCount() {
		if (title == null)
			return 0;

		return title.length;
	}

	// �÷��� ��� ����
	@Override
	public String getColumnName(int column) {
		if (title == null || title.length == 0)
			return null;

		return title[column];
	}

	// ���콺 ����Ŭ���� �������� ���ϰ�
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
}

class MyTableCellRenderer extends DefaultTableCellRenderer {
	private static final long serialVersionUID = 1L;

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
				row, column);
		if (column == 0)
			setHorizontalAlignment(SwingConstants.LEFT);
		else if (column == 1)
			setHorizontalAlignment(SwingConstants.CENTER);
		else
			setHorizontalAlignment(SwingConstants.RIGHT);
		return this;
	}
}
