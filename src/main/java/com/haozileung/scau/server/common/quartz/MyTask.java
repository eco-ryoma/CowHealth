/**
 * 
 */
package com.haozileung.scau.server.common.quartz;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author haozi
 * 
 */
@Service("myTask")
public class MyTask {
	private static final Logger logger = LoggerFactory.getLogger(MyTask.class);
	private static List<String> fileList = null;
	private static boolean isRunning = false;

	@Scheduled(cron = "0 * * * * ?")
	public void execute() {
		if (isRunning == false) {
			if (logger.isDebugEnabled()) {
				logger.debug("定时任务开始...");
			}
			isRunning = true;
			fileList = getFileList();
			processFiles();
			moveFile();
			isRunning = false;
		}
	}

	public void processFiles() {
		for (String file : fileList) {
			BufferedReader br = null;
			String data = null;
			try {
				br = new BufferedReader(new FileReader(file));
			} catch (FileNotFoundException e) {
				logger.error("读取文件失败：文件没有找到！" + e.getMessage());
				continue;
			}
			try {
				data = br.readLine();
			} catch (IOException e) {
				logger.error("读取文件失败：文件读取出错！" + e.getMessage());
				continue;
			}
			while (data != null) {
				System.out.println(data);
				try {
					data = br.readLine();
				} catch (IOException e) {
					logger.error("读取文件失败：文件读取出错！" + e.getMessage());
					continue;
				}
			}
			try {
				br.close();
			} catch (IOException e) {
				logger.error("文件关闭失败！" + e.getMessage());
			}
		}
	}

	public boolean moveFile() {
		return false;
	}

	public List<String> getFileList() {
		return null;
	}
}