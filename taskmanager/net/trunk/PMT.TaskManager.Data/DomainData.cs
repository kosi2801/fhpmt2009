using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace PMT.Taskmanager.Data
{
    public class Task
    {
        private String Subject;
        private Boolean Done;
        private String Owner;
        private DateTime StartDate;
        private DateTime EndDate;

        public String mSubject 
        {
            get
            { return Subject;
            }
            set
            {
                Subject = value;
            }    
        }
        public Boolean mDone
        {
            get
            {
                return Done;
            }
            set
            {
                Done = value;
            }
        }
        public String mOwner
        {
            get
            {
                return Owner;
            }
            set
            {
                Owner = value;
            }
        }
        public DateTime mStartDate
        {
            get
            {
                return StartDate;
            }
            set
            {
                StartDate = value;
            }
        }
        public DateTime mEndDate
        {
            get
            {
                return EndDate;
            }
            set
            {
                EndDate = value;
            }
        }

    }
}
