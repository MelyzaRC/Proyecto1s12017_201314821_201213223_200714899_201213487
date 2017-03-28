﻿using proyecto1WebApi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using Newtonsoft.Json.Linq;
using System.Web.Http;
using System.IO;
using System.Diagnostics;

namespace proyecto1WebApi.Controllers
{
    public class ArbolBController : ApiController
    {
        public static ArbolB arbol = new ArbolB(5);

        [HttpGet]
        [ActionName("nuevoArbol")]
        public void nuevoArbol()
        {
            arbol = new ArbolB(5);
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
        [ActionName("graficarArbol")]
        public string graficarArbol()
        {
            Pagina a = ArbolB.raiz;
            string javascript = "graph {";
            javascript += arbol.graficarArbol(a);
            javascript += "}";

            string filePath = AppDomain.CurrentDomain.BaseDirectory + "imagenes\\archivo_dot.dot";

            if (File.Exists(filePath))
                File.Delete(filePath);

            using (StreamWriter sw = File.CreateText(filePath))
            {
                sw.WriteLine(javascript);
            }

            string parametros = "-Tjpg \"" + filePath + "\" > \"" + AppDomain.CurrentDomain.BaseDirectory + "imagenes\\arbol.jpg\"";
            string comandoCMD = "\"C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe\"";

            ProcessStartInfo p = new ProcessStartInfo();
            p.FileName = comandoCMD;
            p.Arguments = parametros;
            p.CreateNoWindow = true;
            p.WindowStyle = ProcessWindowStyle.Hidden;

            Process proc = new Process();

            proc.StartInfo = p;

            proc.Start();

            string result = proc.StandardOutput.ReadToEnd();
            

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
        public void insertar([FromUri]string userID, [FromUri]string departamento, [FromUri]string assetID, [FromUri]string empresa, [FromUri]string fecha, [FromUri]string diasRentados)
        {
            
            string transactionID = Guid.NewGuid().ToString("N").Substring(0, 15);
            arbol.insertarNodo(new nodo
            {
                transactionID = transactionID,
                assetID = assetID,
                userID = userID,
                empresa = empresa,
                departamento = departamento,
                fecha = fecha,
                diasRentados = diasRentados
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

        [HttpGet]
        [ActionName("eliminarActivo")]
        public void eliminarActivo([FromUri]string assetID)
        {
            Pagina raiz = ArbolB.raiz;

            arbol.eliminarActivo(ref raiz, assetID);

            ArbolB.raiz = raiz;

        }
    }
}
