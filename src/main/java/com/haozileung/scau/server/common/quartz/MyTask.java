/**
 * 
 */
package com.haozileung.scau.server.common.quartz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.haozileung.scau.server.dto.SportDataInfo;
import com.haozileung.scau.server.service.ISportDataService;

/**
 * @author haozi
 * 
 */
@Service("myTask")
public class MyTask {
	@Autowired
	private ISportDataService sportDataService;
	private static final Logger logger = LoggerFactory.getLogger(MyTask.class);
	private static List<String> fileList = null;
	private static boolean isRunning = false;
	private static String dataPath = System.getProperty("ssh.root") + "data";
	private static String dataBackupPath = System.getProperty("ssh.root")
			+ "backup";

	@Scheduled(cron = "0 * * * * ?")
	public void execute() {
		if (isRunning == false) {
			System.out.println("Job...started");
			if (logger.isDebugEnabled()) {
				logger.debug("定时任务开始...");
			}
			isRunning = true;
			System.out.println(dataPath);
			fileList = getFileList(dataPath);
			processFiles();
			isRunning = false;
		}
	}

	public void processFiles() {
		if (null != fileList) {
			for (String file : fileList) {
				if (null != file) {
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
						processLine(data);
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
					moveFile(file);
				}
			}
		}
	}

	public void moveFile(String file) {
		//org.apache.commons.io.FileUtils.moveToDirectory(new File(file), destDir, true);
	}

	public List<String> getFileList(String path) {
		if (null == path) {
			return null;
		}
		List<String> fileLst = new ArrayList<String>();
		File file = new File(path);
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (!files[i].isDirectory()) {
				fileLst.add(files[i].getAbsolutePath());
			} else {
				fileLst.addAll(getFileList(files[i].getAbsolutePath()));
			}
		}
		return fileLst;
	}

	public boolean processLine(String line) {
		SportDataInfo sportDataInfo = new SportDataInfo();
		String[] dataArray = line.split(",");
		sportDataInfo.setCowId(dataArray[0]);
		sportDataInfo.setCurrentDate(dataArray[1]);
		List<Float> data = new ArrayList<Float>();
		for (int i = 2; i < 24; i++) {
			data.add(Float.valueOf(dataArray[i]));
		}
		sportDataService.saveSportData(sportDataInfo);
		return false;
	}
}