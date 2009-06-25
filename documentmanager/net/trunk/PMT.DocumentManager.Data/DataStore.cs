using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace PMT.DocumentManager.Data
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

        private DocumentData document;

        public DocumentData DocumentData
        {
            get
            {
                return document;
            }
            set
            {
                document = value;
            }
        }
    }
}
