package jungsuk.JS_12_InnerEx;

import java.awt.*;
import java.awt.event.*;

class  InnerEx8 {
	public static void main(String[] args) {
		Button b = new Button("Start");
		b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("ActionEvent occurred!!!");
				}
			} //Anonymous class end.
		);
	} // main class end.
} // InnerEx8 class end.
