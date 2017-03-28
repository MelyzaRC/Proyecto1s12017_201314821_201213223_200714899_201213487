#Autor-------------------------------------------------
__author__ = "Melyza Rodriguez - Grupo 4"

#Imports-----------------------------------------------
from flask import Flask, request, Response
app = Flask("Proyecto 1 Estructura de Datos")
import subprocess
from graphviz import Digraph
import random

class Empresa:
	def __init__(self, nombreEmpresa):
		self.nombreEmpresa = nombreEmpresa

class Departamento:
	def __init__(self, nombreDepartamento):
		self.nombreDepartamento = nombreDepartamento
		
class Usuario:
	def __init__(self, nombreUsuario, passwordUsuario, nombreCompleto):
		self.nombreUsuario = nombreUsuario
		self.passwordUsuario = passwordUsuario
		self.nombreCompleto = nombreCompleto

class Nodo:
	def __init__(self, contenido, primero, ultimo, raiz):
		self.contenido = contenido
		self.siguiente=None
		self.anterior =None
		self.arriba = None
		self.abajo = None
		self.adelante = None
		self.atras = None
		self.hijoizquierdo = None
		self.hijoderecho = None
		self.primero = primero
		self.ultimo = ultimo
		self.raiz = raiz

class Activo:
	def __init__(self, idActivo, nombreActivo, descripcionActivo, estado):
		self.idActivo = idActivo
		self.nombreActivo = nombreActivo
		self.descripcionActivo = descripcionActivo
		self.estado = estado
		self.hijoderecho = None
		self.hijoizquierdo = None
		self.raiz = None

class ActivoCatalogo:
	def __init__(self, activo, empresa, departamento, usuario, primero, ultimo):
		self.activo = activo
		self.empresa = empresa
		self.departamento = departamento
		self.usuario = usuario
		self.siguiente = None
		self.primero = primero
		self.ultimo = ultimo

class Transaccion:
	def __init__(self, idA, usuario, departamento, empresa, tiempo, primero, ultimo):
		self.idA = idA
		self.usuario = usuario
		self.departamento = departamento
		self.empresa = empresa
		self.tiempo = tiempo
		self.primero = primero
		self.ultimo = ultimo
		self.siguiente = None
		self.anterior = None

class Matriz:
	def __init__(self):
		self.primerDepartamento = None
		self.ultimoDepartamento = None
		self.primeraEmpresa = None
		self.ultimaEmpresa = None
		self.listaUsuario = Nodo("Lista de acivos pertenecientes a un usuario", None, None, None)
		self.catalogo = ActivoCatalogo("Catalogo de productos", None, None, None, None, None)
		self.transacciones = Transaccion("Transacciones", None, None, None, None, None, None)
	def vacia(self): 
		if self.primeraEmpresa == None:
			return True
		else:
			return False
	def verificarUsuario(self, empresa, departamento, nombre, user, password):
		s = ""
		encontrado = False
		#Busca la empresa:
		if self.primeraEmpresa == None:
			s = self.addUsuario(empresa, departamento, nombre, user, password)
		else:
			tempEmpresa = self.primeraEmpresa
			while tempEmpresa != None:
				if str(empresa) == str(tempEmpresa.contenido.nombreEmpresa):
					#Baja por la empresa
					tempDepartamento = tempEmpresa.primero
					while tempDepartamento != None:
						#Regresion para buscar el departamento
						tempRegresion = tempDepartamento
						while tempRegresion != None:
							if tempRegresion.anterior == None:
								if str(tempRegresion.contenido.nombreDepartamento) == str(departamento):
									tempBusquedaUsuario = tempDepartamento
									while tempBusquedaUsuario != None:
										if str(tempBusquedaUsuario.contenido.nombreUsuario) == str(user):
											encontrado = True
										tempBusquedaUsuario = tempBusquedaUsuario.atras
							tempRegresion = tempRegresion.anterior
						tempDepartamento = tempDepartamento.abajo
				tempEmpresa = tempEmpresa.siguiente

			if encontrado == True:
				s = "No"
			else:
				s = self.addUsuario(empresa, departamento, nombre, user, password)
		return s
	def addNodoArbol(self, user, password, departamento, empresa, nombrea, descripcion):
		activoActual = Activo(self.randomM(), nombrea, descripcion, "D")#D para disponible N para no disponible 
		temp = self.primeraEmpresa
		encontrado = False
		s = ""
		respuesta = ""
		while temp != None:
			if str(temp.contenido.nombreEmpresa) == str(empresa):
				if encontrado == False:
					temp1 = temp.primero
					while temp1 != None:
						if encontrado == False:
							temp2 = temp1
							while temp2 != None:
								if temp2.anterior == None:
									if str(temp2.contenido.nombreDepartamento) == str(departamento):
										temp3 = temp1
										while temp3 != None:
											if encontrado == False:
												if (str(temp3.contenido.nombreUsuario) == str(user)) & (str(password) == str(temp3.contenido.passwordUsuario)):
													encontrado = True
													s = ""
													if temp3.raiz == None:
														temp3.raiz = activoActual
														activoActual.raiz = None
														respuesta = "Raiz"
													else:
														respuesta = self.ubicarNodo(temp3.raiz, activoActual)
														
														respuesta = respuesta
											temp3 = temp3.atras
										break
								temp2 = temp2.anterior
						else:
							break
						temp1 = temp1.abajo
					else:
						break
			temp = temp.siguiente
		
		return respuesta
	def ubicarNodo(self, raiz, activoInsertar):
		s = ""
		if raiz.idActivo < activoInsertar.idActivo:
			if raiz.hijoderecho == None:
				raiz.hijoderecho = activoInsertar
				activoInsertar.raiz = raiz
				s = "Insertado a la derecha de: " + raiz.idActivo
			else:
				s = self.ubicarNodo(raiz.hijoderecho, activoInsertar)
		elif raiz.idActivo > activoInsertar.idActivo:
			if raiz.hijoizquierdo == None:
				raiz.hijoizquierdo = activoInsertar
				activoInsertar.raiz = raiz
				s = "Insertado a la izquierda de: " + raiz.idActivo
			else:
				s = self.ubicarNodo(raiz.hijoizquierdo, activoInsertar)
		elif raiz.idActivo == activoInsertar.idActivo:
			if raiz.hijoizquierdo == None:
				raiz.hijoizquierdo = activoInsertar
				activoInsertar.raiz = raiz
				s = "Insertado a la izquierda de: " + raiz.idActivo
			elif raiz.hijoderecho == None:
				raiz.hijoderecho = activoInsertar
				activoInsertar.raiz = raiz
				s = "Insertado a la derecha de: " + raiz.idActivo
		return s 
	def graphMatriz(self):
		dot = Digraph(comment = 'GraficaLista')
		dot
		#Empresas--------------------------------------------------------------------------------------
		aux10 = self.primeraEmpresa
		if aux10== None:
			return "lista vacia"
		else:
			if aux10 == self.primeraEmpresa == self.ultimaEmpresa:
				dot.node(aux10.contenido.nombreEmpresa)
			else:
				while aux10.siguiente != None:
					dot.node(aux10.contenido.nombreEmpresa)
					dot.node(aux10.siguiente.contenido.nombreEmpresa)
					dot.edge(str(aux10.contenido.nombreEmpresa),str(aux10.siguiente.contenido.nombreEmpresa))
					dot.edge(str(aux10.siguiente.contenido.nombreEmpresa), str(aux10.contenido.nombreEmpresa))
					aux10 = aux10.siguiente
		#Departamentos-----------------------------------------------------------------------------------
		aux10 = self.primerDepartamento
		if aux10== None:
			return "lista vacia"
		else:
			if aux10 == self.primerDepartamento == self.ultimoDepartamento:
				dot.node(aux10.contenido.nombreDepartamento)
			else:
				while aux10.abajo != None:
					dot.node(aux10.contenido.nombreDepartamento)
					dot.node(aux10.abajo.contenido.nombreDepartamento)
					dot.edge(str(aux10.contenido.nombreDepartamento),str(aux10.abajo.contenido.nombreDepartamento))
					dot.edge(str(aux10.abajo.contenido.nombreDepartamento), str(aux10.contenido.nombreDepartamento))
					aux10 = aux10.abajo

		#Usuarios primeros--------------------------------------------------------------------------------
		aux10 = self.primerDepartamento
		if aux10 == None:
			return "lista vacía"
		else:
			while aux10 != None:
				aux11 = aux10.primero
				dot.node(aux10.contenido.nombreDepartamento)
				dot.node(aux11.contenido.nombreUsuario)
				dot.edge(str(aux10.contenido.nombreDepartamento), str(aux11.contenido.nombreUsuario))
				dot.edge(str(aux11.contenido.nombreUsuario), str(aux10.contenido.nombreDepartamento))
				while aux11.siguiente != None:
					if aux11 == aux10.primero:
						dot.node(aux11.contenido.nombreUsuario)
						dot.node(aux11.siguiente.contenido.nombreUsuario)
						dot.edge(str(aux11.contenido.nombreUsuario), str(aux11.siguiente.contenido.nombreUsuario))
						dot.edge(str(aux11.siguiente.contenido.nombreUsuario), str(aux11.contenido.nombreUsuario))
						if aux11 == aux10.ultimo:	
							break
					else:
						dot.node(aux11.contenido.nombreUsuario)
						dot.node(aux11.siguiente.contenido.nombreUsuario)
						dot.edge(str(aux11.contenido.nombreUsuario), str(aux11.siguiente.contenido.nombreUsuario))
						dot.edge(str(aux11.siguiente.contenido.nombreUsuario), str(aux11.contenido.nombreUsuario))
					aux11 = aux11.siguiente
				aux10 = aux10.abajo
		#Usuarios con empresas------------------------------------------------------------------------------------
		aux10 = self.primeraEmpresa
		if aux10 == None:
			return "lista vacía"
		else:
			while aux10 != None:
				aux11 = aux10.primero
				dot.node(aux10.contenido.nombreEmpresa)
				dot.node(aux11.contenido.nombreUsuario)
				dot.edge(str(aux10.contenido.nombreEmpresa), str(aux11.contenido.nombreUsuario))
				dot.edge(str(aux11.contenido.nombreUsuario), str(aux10.contenido.nombreEmpresa))
				while aux11.abajo != None:
					if aux11 == aux10.primero:
						dot.node(aux11.contenido.nombreUsuario)
						dot.node(aux11.abajo.contenido.nombreUsuario)
						dot.edge(str(aux11.contenido.nombreUsuario), str(aux11.abajo.contenido.nombreUsuario))
						dot.edge(str(aux11.abajo.contenido.nombreUsuario), str(aux11.contenido.nombreUsuario))
						if aux11 == aux10.ultimo:	
							break
					else:
						dot.node(aux11.contenido.nombreUsuario)
						dot.node(aux11.abajo.contenido.nombreUsuario)
						dot.edge(str(aux11.contenido.nombreUsuario), str(aux11.abajo.contenido.nombreUsuario))
						dot.edge(str(aux11.abajo.contenido.nombreUsuario), str(aux11.contenido.nombreUsuario))
					aux11 = aux11.abajo
				aux10 = aux10.siguiente

		#Atrás de los usuarios-----------------------------------------------------------------------------------
		aux10 = self.primerDepartamento
		if aux10 == None:
			return "lista vacía"
		else:
			while aux10 != None:
				aux11 = aux10.primero
				while aux11!= None:
					aux12 = aux11
					if aux12.primero != None:
						dot.node(aux12.contenido.nombreUsuario)
						dot.node(aux12.primero.contenido.nombreUsuario)
						dot.edge(str(aux12.contenido.nombreUsuario), str(aux12.primero.contenido.nombreUsuario))
						dot.edge(str(aux12.primero.contenido.nombreUsuario), str(aux12.contenido.nombreUsuario))
						aux13 = aux12.primero
						while aux13.atras != None:
							dot.node(aux13.contenido.nombreUsuario)
							dot.node(aux13.atras.contenido.nombreUsuario)
							dot.edge(str(aux13.contenido.nombreUsuario), str(aux13.atras.contenido.nombreUsuario))
							dot.edge(str(aux13.atras.contenido.nombreUsuario), str(aux13.contenido.nombreUsuario))
							aux13 = aux13.atras
					else:
						break
					aux11 = aux11.siguiente
				aux10 = aux10.abajo

		dot.render('test-output/MatrizDispersa.dot', view=False)
		return "Graficado"
	def recorrerArbol(self, raiz, a):#(Pre-Orden)
		a = "Nodo:\nId: " + raiz.idActivo + "\nNombre: " + raiz.nombreActivo + "\nDescripción: " + raiz.descripcionActivo + "\nEstado: " + raiz.estado + "\n"
		n = Nodo(raiz, None, None, None)
		if self.listaUsuario.primero == None:
			self.listaUsuario.primero = n
			self.listaUsuario.ultimo = n
		else:
			self.listaUsuario.ultimo.siguiente = n
			self.listaUsuario.ultimo = n
		if raiz.hijoizquierdo != None:
			a = a + self.rIzquierda(raiz.hijoizquierdo, a)
		if raiz.hijoderecho != None:
			a = a + self.rDerecha(raiz.hijoderecho, a)
		return a
	def devolverObjetos(self):
		respuesta = "{\n\"activos\":[\n"
		tempArbol = self.listaUsuario.primero
		while tempArbol != None:
			if tempArbol == self.listaUsuario.ultimo:
				respuesta = respuesta + "{\n\"id\":\"" +tempArbol.contenido.idActivo + "\",\n"
				respuesta = respuesta + "\"nombre\":\"" +tempArbol.contenido.nombreActivo + "\",\n"
				respuesta = respuesta + "\"descripcion\":\"" +tempArbol.contenido.descripcionActivo + "\",\n"
				respuesta = respuesta + "\"estado\":\"" +tempArbol.contenido.estado + "\"\n}\n"
			else:
				respuesta = respuesta + "{\n\"id\":\"" +tempArbol.contenido.idActivo + "\",\n"
				respuesta = respuesta + "\"nombre\":\"" +tempArbol.contenido.nombreActivo + "\",\n"
				respuesta = respuesta + "\"descripcion\":\"" +tempArbol.contenido.descripcionActivo + "\",\n"
				respuesta = respuesta + "\"estado\":\"" +tempArbol.contenido.estado + "\"\n},\n"  
			tempArbol = tempArbol.siguiente
		respuesta = respuesta + "]\n}"
		return respuesta
	def devolverObjetosActual(self):
		s = ""
		if self.listaUsuario.primero ==None:
			s = "Vacio"
		else:
			temp = self.listaUsuario.primero
			while temp!= None:
				s = s + "Nodo--- *Id: " + temp.contenido.idActivo + " *Nombre: " + temp.contenido.nombreActivo + " *Descripcion: " + temp.contenido.descripcionActivo + " *Estado: " + temp.contenido.estado + "\n"
				temp =  temp.siguiente
		return s
	def rIzquierda(self, raiz, s):
		s = ""
		s = self.recorrerArbol(raiz, s)
		return s
	def rDerecha(self, raiz, s):
		s = ""
		s = self.recorrerArbol(raiz, s)
		return s
	def vista(self, usuario, password, empresa, departamento):
		s = ""
		encontrado = False
		#Busca la empresa:
		if self.primeraEmpresa == None:
			s = "No hay datos"
		else:
			tempEmpresa = self.primeraEmpresa
			while tempEmpresa != None:
				if str(empresa) == str(tempEmpresa.contenido.nombreEmpresa):
					#Baja por la empresa
					tempDepartamento = tempEmpresa.primero
					while tempDepartamento != None:
						#Regresion para buscar el departamento
						tempRegresion = tempDepartamento
						while tempRegresion != None:
							if tempRegresion.anterior == None:
								if str(tempRegresion.contenido.nombreDepartamento) == str(departamento):
									tempBusquedaUsuario = tempDepartamento
									while tempBusquedaUsuario != None:
										if str(tempBusquedaUsuario.contenido.nombreUsuario) == str(usuario):
											if str(tempBusquedaUsuario.contenido.passwordUsuario) == str(password):
												encontrado = True
												s = ""
												s = s + "\nRecorrer Arbol:---------------------------"
												s = s + "\n" + self.recorrerArbol(tempBusquedaUsuario.raiz, s)
												s = s + "\nDevolver objetos: ------------------------"
												s = s + "\n" + self.devolverObjetosActual()
												s = s + "\nDevolver objetos del actual: -------------"
												s = self.devolverObjetos()
												self.listaUsuario.primero = None
												self.listaUsuario.ultimo = None
										tempBusquedaUsuario = tempBusquedaUsuario.atras
							tempRegresion = tempRegresion.anterior
						tempDepartamento = tempDepartamento.abajo
				tempEmpresa = tempEmpresa.siguiente
		self.listaUsuario.primero = None
		return s
	def addUsuario(self, empresa, departamento, nombre, user, password):
		nuevaEmpresa = Empresa(empresa)
		nuevoDepartamento = Departamento(departamento)
		nuevoUsuario = Usuario(user, password, nombre)

		nodoEmpresa = Nodo(nuevaEmpresa, None, None, None)
		nodoDepartamento = Nodo(nuevoDepartamento, None, None, None)
		nodoUsuario = Nodo(nuevoUsuario, None, None, None)
		s = ""
		#Cuando la matriz está vacía-------------------
		if self.vacia() == True:
			
			self.primeraEmpresa = self.ultimaEmpresa = nodoEmpresa
			self.primerDepartamento = self.ultimoDepartamento = nodoDepartamento

			self.primeraEmpresa.abajo = self.ultimaEmpresa.abajo = self.primeraEmpresa.primero = self.ultimaEmpresa.primero = self.primeraEmpresa.ultimo = self.ultimaEmpresa.ultimo = nodoUsuario
			self.primerDepartamento.siguiente = self.ultimoDepartamento.siguiente = self.primerDepartamento.primero = self.primerDepartamento.ultimo = self.ultimoDepartamento.primero = self.ultimoDepartamento.ultimo = nodoUsuario
			nodoUsuario.anterior = self.primerDepartamento = self.ultimoDepartamento
			nodoUsuario.arriba = self.primeraEmpresa = self.ultimaEmpresa

		else:
			#Empresa-------------------------
			temp = self.primeraEmpresa
			encontrado = False
			while temp != None:
				if str(temp.contenido.nombreEmpresa) == str(nodoEmpresa.contenido.nombreEmpresa):
					encontrado = True
					break
				temp = temp.siguiente

			if encontrado == True:
				s = s
			else:
				self.ultimaEmpresa.siguiente = nodoEmpresa
				nodoEmpresa.anterior = self.ultimaEmpresa
				self.ultimaEmpresa = nodoEmpresa

			#Departamento-------------------
			temp = self.primerDepartamento
			encontrado = False

			while temp != None:
				if str(temp.contenido.nombreDepartamento) == str(nodoDepartamento.contenido.nombreDepartamento):
					encontrado = True
				temp = temp.abajo

			if encontrado == True:
				s = s
			else:
				self.ultimoDepartamento.abajo = nodoDepartamento
				nodoDepartamento.arriba = self.ultimoDepartamento
				self.ultimoDepartamento = nodoDepartamento
			#Nodo---------------------------
			ingresado = False
			temp = self.primeraEmpresa
			while temp != None:
				if str(nodoEmpresa.contenido.nombreEmpresa) == str(temp.contenido.nombreEmpresa):
					if temp.primero == None:
						temp.abajo = temp.primero = temp.ultimo = nodoUsuario
						nodoUsuario.arriba = temp
						temp2 = self.primerDepartamento
						while temp2 != None:
							if str(temp2.contenido.nombreDepartamento) == str(nodoDepartamento.contenido.nombreDepartamento):
								if temp2.primero == None:
									temp2.primero = temp2.ultimo = temp2.siguiente = nodoUsuario
									nodoUsuario.anterior = temp2
									ingresado = True
									break
								else:
									temp2.ultimo.siguiente = nodoUsuario
									nodoUsuario.anterior = temp2.ultimo
									temp2.ultimo = nodoUsuario
									ingresado = True
							temp2 = temp2.abajo
					else:

						#Verificar si hay registro del departamento en la empresa actual 
						temp2 = temp.primero
						ingresado = False
						while temp2 != None:
							temp3 = temp2
							encontrado = False
							while temp3 != None:
								if temp3.anterior == None:
									if str(temp3.contenido.nombreDepartamento) == str(nodoDepartamento.contenido.nombreDepartamento):
										encontrado = True
										break 
								temp3 = temp3.anterior

							if encontrado == True:
								if temp2.primero == None:
									temp2.primero = nodoUsuario
									temp2.ultimo = nodoUsuario
									temp2.atras = nodoUsuario
									nodoUsuario.adelante = temp2
									ingresado = True
									break
								else:
									temp2.ultimo.atras = nodoUsuario
									nodoUsuario.adelante  = temp2.ultimo
									temp2.ultimo = nodoUsuario
									ingresado = True
									break
							temp2 = temp2.abajo
							#Termino de verificar si hay registro y si lo hay lo ingresa atras del que ya esta
							#ingresado = False

						#Departamento vacio
						if ingresado == False:
							temp1 = self.primerDepartamento
							while temp1 != None:
								if str(temp1.contenido.nombreDepartamento) == str(nodoDepartamento.contenido.nombreDepartamento):
									if temp1.primero == None:
										temp1.primero = temp1.ultimo = temp1.siguiente = temp.ultimo.abajo = nodoUsuario
										nodoUsuario.anterior = temp1
										nodoUsuario.arriba = temp.ultimo
										temp.ultimo = nodoUsuario
										ingresado = True
										break
								temp1 = temp1.abajo


						#Busqueda del departamento
						if ingresado == False:
							temp1 = temp.ultimo
							enc = False
							while temp1 != None:
								if temp1.anterior == None:
									temp2 = temp1
									while temp2 != None:
										if str(temp2.contenido.nombreDepartamento)== str(nodoDepartamento.contenido.nombreDepartamento):
											enc = True
											#Se encontró abajo 
											#Buscar anterior
											tempAnteriorEmpresa = temp.anterior
											v = False
											while tempAnteriorEmpresa != None:
												tempAbajo = tempAnteriorEmpresa.primero
												while tempAbajo != None:
													tempAnteriorBuscar = tempAbajo
													while tempAnteriorBuscar != None:
														if tempAnteriorBuscar.anterior == None:
															if str(tempAnteriorBuscar.contenido.nombreDepartamento) == str(nodoDepartamento.contenido.nombreDepartamento):
																if tempAbajo.siguiente != None:
																	nodoUsuario.siguiente = tempAbajo.siguiente
																	tempAbajo.siguiente.anterior = nodoUsuario
																	tempAbajo.siguiente = nodoUsuario
																	nodoUsuario.anterior = tempAbajo
																	temp.ultimo.abajo = nodoUsuario
																	nodoUsuario.arriba = temp.ultimo
																	temp.ultimo = nodoUsuario
																	v = True
																	ingresado = True
																	break
																else:
																	tempAnteriorBuscar.ultimo.siguiente = nodoUsuario
																	nodoUsuario.anterior = tempAnteriorBuscar.ultimo
																	tempAnteriorBuscar.ultimo = nodoUsuario
																	tempAbajo.siguiente = nodoUsuario
																	nodoUsuario.anterior = tempAbajo
																	temp.ultimo.abajo = nodoUsuario
																	nodoUsuario.arriba = temp.ultimo
																	temp.ultimo = nodoUsuario
																	v = True
																	ingresado = True
																	break
														tempAnteriorBuscar = tempAnteriorBuscar.anterior
													if v == True:
														break
													tempAbajo = tempAbajo.abajo
												if v == True:
													break
												tempAnteriorEmpresa = tempAnteriorEmpresa.anterior


											if v == False:
												nodoUsuario.siguiente = temp2.siguiente
												temp2.siguiente.anterior = nodoUsuario
												temp2.primero = nodoUsuario
												nodoUsuario.anterior = temp2
												temp.ultimo.abajo = nodoUsuario
												nodoUsuario.arriba = temp.ultimo
												temp.ultimo = nodoUsuario
												ingresado = True
										temp2 = temp2.abajo 
										##Esto era si el departemento estaba abajo del ultimo elemento de la empresa, ahora a ver si esta antes del ultimo elemento de la empre
								temp1 = temp1.anterior
						
						if ingresado == False:
							#Solo existe el temp que es el que recorre la empresa
							temp1 = temp.ultimo
							if temp1 == temp.primero:
								nodoUsuario.abajo = temp1
								nodoUsuario.arriba = temp1.arriba
								temp1.arriba.abajo = nodoUsuario
								temp1.arriba = nodoUsuario
								temp.primero = nodoUsuario
								#Posiciona el nodo pero solo arriba y abajo
								if temp == self.ultimaEmpresa:
									temp2 = self.primerDepartamento
									while temp2 != None:
										if str(temp2.contenido.nombreDepartamento) == str(nodoDepartamento.contenido.nombreDepartamento):
											temp2.ultimo.siguiente = nodoUsuario
											nodoUsuario.anterior = temp2.ultimo
											temp2.ultimo = nodoUsuario
											nodoUsuario.siguiente = None
											ingresado = True
											break
										temp2 = temp2.abajo
								else:######################
									encontradoSiguiente = False
									tempSiguiente = temp.siguiente
									while tempSiguiente != None:
										if encontradoSiguiente == False:
											tempAbajo = tempSiguiente.primero
											while tempAbajo != None:
												if encontrado == False:
													tempAnterior = tempAbajo
													while tempAnterior != None:
														if tempAnterior.anterior == None:
															if str(tempAnterior.contenido.nombreDepartamento) == str(nodoDepartamento.contenido.nombreDepartamento):
																nodoUsuario.siguiente = tempAbajo
																tempAbajo.anterior= nodoUsuario
																encontradoSiguiente = True
																break
														tempAnterior = tempAnterior.anterior
												else:
													break
												tempAbajo = tempAbajo.abajo
										else:
											break
										tempSiguiente = tempSiguiente.siguiente 

										if encontradoSiguiente == False:
											s = s

									encontradoAnterior = False
									tempAntes = temp.anterior
									while tempAntes != None:
										if encontradoAnterior == False:
											tempAbajo = tempAntes.primero
											while tempAbajo != None:
												if encontrado == False:
													tempAnterior = tempAbajo
													while tempAnterior != None:
														if tempAnterior.anterior == None:
															if str(tempAnterior.contenido.nombreDepartamento) == str(nodoDepartamento.contenido.nombreDepartamento):
																nodoUsuario.anterior = tempAbajo
																tempAbajo.siguiente = nodoUsuario
																encontradoSiguiente = True
																break
														tempAnterior = tempAnterior.anterior
												else:
													break
												tempAbajo = tempAbajo.abajo
										else:
											break
										tempAntes = tempAntes.anterior
									ingresado = True		################################


						if ingresado == False:
							estaArriba = False
							temp1 = temp.ultimo
							while (temp1!= None) & (temp1 != temp):
								temp2 = temp1
								while temp2 != None:
									estaArriba = False
									if temp2.anterior == None:
										temp3 = temp2 
										while temp3 != None:
											if str(temp3.contenido.nombreDepartamento) == str(nodoDepartamento.contenido.nombreDepartamento):
												estaArriba = True
												break
											temp3 = temp3.arriba
									temp2 = temp2.anterior
								if estaArriba == False:
									nodoUsuario.arriba = temp1
									nodoUsuario.abajo = temp1.abajo
									temp1.abajo.arriba = nodoUsuario
									temp1.abajo = nodoUsuario

									if temp == self.ultimaEmpresa:
										temp2 = self.primerDepartamento
										while temp2 != None:
											if str(temp2.contenido.nombreDepartamento) == str(nodoDepartamento.contenido.nombreDepartamento):
												temp2.ultimo.siguiente = nodoUsuario
												nodoUsuario.anterior = temp2.ultimo
												temp2.ultimo = nodoUsuario
												nodoUsuario.siguiente = None
												ingresado = True
												break
											temp2 = temp2.abajo
									elif temp == self.primeraEmpresa:
										temp2 = self.primerDepartamento
										while temp2 != None:
											if str(temp2.contenido.nombreDepartamento) == str(nodoDepartamento.contenido.nombreDepartamento):
												nodoUsuario.anterior = temp2
												nodoUsuario.siguiente = temp2.siguiente
												temp2.siguiente.anterior = nodoUsuario
												temp2.siguiente = nodoUsuario
												temp2.primero = nodoUsuario
												ingresado = True
												break
											temp2 = temp2.abajo			
									else:					
										#Encontrar el anterior y siguiente
										encontradoSiguiente = False
										tempSiguiente = temp.siguiente
										while tempSiguiente != None:
											if encontradoSiguiente == False:
												tempAbajo = tempSiguiente.primero
												while tempAbajo != None:
													if encontrado == False:
														tempAnterior = tempAbajo
														while tempAnterior != None:
															if tempAnterior.anterior == None:
																if str(tempAnterior.contenido.nombreDepartamento) == str(nodoDepartamento.contenido.nombreDepartamento):
																	nodoUsuario.siguiente = tempAbajo
																	tempAbajo.anterior= nodoUsuario
																	encontradoSiguiente = True
																	break
															tempAnterior = tempAnterior.anterior
													else:
														break
													tempAbajo = tempAbajo.abajo
											else:
												break
											tempSiguiente = tempSiguiente.siguiente 

											if encontradoSiguiente == False:
												s = s

										encontradoAnterior = False
										tempAntes = temp.anterior
										while tempAntes != None:
											if encontradoAnterior == False:
												tempAbajo = tempAntes.primero
												while tempAbajo != None:
													if encontrado == False:
														tempAnterior = tempAbajo
														while tempAnterior != None:
															if tempAnterior.anterior == None:
																if str(tempAnterior.contenido.nombreDepartamento) == str(nodoDepartamento.contenido.nombreDepartamento):
																	nodoUsuario.anterior = tempAbajo
																	tempAbajo.siguiente = nodoUsuario
																	encontradoSiguiente = True
																	break
															tempAnterior = tempAnterior.anterior
													else:
														break
													tempAbajo = tempAbajo.abajo
											else:
												break
											tempAntes = tempAntes.anterior						
								temp1 = temp1.arriba
					#Aqui va en la empresa actual o sea la empresa en la que este el usuario del que estemos consultando 
					break
				temp = temp.siguiente
		respuesta = self.recorrerMatriz()
		return "Ok"+"\n"+ respuesta
	def recorrerMatriz(self):
		s = ""
		temp = self.primeraEmpresa
		while temp != None:
			s = s + "Empresa: " + str(temp.contenido.nombreEmpresa) + "\n"
			temp2 = temp.primero
			while temp2 != None:
				temp3 = temp2
				while temp3 != None:
					if temp3.anterior == None:
						s = s + "Departamento: "  + str(temp3.contenido.nombreDepartamento) + " *Usuario: " + str(temp2.contenido.nombreUsuario) + " *Password: " + str(temp2.contenido.passwordUsuario) + " *Nombre: " + str(temp2.contenido.nombreCompleto) + "\n"
						temp4 = temp2.primero
						while temp4 != None:
							s = s + "Departamento: "  + str(temp3.contenido.nombreDepartamento) + " *Usuario: " + str(temp4.contenido.nombreUsuario) + " *Password: " + str(temp4.contenido.passwordUsuario) + " *Nombre: " + str(temp4.contenido.nombreCompleto) + "\n"
							temp4 = temp4.atras
					temp3 = temp3.anterior
				temp2 = temp2.abajo
			temp = temp.siguiente
		s = s + "\n************************************************************************************************" 
		return s
	def Login(self, usuario, password, empresa, departamento):
		s = ""
		encontrado = False
		#Busca la empresa:
		if self.primeraEmpresa == None:
			s = "No hay datos"
		else:
			tempEmpresa = self.primeraEmpresa
			while tempEmpresa != None:
				if str(empresa) == str(tempEmpresa.contenido.nombreEmpresa):
					#Baja por la empresa
					tempDepartamento = tempEmpresa.primero
					while tempDepartamento != None:
						#Regresion para buscar el departamento
						tempRegresion = tempDepartamento
						while tempRegresion != None:
							if tempRegresion.anterior == None:
								if str(tempRegresion.contenido.nombreDepartamento) == str(departamento):
									tempBusquedaUsuario = tempDepartamento
									while tempBusquedaUsuario != None:
										if str(tempBusquedaUsuario.contenido.nombreUsuario) == str(usuario):
											if str(tempBusquedaUsuario.contenido.passwordUsuario) == str(password):
												encontrado = True
										tempBusquedaUsuario = tempBusquedaUsuario.atras
							tempRegresion = tempRegresion.anterior
						tempDepartamento = tempDepartamento.abajo
				tempEmpresa = tempEmpresa.siguiente

			if encontrado == True:
				s = "Ok"
			else:
				s = "No"
		return s
	def devolverCatalogo(self):
		respuesta = ""
		s = ""
		temp = self.primeraEmpresa
		#Temp para la empresa
		while temp != None:
			temp2 = temp.primero
			#Temp2 para abajo
			while temp2 != None:
				temp3 = temp2
				while temp3 != None:
					if temp3.anterior == None:
						#Temp3 para el departamento
						temp4 = temp2
						while temp4 != None:
							s = self.recCatalogo(temp4.raiz, temp.contenido.nombreEmpresa, temp3.contenido.nombreDepartamento, temp4.contenido.nombreUsuario)
							temp4 = temp4.atras
					temp3 = temp3.anterior
				temp2 = temp2.abajo
			temp = temp.siguiente 

		if self.catalogo.primero != None:
			temp = self.catalogo.primero
			respuesta = "{\n\"catalogo\":["
			while temp != None:
				if temp == self.catalogo.ultimo:
					respuesta = respuesta + "\n{\n\"id\":\"" +temp.activo.idActivo + "\",\n"
					respuesta = respuesta + "\"nombre\":\"" +temp.activo.nombreActivo + "\",\n"
					respuesta = respuesta + "\"descripcion\":\"" +temp.activo.descripcionActivo + "\",\n"
					respuesta = respuesta + "\"estado\":\"" +temp.activo.estado + "\",\n"
					respuesta = respuesta + "\"usuario\":\"" +temp.usuario + "\",\n"
					respuesta = respuesta + "\"empresa\":\"" +temp.empresa + "\",\n"
					respuesta = respuesta + "\"departamento\":\"" +temp.departamento + "\"\n}"
				else:
					respuesta = respuesta + "\n{\n\"id\":\"" +temp.activo.idActivo + "\",\n"
					respuesta = respuesta + "\"nombre\":\"" +temp.activo.nombreActivo + "\",\n"
					respuesta = respuesta + "\"descripcion\":\"" +temp.activo.descripcionActivo + "\",\n"
					respuesta = respuesta + "\"estado\":\"" +temp.activo.estado + "\",\n"
					respuesta = respuesta + "\"usuario\":\"" +temp.usuario + "\",\n"
					respuesta = respuesta + "\"empresa\":\"" +temp.empresa + "\",\n"
					respuesta = respuesta + "\"departamento\":\"" +temp.departamento + "\"\n},"
				temp = temp.siguiente
			respuesta = respuesta + "\n]\n}"
			self.catalogo.primero = None
			self.catalogo.ultimo = None
		return respuesta
	def rIzquierdaCatalogo(self, raiz, empresa, departamento, usuario):
		s = ""
		s = self.recCatalogo(raiz, empresa, departamento, usuario)
		return s
	def rDerechaCatalogo(self, raiz, empresa, departamento, usuario):
		s = ""
		s = self.recCatalogo(raiz, empresa, departamento, usuario)
		return s
	def recCatalogo(self, raiz, empresa, departamento, usuario):
		a = ""
		nodo = ActivoCatalogo(raiz, empresa, departamento, usuario, None, None)
		if self.catalogo.primero == None:
			self.catalogo.primero = nodo
			self.catalogo.ultimo = nodo
		else:
			self.catalogo.ultimo.siguiente = nodo
			self.catalogo.ultimo = nodo
		if raiz.hijoizquierdo != None:
			a = a + self.rIzquierdaCatalogo(raiz.hijoizquierdo, empresa, departamento, usuario)
		if raiz.hijoderecho != None:
			a = a + self.rDerechaCatalogo(raiz.hijoderecho, empresa, departamento, usuario)
		return a
	def renta(self, idRenta, usuario, empresa, departamento, tiempo):
		s = ""
		ok = False
		temp = self.primeraEmpresa
		while temp != None:
			temp1 = temp.primero
			while temp1 != None:
				temp2 = temp1
				while temp2 != None:
					s = self.recRentas(temp2.raiz, idRenta)
					ok = True
					temp2 = temp2.atras
				temp1 = temp1.abajo
			temp = temp.siguiente

		if ok == True:
			tempTr = Transaccion(idRenta, usuario, departamento, empresa, tiempo, None, None)
			if self.transacciones.primero == None:
				self.transacciones.primero = tempTr
				self.transacciones.ultimo = tempTr
			else:
				self.transacciones.ultimo.siguiente = tempTr
				tempTr.anterior = self.transacciones.ultimo
				self.transacciones.ultimo = tempTr
		else:
			s = "No encontrado"
		return s
	def devolverRentas(self):
		s = ""
		if self.transacciones.primero == None:
			s = "Vacío"
		else:
			s = "{\n\"rentas\"\n:["
			temp = self.transacciones.primero
			while temp != None:
				if temp == self.transacciones.ultimo:
					s = s + "\n{\n\"id\":\"" + temp.idA + "\",\n"
					s = s + "\"usuario\":\"" + temp.usuario + "\",\n"
					s = s + "\"departamento\":\"" + temp.departamento + "\",\n"
					s = s + "\"empresa\":\"" + temp.empresa + "\",\n"
					s = s + "\"tiempo\":\"" + temp.tiempo + "\"\n}\n" 
				else:
					s = s + "\n{\n\"id\":\"" + temp.idA + "\",\n"
					s = s + "\"usuario\":\"" + temp.usuario + "\",\n"
					s = s + "\"departamento\":\"" + temp.departamento + "\",\n"
					s = s + "\"empresa\":\"" + temp.empresa + "\",\n"
					s = s + "\"tiempo\":\"" + temp.tiempo + "\"\n}," 
				temp = temp.siguiente
		s = s + "]\n}"
		return s
	def recRentas(self, raiz, idAc):
		a = ""
		if str(raiz.idActivo) == str(idAc):
			raiz.estado = "N"
		else:
			if raiz.hijoizquierdo != None:
				a = self.rIz(raiz.hijoizquierdo, idAc)
			if raiz.hijoderecho != None:
				a = self.rDe(raiz.hijoderecho, idAc)
		return a
	def rIz(self, raiz, idAc):
		a = ""
		a = self.recRentas(raiz, idAc)
		return a
	def rDe(self, raiz, idAc):
		a = ""
		a = self.recRentas(raiz, idAc)
		return a
	def devolucion(self, idAc):
		s = ""
		ok = False
		temp = self.primeraEmpresa
		while temp != None:
			temp1 = temp.primero
			while temp1 != None:
				temp2 = temp1
				while temp2 != None:
					s = self.recDev(temp2.raiz, idAc)
					ok = True
					temp2 = temp2.atras
				temp1 = temp1.abajo
			temp = temp.siguiente
		if ok == False:
			s = "No encontrado"
		else:
			temp = self.transacciones.primero
			while temp != None:
				if str(temp.idA) == str(idAc):
					if temp == self.transacciones.primero:
						t1 = temp.siguiente
						self.transacciones.primero = None
						self.transacciones.primero = t1
					elif temp == self.transacciones.ultimo:
						t1 = self.transacciones.ultimo.anterior
						self.transacciones.ultimo = None
						self.transacciones.ultimo = t1
					else:
						temp.siguiente.anterior = temp.anterior
						temp.anterior.siguiente = temp.siguiente
				temp = temp.siguiente
		return s
	def recDev(self, raiz, idAc):
		a = ""
		if str(raiz.idActivo) == str(idAc):
			raiz.estado = "D"
		else:
			if raiz.hijoizquierdo != None:
				a = self.recDev(raiz.hijoizquierdo, idAc)
			if raiz.hijoderecho != None:
				a = self.recDev(raiz.hijoderecho, idAc)
		return a
	def devI(self, raiz, ida):
		a = ""
		a = self.devolucion(raiz, ida)
		return a
	def devD(self, id):
		a = ""
		a = self.devolucion(raiz, ida)
		return a
	def randomM(self):
		import random
		letras = []
		for x in range(65,91):
			letras.append(chr(x))
		for x in range(97,123):
			letras.append(chr(x))
		for x in range(48,58):
			letras.append(chr(x))
		idRandom = "" 
		for x in range(15):
			idRandom = idRandom + random.choice(letras)
		return idRandom



m = Matriz()

#Metodos---------------------------------------------
@app.route('/addActivo',methods=['POST']) 
def addActivo():
	empresaTemp= str(request.form['empresa'])
	departamentoTemp = str(request.form['departamento'])
	userTemp = str(request.form['user'])
	passTemp = str(request.form['password'])
	nombreActivoTemp = str(request.form['nombreActivo'])
	descripcionActivoTemp = str(request.form['descripcionActivo'])
	return m.addNodoArbol(userTemp, passTemp, departamentoTemp, empresaTemp, nombreActivoTemp, descripcionActivoTemp)

@app.route('/random', methods=['POST'])
def random():
	s = ""
	s = m.randomM()
	return s

@app.route('/addMatrizDispersa',methods=['POST']) 
def addMatrizDispersa():
	empresaTemp= str(request.form['empresa'])
	departamentoTemp = str(request.form['departamento'])
	nombreTemp = str(request.form['nombre'])
	userTemp = str(request.form['user'])
	passTemp = str(request.form['password'])
	return m.verificarUsuario(empresaTemp, departamentoTemp, nombreTemp, userTemp, passTemp)

@app.route('/Login',methods=['POST']) 
def Login():
	empresaTemp= str(request.form['empresa'])
	departamentoTemp = str(request.form['departamento'])
	userTemp = str(request.form['user'])
	passTemp = str(request.form['password'])
	return m.Login(userTemp, passTemp, empresaTemp, departamentoTemp)

@app.route('/renta',methods=['POST']) 
def Renta():
	empresaTemp= str(request.form['empresa'])
	departamentoTemp = str(request.form['departamento'])
	userTemp = str(request.form['user'])
	idTemp = str(request.form['id'])
	tiempoTemp = str(request.form['tiempo'])
	s = ""
	s = m.renta(idTemp, userTemp, empresaTemp, departamentoTemp, tiempoTemp)
	s = s + m.devolverRentas()
	return s

@app.route('/graficarMatriz', methods=['POST'])
def graficarMatriz():
	v = m.graphMatriz()
	return v

@app.route('/vista', methods=['POST'])
def vista():
	empresaTemp= str(request.form['empresa'])
	departamentoTemp = str(request.form['departamento'])
	userTemp = str(request.form['user'])
	passTemp = str(request.form['password'])
	return m.vista(userTemp, passTemp, empresaTemp, departamentoTemp)

@app.route('/catalogo', methods=['POST'])
def catalogo():
	s = ""
	s = m.devolverCatalogo()
	return s

@app.route('/devolucion', methods=['POST'])
def devolucion():
	s = ""
	idTemp= str(request.form['id'])
	s = m.devolucion(idTemp)
	return s
	
if __name__ == "__main__":
  app.run(debug=True, host='localhost')