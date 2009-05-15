package at.fh_joanneum.swd.pmt.chat.data;

import java.util.Vector;

public class MessageLog implements IMessageLog 
{
	private Vector<Message> messageLog;
	
	public MessageLog()
	{
		this.messageLog = new Vector<Message>();
	}
	
	@Override
	public void AddMessage(Message message) 
	{
		this.messageLog.add(message);
	}

	@Override
	public Message[] getAllMessages() 
	{
		return (Message[]) messageLog.toArray();
	}

	@Override
	public void ClearLog() 
	{
		this.messageLog.clear();
	}

}
