package com.isutc.interopitability.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.isutc.interopitability.modelEnum.Status;
@Entity
public class WebServiceHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private long requestInst; 
	private long requestedInst;
	@Enumerated(EnumType.STRING)
	private Status status;
	private String reason;
	private LocalDateTime dataEntry; 
	
	public LocalDateTime getDataEntry() {
		return dataEntry;
	}
	public void setDataEntry(LocalDateTime dataEntry) {
		this.dataEntry = dataEntry;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getFrom() {
		return requestInst;
	}
	public void setFrom(long from) {
		this.requestInst = from;
	}
	public long getTo() {
		return requestedInst;
	}
	public void setTo(long to) {
		this.requestedInst = to;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

	public WebServiceHistory(long from, long to, Status status, String reason) {
		super();
		this.requestInst = from;
		this.requestedInst = to;
		this.status = status;
		this.reason = reason;
	}
	public WebServiceHistory() {
		super();
	}
	
	
	
}
