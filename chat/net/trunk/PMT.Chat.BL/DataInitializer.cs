using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using PMT.Chat.Data;

namespace PMT.Chat.BL
{
    public sealed class DataInitializer
    {
        public static void Initialize()
        {
            MessageLog log = MessageLog.Current;
            log.Add(new ChatMessage("System", "Log initialized."));
        }
    }
}
