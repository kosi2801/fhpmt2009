package at.fh_joanneum.swd.pmt.chat.data;

public interface IMessageLog
{
	void AddMessage(Message message);
	Message[] getAllMessages();
	void ClearLog();
}
