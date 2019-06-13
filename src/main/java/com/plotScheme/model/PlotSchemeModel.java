package com.plotScheme.model;

public class PlotSchemeModel {
	private int plotId;
	private int schemeId;
	private int minPlotNumber;
	private int maxPlotNumber;
	private int plotNumber;
	private int clientId;
	private String plotType;
	private String plotStatus;
	private String SchemeName;
	
	
	public int getPlotNumber() {
		return plotNumber;
	}
	public void setPlotNumber(int plotNumber) {
		this.plotNumber = plotNumber;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getPlotStatus() {
		return plotStatus;
	}
	public void setPlotStatus(String plotStatus) {
		this.plotStatus = plotStatus;
	}
	public int getPlotId() {
		return plotId;
	}
	public void setPlotId(int plotId) {
		this.plotId = plotId;
	}
	public int getSchemeId() {
		return schemeId;
	}
	public void setSchemeId(int schemeId) {
		this.schemeId = schemeId;
	}
	public int getMinPlotNumber() {
		return minPlotNumber;
	}
	public void setMinPlotNumber(int minPlotNumber) {
		this.minPlotNumber = minPlotNumber;
	}
	public int getMaxPlotNumber() {
		return maxPlotNumber;
	}
	public void setMaxPlotNumber(int maxPlotNumber) {
		this.maxPlotNumber = maxPlotNumber;
	}
	public String getPlotType() {
		return plotType;
	}
	public void setPlotType(String plotType) {
		this.plotType = plotType;
	}
	public String getSchemeName() {
		return SchemeName;
	}
	public void setSchemeName(String schemeName) {
		SchemeName = schemeName;
	}
	@Override
	public String toString() {
		return "PlotSchemeModel [plotId=" + plotId + ", schemeId=" + schemeId + ", minPlotNumber=" + minPlotNumber
				+ ", maxPlotNumber=" + maxPlotNumber + ", plotNumber=" + plotNumber + ", clientId=" + clientId
				+ ", plotType=" + plotType + ", plotStatus=" + plotStatus + ", SchemeName=" + SchemeName + "]";
	}
	
}
