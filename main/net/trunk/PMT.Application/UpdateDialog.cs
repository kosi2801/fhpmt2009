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

        }
    }
}
