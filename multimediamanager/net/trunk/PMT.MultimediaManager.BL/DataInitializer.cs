using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using PMT.Multimediamanager.Data;

namespace PMT.Multimediamanager.BL
{
    public class DataInitializer
    {

        public void intialize()
        {
            DataStore store = DataStore.Instance;
            List<Multimedia> ms = store.Multimedias;

            Multimedia multimediaI = new Multimedia();
            multimediaI.Titel = "Ferien am Strand";
            multimediaI.Typ = MultimediaTyp.IMAGE;

            ms.Add(multimediaI);

            Multimedia multimediaA = new Multimedia();
            multimediaA.Titel = "Holiday Feeling";
            multimediaA.Typ = MultimediaTyp.AUDIO;

            ms.Add(multimediaA);

            Multimedia multimediaV = new Multimedia();
            multimediaV.Titel = "Summer Day";
            multimediaV.Typ = MultimediaTyp.VIDEO;

            ms.Add(multimediaV);

        }
    }
}
