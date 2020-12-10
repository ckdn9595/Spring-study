package com.increpas.cls.vo;

import java.util.*;

import org.springframework.web.multipart.MultipartFile;

import java.text.*;
import java.sql.Time;
import java.sql.Date;

public class BoardVO {
	private int bno, mno, ano, click, cnt;
	private String title, body, id, avatar, sdate;
	private Date wdate;
	private Time wtime;
	private ArrayList<String> filekeys;
	private ArrayList<FileVO> list;
	
	private MultipartFile[] file;
	/*
	 	업로드된 파일을 기억할 변수는
	 		MultipartFile
	 	이라는 클래스 형태로 만들어야 한다.
	 	그러면 그 안에 스트림 형태로 파일의 내용이 기억되게 된다.
	 	이때 주의사항 만약 
	 		name 속성값이 하나면 일반변수
	 		같은 name 속성값이 여러개이면(다중업로드인 경우)
	 		배열변수로 만들어주면 된다.
	 */
	public MultipartFile[] getFile() {
		return file;
	}
	public void setFile(MultipartFile[] file) {
		this.file = file;
	}
	public void setWtime(Time wtime) {
		this.wtime = wtime;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getClick() {
		return click;
	}
	public void setClick(int click) {
		this.click = click;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate() {
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy/MM/dd");
//		SimpleDateFormat form2 = new SimpleDateFormat("HH:mm");
		sdate = form1.format(wdate) ;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
		setSdate();
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	public Time getWtime() {
		return wtime;
	}
//	public void setWtime(Time wtime) {
//		this.wtime = wtime;
//		setSdate();
//	}
	public ArrayList<String> getFilekeys() {
		return filekeys;
	}
	public void setFilekeys(ArrayList<String> filekeys) {
		this.filekeys = filekeys;
	}
	public ArrayList<FileVO> getList() {
		return list;
	}
	public void setList(ArrayList<FileVO> list) {
		this.list = list;
	}
	
}
