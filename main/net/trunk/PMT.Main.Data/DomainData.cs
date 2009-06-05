using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace PMT.Main.Data
{
    public class User
    {
        private String firstName;

        private String lastName;

        private String mailAdress;

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

        public String MailAdress
        {
            get
            {
                return mailAdress;
            }
            set
            {
                mailAdress = value;
            }
        }

    }
}
