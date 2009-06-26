using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Deployment.Application;
using System.Reflection;

namespace PMT.Application
{

    /// <summary>
    /// Class containing the list of assemblies defined for each module in the personal management tool.
    /// On startup all assemblies are loaded if available and the corresponding flags are set.
    /// </summary>
    public class ModuleManager
    {
        private Dictionary<ModuleKey, String[]> moduleLibraries = new Dictionary<ModuleKey, String[]>();

        public const String MODULE_MAIN = "Main";
        public const String MODULE_CHAT = "Chat";
        public const String MODULE_BIRTHDAYMANAGER = "BirthdayManager";
        public const String MODULE_ADDRESSBOOK = "Addressbook";
        public const String MODULE_DOCUMENTMANAGER = "DocumentManager";
        public const String MODULE_MULTIMEDIAMANAGER = "MultimediaManager";
        public const String MODULE_TASKMANAGER = "TaskManager";

        public ModuleManager() {
            // Declare here the libraries, which constitute your module
            moduleLibraries.Add(new ModuleKey(ModuleManager.MODULE_MAIN), new String[] { "PMT.Main.UI", "PMT.Main.BL", "PMT.Main.Data"});
            moduleLibraries.Add(new ModuleKey(ModuleManager.MODULE_BIRTHDAYMANAGER), new String[] { "PMT.BirthdayManager.UI"});
            moduleLibraries.Add(new ModuleKey(ModuleManager.MODULE_CHAT), new String[] { "PMT.Chat.UI" });
            moduleLibraries.Add(new ModuleKey(ModuleManager.MODULE_ADDRESSBOOK), new String[] { "PMT.AddressBook.UI", "PMT.AddressBook.BL", "PMT.AddressBook.Data" });            
            moduleLibraries.Add(new ModuleKey(ModuleManager.MODULE_DOCUMENTMANAGER), new String[] { "PMT.DocumentManager.UI" });
            moduleLibraries.Add(new ModuleKey(ModuleManager.MODULE_MULTIMEDIAMANAGER), new String[] { "PMT.Multimediamanager.UI" });
            moduleLibraries.Add(new ModuleKey(ModuleManager.MODULE_TASKMANAGER), new String[] { "PMT.Taskmanager.UI" });
            //try to load all libraries
            loadPlugins(ModuleManager.MODULE_MAIN);
            loadPlugins(ModuleManager.MODULE_BIRTHDAYMANAGER);
            loadPlugins(ModuleManager.MODULE_CHAT);
            loadPlugins(ModuleManager.MODULE_ADDRESSBOOK);
            loadPlugins(ModuleManager.MODULE_DOCUMENTMANAGER);
            loadPlugins(ModuleManager.MODULE_MULTIMEDIAMANAGER);
            loadPlugins(ModuleManager.MODULE_TASKMANAGER);
        }

        /// <summary>
        /// Check if the given module is available by selecting the corresponding key for this module and looking if the libraries are currently loaded.
        /// </summary>
        /// <param name="module">String corresponding to one of the MODULE constants</param>
        /// <returns></returns>
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

        /// <summary>
        /// Checks if a module is loaded by looking at the loaded flag of the module key.
        /// </summary>
        /// <param name="module">String corresponding to one of the MODULE constants</param>
        /// <returns></returns>
        public bool isModuleLoaded(String module)
        {
            ModuleKey key = getKey(module);
            if (key == null)
                return false;
            return key.Loaded;
        }

        /// <summary>
        /// Gets the key for the corresponding module from the modulelibraries map
        /// </summary>
        /// <param name="module"></param>
        /// <returns></returns>
        private ModuleKey getKey(String module)
        {
            foreach (ModuleKey key in moduleLibraries.Keys)
            {
                if (key.Key == module)
                    return key;
            }
            return null;
        }

        /// <summary>
        /// Loads all libraries registered for the given module in the modulelibraries map. If all libraries have been loaded, the loaded flag
        /// of the module key is set to true.
        /// </summary>
        /// <param name="module">String corresponding to one of the MODULE constants</param>
        public void loadPlugins(String module)
        {
            ModuleKey moduleKey = getKey(module);
            
            if (moduleKey == null || moduleKey.Loaded)
                return;
            try
            {
                foreach (String library in moduleLibraries[moduleKey])
                {
                    
                   // Assembly asm = Assembly.Load(library);
                    Assembly asm = Assembly.LoadFile(System.Windows.Forms.Application.StartupPath + @"\" + library + ".dll");

                    if (asm == null)
                    {
                        moduleKey.Loaded = false;
                        return;
                    }
                }
                moduleKey.Loaded = true;
            }
            catch (Exception)
            {
                //System.Windows.Forms.MessageBox.Show(ex.Message, "Error");
            }

        }

        /// <summary>
        /// Loads a given windows.form from a given assembly. This method is required to allow initialization of forms
        /// in the application main dialog, which are not contributed by referenced assemblies.
        /// </summary>
        /// <param name="assemblyName"></param>
        /// <param name="qualifiedFormName"></param>
        /// <returns></returns>
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
