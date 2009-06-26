using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using PMT.AddressBook.Data;
using PMT.AddressBook.BL;

namespace PMT.AddressBook.UI
{
    public partial class AddressBookForm : Form
    {
        private String selectedName;
        public AddressBookForm()
        {
            InitializeComponent();
        }

        private void closeButton_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (tb_name.Text.Length == 0)
            {
                MessageBox.Show("At least a name must be given!");
                return;
            }

            Address tmp = new Address();
            tmp.Name = tb_name.Text;
            tmp.Street = tb_street.Text;
            tmp.Zip = tb_zip.Text;            
            tmp.City = tb_city.Text;
            tmp.Country = tb_country.Text;
            tmp.Email = tb_email.Text;
            tmp.Phone = tb_phone.Text;
            tmp.Mobile = tb_mobile.Text;

            AddressDataStore.Instance.addAddress(tmp);

            lv_Addresses.Items.Add(tmp.Name);

            initControlls();
        }

        private void lv_Addresses_DoubleClick(object sender, EventArgs e)
        {
            String name = lv_Addresses.SelectedItems[0].Text;
            Address tmp = AddressDataStore.Instance.findAddress(name);
            fillControlls(tmp);
            selectedName = name;
        }

        private void initializeButton_Click(object sender, EventArgs e)
        {
            AddressBookInitializer init = new AddressBookInitializer();
            init.initialize();
            lv_Addresses.Items.Clear();
            lv_Addresses.Items.Add(AddressDataStore.Instance.getElementAt(0).Name);
        }

        private void fillControlls(Address addr)
        {
            tb_name.Text = addr.Name;
            tb_street.Text = addr.Street;
            tb_zip.Text = addr.Zip;
            tb_city.Text = addr.City;
            tb_country.Text = addr.Country;
            tb_email.Text = addr.Email;
            tb_phone.Text = addr.Phone;
            tb_mobile.Text = addr.Mobile;
        }

        private void deleteButton_Click(object sender, EventArgs e)
        {
            if (lv_Addresses.SelectedItems.Count == 0)
            {
                MessageBox.Show("No item selected!");
                return;
            }
            String name = lv_Addresses.SelectedItems[0].Text;
            AddressDataStore.Instance.removeAddress(name);
            lv_Addresses.Items.Remove(lv_Addresses.SelectedItems[0]);
            initControlls();
        }

        private void initControlls()
        {
            tb_name.Text = "";
            tb_street.Text = "";
            tb_zip.Text = "";
            tb_city.Text = "";
            tb_country.Text = "";
            tb_email.Text = "";
            tb_phone.Text = "";
            tb_mobile.Text = "";
        }

        private void udpateButton_Click(object sender, EventArgs e)
        {
            if (selectedName == null)
            {
                MessageBox.Show("No Address selected!");
                return;
            };
            if (AddressDataStore.Instance.findAddress(tb_name.Text) != null &&
                selectedName.CompareTo(tb_name.Text) != 0 )
            {
                MessageBox.Show("This person already exists in your addressbook!");
                return;
            };

            AddressDataStore.Instance.findAddress(selectedName).Name = tb_name.Text;
            AddressDataStore.Instance.findAddress(selectedName).Street = tb_street.Text;
            AddressDataStore.Instance.findAddress(selectedName).Zip = tb_zip.Text;
            AddressDataStore.Instance.findAddress(selectedName).City = tb_city.Text;
            AddressDataStore.Instance.findAddress(selectedName).Country = tb_country.Text;
            AddressDataStore.Instance.findAddress(selectedName).Email = tb_email.Text;
            AddressDataStore.Instance.findAddress(selectedName).Phone = tb_phone.Text;
            AddressDataStore.Instance.findAddress(selectedName).Mobile = tb_mobile.Text;
            
        }
    }
}
