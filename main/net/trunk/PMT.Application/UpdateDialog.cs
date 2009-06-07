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

        public UpdateDialog(ModuleManager manager)
        {
            this.manager = manager;
            InitializeComponent();
            modules.Add("Main", checkBoxMain);
        }

        private void installButton_Click(object sender, EventArgs e)
        {
            foreach (String module in modules.Keys)
                {
                    if (modules[module].Enabled && modules[module].Checked) {

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
                            }
                        }
                        else
                        {
                            manager.loadPlugins(module);
                        }
                    }
                }
        }

        void OnPluginDownloadCompleted(Object sender, DownloadFileGroupCompletedEventArgs e)
        {
            manager.loadPlugins(e.Group);
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
                checkBoxMain.Checked = current.IsFileGroupDownloaded("Main");
            }
            else
            {
                checkBoxMain.Checked = true;
            }
            checkBoxMain.Enabled = !checkBoxMain.Checked;
        }

    }
}
