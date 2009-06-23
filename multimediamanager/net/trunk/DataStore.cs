using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace PMT.Multimediamanager.Data
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

        private List<Multimedia> multimedias;

        public List<Multimedia> Multimedias
        {
            get
            {
                if (multimedias == null)
                {
                    multimedias = new List<Multimedia>();

                }
                return multimedias;
            }
            set
            {
                multimedias = value;
            }
        }
    }
}
