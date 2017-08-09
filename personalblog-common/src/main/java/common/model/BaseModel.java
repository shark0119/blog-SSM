package common.model;

import java.io.Serializable;

public abstract class BaseModel implements Serializable {

	private static final long serialVersionUID = -7355190889507111306L;
	

	// @Override
	// public boolean equals(Object obj) {
	// if (obj == null) {
	// return false;
	// }
	// return EqualsBuilder.reflectionEquals(this, obj);
	// }
	//
	// @Override
	// public int hashCode() {
	// return HashCodeBuilder.reflectionHashCode(this);
	// }
	//
	// @Override
	// public String toString() {
	// return ToStringBuilder.reflectionToString(this, CustomToStringStyle.Style);
	// }
}
