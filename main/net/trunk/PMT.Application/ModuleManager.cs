using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Deployment.Application;
using System.Reflection;

namespace PMT.Application
{


    public class ModuleManager
    {


        private Dictionary<ModuleKey, String[]> moduleLibraries = new Dictionary<ModuleKey, String[]>();


        public ModuleManager() {
            moduleLibraries.Add(new ModuleKey("Main"), new String[] { "PMT.Main.UI", "PMT.Main.BL", "PMT.Main.Data"});
            moduleLibraries.Add(new ModuleKey("Birthdaymanager"), new String[] { "PMT.BirthdayManager.UI"});
            loadPlugins("Main");
            loadPlugins("Birthdaymanager");
        }

        public Boolean checkModuleAvailability(String module)
        {
            ModuleKey key = getKey(module);
            if (key == null)
                return false;
            Assembly[] asms = AppDomain.CurrentDomain.GetAssemblies();
            foreach (String library in moduleLibraries[key])
            {
                bool found = false;
                foreach (Assembly asm in asms)
                {
                    if (asm.FullName.CompareTo(library)== 0)
                    {
                        found = true;
                        break;
                    }
                };
                if (!found)
                    return false;
            }
            return true;
        }

        public bool isModuleLoaded(String module)
        {
            ModuleKey key = getKey(module);
            if (key == null)
                return false;
            return key.Loaded;
        }

        private ModuleKey getKey(String module)
        {
            foreach (ModuleKey key in moduleLibraries.Keys)
            {
                if (key.Key == module)
                    return key;
            }
            return null;
        }

        public void loadPlugins(String module)
        {
            ModuleKey moduleKey = getKey(module);
            if (moduleKey == null || moduleKey.Loaded)
                return;
            try
            {
                foreach (String library in moduleLibraries[moduleKey])
                {
                    Assembly asm = Assembly.Load(library);
                    if (asm == null)
                    {
                        moduleKey.Loaded = false; 
                        throw new Exception("Failed to load " + library);
                    }
                }
                moduleKey.Loaded = true;
            }
            catch (Exception ex)
            {
                //System.Windows.Forms.MessageBox.Show(ex.Message, "Error");
            }

        }

        public System.Windows.Forms.Form loadForm(String assemblyName, String qualifiedFormName)
        {
            
            Assembly[] assemblies=AppDomain.CurrentDomain.GetAssemblies();
            foreach (Assembly assembly in assemblies)
            {
                if (assembly.GetName().Name == assemblyName)
                {
                    object classInstance = assembly.CreateInstance(qualifiedFormName);
                    if (classInstance == null)
                        return null;
                    else
                        return (System.Windows.Forms.Form)classInstance;
                }
            }
            return null;

        }

    }

    public class ModuleKey
    {
        private String key;

        private bool loaded;

        public ModuleKey(String key)
        {
            this.key = key;
            this.loaded = false;
        }

        public bool Loaded
        {
            get
            {
                return loaded;
            }
            set
            {
                loaded = value;
            }
        }

        public String Key
        {
            get
            {
                return key;
            }
        }
    }


}
