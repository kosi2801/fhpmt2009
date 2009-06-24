using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using PMT.Multimediamanager.Data;

namespace PMT.Multimediamanager.UI
{
    public partial class EditData : Form
    {
        Multimedia mm;
        
        public EditData()
        {
            InitializeComponent();
        }

        public EditData(Multimedia mme)
        {
            InitializeComponent();
            if (mme != null)
            {
                this.mm = mme;
                this.textTitel.Text = mm.Titel;
            }
        }

        private void closeButton_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void editButton_Click(object sender, EventArgs e)
        {
            if (mm != null) mm.Titel = this.textTitel.Text;
            this.Close();
        }
    }
}
