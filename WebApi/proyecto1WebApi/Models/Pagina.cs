using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace proyecto1WebApi.Models
{
    public unsafe class Pagina
    {
        public int orden { get; set; }
        public Pagina[] ramas { get; set; }
        public nodo[] claves { get; set; }
        public int cuenta { get; set; }

        public Pagina(int orden)
        {
            this.orden = orden;
            claves = new nodo[this.orden];
            ramas= new Pagina[this.orden];
        }

        
    }
}
