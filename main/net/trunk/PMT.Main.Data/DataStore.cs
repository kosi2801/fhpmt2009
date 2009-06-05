using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace PMT.Main.Data
{
    public class DataStore
    {
        private static DataStore instance;

        public static DataStore Instance
        {
            get
            {
                if (instance == null)
                {
                    instance = new DataStore();
                }
                return instance;
            }
        }

        private User user;

        public User User
        {
            get
            {
                return user;
            }
            set
            {
                user = value;
            }
        }
    }
}
