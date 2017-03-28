using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace proyecto1WebApi.Models
{
    public class nodo
    {
        public string transactionID  { get; set; }
        public string assetID { get; set; }
        public string userID { get; set; }
        public string departamento { get; set; }
        public string empresa { get; set; }
        public string fecha { get; set; }
        public string diasRentados { get; set; }
    }
}
