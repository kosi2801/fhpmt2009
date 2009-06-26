namespace PMT.AddressBook.UI
{
    partial class AddressBookForm
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
            this.closeButton = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.tb_name = new System.Windows.Forms.TextBox();
            this.tb_street = new System.Windows.Forms.TextBox();
            this.tb_zip = new System.Windows.Forms.TextBox();
            this.tb_country = new System.Windows.Forms.TextBox();
            this.tb_email = new System.Windows.Forms.TextBox();
            this.tb_phone = new System.Windows.Forms.TextBox();
            this.tb_mobile = new System.Windows.Forms.TextBox();
            this.label8 = new System.Windows.Forms.Label();
            this.tb_city = new System.Windows.Forms.TextBox();
            this.lv_Addresses = new System.Windows.Forms.ListView();
            this.ch_name = new System.Windows.Forms.ColumnHeader();
            this.button1 = new System.Windows.Forms.Button();
            this.initializeButton = new System.Windows.Forms.Button();
            this.deleteButton = new System.Windows.Forms.Button();
            this.udpateButton = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // closeButton
            // 
            this.closeButton.Location = new System.Drawing.Point(354, 313);
            this.closeButton.Name = "closeButton";
            this.closeButton.Size = new System.Drawing.Size(75, 23);
            this.closeButton.TabIndex = 0;
            this.closeButton.Text = "&Close";
            this.closeButton.UseVisualStyleBackColor = true;
            this.closeButton.Click += new System.EventHandler(this.closeButton_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(16, 206);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(38, 13);
            this.label1.TabIndex = 1;
            this.label1.Text = "Name:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(16, 232);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(38, 13);
            this.label2.TabIndex = 2;
            this.label2.Text = "Street:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(16, 258);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(55, 13);
            this.label3.TabIndex = 3;
            this.label3.Text = "ZIP-Code:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(253, 206);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(46, 13);
            this.label4.TabIndex = 4;
            this.label4.Text = "Country:";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(253, 232);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(39, 13);
            this.label5.TabIndex = 5;
            this.label5.Text = "E-Mail:";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(253, 258);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(41, 13);
            this.label6.TabIndex = 6;
            this.label6.Text = "Phone:";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(253, 284);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(41, 13);
            this.label7.TabIndex = 7;
            this.label7.Text = "Mobile:";
            // 
            // tb_name
            // 
            this.tb_name.Location = new System.Drawing.Point(84, 203);
            this.tb_name.Name = "tb_name";
            this.tb_name.Size = new System.Drawing.Size(142, 20);
            this.tb_name.TabIndex = 8;
            // 
            // tb_street
            // 
            this.tb_street.Location = new System.Drawing.Point(84, 229);
            this.tb_street.Name = "tb_street";
            this.tb_street.Size = new System.Drawing.Size(142, 20);
            this.tb_street.TabIndex = 9;
            // 
            // tb_zip
            // 
            this.tb_zip.Location = new System.Drawing.Point(84, 255);
            this.tb_zip.Name = "tb_zip";
            this.tb_zip.Size = new System.Drawing.Size(142, 20);
            this.tb_zip.TabIndex = 10;
            // 
            // tb_country
            // 
            this.tb_country.Location = new System.Drawing.Point(305, 203);
            this.tb_country.Name = "tb_country";
            this.tb_country.Size = new System.Drawing.Size(142, 20);
            this.tb_country.TabIndex = 11;
            // 
            // tb_email
            // 
            this.tb_email.Location = new System.Drawing.Point(305, 229);
            this.tb_email.Name = "tb_email";
            this.tb_email.Size = new System.Drawing.Size(142, 20);
            this.tb_email.TabIndex = 12;
            // 
            // tb_phone
            // 
            this.tb_phone.Location = new System.Drawing.Point(305, 255);
            this.tb_phone.Name = "tb_phone";
            this.tb_phone.Size = new System.Drawing.Size(142, 20);
            this.tb_phone.TabIndex = 13;
            // 
            // tb_mobile
            // 
            this.tb_mobile.Location = new System.Drawing.Point(305, 281);
            this.tb_mobile.Name = "tb_mobile";
            this.tb_mobile.Size = new System.Drawing.Size(142, 20);
            this.tb_mobile.TabIndex = 14;
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(16, 284);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(27, 13);
            this.label8.TabIndex = 15;
            this.label8.Text = "City:";
            // 
            // tb_city
            // 
            this.tb_city.Location = new System.Drawing.Point(84, 281);
            this.tb_city.Name = "tb_city";
            this.tb_city.Size = new System.Drawing.Size(142, 20);
            this.tb_city.TabIndex = 16;
            // 
            // lv_Addresses
            // 
            this.lv_Addresses.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.ch_name});
            this.lv_Addresses.Location = new System.Drawing.Point(19, 11);
            this.lv_Addresses.Name = "lv_Addresses";
            this.lv_Addresses.Size = new System.Drawing.Size(428, 178);
            this.lv_Addresses.TabIndex = 17;
            this.lv_Addresses.UseCompatibleStateImageBehavior = false;
            this.lv_Addresses.View = System.Windows.Forms.View.Details;
            this.lv_Addresses.DoubleClick += new System.EventHandler(this.lv_Addresses_DoubleClick);
            // 
            // ch_name
            // 
            this.ch_name.Text = "Name";
            this.ch_name.Width = 424;
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(30, 313);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 23);
            this.button1.TabIndex = 18;
            this.button1.Text = "&Add";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // initializeButton
            // 
            this.initializeButton.Location = new System.Drawing.Point(273, 313);
            this.initializeButton.Name = "initializeButton";
            this.initializeButton.Size = new System.Drawing.Size(75, 23);
            this.initializeButton.TabIndex = 19;
            this.initializeButton.Text = "&Initialize";
            this.initializeButton.UseVisualStyleBackColor = true;
            this.initializeButton.Click += new System.EventHandler(this.initializeButton_Click);
            // 
            // deleteButton
            // 
            this.deleteButton.Location = new System.Drawing.Point(192, 313);
            this.deleteButton.Name = "deleteButton";
            this.deleteButton.Size = new System.Drawing.Size(75, 23);
            this.deleteButton.TabIndex = 20;
            this.deleteButton.Text = "&Delete";
            this.deleteButton.UseVisualStyleBackColor = true;
            this.deleteButton.Click += new System.EventHandler(this.deleteButton_Click);
            // 
            // udpateButton
            // 
            this.udpateButton.Location = new System.Drawing.Point(111, 313);
            this.udpateButton.Name = "udpateButton";
            this.udpateButton.Size = new System.Drawing.Size(75, 23);
            this.udpateButton.TabIndex = 21;
            this.udpateButton.Text = "&Update";
            this.udpateButton.UseVisualStyleBackColor = true;
            this.udpateButton.Click += new System.EventHandler(this.udpateButton_Click);
            // 
            // AddressBookForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(459, 347);
            this.Controls.Add(this.udpateButton);
            this.Controls.Add(this.deleteButton);
            this.Controls.Add(this.initializeButton);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.lv_Addresses);
            this.Controls.Add(this.tb_city);
            this.Controls.Add(this.label8);
            this.Controls.Add(this.tb_mobile);
            this.Controls.Add(this.tb_phone);
            this.Controls.Add(this.tb_email);
            this.Controls.Add(this.tb_country);
            this.Controls.Add(this.tb_zip);
            this.Controls.Add(this.tb_street);
            this.Controls.Add(this.tb_name);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.closeButton);
            this.Name = "AddressBookForm";
            this.Text = "AddressBookForm";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button closeButton;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.TextBox tb_name;
        private System.Windows.Forms.TextBox tb_street;
        private System.Windows.Forms.TextBox tb_zip;
        private System.Windows.Forms.TextBox tb_country;
        private System.Windows.Forms.TextBox tb_email;
        private System.Windows.Forms.TextBox tb_phone;
        private System.Windows.Forms.TextBox tb_mobile;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.TextBox tb_city;
        private System.Windows.Forms.ListView lv_Addresses;
        private System.Windows.Forms.ColumnHeader ch_name;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Button initializeButton;
        private System.Windows.Forms.Button deleteButton;
        private System.Windows.Forms.Button udpateButton;
    }
}