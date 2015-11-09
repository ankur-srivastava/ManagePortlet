/**
 * 
 */
package com.ui.listeners;

import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.services.model.AdListing;

/**
 * @author srivastavaa
 *
 */
public class PostListener implements MessageListener{

	@Override
	public void receive(Message message) throws MessageListenerException {
		// TODO Auto-generated method stub
		AdListing adListing = (AdListing)message.get("adListing");
		if(adListing != null){
			
		}
	}
	
}
