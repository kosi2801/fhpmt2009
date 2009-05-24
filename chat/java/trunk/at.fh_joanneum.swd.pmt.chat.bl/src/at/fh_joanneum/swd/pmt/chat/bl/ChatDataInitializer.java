package at.fh_joanneum.swd.pmt.chat.bl;

import at.fh_joanneum.swd.pmt.bl.DataInitializerInterface;
import at.fh_joanneum.swd.pmt.chat.data.IMessageLog;
import at.fh_joanneum.swd.pmt.chat.data.Message;

public class ChatDataInitializer implements DataInitializerInterface 
{
	@Override
	public void initialize() 
	{
		IMessageLog log = Activator.getDefault().getMessageLog();
		if (log != null)
		{
			log.ClearLog();

			Message message = new Message();
			message.setMessage("Default message");
			message.setUserName("Default user");
			log.AddMessage(message);
		}
	}

}
