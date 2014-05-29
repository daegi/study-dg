package com.omok;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class OmokServer extends Omok implements ActionListener, Runnable {
	private static final long serialVersionUID = 5L;
	
	private JTextArea ta;
	private JTextField tf;
	private JButton startBtn, endBtn;
	
	private ServerSocket serverSock = null;
	private Socket sock = null;
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	
	private int port = 7777;
	private String user="자바";
	
	//***************************************************************
	// 생성자
	 public OmokServer() {
		 setLayout(null);

		gp = new BadukPan(this);
		gp.setBounds(10, 10, 380, 380);
		add(gp);
		gp.repaint();
		
		startBtn=new JButton("게임 시작");
		startBtn.addActionListener(this);
		startBtn.setBounds(400, 10, 100, 25);
		add(startBtn);

		endBtn=new JButton("게임 종료");
		endBtn.addActionListener(this);
		endBtn.setBounds(400, 40, 100, 25);
		add(endBtn);
		
		ta = new JTextArea();
		ta.setEditable(false);
		JScrollPane pane=new JScrollPane(ta);
		pane.setBounds(10, 400, 380, 90);
		add(pane);
		
		tf = new JTextField();
		tf.addActionListener(this);
		tf.setBounds(10, 495, 380, 20);
		add(tf);

		gp.addMouseListener(new MouseHandler());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setTitle("서버");
		setSize(520, 550);
		setResizable(false);
		setVisible(true);

		//  서버 시작
		try{
			serverSock = new ServerSocket(port);
			ta.setText("서버 시작...\n");
		}catch(Exception e){
			System.out.println("Error in Server() ==>" + e);
			System.exit(1);
		}

		 try {
			 sock = serverSock.accept();
			 oos = new ObjectOutputStream(sock.getOutputStream());
			 oos.flush(); // 중요
			 ois = new ObjectInputStream(sock.getInputStream());
			 Thread th = new Thread(this);
			 th.start();
		 }catch(Exception e) {
		 }
    }

	//***************************************************************
	// 게임 초기화
	 public void gameInit() {
		int x, y;
		for(x=0; x<19; x++)
			for(y=0; y<19; y++)
			board[x][y]=NONE;
		panjeong = NONE;
		bWhTurn  = false;
	}
	
	//***************************************************************
	// main()
  	public static void main(String[] args) {
         new OmokServer();		
	}

	//***************************************************************
	// 스레드 작업
   public void run() {
    try{
	 ta.append("상대방이 접속 했습니다.\n");
	 ta.setCaretPosition(ta.getDocument().getLength());
	 
      while(true) {
		Object ob = ois.readObject();
		if(ob instanceof PointMsg) {
			PointMsg pm = (PointMsg)ob;
			
			if(pm.getCode()==10) {
				bGameB=true;
				ta.append("상대방이 게임을 시작했습니다.\n");
				ta.setCaretPosition(ta.getDocument().getLength());
			} else if(pm.getCode()==100) {
				gamePlay(pm, ta);
				bWhTurn = !bWhTurn;
			} else if(pm.getCode()==200) {
				bGameA=false;
				bGameB=false;
				ta.append("상대방이 게임을 종료했습니다.\n");
				ta.setCaretPosition(ta.getDocument().getLength());
			}
		} else if(ob instanceof ChatMsg) {
			ChatMsg chat=(ChatMsg)ob;
			String s=chat.getUserName()+"] " + chat.getMsg();
			ta.append(s+"\n");
			ta.setCaretPosition(ta.getDocument().getLength());
		}
		
      }
    } catch(Exception e) {
    	ta.append("상대방 연결이 종료 됨...\n");
		sock=null;
		oos=null;
		ois=null;
   }
  }

	//***************************************************************
	// 마우스 이벤트 처리
    class MouseHandler extends MouseAdapter {
		public void mousePressed(MouseEvent evt) {
			if(bGameA==true && bGameB==true)	{
				int ax, ay;
				if(panjeong != NONE)
					return;

				//검은돌 차례인 경우 돌아감
				if(!bWhTurn)
					return;

				ax = evt.getX()/20;
				ay = evt.getY()/20;

				if((ax<0) ||(ax>=19) || (ay<0) || (ay>=19))
					return;

				if (board[ax][ay]!=NONE)
					return;

				PointMsg pm = new PointMsg();
				pm.setCode(100);
				pm.setX(ax);
				pm.setY(ay);
				pm.setDol(WHITE);

				// 마우스 좌표 전송
				try{
					oos.writeObject(pm);
					gamePlay(pm, ta);
					bWhTurn = !bWhTurn;
				}catch(Exception e) {
					//
				}
			}
		}
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==startBtn) {
			if(ois==null) {
				JOptionPane.showMessageDialog(this, "게임상대가 없습니다.", "정보",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			if(bGameA==true) return;
			
			bGameA=true;
			gameInit();
			gp.repaint();
			
			// 게임 시작을 전송
			PointMsg pm = new PointMsg();
			pm.setCode(10);
			pm.setX(-1);
			pm.setY(-1);

			try{
				oos.writeObject(pm);
			}catch(Exception e1) {
			}			
			
			ta.append("게임을 시작합니다.\n");
			ta.setCaretPosition(ta.getDocument().getLength());
		
		} else if(e.getSource()==endBtn) {
			if(bGameA==false) return;
			
			bGameA=false;
			bGameB=false;
			
			// 게임 중지를 전송
			PointMsg pm = new PointMsg();
			pm.setCode(200);
			pm.setX(-1);
			pm.setY(-1);

			try{
				oos.writeObject(pm);
			}catch(Exception e1) {
			}			
			
			ta.append("게임을 종료합니다.\n");
			ta.setCaretPosition(ta.getDocument().getLength());
		} else if(e.getSource()==tf) {
			String s=tf.getText().trim();
			if(s.length()==0) return;
			
			if(sock==null || oos==null) return;
			try {
				ChatMsg chat=new ChatMsg();
				chat.setUserName(user);
				chat.setMsg(s);
				oos.writeObject(chat);
			} catch (Exception e2) {
				ta.append("상대방 연결이 종료 됨...\n");
				sock=null;
				oos=null;
				ois=null;
				return;
			}
			
			ta.append("보냄] "+s+"\n");
			ta.setCaretPosition(ta.getDocument().getLength());
			
			tf.setText("");
			tf.requestFocus();			
		}
	}
} // class_end
