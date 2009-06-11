using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using PMT.Chat.BL;
using PMT.Chat.Data;

namespace PMT.Chat.UI
{
    internal class Presenter
    {
        private IRequestsLogUpdate client;
        private string userName;
        public Presenter(IRequestsLogUpdate presentationClient)
        {
            this.client = presentationClient;
            this.userName = "SWD Student"; // this can be retrieved from main plugin, but its always the same...

            MessageLog.Current.LogChanged += 
                new MessageLog.LogChangedDelegate(Current_LogChanged);

            DataInitializer.Initialize();
        }

        void Current_LogChanged(LogChangedEventArgs args)
        {
            client.UpdateLog(args);
        }

        public void AddMessage(string message)
        {
            MessageLog.Current.Add(new ChatMessage(userName, message));
        }

        internal void ClearLog()
        {
            MessageLog.Current.ClearLog();
        }
    }
}
