package nbcu.automation.ui.pojos.ncxUnifiedTool;

import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class LocationRecord {
	private String location;
	private String setLocation;
	private String address;
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSetLocation() {
		return setLocation;
	}
	public void setSetLocation(String setLocation) {
		this.setLocation = setLocation;
	}
	public LocationRecord(String location, String setLocation) {
		super();
		this.location = location;
		this.setLocation = setLocation;
	}
	public LocationRecord() {
		super();
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocationRecord(String location, String setLocation, String address) {
		super();
		this.location = location;
		this.setLocation = setLocation;
		this.address = address;
	}
	@Override
	public String toString() {
		return "LocationRecord [location=" + location + ", setLocation=" + setLocation + ", address=" + address + "]";
	}
	public LocationRecord copy() {
		LocationRecord rec = new LocationRecord();
		if(Objects.nonNull(location)) {
			rec.setLocation(new String(location));
		}
		if(Objects.nonNull(setLocation)) {
			rec.setSetLocation(new String(setLocation));
		}
		if(Objects.nonNull(address)) {
			rec.setAddress(new String(address));
		}
		return rec;
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, location, setLocation);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocationRecord other = (LocationRecord) obj;
		return Objects.equals(address, other.address) && Objects.equals(location, other.location)
				&& Objects.equals(setLocation, other.setLocation);
	}
	public static Comparator<LocationRecord> getComparator() {
		return (o1,o2)->{
			int loc = o1.getLocation().compareTo(o2.getLocation());
			if(loc != 0) {
				return loc;
			}
			String setloc1 = o1.getSetLocation();
			String setloc2 = o2.getSetLocation();
			if(Objects.nonNull(setloc1) && Objects.nonNull(setloc2)){
				int setloc = setloc1.compareTo(setloc2);
				if(setloc != 0) {
					return setloc;
				}
			}
			String add1 = o1.getAddress();
			String add2 = o2.getAddress();
			if(Objects.nonNull(add1) && Objects.nonNull(add2)){
				int add = add1.compareTo(add2);
				if(add != 0) {
					return add;
				}
			}
			if(Objects.nonNull(setloc1)) {
				return -1;
			}
			if(Objects.nonNull(setloc2)) {
				return 1;
			}
			if(Objects.nonNull(add1)) {
				return -1;
			}
			if(Objects.nonNull(add2)) {
				return 1;
			}
			return loc;
		};
	}
}
