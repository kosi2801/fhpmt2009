using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using PMT.Multimediamanager.BL;
using PMT.Multimediamanager.Data;

namespace PMT.Multimediamanager.UI
{

    public partial class Formular1 : Form
    {
        private MultimediaTyp active = MultimediaTyp.IMAGE;
        private List<String> auswahl = new List<String>();
        private DataStore store;

        public Formular1()
        {
            InitializeComponent();
            new DataInitializer().intialize();
            updateData();
        }

        private void resetButton_Click(object sender, EventArgs e)
        {
            new DataInitializer().intialize();
            updateData();
        }

        private void closeButton_Click(object sender, EventArgs e)
        {
            this.Close();
        }
        private void multimediaTabs_Click(object sender, EventArgs e)
        {
            if (this.multimediaTabs.SelectedIndex == 0) active = MultimediaTyp.IMAGE;
            if (this.multimediaTabs.SelectedIndex == 1) active = MultimediaTyp.AUDIO;
            if (this.multimediaTabs.SelectedIndex == 2) active = MultimediaTyp.VIDEO;
            updateData();
        }
        public void updateData()
        {
            store = DataStore.Instance;
            if (this.store.Multimedias != null)
            {
                auswahl.Clear();
                foreach (Multimedia mm in store.Multimedias) {
                    if (mm.Typ == active)
                    {
                        auswahl.Add(mm.Titel);
                    }
                }
                this.listImages.DataSource = auswahl;
                this.listAudios.DataSource = auswahl;
                this.listVideos.DataSource = auswahl;
                if (active == MultimediaTyp.IMAGE)
                {
                    this.listImages.BindingContext[this.listImages.DataSource].SuspendBinding();
                    this.listImages.DataSource = auswahl;
                    this.listImages.BindingContext[this.listImages.DataSource].ResumeBinding();
                }
                if (active == MultimediaTyp.AUDIO)
                {
                    this.listAudios.BindingContext[this.listAudios.DataSource].SuspendBinding();
                    this.listAudios.DataSource = auswahl;
                    this.listAudios.BindingContext[this.listAudios.DataSource].ResumeBinding();
                }
                if (active == MultimediaTyp.VIDEO)
                {
                    this.listVideos.BindingContext[this.listVideos.DataSource].SuspendBinding();
                    this.listVideos.DataSource = auswahl;
                    this.listVideos.BindingContext[this.listVideos.DataSource].ResumeBinding();
                }
            }
        }
        private void editButton_Click(object sender, EventArgs e)
        {
            int i = 0;
            int j = 0;
            int selectedInd = -1;
            Multimedia selected = null;
            foreach (Multimedia mm in store.Multimedias)
            {
                if (mm.Typ == active)
                {
                    if (this.listImages.SelectedIndex == i)
                    {
                        selected = mm;
                        selectedInd = j;
                    }
                    i++;
                }
                j++;
            }

            EditData editForm = new EditData(selected);
            editForm.ShowDialog();
            if (editForm.DialogResult == DialogResult.OK)
            {
                if (selected == null)
                {
                    Multimedia newmm = new Multimedia();
                    newmm.Titel = editForm.textTitel.Text;
                    newmm.Typ = active;
                    store.Multimedias.Add(newmm);
                }
                else
                {
                    store.Multimedias.ElementAt(selectedInd).Titel = editForm.textTitel.Text;
                }
                updateData();
            }
        }
        private void addButton_Click(object sender, EventArgs e)
        {
            EditData editForm = new EditData();
            editForm.ShowDialog();
            if (editForm.DialogResult == DialogResult.OK)
            {
                    Multimedia newmm = new Multimedia();
                    newmm.Titel = editForm.textTitel.Text;
                    newmm.Typ = active;
                    store.Multimedias.Add(newmm);
            }
            updateData();
        }
        private void removeButton_Click(object sender, EventArgs e)
        {
            int i = 0;
            int j = 0;
            int selectedInd = -1;
            Multimedia selected = null;
            foreach (Multimedia mm in store.Multimedias)
            {
                if (mm.Typ == active)
                {
                    if (this.listImages.SelectedIndex == i)
                    {
                        selected = mm;
                        selectedInd = j;
                    }
                    i++;
                }
                j++;
            }
            
            RemoveData removeForm = new RemoveData(selected);
            removeForm.ShowDialog();
            if (removeForm.DialogResult == DialogResult.OK)
            {
                store.Multimedias.RemoveAt(selectedInd);
            }
            updateData();

        }
    }
}
