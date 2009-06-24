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
    public partial class RemoveData : Form
    {
        public RemoveData()
        {
            InitializeComponent();
        }
        public RemoveData(Multimedia mm)
        {
            InitializeComponent();
            mmTitel.Text = mm.Titel;
            mmTyp.Text = mm.Typ.ToString();
            this.Update();

        }

        
    }
}
