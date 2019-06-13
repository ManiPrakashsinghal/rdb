package com.plotScheme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plotScheme.dao.PlotSchemeDao;
import com.plotScheme.model.PlotSchemeModel;

@Service
public class PlotSchemeServiceImpl implements PlotSchemeService{

	@Autowired
	PlotSchemeDao plotSchemeDao;
	
	@Override
	public Integer insertSchemeDetails(PlotSchemeModel plotSchemeModel) {
		return plotSchemeDao.insertSchemeDetails(plotSchemeModel);
	}

	@Override
	public Integer insertPlotShopDetails(PlotSchemeModel plotSchemeModel) {
		return plotSchemeDao.insertPlotShopDetails(plotSchemeModel);
	}

	@Override
	public Integer updateSchemeDetails(PlotSchemeModel plotSchemeModel) {
		return plotSchemeDao.updateSchemeDetails(plotSchemeModel);
	}

	@Override
	public List<PlotSchemeModel> getSchemeDetails() {
		return plotSchemeDao.getSchemeDetails();
	}

	@Override
	public List<PlotSchemeModel> getPlotShopDetails() {
		return plotSchemeDao.getPlotShopDetails();
	}

}
