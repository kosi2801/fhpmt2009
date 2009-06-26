using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace PMT.AddressBook.Data
{
    public class Address
    {
        private String name;
        private String street;
        private String zip;
        private String city;
        private String country;
        private String email;
        private String phone;
        private String mobile;        

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
        public String Street
        {
            get
            {
                return street;
            }
            set
            {
                street = value;
            }
        }
        public String Zip
        {
            get
            {
                return zip;
            }
            set
            {
                zip = value;
            }
        }
        public String City
        {
            get
            {
                return city;
            }
            set
            {
                city = value;
            }
        }
        public String Country
        {
            get
            {
                return country;
            }
            set
            {
                country = value;
            }
        }
        public String Email
        {
            get
            {
                return email;
            }
            set
            {
                email = value;
            }
        }
        public String Phone
        {
            get
            {
                return phone;
            }
            set
            {
                phone = value;
            }
        }
        public String Mobile
        {
            get
            {
                return mobile;
            }
            set
            {
                mobile = value;
            }
        }        
    }
}
