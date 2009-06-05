using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using PMT.Main.BL;
using PMT.Main.Data;

namespace PMT.Main.UI
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
            updateData();
        }

        private void updateData()
        {
            DataStore store = DataStore.Instance;
            if (store.User != null)
            {
                textBoxFirstName.Text = store.User.FirstName;
                textBoxLastName.Text = store.User.LastName;
                textBoxMail.Text = store.User.MailAdress;
            }
            else
            {
                textBoxFirstName.Text = "";
                textBoxLastName.Text = "";
                textBoxMail.Text = "";
            }
        }
        
        private void resetButton_Click(object sender, EventArgs e)
        {
            new DataInitializer().intialize();
            updateData();
        }

        private void closeButton_Click(object sender, EventArgs e)
        {
            this.Hide();
            this.Dispose();
        }

        private void saveButton_Click(object sender, EventArgs e)
        {
            DataStore store = DataStore.Instance;
            store.User.FirstName = textBoxFirstName.Text;
            store.User.LastName = textBoxLastName.Text;
            store.User.MailAdress = textBoxMail.Text;
            updateData();
        }
    }
}
