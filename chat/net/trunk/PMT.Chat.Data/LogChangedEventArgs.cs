using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace PMT.Chat.Data
{
    public class LogChangedEventArgs : EventArgs
    {
        public LogChangedMode Mode { get; private set; }
        public ChatMessage NewItem { get; private set; }

        public LogChangedEventArgs()
        {
            this.Mode = LogChangedMode.Cleared;
        }

        public LogChangedEventArgs(ChatMessage newItem)
        {
            this.Mode = LogChangedMode.Added;
            this.NewItem = newItem;
        }
    }
}
