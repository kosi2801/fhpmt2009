using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using PMT.Chat.Data;

namespace PMT.Chat.UI
{
    interface IRequestsLogUpdate
    {
        void UpdateLog(LogChangedEventArgs args);
    }
}
