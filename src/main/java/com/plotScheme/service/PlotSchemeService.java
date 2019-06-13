package com.plotScheme.service;

import java.util.List;

import com.plotScheme.model.PlotSchemeModel;

public interface PlotSchemeService {
	Integer insertSchemeDetails(PlotSchemeModel plotSchemeModel);
	Integer insertPlotShopDetails(PlotSchemeModel plotSchemeModel);
	Integer updateSchemeDetails(PlotSchemeModel plotSchemeModel);
	List<PlotSchemeModel> getSchemeDetails();
	List<PlotSchemeModel> getPlotShopDetails();
}
