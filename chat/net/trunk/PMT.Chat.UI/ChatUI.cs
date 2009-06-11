using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using PMT.Chat.Data;

namespace PMT.Chat.UI
{
    public partial class ChatUI : Form, IRequestsLogUpdate
    {
        private Presenter presenter;

        public ChatUI()
        {
            InitializeComponent();

            this.presenter = new Presenter(this);
        }

        private void buttonClose_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void buttonSend_Click(object sender, EventArgs e)
        {
            this.presenter.AddMessage(textBox1.Text);
        }

        #region IRequestsLogUpdate Members

        public void UpdateLog(LogChangedEventArgs args)
        {
            switch (args.Mode)
            {
                case LogChangedMode.Cleared:
                    listBox1.Items.Clear();
                    break;
                case LogChangedMode.Added:
                    listBox1.Items.Add(args.NewItem);
                    break;
                default:
                    // do nothing...
                    break;
            }
        }

        #endregion

        private void buttonClearLog_Click(object sender, EventArgs e)
        {
            this.presenter.ClearLog();
        }
    }
}
