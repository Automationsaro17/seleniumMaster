package nbcu.automation.ui.pojos.ncxUnifiedTool;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SectionLog {
	private Map<String, List<String>> logMap;
	
	public SectionLog() {
		this.logMap = new HashMap<>();
	}
	public void putLog(String sectionLog, String fieldLog) {
		List<String> sectionLogList = logMap.getOrDefault(sectionLog, new ArrayList<>());
		if(fieldLog != null && !sectionLogList.contains(fieldLog)) {
			sectionLogList.add(fieldLog);
		}
		logMap.putIfAbsent(sectionLog, sectionLogList);
	}
	public Boolean anySectionLogsPresent() {
		return logMap.size() > 0;
	}
	public void removeLogStartingWith(String sectionLog, String fieldLogStarting) {
		List<String> sectionLogList = logMap.get(sectionLog);
		if(sectionLogList != null) {
			for(int i = 0; i < sectionLogList.size(); ++i) {
				if(sectionLogList.get(i).startsWith(fieldLogStarting)) {
					sectionLogList.remove(i);
				}
			}
			if(sectionLogList.size() == 0) {
				logMap.remove(sectionLog);
			}
		}
	}
	public List<String> getSectionLogs(){
		List<String> sectionLogs = new ArrayList<>();
		logMap.keySet().forEach((key)->{
			if(!sectionLogs.contains(key)) {
				sectionLogs.add(key);
			}
		});
		return sectionLogs;
	}
	public List<String> getFieldLogs(){
		List<String> fieldLogs = new ArrayList<>();
		logMap.keySet().forEach((key)->logMap.get(key).forEach((val)->{
			if(!fieldLogs.contains(val)) {
				fieldLogs.add(val);
			}
		}));
		Comparator<String> comparator=(o1,o2)->{
			return o2.length()-o1.length();
		};
		Collections.sort(fieldLogs, comparator);
		return fieldLogs;
	}
	public List<String> getSectionAndFieldLogs(){
		List<String> logs = new ArrayList<>();
		logs.addAll(getSectionLogs());
		logs.addAll(getFieldLogs());
		return logs;
	}
	public Boolean containsSectionLog(String sectionLog) {
		return logMap.get(sectionLog) != null;
	}
	@Override
	public String toString() {
		return "SectionLog [logMap=" + logMap + "]";
	}
}
