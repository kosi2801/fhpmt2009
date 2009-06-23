using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace PMT.Multimediamanager.Data
{
    public enum MultimediaTyp { IMAGE, VIDEO, AUDIO };

    public class Multimedia
    {

        private String titel;
        private MultimediaTyp typ;

        public String Titel
        {
            get
            {
                return titel;
            }
            set
            {
                titel = value;
            }
        }

        public MultimediaTyp Typ
        {
            get
            {
                return typ;
            }
            set
            {
                typ = value;
            }
        }
    }
}
