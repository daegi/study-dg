package com.omok;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public abstract class Omok extends JFrame {
	private static final long serialVersionUID = 4L;

	protected static final int NONE = 0;
	protected static final int BLACK = 1;
	protected static final int WHITE = 2;
	protected int board[][] = new int[19][19];
	protected boolean bWhTurn; // 검은돌인지 흰돌인지
	protected boolean bGameA, bGameB; // 게임상태
	protected int panjeong;

	protected BadukPan gp;

	public abstract void gameInit();

	// ***************************************************************
	// 게임 플레이
	public void gamePlay(PointMsg pm, JTextArea ta) {
		int ax, ay;
		ax = pm.getX();
		ay = pm.getY();

		board[ax][ay] = bWhTurn ? WHITE : BLACK;

		drawSite(ax, ay, board[ax][ay]);
		gamePanjeong(ax, ay);

		if (panjeong == BLACK) {
			ta.append("검은돌이 승리 했습니다.\n");
			ta.setCaretPosition(ta.getDocument().getLength());
			bGameA=false;
			bGameB=false;
		} else if (panjeong == WHITE) {
			ta.append("흰돌이 승리 했습니다.\n");
			ta.setCaretPosition(ta.getDocument().getLength());
			bGameA=false;
			bGameB=false;
		}
	}

	// ***************************************************************
	// 게임 판정
	public void gamePanjeong(int ax, int ay) {
		int cnt;
		int i;
		int dol;

		dol = board[ax][ay];

		cnt = 1;
		for (i = 1; i < 6; i++) {
			if (ay - i < 0)
				break;
			if (board[ax][ay - i] == dol)
				cnt++;
			else
				break;
		}
		for (i = 1; i < 6; i++) {
			if (ay + i >= 19)
				break;
			if (board[ax][ay + i] == dol)
				cnt++;
			else
				break;
		}
		if (cnt == 5) {
			panjeong = dol;
			return;
		}

		cnt = 1;
		for (i = 1; i < 6; i++) {
			if (ax - i < 0)
				break;
			if (board[ax - i][ay] == dol)
				cnt++;
			else
				break;
		}
		for (i = 1; i < 6; i++) {
			if (ax + i >= 19)
				break;
			if (board[ax + i][ay] == dol)
				cnt++;
			else
				break;
		}
		if (cnt == 5) {
			panjeong = dol;
			return;
		}

		cnt = 1;
		for (i = 1; i < 6; i++) {
			if (ax - i < 0 || ay - i < 0)
				break;
			if (board[ax - i][ay - i] == dol)
				cnt++;
			else
				break;
		}
		for (i = 1; i < 6; i++) {
			if (ax + i >= 19 || ay + i >= 19)
				break;
			if (board[ax + i][ay + i] == dol)
				cnt++;
			else
				break;
		}
		if (cnt == 5) {
			panjeong = dol;
			return;
		}

		cnt = 1;
		for (i = 1; i < 6; i++) {
			if (ax + i >= 19 || ay - i < 0)
				break;
			if (board[ax + i][ay - i] == dol)
				cnt++;
			else
				break;
		}
		for (i = 1; i < 6; i++) {
			if (ax - i < 0 || ay + i >= 19)
				break;
			if (board[ax - i][ay + i] == dol)
				cnt++;
			else
				break;
		}
		if (cnt == 5) {
			panjeong = dol;
			return;
		}
	}

	// ***************************************************************
	// 돌 그리기
	public void drawSite(int x, int y, int dol) {
		Graphics g = gp.getGraphics();

		if (dol == BLACK)
			g.setColor(new Color(0, 0, 0));
		else
			g.setColor(new Color(255, 255, 255));
		if (dol != NONE)
			g.fillOval(x * 20 + 2, y * 20 + 2, 16, 16);
	}
}
