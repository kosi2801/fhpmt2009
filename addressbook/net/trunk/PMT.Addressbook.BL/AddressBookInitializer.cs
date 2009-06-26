using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using PMT.AddressBook.Data;

namespace PMT.AddressBook.BL
{
    public class AddressBookInitializer
    {
        public void initialize()
        {
            AddressDataStore store = AddressDataStore.Instance;

            Address addr = new Address();
            addr.Name = "Max Mustermann";
            addr.Street = "Musterstraße 12";
            addr.Zip = "A-12345";
            addr.City = "Musterstadt";
            addr.Country = "Musterland";
            addr.Email = "max.mustermann@mustercompany.mu";
            addr.Phone = "123-456 789";
            addr.Mobile = "9784/512 30 24";

            store.Addresses.Clear();
            store.addAddress(addr);
        }
    }
}
