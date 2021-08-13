package com.fhec.locker;

import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.ConcurrentHashMap;

import com.fhec.exceptions.BusinessException;

public class FileLocker implements Closeable {
	private static ConcurrentHashMap<String, FileLocker> fileLockers = new ConcurrentHashMap<String, FileLocker>();

	private RandomAccessFile randomAccessFile;

	private FileChannel fileChannel;

	private FileLock fileLock;

	public FileLocker() {
	}

	public static FileLocker GetOrCreate(String filename) throws Exception {

		if (!fileLockers.containsKey(filename)) {
			FileLocker fileLocker = new FileLocker(filename);
			fileLockers.putIfAbsent(filename, fileLocker);
		}
		return fileLockers.get(filename);
	}

	public FileLocker(String filename) throws Exception {
		randomAccessFile = new RandomAccessFile(filename, "rw");
		fileChannel = randomAccessFile.getChannel();
		fileLock = fileChannel.tryLock();
	}

	public byte[] readBytes() {

		try {
			byte[] bytes = new byte[(int) randomAccessFile.length()];
			randomAccessFile.read(bytes);
			return bytes;
		} catch (Exception e) {
			throw new BusinessException(e);
		}

	}

	public boolean isValid() throws IOException {
		if (fileLock == null) {
			return false;
		}
		return fileLock.isValid();
	}

	@Override
	public void close() throws IOException {
		if (fileLock != null) {
			fileLock.close();
		}
		if (fileChannel != null) {
			fileChannel.close();
		}
		if (randomAccessFile != null) {
			randomAccessFile.close();
		}
	}

}
