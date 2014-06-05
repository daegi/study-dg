package com.omok;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

//서버, 클라이언트 공용
public class BadukPan extends Canvas {
	private static final long serialVersionUID = 3L;
	private Omok bp;

	public BadukPan(Omok bp) {
		this.bp = bp;
	}

	public void paint(Graphics g) {
		update(g);
		
		if(bp.bGameA==true && bp.bGameB==true) {
			int x, y;
			for(x=0 ;x<19 ;x++) {
			  g.drawLine(10, 10+x*20, 370, 10+x*20);
			}
			for(y=0 ;y<19 ;y++) {
			  g.drawLine(10+y*20, 10, 10+y*20, 370);
		  }

		for(x=0 ;x<19 ; x++)
			for(y=0 ;y<19 ;y++)
				bp.drawSite(x, y, bp.board[x][y]);
		}
	}

	public void update(Graphics g) {
		int x, y;
		// setBackground(new Color(230, 205, 70));
        g.setColor(new Color(230, 205, 70));
        g.fillRect(0, 0, 380, 380);

        g.setColor(Color.black);
		for(x=0 ;x<19 ;x++) {
		  g.drawLine(10, 10+x*20, 370, 10+x*20);
		}
		for(y=0 ;y<19 ;y++) {
		  g.drawLine(10+y*20, 10, 10+y*20, 370);
		}
	}
}

