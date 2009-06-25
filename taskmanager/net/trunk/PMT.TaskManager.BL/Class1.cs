using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using PMT.Taskmanager.Data;


namespace PMT.Taskmanager.BL
{
    public class DataInitializer
    {

        public void intialize()
        {
            DataStore store = DataStore.Instance;

            Task task = new Task();
            task.mSubject = "Aufgabe 1";
            task.mDone = false;
            task.mOwner = "Hugo Mustermann";
            task.mStartDate = new System.DateTime(2009, 07, 01);
            task.mEndDate = new System.DateTime(2009, 07, 31);
            store.mtask = task;
        }
    }
}
