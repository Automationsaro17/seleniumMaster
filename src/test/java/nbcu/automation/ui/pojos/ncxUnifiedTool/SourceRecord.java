package nbcu.automation.ui.pojos.ncxUnifiedTool;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SourceRecord {
	private String source;
	private String sourceDetails;
	private Integer quantity;
	private String comments;
	private List<String> cameras;
	private List<String> cnbcStratusSlugs;
	private String timecodes;
	
	public SourceRecord() {
		cameras = new ArrayList<>();
		cnbcStratusSlugs= new ArrayList<>();
		quantity=1;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	public String getSourceDetails() {
		return sourceDetails;
	}

	public void setSourceDetails(String sourceDetails) {
		this.sourceDetails = sourceDetails;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public String getTimecodes() {
		return timecodes;
	}

	public void setTimecodes(String timecodes) {
		this.timecodes = timecodes;
	}

	public List<String> getCameras() {
		return cameras;
	}

	public void setCameras(List<String> cameras) {
		this.cameras = cameras;
	}

	public List<String> getCnbcStratusSlugs() {
		return cnbcStratusSlugs;
	}

	public void setCnbcStratusSlugs(List<String> cnbcStratusSlugs) {
		this.cnbcStratusSlugs = cnbcStratusSlugs;
	}
	public SourceRecord copy() {
		SourceRecord rec = new SourceRecord();
		if(source != null) {
			rec.setSource(new String(source));
		}
		if(quantity != null) {
			rec.setQuantity((int)quantity);
		}
		if(comments != null) {
			rec.setComments(new String(comments));
		}
		if(sourceDetails != null) {
			rec.setSourceDetails(new String(sourceDetails));
		}
		if(timecodes != null) {
			rec.setTimecodes(new String(timecodes));
		}
		cameras.forEach((camera)->rec.getCameras().add(new String(camera)));
		cnbcStratusSlugs.forEach((slug)->rec.getCnbcStratusSlugs().add(new String(slug)));
		return rec;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cameras, cnbcStratusSlugs, comments, quantity, source,sourceDetails,timecodes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SourceRecord other = (SourceRecord) obj;
		return Objects.equals(cameras, other.cameras) && Objects.equals(cnbcStratusSlugs, other.cnbcStratusSlugs)
				&& Objects.equals(comments, other.comments) && Objects.equals(quantity, other.quantity)
				&& Objects.equals(source, other.source) && Objects.equals(sourceDetails, other.sourceDetails)
				&& Objects.equals(timecodes, other.timecodes) ;
	}

	@Override
	public String toString() {
		return "SourceRecord [source=" + source + ", sourceDetails="+sourceDetails+", timecodes="+timecodes+
				", quantity=" + quantity + ", comments=" + comments + ", cameras="+ cameras.toString() 
				+ ", cnbcStratusSlugs=" + cnbcStratusSlugs.toString() + "]";
	}
}
