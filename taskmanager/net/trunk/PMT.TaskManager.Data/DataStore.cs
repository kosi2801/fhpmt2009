using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace PMT.Taskmanager.Data
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

        private Task task;

        public Task mtask
        {
            get
            {
                return task;
            }
            set
            {
                task = value;
            }
        }
    }
}
