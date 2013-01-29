package com.haozileung.scau.server.common.dto;

import java.util.List;

import org.springframework.data.domain.Page;

public class MyPage<O extends IDataTransferObject> {
	/**
	 * 内容
	 */
	private List<O> content;
	/**
	 * 当前页号
	 */
	private int number;
	/**
	 * 当前页元素个数
	 */
	private int numberOfElements;
	/**
	 * 分页大小
	 */
	private int size;
	/**
	 * 总个数
	 */
	private long totalElements;
	/**
	 * 总页数
	 */
	private int totalPages;
	
	public MyPage(){
	}
	
	public MyPage(Page<?> page){
		this.number = page.getNumber();
		this.numberOfElements = page.getNumberOfElements();
		this.size = page.getSize();
		this.totalElements = page.getTotalElements();
		this.totalPages = page.getTotalPages();
	}

	/**
	 * @return the content
	 */
	public List<O> getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(List<O> content) {
		this.content = content;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the numberOfElements
	 */
	public int getNumberOfElements() {
		return numberOfElements;
	}

	/**
	 * @param numberOfElements
	 *            the numberOfElements to set
	 */
	public void setNumberOfElements(int numberOfElements) {
		this.numberOfElements = numberOfElements;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return the totalElements
	 */
	public long getTotalElements() {
		return totalElements;
	}

	/**
	 * @param totalElements
	 *            the totalElements to set
	 */
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	/**
	 * @return the totalPages
	 */
	public int getTotalPages() {
		return totalPages;
	}

	/**
	 * @param totalPages
	 *            the totalPages to set
	 */
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

}
