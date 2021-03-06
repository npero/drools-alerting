package com.jboss.examples.drools.cep.alerting.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 
 * @author Jeremy Davis jeremy.davis@redhat.com
 * 
 */
public class CompoundAlert {
	
	/**
	 * Identifier
	 */
	private String groupName;

	private Collection<DeviceAlert> alerts;

	/**
	 * Convenience method for adding an existing Collection<Alert> of Alert
	 * objects. The underlying Collection<Alert> will be initialized if it isn't
	 * already.
	 * 
	 * @param alertsToAdd
	 *            Collection<Alert>
	 * @see DeviceAlert
	 */
	public void addAlerts(Collection<DeviceAlert> alertsToAdd) {
		getAlerts().addAll(alertsToAdd);
	}

	/**
	 * Convenience method for adding an Alert to the underlying
	 * Collection<Alert>. The underlying Collection<Alert> will be initialized
	 * if it isn't already.
	 * 
	 * @param alertToAdd
	 *            Alert
	 * @see DeviceAlert
	 */
	public void addAlert(DeviceAlert alertToAdd) {
		getAlerts().add(alertToAdd);
	}
	
	/**
	 * Returns the number of Alert objects in the underlying Collection<Alert>.
	 * 
	 * @return int
	 */
	public int numberOfAlerts(){
		return getAlerts().size();
	}

	/**
	 * Checks to see if the String argument matches the Alert.deviceName of any
	 * of the Alert objects in the underlying Collection<Alert>.
	 * 
	 * @param deviceName String
	 * @return boolean
	 */
	public boolean containsDevice(Integer deviceName) {
		
		// basic sanity checks
		if (deviceName == null) return false;
		if ("".equals(deviceName)) 	return false;
		if (this.alerts == null || this.alerts.isEmpty()) return false;

		// check for existence
		Iterator<DeviceAlert> it = this.alerts.iterator();
		while (it.hasNext()) {
			if (deviceName.equals(it.next().getDeviceName()))
				return true;
		}
		
		return false;
	}

	public CompoundAlert(String nameToSet){
		this.groupName = nameToSet;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(98587971, 810426665).append(groupName).append(alerts).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append(groupName).append(alerts).toString();
	}
	// --------------------------------------------------------------------------
	// generated getters and setters
	// --------------------------------------------------------------------------
	public Collection<DeviceAlert> getAlerts() {
		if (this.alerts == null)
			this.alerts = new ArrayList<DeviceAlert>(0);
		return alerts;
	}

	public void setAlerts(Collection<DeviceAlert> alerts) {
		this.alerts = alerts;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	

}
