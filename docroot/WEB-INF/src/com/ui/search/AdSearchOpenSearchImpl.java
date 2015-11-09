package com.ui.search;

import com.liferay.portal.kernel.search.HitsOpenSearchImpl;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;

public class AdSearchOpenSearchImpl extends HitsOpenSearchImpl{
	
	public static final String SEARCH_PATH = "/search/search";

	public static final String TITLE = "Ad Listing Search: ";

	@Override
	public Indexer getIndexer() {
		return IndexerRegistryUtil.getIndexer(AdSearch.class);
	}

	@Override
	public String getPortletId() {
		return AdSearch.PORTLET_ID;
	}

	@Override
	public String getSearchPath() {
		return SEARCH_PATH;
	}

	@Override
	public String getTitle(String keywords) {
		return TITLE + keywords;
	}

}
