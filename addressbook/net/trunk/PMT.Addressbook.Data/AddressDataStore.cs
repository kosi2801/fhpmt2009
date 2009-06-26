using System;
using System.Collections;
using System.Linq;
using System.Text;

namespace PMT.AddressBook.Data
{
    public class AddressDataStore
    {
        private static AddressDataStore instance;

        public AddressDataStore()
        {
            addresses = new ArrayList();
        }

        public static AddressDataStore Instance
        {
            get
            {
                if( instance == null )
                {
                    instance = new AddressDataStore();
                }
                return instance;
            }            
        }
        private ArrayList addresses;
        public ArrayList Addresses
        {
            get
            {
                return addresses;
            }            
        }

        public void addAddress(Address addr)
        {
            if(findAddress(addr.Name)== null)
                addresses.Add(addr);
        }

        public Address findAddress(String name)
        {
            foreach (Address i in addresses)
            {
                if (i.Name.CompareTo(name)==0)
                    return i;
            }
            return null;
        }

        public void removeAddress(String name)
        {
            Address tmp;
            tmp = findAddress(name);
            if(tmp != null)
                addresses.Remove(tmp);
        }
        public Address getElementAt(int idx)
        {
            if (addresses.Count < idx)
                return null;

            int cnt = 0;
            foreach (Address i in addresses)
            {
                if (cnt == idx)
                    return i;
            }
            return null;
        }
    }
}
