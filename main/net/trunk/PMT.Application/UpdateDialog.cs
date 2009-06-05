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
        public UpdateDialog()
        {
            InitializeComponent();
        }

        private void installButton_Click(object sender, EventArgs e)
        {
            if (ApplicationDeployment.IsNetworkDeployed)
            {
                ApplicationDeployment current = ApplicationDeployment.CurrentDeployment;


                if (!current.IsFileGroupDownloaded("Main"))
                {
                    current.DownloadFileGroupCompleted += OnPluginDownloadCompleted;
                    current.DownloadFileGroupAsync("Main");
                }
                else
                {
                    loadPlugins();
                }
            }
            else
            {
                loadPlugins();
            }
        }

        void OnPluginDownloadCompleted(Object sender, DownloadFileGroupCompletedEventArgs e)
        {
            loadPlugins();
        }

        public void loadPlugins()
        {
            try
            {
                Assembly asm = Assembly.Load("PMT.Main.UI");
                if (asm == null)
                {
                    throw new Exception("Failed to load Main.UI");
                }
                asm = Assembly.Load("PMT.Main.Data");
                if (asm == null)
                {
                    throw new Exception("Failed to load Main.Data");
                }
                asm = Assembly.Load("PMT.Main.BL");
                if (asm == null)
                {
                    throw new Exception("Failed to load Main.Bl");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error");
            }
        }

        private void cancelButton_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
