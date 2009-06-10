using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Deployment.Application;


namespace PMT.Application
{
    public partial class UpdateDialog : Form
    {
        private Dictionary<String, CheckBox> modules = new Dictionary<String, CheckBox>();
        private ModuleManager manager;
        private PMTApplicationForm applicationForm;

        public UpdateDialog(ModuleManager manager, PMTApplicationForm form)
        {
            this.manager = manager;
            applicationForm = form;
            InitializeComponent();
            modules.Add(ModuleManager.MODULE_MAIN, checkBoxMain);
            modules.Add(ModuleManager.MODULE_CHAT, checkBoxChat);
            modules.Add(ModuleManager.MODULE_BIRTHDAYMANAGER, checkBoxBirthDayManager);
            modules.Add(ModuleManager.MODULE_ADDRESSBOOK, checkBoxAdressBook);
            modules.Add(ModuleManager.MODULE_DOCUMENTMANAGER, checkBoxDocumentManager);
            modules.Add(ModuleManager.MODULE_MULTIMEDIAMANAGER, checkBoxMultimediaManager);
            modules.Add(ModuleManager.MODULE_TASKMANAGER, checkBoxTaskManager);
        }

        private void installButton_Click(object sender, EventArgs e)
        {
            foreach (String module in modules.Keys)
            {
                if (modules[module].Enabled && modules[module].Checked)
                {

                    if (ApplicationDeployment.IsNetworkDeployed)
                    {
                        ApplicationDeployment current = ApplicationDeployment.CurrentDeployment;

                        if (!current.IsFileGroupDownloaded(module))
                        {
                            current.DownloadFileGroupCompleted += OnPluginDownloadCompleted;
                            current.DownloadFileGroupAsync(module);
                        }
                        else
                        {
                            manager.loadPlugins(module);
                            applicationForm.updateToolbar();
                        }
                    }
                    else
                    {
                        manager.loadPlugins(module);
                        applicationForm.updateToolbar();
                    }
                }
            }
            this.Close();
        }

        void OnPluginDownloadCompleted(Object sender, DownloadFileGroupCompletedEventArgs e)
        {
            manager.loadPlugins(e.Group);
            applicationForm.updateToolbar();
        }

        private void cancelButton_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void UpdateDialog_Load(object sender, EventArgs e)
        {
            if (ApplicationDeployment.IsNetworkDeployed)
            {
                ApplicationDeployment current = ApplicationDeployment.CurrentDeployment;
                foreach (String module in modules.Keys)
                {
                    try
                    {
                        modules[module].Checked = current.IsFileGroupDownloaded(module);
                    }
                    catch (Exception)
                    {
                        modules[module].Enabled = false;
                    }
                }
            }
            else
            {
                checkBoxMain.Checked = true;
            }
            foreach (CheckBox checkBox in modules.Values)
            {
                if (checkBox.Enabled)
                    checkBox.Enabled = !checkBox.Checked;
            }
        }

    }
}
