namespace PMT.Application
{
    partial class PMTApplicationForm
    {
        /// <summary>
        /// Erforderliche Designervariable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Verwendete Ressourcen bereinigen.
        /// </summary>
        /// <param name="disposing">True, wenn verwaltete Ressourcen gelöscht werden sollen; andernfalls False.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Vom Windows Form-Designer generierter Code

        /// <summary>
        /// Erforderliche Methode für die Designerunterstützung.
        /// Der Inhalt der Methode darf nicht mit dem Code-Editor geändert werden.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(PMTApplicationForm));
            this.toolStrip1 = new System.Windows.Forms.ToolStrip();
            this.mainButton = new System.Windows.Forms.ToolStripButton();
            this.updateButton = new System.Windows.Forms.ToolStripButton();
            this.chatButton = new System.Windows.Forms.ToolStripButton();
            this.multimediaManagerButton = new System.Windows.Forms.ToolStripButton();
            this.taskManagerButton = new System.Windows.Forms.ToolStripButton();
            this.documentManagerButton = new System.Windows.Forms.ToolStripButton();
            this.addressBookManagerButton = new System.Windows.Forms.ToolStripButton();
            this.birthDayManager = new System.Windows.Forms.ToolStripButton();
            this.toolStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // toolStrip1
            // 
            this.toolStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.updateButton,
            this.mainButton,
            this.chatButton,
            this.multimediaManagerButton,
            this.taskManagerButton,
            this.documentManagerButton,
            this.addressBookManagerButton,
            this.birthDayManager});
            this.toolStrip1.Location = new System.Drawing.Point(0, 0);
            this.toolStrip1.Name = "toolStrip1";
            this.toolStrip1.Size = new System.Drawing.Size(590, 25);
            this.toolStrip1.TabIndex = 1;
            this.toolStrip1.Text = "toolStrip1";
            // 
            // mainButton
            // 
            this.mainButton.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.mainButton.Image = ((System.Drawing.Image)(resources.GetObject("mainButton.Image")));
            this.mainButton.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.mainButton.Name = "mainButton";
            this.mainButton.Size = new System.Drawing.Size(23, 22);
            this.mainButton.Text = "toolStripButton1";
            this.mainButton.Click += new System.EventHandler(this.toolStripButton1_Click);
            // 
            // updateButton
            // 
            this.updateButton.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.updateButton.Image = ((System.Drawing.Image)(resources.GetObject("updateButton.Image")));
            this.updateButton.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.updateButton.Name = "updateButton";
            this.updateButton.Size = new System.Drawing.Size(23, 22);
            this.updateButton.Text = "Update";
            this.updateButton.Click += new System.EventHandler(this.updateButton_Click);
            // 
            // chatButton
            // 
            this.chatButton.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.chatButton.Image = ((System.Drawing.Image)(resources.GetObject("chatButton.Image")));
            this.chatButton.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.chatButton.Name = "chatButton";
            this.chatButton.Size = new System.Drawing.Size(23, 22);
            this.chatButton.Text = "toolStripButton2";
            // 
            // multimediaManagerButton
            // 
            this.multimediaManagerButton.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.multimediaManagerButton.Image = ((System.Drawing.Image)(resources.GetObject("multimediaManagerButton.Image")));
            this.multimediaManagerButton.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.multimediaManagerButton.Name = "multimediaManagerButton";
            this.multimediaManagerButton.Size = new System.Drawing.Size(23, 22);
            this.multimediaManagerButton.Text = "toolStripButton2";
            // 
            // taskManagerButton
            // 
            this.taskManagerButton.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.taskManagerButton.Image = ((System.Drawing.Image)(resources.GetObject("taskManagerButton.Image")));
            this.taskManagerButton.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.taskManagerButton.Name = "taskManagerButton";
            this.taskManagerButton.Size = new System.Drawing.Size(23, 22);
            this.taskManagerButton.Text = "toolStripButton2";
            // 
            // documentManagerButton
            // 
            this.documentManagerButton.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.documentManagerButton.Image = ((System.Drawing.Image)(resources.GetObject("documentManagerButton.Image")));
            this.documentManagerButton.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.documentManagerButton.Name = "documentManagerButton";
            this.documentManagerButton.Size = new System.Drawing.Size(23, 22);
            this.documentManagerButton.Text = "toolStripButton2";
            // 
            // addressBookManagerButton
            // 
            this.addressBookManagerButton.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.addressBookManagerButton.Image = ((System.Drawing.Image)(resources.GetObject("addressBookManagerButton.Image")));
            this.addressBookManagerButton.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.addressBookManagerButton.Name = "addressBookManagerButton";
            this.addressBookManagerButton.Size = new System.Drawing.Size(23, 22);
            this.addressBookManagerButton.Text = "toolStripButton2";
            // 
            // birthDayManager
            // 
            this.birthDayManager.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.birthDayManager.Image = ((System.Drawing.Image)(resources.GetObject("birthDayManager.Image")));
            this.birthDayManager.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.birthDayManager.Name = "birthDayManager";
            this.birthDayManager.Size = new System.Drawing.Size(23, 22);
            this.birthDayManager.Text = "toolStripButton2";
            // 
            // PMTApplicationForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(590, 322);
            this.Controls.Add(this.toolStrip1);
            this.IsMdiContainer = true;
            this.Name = "PMTApplicationForm";
            this.Text = "Personal Management Tool";
            this.toolStrip1.ResumeLayout(false);
            this.toolStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ToolStrip toolStrip1;
        private System.Windows.Forms.ToolStripButton mainButton;
        private System.Windows.Forms.ToolStripButton updateButton;
        private System.Windows.Forms.ToolStripButton chatButton;
        private System.Windows.Forms.ToolStripButton multimediaManagerButton;
        private System.Windows.Forms.ToolStripButton taskManagerButton;
        private System.Windows.Forms.ToolStripButton documentManagerButton;
        private System.Windows.Forms.ToolStripButton addressBookManagerButton;
        private System.Windows.Forms.ToolStripButton birthDayManager;
    }
}

