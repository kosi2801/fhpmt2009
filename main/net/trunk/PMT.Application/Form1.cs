using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using PMT.Main.UI;

namespace PMT.Application
{
    public partial class PMTApplicationForm : Form
    {
        public PMTApplicationForm()
        {
            InitializeComponent();
        }

        private void toolStripButton1_Click(object sender, EventArgs e)
        {
            Form form = new MainForm();
            form.MdiParent = this;
            form.Show();
        }

        private void updateButton_Click(object sender, EventArgs e)
        {
            Form form = new UpdateDialog();
            form.ShowDialog();
        }
    }
}
