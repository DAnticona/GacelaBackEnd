package com.wollcorp.controladores;

import java.util.ArrayList;
import java.util.List;

import com.wollcorp.beans.Login;
import com.wollcorp.beans.Usuario;
import com.wollcorp.dao.LoginDaoImpl;
import com.wollcorp.dao.UsuarioDaoImpl;
import com.wollcorp.globales.Globales;
import com.wollcorp.globales.Log;

public class LoginControlador {
	
	public LoginControlador() {
		
		Globales.variablesGlobales.put("log", new Log());
		
	}
	
	public boolean validarLogin(Login login) {
		
		LoginDaoImpl loginDao = new LoginDaoImpl();
		
		((Log)Globales.variablesGlobales.get("log")).setMensaje("INTENTO DE LOGIN - USUARIO: " + login.getUsuario());
		((Log)Globales.variablesGlobales.get("log")).registraInfo();
		
		if(loginDao.login(login)) {
			
			((Log)Globales.variablesGlobales.get("log")).setMensaje("LOGIN VALIDO - USUARIO: " + login.getUsuario());
			((Log)Globales.variablesGlobales.get("log")).registraInfo();
			
			//Registra el conector en las variables Globales del Sistema
			Globales.variablesGlobales.put("conector", loginDao.getConector());
			
			return true;
					
		} else {
			
			return false;
			
		}
	}
	
	public boolean obtenerUsuario(Login login) {
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		//Devuelve datos del usuario
		UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();
		
		((Log)Globales.variablesGlobales.get("log")).setMensaje("CONSULTANDO DATOS DEL USUARIO: " + login.getUsuario());
		((Log)Globales.variablesGlobales.get("log")).registraInfo();
		
		usuarios = usuarioDao.obtenerUsuarios(login.getUsuario());
		
		if(usuarios.size() == 0) {
			
			((Log)Globales.variablesGlobales.get("log")).setMensaje("NINGUN USUARIO ENCONTRADO EN BASE DE DATOS: " + login.getUsuario());
			((Log)Globales.variablesGlobales.get("log")).setException(null);
			((Log)Globales.variablesGlobales.get("log")).setCodigo(-100);
			((Log)Globales.variablesGlobales.get("log")).setEstado(null);
			((Log)Globales.variablesGlobales.get("log")).setNombreClase(this.getClass().getName());
			((Log)Globales.variablesGlobales.get("log")).registraError();
			
			return false;
			
		} else if(usuarios.size() == 1){
			
			((Log)Globales.variablesGlobales.get("log")).setMensaje("USUARIO ENCONTRADO EN BASE DE DATOS: " + login.getUsuario());
			((Log)Globales.variablesGlobales.get("log")).registraInfo();
			
			Globales.variablesGlobales.put("usuario", usuarios.get(0));
			
			return true;
			
		} else if(usuarios.size() > 1) {
			
			((Log)Globales.variablesGlobales.get("log")).setMensaje("MAS DE UN USUARIO ENCONTRADO EN BASE DE DATOS: " + login.getUsuario());
			((Log)Globales.variablesGlobales.get("log")).setException(null);
			((Log)Globales.variablesGlobales.get("log")).setCodigo(-110);
			((Log)Globales.variablesGlobales.get("log")).setEstado(null);
			((Log)Globales.variablesGlobales.get("log")).setNombreClase(this.getClass().getName());
			((Log)Globales.variablesGlobales.get("log")).registraError();
			
			return false;
			
		} else {
			//ERROR DE BASE DE DATOS, EL ERROR LO JALARA DEL DAO
			return false;
			
		}
		
	}
	
}