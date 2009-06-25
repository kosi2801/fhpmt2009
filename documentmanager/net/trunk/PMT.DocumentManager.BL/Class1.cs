using PMT.DocumentManager.Data;

namespace PMT.DocumentManager.BL
{
    public class DataInitializer
    {

        public void intialize()
        {
            DataStore store = DataStore.Instance;

            DocumentData doc = new DocumentData();
            doc.Name = "Dokument1_Abgabe.docx";
            doc.Owner = "Andreas Höfler";
            doc.Location = "C:\\Privat\\";

            store.DocumentData = doc;
        }
    }
}
