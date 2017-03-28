using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace proyecto1WebApi.Models
{
    public class ArbolB
    {
        public int orden { get; set; }
        public static Pagina raiz { get; set; }
        public ArbolB (int _orden)
        {
            this.orden = _orden;
            ArbolB.raiz = null;
        }
        public void insertarNodo(nodo cl)
        {
            Pagina temp = ArbolB.raiz;
            insertar(ref temp, cl);
            ArbolB.raiz = temp;
        }


        public void insertar(ref Pagina raiz, nodo cl)
        {
            bool subeArriba = false;
            nodo mediana = null;
            Pagina p, nd = null;

            empujar(ref raiz, cl, ref subeArriba, ref mediana, ref nd);

            if (subeArriba)
            {
                p = new Pagina(this.orden);
                p.cuenta = 1;
                p.claves[1] = mediana;
                p.ramas[0] = raiz;
                p.ramas[1] = nd;
                raiz = p;
            }
        }

        public bool buscarNodo(ref Pagina actual, nodo cl, ref int k)
        {
            bool encontrado;

            if (strcmp(cl.transactionID, actual.claves[1].transactionID) < 0)
            {
                encontrado = false;
                k = 0;
            }
            else
            {
                k = actual.cuenta;
                while ((strcmp(cl.transactionID, actual.claves[k].transactionID) < 0) && (k > 1))
                    (k)--;

                encontrado = (strcmp(cl.transactionID, actual.claves[k].transactionID) == 0);
            }
            return encontrado;
        }

        public void empujar(ref Pagina actual, nodo cl, ref bool subeArriba, ref nodo mediana, ref Pagina nuevo)
        {
            int k = 0;

            if (actual == null)
            {
                subeArriba = true;
                mediana = cl;
                nuevo = null;
            }
            else
            {
                bool esta;
                esta = buscarNodo(ref actual, cl, ref k);

                if (esta)
                {
                    System.Console.WriteLine("\nClave duplicada");
                    subeArriba = false;
                    return;
                }

                empujar(ref actual.ramas[k], cl, ref subeArriba, ref mediana, ref nuevo);


                if (subeArriba)
                {
                    if (nodoLLeno(actual))
                        dividirNodo(ref actual, ref mediana, ref nuevo, k, ref mediana, ref nuevo);
                    else
                    {
                        subeArriba = false; 
                        meterHoja(ref actual, ref mediana, ref nuevo, k);
                    }
                }
            }
        }

        public void meterHoja(ref Pagina actual, ref nodo cl, ref Pagina rd, int k)
        {
            
            int i;
            for (i = actual.cuenta; i >= k + 1; i--)
            {
                actual.claves[i + 1] = actual.claves[i];
                actual.ramas[i + 1] = actual.ramas[i];

                actual.claves[i] = null;
                actual.ramas[i] = null;
            }
            actual.claves[k + 1] = cl;
            actual.ramas[i + 1] = rd;
            actual.cuenta++;
        }

        public void dividirNodo(ref Pagina actual, ref nodo cl, ref Pagina rd, int k, ref nodo mediana, ref Pagina nuevo)
        {
            int i, claveMedia;

            claveMedia = (k <= this.orden / 2) ? this.orden / 2 : this.orden / 2 + 1;
            if (nuevo==null)
                nuevo = new Pagina(5);

            for (i = claveMedia + 1; i < this.orden; i++)
            {

                nuevo.claves[i - claveMedia] = actual.claves[i];
                nuevo.ramas[i - claveMedia] = actual.ramas[i];

                actual.claves[i] = null;
                actual.ramas[i] = null;
            }
            nuevo.cuenta = (this.orden - 1) - claveMedia;
            actual.cuenta = claveMedia;

            Pagina nula = null;

            if (k <= this.orden / 2)
                meterHoja(ref actual, ref cl, ref nula, k);
            else
                meterHoja(ref nuevo, ref cl, ref nula, k - claveMedia);


            mediana = actual.claves[actual.cuenta];
            nuevo.ramas[0] = actual.ramas[actual.cuenta];
            actual.ramas[actual.cuenta] = null;
            actual.claves[actual.cuenta] = null;
            actual.cuenta--;
        }

        public void eliminar(ref Pagina raiz, nodo cl)
        {
            bool encontrado = false;

            eliminarRegistro(ref raiz, cl, ref encontrado);
            if (encontrado)
            {
                System.Console.WriteLine("Clave %s eliminada\n", cl.transactionID);
                if (raiz.cuenta == 0)
                {
                    Pagina p = raiz;
                    raiz = raiz.ramas[0];
                }
            }
            else
                System.Console.WriteLine("La clave no se encuentra en el arbol\n");
        }

        public void eliminarRegistro(ref Pagina actual, nodo cl, ref bool encontrado)
        {
            int k = 0;

            if (actual != null)
            {
                encontrado = buscarNodo(ref actual, cl, ref k);
                if (encontrado)
                {
                    if (actual.ramas[k - 1] == null)
                        quitar(ref actual, k);
                    else
                    {
                        sucesor(ref actual, k);
                        eliminarRegistro(ref actual.ramas[k], actual.claves[k], ref encontrado);
                    }
                }
                else
                {
                    eliminarRegistro(ref actual.ramas[k], cl, ref encontrado);
                }

                if (actual.ramas[k] != null)
                    if (actual.ramas[k].cuenta < this.orden / 2)
                        restablecer(ref actual, k);
            }
            else
                encontrado = false;
        }

        public void quitar(ref Pagina actual, int k)
        {
            int j;

            for (j = k + 1; j <= actual.cuenta; j++)
            {
                actual.claves[j - 1] = actual.claves[j];
                actual.claves[j] = null;
                actual.ramas[j - 1] = actual.ramas[j];
                actual.ramas[j] = null;
            }
            actual.cuenta--;
        }

        public void sucesor(ref Pagina actual, int k)
        {
            Pagina q;

            q = actual.ramas[k];
            while (q.ramas[0] != null)
                q = q.ramas[0];
            actual.claves[k] = q.claves[1];
            //q.claves[1] = null;
            actual.ramas[k] = q;
        }

        public void restablecer(ref Pagina actual, int k)
        {

            if (k > 0)
                if (actual.ramas[k - 1].cuenta > this.orden / 2)
                    moverDrcha(ref actual, k);
                else
                    combina(ref actual, k);

            else
               if (actual.ramas[1].cuenta > this.orden / 2)
                moverIzqda(ref actual, 1);
            else
                combina(ref actual, 1);
        }

        public void moverDrcha(ref Pagina actual, int k)
        {
            int j;

            Pagina nodoProblema = actual.ramas[k];
            Pagina nodoIzqdo = actual.ramas[k - 1];

            for (j = nodoProblema.cuenta; j >= 1; j--)
            {
                nodoProblema.claves[j + 1] = nodoProblema.claves[j];
                nodoProblema.ramas[j + 1] = nodoProblema.ramas[j];

                nodoProblema.claves[j] = null;
                nodoProblema.ramas[j] = null;
            }
            nodoProblema.cuenta++;
            nodoProblema.ramas[1] = nodoProblema.ramas[0];
            nodoProblema.claves[1] = actual.claves[k];

            actual.claves[k] = nodoIzqdo.claves[nodoIzqdo.cuenta];
            nodoProblema.ramas[0] = nodoIzqdo.ramas[nodoIzqdo.cuenta];
            nodoIzqdo.cuenta--;
        }

        public void moverIzqda(ref Pagina actual, int k)
        {
            int j;

            Pagina nodoProblema = actual.ramas[k - 1];
            Pagina nodoDrcho = actual.ramas[k];

            nodoProblema.cuenta++;
            nodoProblema.claves[nodoProblema.cuenta] = actual.claves[k];
            nodoProblema.ramas[nodoProblema.cuenta] = nodoDrcho.ramas[0];


            actual.claves[k] = nodoDrcho.claves[1];
            nodoDrcho.ramas[1] = nodoDrcho.ramas[0];
            nodoDrcho.cuenta--;

            for (j = 1; j <= nodoDrcho.cuenta; j++)
            {
                nodoDrcho.claves[j] = nodoDrcho.claves[j + 1];
                nodoDrcho.ramas[j] = nodoDrcho.ramas[j + 1];

                nodoDrcho.claves[j + 1] = null;
                nodoDrcho.ramas[j + 1] = null;
            }

            actual.ramas[k - 1] = nodoProblema;
            actual.ramas[k] = nodoDrcho;

        }

        public void combina(ref Pagina actual, int k)
        {
            int j;
            Pagina nodoIzqdo, q;

            q = actual.ramas[k];
            nodoIzqdo = actual.ramas[k - 1];
            nodoIzqdo.cuenta++;
            nodoIzqdo.claves[nodoIzqdo.cuenta] = actual.claves[k];
            nodoIzqdo.ramas[nodoIzqdo.cuenta] = q.ramas[0];
            for (j = 1; j <= q.cuenta; j++)
            {
                nodoIzqdo.cuenta++;
                nodoIzqdo.claves[nodoIzqdo.cuenta] = q.claves[j];
                nodoIzqdo.ramas[nodoIzqdo.cuenta] = q.ramas[j];
                q.claves[j] = null;
                q.ramas[j] = null;
            }

            for (j = k; j <= actual.cuenta - 1; j++)
            {
                actual.claves[j] = actual.claves[j + 1];
                actual.ramas[j] = actual.ramas[j + 1];
                actual.claves[j + 1] = null;
                actual.ramas[j + 1] = null;
            }
            actual.cuenta--;

            actual.ramas[k] = q;
            actual.ramas[k - 1] = nodoIzqdo;

        }

        public string dibujaArbol(Pagina actual)
        {
            string res = "text: { name: '|";

            for (int i = 0; i < 5; i++)
            {
                res += actual.claves[i] == null ? " " : actual.claves[i].transactionID;
                res += "|";
            }
            res += "'}";
            bool primero = true;
            for (int j = 0; j < 5; j++)
            {
                if (actual.ramas[j] != null)
                {
                    if (primero)
                    {
                        res += ",children: [ ";

                    }

                    res += "{";
                    primero = false;
                    res += dibujaArbol(actual.ramas[j]);

                    res += "}";

                    if (actual.ramas.Count() > (j + 1) && actual.ramas[j + 1] != null)
                        res += ",";
                }
            }
            if (!primero)
                res += "]";

            return res;
        }

        public string graficarArbol(Pagina actual)
        {
            string res = "";
            string claves = getClaves(actual);
            
            for (int j = 0; j < 5; j++)
            {
                if (actual.ramas[j] != null)
                {
                    string rama = getClaves(actual.ramas[j]);

                    if (!string.IsNullOrEmpty(rama))
                    {
                        res += " " + claves + " -- " + rama + ";";
                    }

                    res += graficarArbol(actual.ramas[j]);
                    
                }
            }

            return res;
        }

        public string getClaves(Pagina pag)
        {
            if (pag.cuenta == 0)
                return null;

            string res = "\"|";

            for (int i = 0; i < 5; i++)
            {
                res += pag.claves[i] == null ? " " : pag.claves[i].transactionID;
                res += "|";
            }
            res += "\"";
            return res;
        }

        public int strcmp(string a, string b)
        {
            return a.CompareTo(b);
        }

        public bool nodoLLeno(Pagina actual)
        {
            return (actual.cuenta == this.orden - 1);
        }


        public void eliminarActivo (ref Pagina pag, string activo)
        {
            for(int i = 0; i < 5; i++)
            {
                if (pag.claves[i].assetID.Equals(activo))
                {
                    eliminar(ref pag, pag.claves[i]);
                    Pagina p = ArbolB.raiz;
                    eliminarActivo(ref p, activo);
                    ArbolB.raiz = p;
                }
                if (pag.ramas[i] != null)
                {
                    eliminarActivo(ref pag.ramas[i], activo);
                }
            }
        }

    }
}
