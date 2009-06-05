using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using PMT.Main.Data;

namespace PMT.Main.BL
{
    public class DataInitializer
    {

        public void intialize()
        {
            DataStore store = DataStore.Instance;

            User user = new User();
            user.FirstName = "Hugo";
            user.LastName = "Mustermann";
            user.MailAdress = "hugo.mustermann@somewhere.com";

            store.User = user;
        }
    }
}
