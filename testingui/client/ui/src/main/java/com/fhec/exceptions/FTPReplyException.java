package com.fhec.exceptions;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FTPReplyException extends RuntimeException {

	private FTPClient ftpClient;

	private boolean error;

	private int replyCode;

	private String replyString;

	public FTPReplyException(FTPClient ftpClient) {
		this.ftpClient = ftpClient;
		this.replyCode = ftpClient.getReplyCode();
		this.replyString = ftpClient.getReplyString();
		error = !FTPReply.isPositivePreliminary(ftpClient.getReplyCode());
	}

	public FTPReplyException(FTPClient ftpClient, String var1) {
		super(var1 + "ftp码:" + ftpClient.getReplyString());
		this.ftpClient = ftpClient;
		this.replyCode = ftpClient.getReplyCode();
		this.replyString = ftpClient.getReplyString();
		error = !FTPReply.isPositivePreliminary(ftpClient.getReplyCode());
	}

	public FTPReplyException(FTPClient ftpClient, String var1, Throwable var2) {
		super(var1 + "ftp码:" + ftpClient.getReplyString(), var2);
		this.ftpClient = ftpClient;
		this.replyCode = ftpClient.getReplyCode();
		this.replyString = ftpClient.getReplyString();
		error = !FTPReply.isPositivePreliminary(ftpClient.getReplyCode());
	}

	public FTPReplyException(FTPClient ftpClient, Throwable var1) {
		super(var1);
		this.ftpClient = ftpClient;
		this.replyCode = ftpClient.getReplyCode();
		this.replyString = ftpClient.getReplyString();
		error = !FTPReply.isPositivePreliminary(ftpClient.getReplyCode());
	}

	protected FTPReplyException(FTPClient ftpClient, String var1, Throwable var2, boolean var3, boolean var4) {
		super(var1 + "ftp码:" + ftpClient.getReplyString(), var2, var3, var4);
		this.ftpClient = ftpClient;
		this.replyCode = ftpClient.getReplyCode();
		this.replyString = ftpClient.getReplyString();
		error = !FTPReply.isPositivePreliminary(ftpClient.getReplyCode());
	}
}
