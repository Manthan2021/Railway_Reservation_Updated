package com.irctc.project.model;

public class ticketpassenger {
	private long tid;
	private long train_id;
	private String fromst;
	private String tost;
	private String deptdate;
	private String arrdate;
	private String deptTime;
	private String arrTime;
	private long pid;
	private String pname;
	private int age;
	
	public ticketpassenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ticketpassenger(long tid, long train_id, String fromst, String tost, String deptdate, String arrdate,
			String deptTime, String arrTime, long pid, String pname, int age) {
		super();
		this.tid = tid;
		this.train_id = train_id;
		this.fromst = fromst;
		this.tost = tost;
		this.deptdate = deptdate;
		this.arrdate = arrdate;
		this.deptTime = deptTime;
		this.arrTime = arrTime;
		this.pid = pid;
		this.pname = pname;
		this.age = age;
	}

	public long getTid() {
		return tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
	}

	public long getTrain_id() {
		return train_id;
	}

	public void setTrain_id(long train_id) {
		this.train_id = train_id;
	}

	public String getFromst() {
		return fromst;
	}

	public void setFromst(String fromst) {
		this.fromst = fromst;
	}

	public String getTost() {
		return tost;
	}

	public void setTost(String tost) {
		this.tost = tost;
	}

	public String getDeptdate() {
		return deptdate;
	}

	public void setDeptdate(String deptdate) {
		this.deptdate = deptdate;
	}

	public String getArrdate() {
		return arrdate;
	}

	public void setArrdate(String arrdate) {
		this.arrdate = arrdate;
	}

	public String getDeptTime() {
		return deptTime;
	}

	public void setDeptTime(String deptTime) {
		this.deptTime = deptTime;
	}

	public String getArrTime() {
		return arrTime;
	}

	public void setArrTime(String arrTime) {
		this.arrTime = arrTime;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
}
