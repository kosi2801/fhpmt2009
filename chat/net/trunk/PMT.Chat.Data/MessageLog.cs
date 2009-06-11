using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace PMT.Chat.Data
{
    public class MessageLog
    {
        public delegate void LogChangedDelegate(LogChangedEventArgs args);

        public event LogChangedDelegate LogChanged;

        private List<ChatMessage> loggedMessages;
        private MessageLog()
	    {
            this.loggedMessages = new List<ChatMessage>();
	    }

        // the first reference on properties or methods of the class 
        // instantiate the class - not a lazy singleton, nut suffices 
        // our needs
        private static readonly MessageLog instance = new MessageLog();
        public static MessageLog Current
        {
            get { return instance; }
        }

        public IEnumerable<ChatMessage> LoggedMessages 
        {
            get
            {
                return this.loggedMessages;
            }
        }

        public void ClearLog()
        {
            this.loggedMessages.Clear();

            OnLogChanged(new LogChangedEventArgs());
        }

        public void Add(ChatMessage message)
        {
            this.loggedMessages.Add(message);

            OnLogChanged(new LogChangedEventArgs(message));
        }

        private void OnLogChanged(LogChangedEventArgs args)
        {
            LogChangedDelegate act = LogChanged;
            if (act != null)
                act.Invoke(args);
        }
    }
}
