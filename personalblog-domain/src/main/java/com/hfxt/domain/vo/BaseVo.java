package com.hfxt.domain.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import common.tostringstyle.CustomToStringStyle;

public abstract class BaseVo implements Serializable {

	private static final long serialVersionUID = -8364830628770277137L;

	public interface ValidGroup_Admin_Add {
	}
	public interface ValidGroup_Admin_Edit {
	}
	
	

	

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, CustomToStringStyle.Style);
	}

}
