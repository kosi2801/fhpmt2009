namespace PMT.Multimediamanager.UI
{
    partial class Formular1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.multimediaTabs = new System.Windows.Forms.TabControl();
            this.tabImages = new System.Windows.Forms.TabPage();
            this.resetButton = new System.Windows.Forms.Button();
            this.listImages = new System.Windows.Forms.ListBox();
            this.addButton = new System.Windows.Forms.Button();
            this.closeButton = new System.Windows.Forms.Button();
            this.editButton = new System.Windows.Forms.Button();
            this.removeButton = new System.Windows.Forms.Button();
            this.tabAudios = new System.Windows.Forms.TabPage();
            this.button13 = new System.Windows.Forms.Button();
            this.listAudios = new System.Windows.Forms.ListBox();
            this.button5 = new System.Windows.Forms.Button();
            this.button6 = new System.Windows.Forms.Button();
            this.button7 = new System.Windows.Forms.Button();
            this.button8 = new System.Windows.Forms.Button();
            this.tabVideos = new System.Windows.Forms.TabPage();
            this.button15 = new System.Windows.Forms.Button();
            this.listVideos = new System.Windows.Forms.ListBox();
            this.button9 = new System.Windows.Forms.Button();
            this.button10 = new System.Windows.Forms.Button();
            this.button11 = new System.Windows.Forms.Button();
            this.button12 = new System.Windows.Forms.Button();
            this.multimediaTabs.SuspendLayout();
            this.tabImages.SuspendLayout();
            this.tabAudios.SuspendLayout();
            this.tabVideos.SuspendLayout();
            this.SuspendLayout();
            // 
            // multimediaTabs
            // 
            this.multimediaTabs.Controls.Add(this.tabImages);
            this.multimediaTabs.Controls.Add(this.tabAudios);
            this.multimediaTabs.Controls.Add(this.tabVideos);
            this.multimediaTabs.Location = new System.Drawing.Point(12, 12);
            this.multimediaTabs.Name = "multimediaTabs";
            this.multimediaTabs.SelectedIndex = 0;
            this.multimediaTabs.Size = new System.Drawing.Size(457, 322);
            this.multimediaTabs.TabIndex = 6;
            this.multimediaTabs.Click += new System.EventHandler(this.multimediaTabs_Click);
            // 
            // tabImages
            // 
            this.tabImages.Controls.Add(this.resetButton);
            this.tabImages.Controls.Add(this.listImages);
            this.tabImages.Controls.Add(this.addButton);
            this.tabImages.Controls.Add(this.closeButton);
            this.tabImages.Controls.Add(this.editButton);
            this.tabImages.Controls.Add(this.removeButton);
            this.tabImages.Location = new System.Drawing.Point(4, 22);
            this.tabImages.Name = "tabImages";
            this.tabImages.Padding = new System.Windows.Forms.Padding(3);
            this.tabImages.Size = new System.Drawing.Size(449, 296);
            this.tabImages.TabIndex = 0;
            this.tabImages.Text = "Images";
            this.tabImages.UseVisualStyleBackColor = true;
            // 
            // resetButton
            // 
            this.resetButton.Location = new System.Drawing.Point(134, 224);
            this.resetButton.Name = "resetButton";
            this.resetButton.Size = new System.Drawing.Size(185, 23);
            this.resetButton.TabIndex = 11;
            this.resetButton.Text = "Load default values";
            this.resetButton.UseVisualStyleBackColor = true;
            this.resetButton.Click += new System.EventHandler(this.resetButton_Click);
            // 
            // listImages
            // 
            this.listImages.FormattingEnabled = true;
            this.listImages.Location = new System.Drawing.Point(28, 19);
            this.listImages.Name = "listImages";
            this.listImages.ScrollAlwaysVisible = true;
            this.listImages.Size = new System.Drawing.Size(392, 199);
            this.listImages.TabIndex = 10;
            // 
            // addButton
            // 
            this.addButton.Location = new System.Drawing.Point(27, 252);
            this.addButton.Name = "addButton";
            this.addButton.Size = new System.Drawing.Size(75, 25);
            this.addButton.TabIndex = 6;
            this.addButton.Text = "Add...";
            this.addButton.UseVisualStyleBackColor = true;
            this.addButton.Click += new System.EventHandler(this.addButton_Click);
            // 
            // closeButton
            // 
            this.closeButton.Location = new System.Drawing.Point(348, 253);
            this.closeButton.Name = "closeButton";
            this.closeButton.Size = new System.Drawing.Size(73, 25);
            this.closeButton.TabIndex = 7;
            this.closeButton.Text = "Close";
            this.closeButton.UseVisualStyleBackColor = true;
            this.closeButton.Click += new System.EventHandler(this.closeButton_Click);
            // 
            // editButton
            // 
            this.editButton.Location = new System.Drawing.Point(240, 253);
            this.editButton.Name = "editButton";
            this.editButton.Size = new System.Drawing.Size(79, 24);
            this.editButton.TabIndex = 9;
            this.editButton.Text = "Edit...";
            this.editButton.UseVisualStyleBackColor = true;
            this.editButton.Click += new System.EventHandler(this.editButton_Click);
            // 
            // removeButton
            // 
            this.removeButton.Location = new System.Drawing.Point(134, 253);
            this.removeButton.Name = "removeButton";
            this.removeButton.Size = new System.Drawing.Size(76, 24);
            this.removeButton.TabIndex = 8;
            this.removeButton.Text = "Remove...";
            this.removeButton.UseVisualStyleBackColor = true;
            this.removeButton.Click += new System.EventHandler(this.removeButton_Click);
            // 
            // tabAudios
            // 
            this.tabAudios.Controls.Add(this.button13);
            this.tabAudios.Controls.Add(this.listAudios);
            this.tabAudios.Controls.Add(this.button5);
            this.tabAudios.Controls.Add(this.button6);
            this.tabAudios.Controls.Add(this.button7);
            this.tabAudios.Controls.Add(this.button8);
            this.tabAudios.Location = new System.Drawing.Point(4, 22);
            this.tabAudios.Name = "tabAudios";
            this.tabAudios.Padding = new System.Windows.Forms.Padding(3);
            this.tabAudios.Size = new System.Drawing.Size(449, 296);
            this.tabAudios.TabIndex = 1;
            this.tabAudios.Text = "Audios";
            this.tabAudios.UseVisualStyleBackColor = true;
            // 
            // button13
            // 
            this.button13.Location = new System.Drawing.Point(134, 224);
            this.button13.Name = "button13";
            this.button13.Size = new System.Drawing.Size(185, 23);
            this.button13.TabIndex = 11;
            this.button13.Text = "Load default values";
            this.button13.UseVisualStyleBackColor = true;
            this.button13.Click += new System.EventHandler(this.resetButton_Click);
            // 
            // listAudios
            // 
            this.listAudios.FormattingEnabled = true;
            this.listAudios.Location = new System.Drawing.Point(28, 19);
            this.listAudios.Name = "listAudios";
            this.listAudios.ScrollAlwaysVisible = true;
            this.listAudios.Size = new System.Drawing.Size(392, 199);
            this.listAudios.TabIndex = 10;
            // 
            // button5
            // 
            this.button5.Location = new System.Drawing.Point(27, 252);
            this.button5.Name = "button5";
            this.button5.Size = new System.Drawing.Size(75, 25);
            this.button5.TabIndex = 6;
            this.button5.Text = "Add...";
            this.button5.UseVisualStyleBackColor = true;
            this.button5.Click += new System.EventHandler(this.addButton_Click);
            // 
            // button6
            // 
            this.button6.Location = new System.Drawing.Point(348, 253);
            this.button6.Name = "button6";
            this.button6.Size = new System.Drawing.Size(73, 25);
            this.button6.TabIndex = 7;
            this.button6.Text = "Close";
            this.button6.UseVisualStyleBackColor = true;
            this.button6.Click += new System.EventHandler(this.closeButton_Click);
            // 
            // button7
            // 
            this.button7.Location = new System.Drawing.Point(240, 253);
            this.button7.Name = "button7";
            this.button7.Size = new System.Drawing.Size(79, 24);
            this.button7.TabIndex = 9;
            this.button7.Text = "Edit...";
            this.button7.UseVisualStyleBackColor = true;
            this.button7.Click += new System.EventHandler(this.editButton_Click);
            // 
            // button8
            // 
            this.button8.Location = new System.Drawing.Point(134, 253);
            this.button8.Name = "button8";
            this.button8.Size = new System.Drawing.Size(76, 24);
            this.button8.TabIndex = 8;
            this.button8.Text = "Remove...";
            this.button8.UseVisualStyleBackColor = true;
            this.button8.Click += new System.EventHandler(this.removeButton_Click);
            // 
            // tabVideos
            // 
            this.tabVideos.Controls.Add(this.button15);
            this.tabVideos.Controls.Add(this.listVideos);
            this.tabVideos.Controls.Add(this.button9);
            this.tabVideos.Controls.Add(this.button10);
            this.tabVideos.Controls.Add(this.button11);
            this.tabVideos.Controls.Add(this.button12);
            this.tabVideos.Location = new System.Drawing.Point(4, 22);
            this.tabVideos.Name = "tabVideos";
            this.tabVideos.Padding = new System.Windows.Forms.Padding(3);
            this.tabVideos.Size = new System.Drawing.Size(449, 296);
            this.tabVideos.TabIndex = 2;
            this.tabVideos.Text = "Videos";
            this.tabVideos.UseVisualStyleBackColor = true;
            // 
            // button15
            // 
            this.button15.Location = new System.Drawing.Point(134, 224);
            this.button15.Name = "button15";
            this.button15.Size = new System.Drawing.Size(185, 23);
            this.button15.TabIndex = 11;
            this.button15.Text = "Load default values";
            this.button15.UseVisualStyleBackColor = true;
            this.button15.Click += new System.EventHandler(this.resetButton_Click);
            // 
            // listVideos
            // 
            this.listVideos.FormattingEnabled = true;
            this.listVideos.Location = new System.Drawing.Point(28, 19);
            this.listVideos.Name = "listVideos";
            this.listVideos.ScrollAlwaysVisible = true;
            this.listVideos.Size = new System.Drawing.Size(392, 199);
            this.listVideos.TabIndex = 10;
            // 
            // button9
            // 
            this.button9.Location = new System.Drawing.Point(27, 252);
            this.button9.Name = "button9";
            this.button9.Size = new System.Drawing.Size(75, 25);
            this.button9.TabIndex = 6;
            this.button9.Text = "Add...";
            this.button9.UseVisualStyleBackColor = true;
            this.button9.Click += new System.EventHandler(this.addButton_Click);
            // 
            // button10
            // 
            this.button10.Location = new System.Drawing.Point(348, 253);
            this.button10.Name = "button10";
            this.button10.Size = new System.Drawing.Size(73, 25);
            this.button10.TabIndex = 7;
            this.button10.Text = "Close";
            this.button10.UseVisualStyleBackColor = true;
            this.button10.Click += new System.EventHandler(this.closeButton_Click);
            // 
            // button11
            // 
            this.button11.Location = new System.Drawing.Point(240, 253);
            this.button11.Name = "button11";
            this.button11.Size = new System.Drawing.Size(79, 24);
            this.button11.TabIndex = 9;
            this.button11.Text = "Edit...";
            this.button11.UseVisualStyleBackColor = true;
            this.button11.Click += new System.EventHandler(this.editButton_Click);
            // 
            // button12
            // 
            this.button12.Location = new System.Drawing.Point(134, 253);
            this.button12.Name = "button12";
            this.button12.Size = new System.Drawing.Size(76, 24);
            this.button12.TabIndex = 8;
            this.button12.Text = "Remove...";
            this.button12.UseVisualStyleBackColor = true;
            this.button12.Click += new System.EventHandler(this.removeButton_Click);
            // 
            // Formular1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(481, 346);
            this.Controls.Add(this.multimediaTabs);
            this.Name = "Formular1";
            this.Text = "Multimediamanager";
            this.multimediaTabs.ResumeLayout(false);
            this.tabImages.ResumeLayout(false);
            this.tabAudios.ResumeLayout(false);
            this.tabVideos.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TabControl multimediaTabs;
        private System.Windows.Forms.TabPage tabImages;
        private System.Windows.Forms.TabPage tabAudios;
        private System.Windows.Forms.TabPage tabVideos;
        private System.Windows.Forms.ListBox listImages;
        private System.Windows.Forms.Button addButton;
        private System.Windows.Forms.Button closeButton;
        private System.Windows.Forms.Button editButton;
        private System.Windows.Forms.Button removeButton;
        private System.Windows.Forms.ListBox listAudios;
        private System.Windows.Forms.Button button5;
        private System.Windows.Forms.Button button6;
        private System.Windows.Forms.Button button7;
        private System.Windows.Forms.Button button8;
        private System.Windows.Forms.ListBox listVideos;
        private System.Windows.Forms.Button button9;
        private System.Windows.Forms.Button button10;
        private System.Windows.Forms.Button button11;
        private System.Windows.Forms.Button button12;
        private System.Windows.Forms.Button resetButton;
        private System.Windows.Forms.Button button13;
        private System.Windows.Forms.Button button15;
    }
}