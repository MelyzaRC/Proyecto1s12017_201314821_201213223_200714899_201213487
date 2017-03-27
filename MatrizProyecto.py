# coding=utf-8
#Autor-------------------------------------------------
__author__ = "Melyza Rodriguez - Grupo 4"

#Imports-----------------------------------------------
from flask import Flask, request, Response
app = Flask("Proyecto 1 Estructura de Datos")
import subprocess
from graphviz import Digraph

#Notas------------------------------------------------
#Los metodos retornan valores "Ok" para decir que si realizó la acción y "No" para decir que no la realizó
#El id del activo se genera automaticamente y es correlativo
#Para devolver los activos pertenecientes a determinado usuario los devuelve en objetos json

#Constructores de objetos------------------------------
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

#Matriz Dispersa--------------------------------------
class Matriz:
	def __init__(self):
		self.primerDepartamento = None
		self.ultimoDepartamento = None
		self.primeraEmpresa = None
		self.ultimaEmpresa = None
		self.contadorId = 1000000

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

	def addActivo(self, user, password, departamento, empresa, nombrea, descripcion):
		idActivo = self.asignarId()
		activoActual = Activo(idActivo, nombrea, descripcion, "D")#D para disponible N para no disponible 
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
													if temp3.raiz == None:
														temp3.raiz = activoActual
														temp3.raiz.raiz = activoActual
														s = self.verArbol(temp3.raiz)
														encontrado = True
													else:
														s = self.ubicarNodoArbol(temp3.raiz, activoActual)
														s = self.verArbol(temp3.raiz)
														encontrado = True
											temp3 = temp3.atras
										break
								temp2 = temp2.anterior
						else:
							break
						temp1 = temp1.abajo
					else:
						break
			temp = temp.siguiente
		if encontrado == True:
			respuesta = "Ok" + "\n" + s
			encontrado = False
		else:
			respuesta = "No"
			if self.contadorId > 1000000:
				self.contadorId = self.contadorId - 1
			else:
				self.contadorId = self.contadorId
		return respuesta

	def verArbol(self, raiz):
		a = ""
		temp = raiz
		a = "Raiz: Id-->" + str(temp.idActivo) + " Descripcion: " + str(temp.descripcionActivo) + "\n*****     Subarboles     *****\n"
		while temp != None:
			if temp.hijoizquierdo == None:
				break
			else:
				a = a + "\nPadre: " + str(temp.nombreActivo) + " Id: " + str(temp.idActivo) + " Descripción: " +  str(temp.descripcionActivo)
				if temp.hijoizquierdo != None:
					a = a + "\nHijo izquierdo: " + str(temp.hijoizquierdo.nombreActivo) + " Id: " + str(temp.hijoizquierdo.idActivo) + " Descripción: " +  str(temp.hijoizquierdo.descripcionActivo)
				if temp.hijoderecho != None:
					a = a + "\nHijo derecho: " + str(temp.hijoderecho.nombreActivo) + " Id: " + str(temp.hijoderecho.idActivo) + " Descripcion: " + str(temp.hijoderecho.descripcionActivo)
			temp = temp.hijoizquierdo
		return a

	def ubicarNodoArbol(self, raiz, activo):
		a = ""
		if raiz.hijoizquierdo == None:
			raiz.hijoizquierdo = activo
			a = "Agregado un nodo a la izquierda"
		elif raiz.hijoderecho == None:
			raiz.hijoderecho = activo
			a = "Agregado un nodo a la derecha"
		else:
			a = self.ubicarNodoArbol(raiz.hijoizquierdo, activo)
		return a
	
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
		##Aqui recorrer:
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

	def asignarId(self):
		idGenerado = ""
		idGenerado = "eddactivo"+ str(self.contadorId)
		self.contadorId = self.contadorId + 1
		return idGenerado

	def modificarActivo(self, user, password, departamento, empresa, idbuscar, descripcionNueva):
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
													tempArbol = temp3.raiz
													while tempArbol != None:
														if str(tempArbol.idActivo) == str(idbuscar):
															tempArbol.descripcionActivo = str(descripcionNueva)
															encontrado = True
															s = self.verArbol(temp3.raiz)
															break
														elif tempArbol.hijoizquierdo != None:
															if str(tempArbol.hijoizquierdo.idActivo) == str(idbuscar):
																tempArbol.hijoizquierdo.descripcionActivo = str(descripcionNueva)
																encontrado = True
																s = self.verArbol(temp3.raiz)
																break
														elif tempArbol.hijoderecho != None:
															if str(tempArbol.hijoderecho.idActivo) == str(idbuscar):
																tempArbol.hijoderecho.descripcionActivo = str(descripcionNueva)
																encontrado = True
																s = self.verArbol(temp3.raiz)
																break
														tempArbol = tempArbol.hijoizquierdo
											temp3 = temp3.atras
										break
								temp2 = temp2.anterior
						else:
							break
						temp1 = temp1.abajo
					else:
						break
			temp = temp.siguiente
		if encontrado == True:
			respuesta = "Ok"
		else:
			respuesta = "No"
		return respuesta + "\n" + s

	def devolverElementos(self, user, password, departamento, empresa):
		temp = self.primeraEmpresa
		encontrado = False
		respuesta = "{\n\"Activos\":[\n"
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
													tempArbol = temp3.raiz
													while tempArbol != None:
														if tempArbol.hijoizquierdo != None:
															respuesta = respuesta + "{\n\"id\":\"" +tempArbol.idActivo + "\",\n"
															respuesta = respuesta + "\"nombre\":\"" +tempArbol.nombreActivo + "\",\n"
															respuesta = respuesta + "\"descripcion\":\"" +tempArbol.descripcionActivo + "\",\n"
															respuesta = respuesta + "\"estado\":\"" +tempArbol.estado + "\"\n},\n" 
															if tempArbol.hijoderecho != None:
																respuesta = respuesta + "{\n\"id\":\"" +tempArbol.hijoderecho.idActivo + "\",\n"
																respuesta = respuesta + "\"nombre\":\"" +tempArbol.hijoderecho.nombreActivo + "\",\n"
																respuesta = respuesta + "\"descripcion\":\"" +tempArbol.hijoderecho.descripcionActivo + "\",\n"
																respuesta = respuesta + "\"estado\":\"" +tempArbol.hijoderecho.estado + "\"\n},\n" 
														else:
															respuesta = respuesta + "{\n\"id\":\"" +tempArbol.idActivo + "\",\n"
															respuesta = respuesta + "\"nombre\":\"" +tempArbol.nombreActivo + "\",\n"
															respuesta = respuesta + "\"descripcion\":\"" +tempArbol.descripcionActivo + "\",\n"
															respuesta = respuesta + "\"estado\":\"" +tempArbol.estado + "\"\n}\n" 
														tempArbol = tempArbol.hijoizquierdo
													encontrado = True
											temp3 = temp3.atras
										break
								temp2 = temp2.anterior
						else:
							break
						temp1 = temp1.abajo
					else:
						break
			temp = temp.siguiente
		
		return respuesta + "]\n}"

	def graficarMatriz(self):
		dot = Digraph(comment = 'GraficaMatrizDispersa')
		dot
		#Primero crear empresas con sus primeros 
		temp = self.primeraEmpresa
		while temp != None:
			temp1 = temp.primero
			while temp1.Primero != None:
				if temp1 == temp.primero:
					dot.node(temp.contenido.nombreEmpresa)
					dot.node(temp1.nombreUsuario)
					dot.edge(str(temp.contenido.nombreEmpresa),str(temp.primero.nombreUsuario))
					dot.render('test-output/ListaSimple.dot', view=False)
				temp1 = temp1.abajo
			temp = temp.siguiente
		return "Graficado"

m = Matriz()

#Metodos---------------------------------------------

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
	return m.Login(userTemp, passTemp, empresaTemp, departamentoTemp, )

@app.route('/addActivo',methods=['POST']) 
def addActivo():
	empresaTemp= str(request.form['empresa'])
	departamentoTemp = str(request.form['departamento'])
	userTemp = str(request.form['user'])
	passTemp = str(request.form['password'])
	nombreActivoTemp = str(request.form['nombreActivo'])
	descripcionActivoTemp = str(request.form['descripcionActivo'])
	return m.addActivo(userTemp, passTemp, departamentoTemp, empresaTemp, nombreActivoTemp, descripcionActivoTemp)

@app.route('/modificarActivo',methods=['POST']) 
def modificarActivo():
	empresaTemp= str(request.form['empresa'])
	departamentoTemp = str(request.form['departamento'])
	userTemp = str(request.form['user'])
	passTemp = str(request.form['password'])
	idTemp = str(request.form['idActivo'])
	descripcionActivoTemp = str(request.form['descripcionNueva'])
	return m.modificarActivo(userTemp, passTemp, departamentoTemp, empresaTemp, idTemp, descripcionActivoTemp)

@app.route('/devolverElementos',methods=['POST']) 
def devolverElementos():
	empresaTemp= str(request.form['empresa'])
	departamentoTemp = str(request.form['departamento'])
	userTemp = str(request.form['user'])
	passTemp = str(request.form['password'])
	s = m.devolverElementos(userTemp, passTemp, departamentoTemp, empresaTemp)
	return s 

@app.route('/verMatriz', methods=['POST'])
def verMatriz():
	return m.graficarMatriz()

if __name__ == "__main__":
  app.run(debug=True, host='localhost')