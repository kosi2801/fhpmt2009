using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Deployment.Application;
using System.Reflection;


namespace PMT.Application
{
    public partial class UpdateDialog : Form
    {
        private Dictionary<String,CheckBox> modules = new Dictionary<String, CheckBox>();

        private Dictionary<String, String[]> moduleLibraries = new Dictionary<String, String[]>();
        public UpdateDialog()
        {
            InitializeComponent();
            modules.Add("Main", checkBoxMain);
            moduleLibraries.Add("Main", new String[] { "PMT.Main.UI", "PMT.Main.BL", "PMT.Main.Data"});
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
                                loadPlugins(module);
                            }
                        }
                        else
                        {
                            loadPlugins(module);
                        }
                    }
                }
        }

        void OnPluginDownloadCompleted(Object sender, DownloadFileGroupCompletedEventArgs e)
        {
            loadPlugins(e.Group);
        }

        public void loadPlugins(String module)
        {
            try
            {
                foreach (String library in moduleLibraries[module])
                {
                    Assembly asm = Assembly.Load(library);
                    if (asm == null)
                    {
                        throw new Exception("Failed to load " + library);
                    }
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error");
            }
            this.Close();
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
