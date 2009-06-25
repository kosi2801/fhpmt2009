using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace PMT.DocumentManager.Data
{
    public class DocumentData
    {
        private String name;

        private String location;

        private String owner;

        public String Name
        {
            get
            {
                return name;
            }
            set
            {
                name = value;
            }
        }

        public String Location
        {
            get
            {
                return location;
            }
            set
            {
                location = value;
            }
        }

        public String Owner
        {
            get
            {
                return owner;
            }
            set
            {
                owner = value;
            }
        }

    }
}
