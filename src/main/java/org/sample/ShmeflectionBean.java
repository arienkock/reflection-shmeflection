package org.sample;

public class ShmeflectionBean extends BaseBean {

	@Override
	public void set(String field, Object value) {
		if ("age".equals(field)) {
			setAge((Integer)value);
		} else if ("firstName".equals(field)) {
			setFirstName((String)value);
		} else if ("lastName".equals(field)) {
			setLastName((String)value);
		} else if ("socialSecurityNumber".equals(field)) {
			setSocialSecurityNumber((String)value);
		} else {
			throw new NoSuchMethodError();
		}
	}

	@Override
	public Object get(String field) {
		if ("age".equals(field)) {
			return getAge();
		} else if ("firstName".equals(field)) {
			return getFirstName();
		} else if ("lastName".equals(field)) {
			return getLastName();
		} else if ("socialSecurityNumber".equals(field)) {
			return getSocialSecurityNumber();
		} else {
			throw new NoSuchMethodError();
		}
	}

}
