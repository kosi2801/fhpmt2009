﻿using System;
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
            updateToolbar();
        }

        /// <summary>
        /// Activates the toolbar buttons if the corresponding module is loaded
        /// </summary>
        public void updateToolbar()
        {
            mainButton.Visible = manager.isModuleLoaded(ModuleManager.MODULE_MAIN);
            chatButton.Visible = manager.isModuleLoaded(ModuleManager.MODULE_CHAT);
            multimediaManagerButton.Visible = manager.isModuleLoaded(ModuleManager.MODULE_MULTIMEDIAMANAGER);
            taskManagerButton.Visible = manager.isModuleLoaded(ModuleManager.MODULE_TASKMANAGER);
            documentManagerButton.Visible = manager.isModuleLoaded(ModuleManager.MODULE_DOCUMENTMANAGER);
            addressBookManagerButton.Visible = manager.isModuleLoaded(ModuleManager.MODULE_ADDRESSBOOK);
            birthDayManager.Visible = manager.isModuleLoaded(ModuleManager.MODULE_BIRTHDAYMANAGER);
        }

        /// <summary>
        /// Tries to open the given form or displays an error message, if the given form has not been
        /// found in the given assembly
        /// </summary>
        /// <param name="qualifiedAssemblyName">the full qualified name of the assembly
        /// (like specified in the application tab of the project properties)</param>
        /// <param name="qualifiedFormName">the full qualified name of the form including namespace and form name.
        /// To get this information right click on the form to be shown and select show code. look for the namespace and the name of the partial class.</param>
        private void showForm(String qualifiedAssemblyName, String qualifiedFormName)
        {
            Form form = manager.loadForm(qualifiedAssemblyName, qualifiedFormName);
            if (form == null)
            {
                MessageBox.Show("Error loading form '" + qualifiedFormName + "' from assembly '" + qualifiedAssemblyName + "'", "Error loading form", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }
            form.MdiParent = this;
            form.Show();
        }

        private void toolStripButton1_Click(object sender, EventArgs e)
        {
            showForm("PMT.Main.UI","PMT.Main.UI.MainForm");
        }

        private void updateButton_Click(object sender, EventArgs e)
        {
            Form form = new UpdateDialog(manager,this);
            form.ShowDialog();
        }

        private void chatButton_Click(object sender, EventArgs e)
        {
            showForm("PMT.Chat.UI", "PMT.Chat.UI.ChatUI");
        }

        private void multimediaManagerButton_Click(object sender, EventArgs e)
        {
            showForm("PMT.Multimediamanager.UI", "PMT.Multimediamanager.UI.Formular1");
        }

        private void birthDayManager_Click(object sender, EventArgs e)
        {
            showForm("PMT.BirthdayManager.UI", "PMT.BirthdayManager.UI.BirthdayManagerForm");
        }

        private void documentManagerButton_Click(object sender, EventArgs e)
        {
            showForm("PMT.DocumentManager.UI", "PMT.DocumentManager.UI.DocumentManagerForm");
        }
    }
}
