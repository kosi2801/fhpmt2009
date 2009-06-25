using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using PMT.DocumentManager.Data;
using PMT.DocumentManager.BL;

namespace PMT.DocumentManager.UI
{
    public partial class DocumentManagerForm : Form
    {
        public DocumentManagerForm()
        {
            InitializeComponent();
            updateData();
        }

        private void updateData()
        {
            DataStore store = DataStore.Instance;
            if (store.DocumentData != null)
            {
                nameTextBox.Text = store.DocumentData.Name;
                locationTextBox.Text = store.DocumentData.Location;
                ownerTextBox.Text = store.DocumentData.Owner;
            }
            else
            {
                nameTextBox.Text = "";
                locationTextBox.Text = "";
                ownerTextBox.Text = "";
            }

        }

        private void DocumentManagerForm_Load(object sender, EventArgs e)
        {

        }

        private void saveButton_Click(object sender, EventArgs e)
        {
            DataStore store = DataStore.Instance;
            store.DocumentData.Name = nameTextBox.Text;
            store.DocumentData.Location = locationTextBox.Text;
            store.DocumentData.Owner = ownerTextBox.Text;
            updateData();
        }

        private void setDefaultsButton_Click(object sender, EventArgs e)
        {
            new DataInitializer().intialize();
            updateData();
        }

        private void closeButton_Click(object sender, EventArgs e)
        {
            this.Hide();
            this.Dispose();
        }
    }
}
