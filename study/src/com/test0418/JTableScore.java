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
		// 프레임의 타이틀 설정(도는 setTitle("제목")
		super(title);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//기본 BorderLayout를 제거함. 수동으로 부착
		setLayout(null);

		String caption[] = { "이름 :", "국어 :", "영어 :", "수학 :" };
		for (int i = 0; i < 4; i++) {
			JLabel lbl = new JLabel();
			lbl.setText(caption[i]);
			//지정위치에 컴포넌트 부착(x, y, 폭, 높이)
			lbl.setBounds(10, (i + 1) * 30, 50, 20);
			add(lbl); //프레임에 부착
			
			//반드시 new 해야함
			tf[i] = new JTextField(); //한줄 입력만 가능			
			this.tf[i].setBounds(80, (i + 1) * 30, 70, 20);
			//텍스트필드의 키보드 이벤트 처리
			tf[i].addKeyListener(new KeyHandler());
			add(this.tf[i]);
		}

		but1 = new JButton("추가");
		but1.addActionListener(this);
		but1.addKeyListener(new KeyHandler());
		but1.setBounds(10, 160, 60, 20);
		add(but1);

		but2 = new JButton("종료");
		but2.addActionListener(this);
		but2.setBounds(90, 160, 60, 20);
		add(but2);

		// 테이블 추가
		addTable();
		
		setResizable(false);
		setSize(550, 250);
		setVisible(true);
	}

	public static void main(String[] args) {
		new JTableScore("성적 처리");
	}

	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == but1) {
			insertData();
		} else if (evt.getSource() == but2) {
			System.exit(0);
		}
	}

	public void addTable() {
		String[] title = { "이름", "국어", "영어", "수학", "총점", "평균" };
		model = new MyTableModel(title);
		table = new JTable(model);

		JScrollPane scrollPane = new JScrollPane(table);

		scrollPane.setBounds(160, 30, 355, 150);
		add(scrollPane);

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // 기본값인 자동크기변경을 OFF
		for (int i = 0; i < 6; i++) { // 컬럼폭 변경
			TableColumn col = table.getColumnModel().getColumn(i);
			col.setPreferredWidth(55); // 지정 컬럼폭 변경
		}
		
		
		// 정렬
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

			// 테이블에 자료 추가
			((MyTableModel) table.getModel()).addRow(strData);

			for (i = 0; i < 4; i++)
				tf[i].setText("");
			tf[0].requestFocus();
		} catch (Exception e) {

		}
	}
	
	//키보드 이벤트 처리
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

// JTable 모델 클래스 - DefaultTableModel : AbstractTableModel 추상 클래스를 구현한 서브 클래스
class MyTableModel extends DefaultTableModel {
	private static final long serialVersionUID = 2L;

	protected String title[]; // 테이블 헤더

	public MyTableModel(String[] title) {
		this.title = title;
	}

	// 컬럼의 개수
	@Override
	public int getColumnCount() {
		if (title == null)
			return 0;

		return title.length;
	}

	// 컬럼의 헤더 제목
	@Override
	public String getColumnName(int column) {
		if (title == null || title.length == 0)
			return null;

		return title[column];
	}

	// 마우스 더블클릭시 편집하지 못하게
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
