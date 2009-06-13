using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace PMT.BirthdayManager.Data
{
    public class User
    {
        private String firstName;
        private String lastName;
        private String birthDay;

        public String FirstName
        {
            get
            {
                return firstName;
            }
            set
            {
                firstName = value;
            }
        }

        public String LastName
        {
            get
            {
                return lastName;
            }
            set
            {
                lastName = value;
            }
        }

        public String BirthDay
        {
            get
            {
                return birthDay;
            }
            set
            {
                birthDay = value;
            }
        }

    }
}
