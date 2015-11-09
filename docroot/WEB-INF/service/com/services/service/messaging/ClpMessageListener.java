/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.services.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.services.service.AdCategoryLocalServiceUtil;
import com.services.service.AdCategoryServiceUtil;
import com.services.service.AdCityLocalServiceUtil;
import com.services.service.AdCountryLocalServiceUtil;
import com.services.service.AdListingLocalServiceUtil;
import com.services.service.AdListingServiceUtil;
import com.services.service.AdResponseTrackerLocalServiceUtil;
import com.services.service.AdStatsTrackerLocalServiceUtil;
import com.services.service.ClpSerializer;

/**
 * @author Ankur Srivastava
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			AdCategoryLocalServiceUtil.clearService();

			AdCategoryServiceUtil.clearService();
			AdCityLocalServiceUtil.clearService();

			AdCountryLocalServiceUtil.clearService();

			AdListingLocalServiceUtil.clearService();

			AdListingServiceUtil.clearService();
			AdResponseTrackerLocalServiceUtil.clearService();

			AdStatsTrackerLocalServiceUtil.clearService();
		}
	}
}