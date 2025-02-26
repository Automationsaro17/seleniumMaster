package nbcu.automation.ui.pojos.ncxUnifiedTool;

import java.util.Objects;

public class DestinationRecord {
	private String destination;
	private Integer quantity;
	private String details;
	
	public DestinationRecord() {
		quantity = 1;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public int hashCode() {
		return Objects.hash(destination, details, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DestinationRecord other = (DestinationRecord) obj;
		return Objects.equals(destination, other.destination) && Objects.equals(details, other.details)
				&& Objects.equals(quantity, other.quantity);
	}
	public DestinationRecord copy() {
		DestinationRecord rec = new DestinationRecord();
		if(Objects.nonNull(destination)) {
			rec.setDestination(new String(destination));
		}
		if(Objects.nonNull(quantity)) {
			rec.setQuantity(((int)quantity));
		}
		if(Objects.nonNull(details)) {
			rec.setDetails(new String(details));
		}
		return rec;
	}
}
