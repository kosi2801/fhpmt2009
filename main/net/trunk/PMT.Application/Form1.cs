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
        private ModuleManager manager;

        public PMTApplicationForm()
        {
            InitializeComponent();
            manager = new ModuleManager();
            mainButton.Visible = manager.isModuleLoaded("Main");
            chatButton.Visible = manager.isModuleLoaded("Chat");
            multimediaManagerButton.Visible = manager.isModuleLoaded("MultimediaManager");
            taskManagerButton.Visible = manager.isModuleLoaded("TaskManager");
            documentManagerButton.Visible = manager.isModuleLoaded("DocumentManager");
            addressBookManagerButton.Visible = manager.isModuleLoaded("AdressBook");
            birthDayManager.Visible = manager.isModuleLoaded("BirthdayManager");
        }

        private void toolStripButton1_Click(object sender, EventArgs e)
        {
            Form form = manager.loadForm("PMT.Main.UI","PMT.Main.UI.MainForm");
            form.MdiParent = this;
            form.Show();
        }

        private void updateButton_Click(object sender, EventArgs e)
        {
            Form form = new UpdateDialog(manager);
            form.ShowDialog();
        }

        private void chatButton_Click(object sender, EventArgs e)
        {
            //Form form = new Chat.UI.ChatUI();
            //form.MdiParent = this;
            //form.Show();

        }

        private void multimediaManagerButton_Click(object sender, EventArgs e)
        {
//            Form form = System.Runtime.new Multimediamanager.UI.Formular1();
//            form.MdiParent = this;
//            form.Show();
        }
    }
}
