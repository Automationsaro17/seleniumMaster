package nbcu.automation.ui.pojos.ncxUnifiedTool;

import java.time.LocalDateTime;

import nbcu.automation.ui.enums.RequestStatus;

public class RequestLog {
	private SectionLog logs;
	private RequestStatus status;
	private String date;
	private String time;
	private String modifiedBy;
	private String requestNumber;
	
	public RequestLog() {
		logs = new SectionLog();
	}
	public SectionLog getLogs() {
		return logs;
	}
	public void setLogs(SectionLog logs) {
		this.logs = logs;
	}
	public RequestStatus getStatus() {
		return status;
	}
	public void setStatus(RequestStatus status) {
		this.status = status;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getRequestNumber() {
		return requestNumber;
	}
	public void setRequestNumber(String requestNumber) {
		this.requestNumber = requestNumber;
	}
	@Override
	public String toString() {
		return "RequestLog [logs=" + logs + ", status=" + status + ", date=" + date + ", time=" + time + ", modifiedBy="
				+ modifiedBy + ", requestNumber=" + requestNumber + "]";
	}
}