using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace PMT.Chat.Data
{
    public class ChatMessage
    {
        public string Message { get; private set; }
        public DateTime Received { get; private set; }
        public string User { get; private set; }

        public ChatMessage(string user, string message)
        {
            this.User = user;
            this.Message = message;
            this.Received = DateTime.Now;
        }

        public override string ToString()
        {
            return string.Format("[{0}] {1}: {2}",
                this.Received.ToShortTimeString(), 
                this.User, 
                this.Message);
        }
    }
}
