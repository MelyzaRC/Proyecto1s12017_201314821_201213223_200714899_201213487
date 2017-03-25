using proyecto1WebApi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using Newtonsoft.Json.Linq;
using System.Web.Http;

namespace proyecto1WebApi.Controllers
{
    public class ArbolBController : ApiController
    {
        public static ArbolB arbol = new ArbolB(5);
        public static List<string> transactions = new List<string>();

        [HttpGet]
        [ActionName("nuevoArbol")]
        public void nuevoArbol()
        {
            arbol = new ArbolB(5);
            transactions = new List<string>();
        }

        [HttpGet]
        [ActionName("dibujarArbol")]
        public string dibujarArbol()
        {
            Pagina a = ArbolB.raiz;
            string javascript = "var simple_chart_config = { chart: { container: '#OrganiseChart-simple'	}, nodeStructure: {";
            javascript += arbol.dibujaArbol(a);
            javascript += "}};";
            return javascript;
        }


        [HttpGet]
        [ActionName("obtenerArbol")]
        public Pagina obtenerArbol()
        {
            return ArbolB.raiz;
        }

        [HttpGet]
        [ActionName("insertar")]
        public void insertar([FromUri]string transactionID)//, [FromUri]string userID, [FromUri]string departamento, [FromUri]string assetID, [FromUri]string empresa, [FromUri]string fecha, [FromUri]string diasRentados)
        {
            transactions.Add(transactionID);
            //+string transactionID = Guid.NewGuid().ToString("N").Substring(0, 15);
            arbol.insertarNodo(new nodo
            {
                transactionID = transactionID/*,
                assetID = assetID,
                userID = userID,
                empresa = empresa,
                departamento = departamento,
                fecha = fecha,
                diasRentados = diasRentados*/
            });
        }

        [HttpGet]
        [ActionName("eliminar")]
        public void eliminar([FromUri]string transactionID)
        {
            Pagina raiz = ArbolB.raiz;

            arbol.eliminar(ref raiz, new nodo { transactionID = transactionID });

            ArbolB.raiz = raiz;
            
        }
    }
}
