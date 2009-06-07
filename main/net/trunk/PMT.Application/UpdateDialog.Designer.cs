namespace PMT.Application
{
    partial class UpdateDialog
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
            this.checkBoxMain = new System.Windows.Forms.CheckBox();
            this.installButton = new System.Windows.Forms.Button();
            this.cancelButton = new System.Windows.Forms.Button();
            this.checkBoxChat = new System.Windows.Forms.CheckBox();
            this.checkBoxMultimediaManager = new System.Windows.Forms.CheckBox();
            this.checkBoxTaskManager = new System.Windows.Forms.CheckBox();
            this.checkBoxDocumentManager = new System.Windows.Forms.CheckBox();
            this.AdressBook = new System.Windows.Forms.CheckBox();
            this.checkBoxBirthDayManager = new System.Windows.Forms.CheckBox();
            this.SuspendLayout();
            // 
            // checkBoxMain
            // 
            this.checkBoxMain.AutoSize = true;
            this.checkBoxMain.Location = new System.Drawing.Point(34, 29);
            this.checkBoxMain.Name = "checkBoxMain";
            this.checkBoxMain.Size = new System.Drawing.Size(49, 17);
            this.checkBoxMain.TabIndex = 0;
            this.checkBoxMain.Text = "Main";
            this.checkBoxMain.UseVisualStyleBackColor = true;
            // 
            // installButton
            // 
            this.installButton.Location = new System.Drawing.Point(34, 215);
            this.installButton.Name = "installButton";
            this.installButton.Size = new System.Drawing.Size(75, 23);
            this.installButton.TabIndex = 1;
            this.installButton.Text = "Update";
            this.installButton.UseVisualStyleBackColor = true;
            this.installButton.Click += new System.EventHandler(this.installButton_Click);
            // 
            // cancelButton
            // 
            this.cancelButton.Location = new System.Drawing.Point(189, 215);
            this.cancelButton.Name = "cancelButton";
            this.cancelButton.Size = new System.Drawing.Size(75, 23);
            this.cancelButton.TabIndex = 2;
            this.cancelButton.Text = "Cancel";
            this.cancelButton.UseVisualStyleBackColor = true;
            this.cancelButton.Click += new System.EventHandler(this.cancelButton_Click);
            // 
            // checkBoxChat
            // 
            this.checkBoxChat.AutoSize = true;
            this.checkBoxChat.Location = new System.Drawing.Point(34, 52);
            this.checkBoxChat.Name = "checkBoxChat";
            this.checkBoxChat.Size = new System.Drawing.Size(48, 17);
            this.checkBoxChat.TabIndex = 3;
            this.checkBoxChat.Text = "Chat";
            this.checkBoxChat.UseVisualStyleBackColor = true;
            // 
            // checkBoxMultimediaManager
            // 
            this.checkBoxMultimediaManager.AutoSize = true;
            this.checkBoxMultimediaManager.Location = new System.Drawing.Point(34, 75);
            this.checkBoxMultimediaManager.Name = "checkBoxMultimediaManager";
            this.checkBoxMultimediaManager.Size = new System.Drawing.Size(118, 17);
            this.checkBoxMultimediaManager.TabIndex = 4;
            this.checkBoxMultimediaManager.Text = "MultimediaManager";
            this.checkBoxMultimediaManager.UseVisualStyleBackColor = true;
            // 
            // checkBoxTaskManager
            // 
            this.checkBoxTaskManager.AutoSize = true;
            this.checkBoxTaskManager.Location = new System.Drawing.Point(34, 98);
            this.checkBoxTaskManager.Name = "checkBoxTaskManager";
            this.checkBoxTaskManager.Size = new System.Drawing.Size(91, 17);
            this.checkBoxTaskManager.TabIndex = 5;
            this.checkBoxTaskManager.Text = "Taskmanager";
            this.checkBoxTaskManager.UseVisualStyleBackColor = true;
            // 
            // checkBoxDocumentManager
            // 
            this.checkBoxDocumentManager.AutoSize = true;
            this.checkBoxDocumentManager.Location = new System.Drawing.Point(34, 121);
            this.checkBoxDocumentManager.Name = "checkBoxDocumentManager";
            this.checkBoxDocumentManager.Size = new System.Drawing.Size(117, 17);
            this.checkBoxDocumentManager.TabIndex = 6;
            this.checkBoxDocumentManager.Text = "DocumentManager";
            this.checkBoxDocumentManager.UseVisualStyleBackColor = true;
            // 
            // AdressBook
            // 
            this.AdressBook.AutoSize = true;
            this.AdressBook.Location = new System.Drawing.Point(34, 144);
            this.AdressBook.Name = "AdressBook";
            this.AdressBook.Size = new System.Drawing.Size(82, 17);
            this.AdressBook.TabIndex = 7;
            this.AdressBook.Text = "Adressbook";
            this.AdressBook.UseVisualStyleBackColor = true;
            // 
            // checkBoxBirthDayManager
            // 
            this.checkBoxBirthDayManager.AutoSize = true;
            this.checkBoxBirthDayManager.Location = new System.Drawing.Point(34, 167);
            this.checkBoxBirthDayManager.Name = "checkBoxBirthDayManager";
            this.checkBoxBirthDayManager.Size = new System.Drawing.Size(106, 17);
            this.checkBoxBirthDayManager.TabIndex = 8;
            this.checkBoxBirthDayManager.Text = "BirthdayManager";
            this.checkBoxBirthDayManager.UseVisualStyleBackColor = true;
            // 
            // UpdateDialog
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(291, 254);
            this.Controls.Add(this.checkBoxBirthDayManager);
            this.Controls.Add(this.AdressBook);
            this.Controls.Add(this.checkBoxDocumentManager);
            this.Controls.Add(this.checkBoxTaskManager);
            this.Controls.Add(this.checkBoxMultimediaManager);
            this.Controls.Add(this.checkBoxChat);
            this.Controls.Add(this.cancelButton);
            this.Controls.Add(this.installButton);
            this.Controls.Add(this.checkBoxMain);
            this.Name = "UpdateDialog";
            this.Text = "UpdateDialog";
            this.Load += new System.EventHandler(this.UpdateDialog_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.CheckBox checkBoxMain;
        private System.Windows.Forms.Button installButton;
        private System.Windows.Forms.Button cancelButton;
        private System.Windows.Forms.CheckBox checkBoxChat;
        private System.Windows.Forms.CheckBox checkBoxMultimediaManager;
        private System.Windows.Forms.CheckBox checkBoxTaskManager;
        private System.Windows.Forms.CheckBox checkBoxDocumentManager;
        private System.Windows.Forms.CheckBox AdressBook;
        private System.Windows.Forms.CheckBox checkBoxBirthDayManager;
    }
}