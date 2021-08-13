package com.fhec.event.impls;

import com.fhec.abstracts.AbstractActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Button1ActionListener extends AbstractActionListener{

	private JEditorPane editorPane;
	
	public Button1ActionListener(Window window){
		super(window);
	}
	
	@Override
	public void actionPerformed(ActionEvent var1) {
		
		String text = editorPane.getText();
		System.out.println(text);
	}

}
