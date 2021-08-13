package com.fhec.abstracts;

import java.awt.Window;
import java.awt.event.ActionListener;

public abstract class AbstractActionListener<TWin extends Window> implements ActionListener {

	protected TWin window;

	public AbstractActionListener(TWin window) {
		this.window = window;

	}
}
