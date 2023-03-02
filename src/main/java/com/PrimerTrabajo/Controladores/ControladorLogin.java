package com.PrimerTrabajo.Controladores;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.PrimerTrabajo.Cliente.ClienteRest;
import com.PrimerTrabajo.bbdd.Consultasrepositorios;
import com.PrimerTrabajo.entidades.carrito.Carrito;
import com.PrimerTrabajo.entidades.productos.Productos;
import com.PrimerTrabajo.entidades.productos.VentasBien;
import com.PrimerTrabajo.entidades.usuarios.Usuarios;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class ControladorLogin {
	@Autowired
	protected Consultasrepositorios u;

	@GetMapping("/index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();

		/*
		 * Condicion para que no se dejen vacios los campos de iniciar sesion. Si se
		 * dejan vacios redirige al index si no pasa a primera donde se valida.
		 */
		if (sesion.getAttribute("usuario") != null) {
			response.sendRedirect("primera");
		}

		return new ModelAndView("index");
	}

	@GetMapping("/primera")
	public ModelAndView primera(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sesion = request.getSession();
		// Se guarda el usuario y contraseña introducido por el usuario
		String login = request.getParameter("usuario");
		String pass = request.getParameter("contrasena");

		// Obtenemos el usuario y contraseña desde el metodo obtener usuario ya validado
		List<Usuarios> usuario = u.obtenerUsuario(login, pass);

		// Condicion para ver si esta vacio el usuario cogido del metodo anterior.
		if (usuario != null && usuario.size() != 0) {
			ModelAndView mw;

			int idadmin = usuario.get(0).getId();
			if (idadmin != 2) {
				mw = new ModelAndView("primera");
			} else {
				mw = new ModelAndView("primeraadmin");
			}

			// bucle para pasar a la vista todos los datos de los productos.
			for (int i = 0; i < u.obtenerProductos().size(); i++) {
				mw.addObject("id" + i, u.obtenerProductos().get(i).getId());
				mw.addObject("nombre" + i, u.obtenerProductos().get(i).getNombre());
				mw.addObject("precio" + i, u.obtenerProductos().get(i).getPrecio());
				mw.addObject("url" + i, u.obtenerProductos().get(i).getUrl());

			}

			// Guardo en el objeto sesion el usuario validado.
			sesion.setAttribute("id", usuario.get(0).getId());
			sesion.setAttribute("login", usuario.get(0).getLogin());
			sesion.setAttribute("pass", usuario.get(0).getPassword());

			// Paso el tamaño del objeto para poder recogerlo en la vista.
			mw.addObject("tamanoProductos", u.obtenerProductos().size());

			return mw;

		} else {
			// Si no está en la base de datos pasamos el mensaje de error que mostrare.
			ModelAndView mw = new ModelAndView("index");
			mw.addObject("error", "<div style='color:red'>Usuario y/o Clave incorrecta!</div>");
			return mw;
		}

	}

	@GetMapping("/carrito")
	public ModelAndView carrito(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		// Condicion que se ponen en todos para que no se puedan acceder a ellas sin
		// antes tener la sesion validada.
		if (sesion.getAttribute("login") == null) {
			response.sendRedirect("index");
		}

		return new ModelAndView("carrito");
	}

	// Metodo para cerrar sesion e invalidarla y redirigirte al index.
	@GetMapping("/cerrarsesion")
	public void cerrarsesion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		sesion.invalidate();

		response.sendRedirect("index");
	}

	// Metodo para añadir articulos al carrito.
	@GetMapping("/anadircarrito")
	public void anadircarrito(HttpServletRequest request, int id, String nombre, double precio) {
		Carrito carro = new Carrito();

		carro.setId(id);
		carro.setNombre(nombre);
		carro.setPrecio(precio);

	}

	@GetMapping("/ventas")
	public ModelAndView ventas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		ModelAndView mw = new ModelAndView("ventas");

		if (sesion.getAttribute("login") == null) {
			response.sendRedirect("index");
		}

		for (int i = 0; i < u.obtenerVentas().size(); i++) {
			mw.addObject("id" + i, u.obtenerVentas().get(i).getId());
			mw.addObject("nombre" + i, u.obtenerVentas().get(i).getNombre());
			mw.addObject("direccion" + i, u.obtenerVentas().get(i).getDireccion());
			mw.addObject("municipio" + i, u.obtenerVentas().get(i).getMunicipio());
			mw.addObject("provincia" + i, u.obtenerVentas().get(i).getProvincia());
			mw.addObject("cod_postal" + i, u.obtenerVentas().get(i).getCod_postal());
			mw.addObject("telefono" + i, u.obtenerVentas().get(i).getTelefono());
			mw.addObject("precio" + i, u.obtenerVentas().get(i).getPrecio());

		}

		mw.addObject("tamanoVentas", u.obtenerVentas().size());

		return mw;
	}

	@GetMapping("/producto1")
	public ModelAndView producto1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		ModelAndView mw = new ModelAndView("producto1");
		if (sesion.getAttribute("login") == null) {
			response.sendRedirect("index");
		}

		int idVenta = 1;

		int tamanio = u.obtenerIdProducto(idVenta).size();
		int array[] = new int[tamanio];

		for (int i = 0; i < tamanio; i++) {
			array[i] = (u.obtenerIdProducto(idVenta).get(i).getIdProducto());
		}

		for (int i = 0; i < tamanio; i++) {
			mw.addObject("nombre" + i, u.obtenernombreProductos(array[i]).get(0).getNombre());
			mw.addObject("img" + i, u.obtenernombreProductos(array[i]).get(0).getUrl());
			mw.addObject("precio" + i, u.obtenernombreProductos(array[i]).get(0).getPrecio());
		}

		mw.addObject("tamanoproducto", tamanio);

		return mw;
	}

	@GetMapping("/producto2")
	public ModelAndView producto2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		ModelAndView mw = new ModelAndView("producto2");
		int idVenta = 2;

		int tamanio = u.obtenerIdProducto(idVenta).size();
		int array[] = new int[tamanio];

		for (int i = 0; i < tamanio; i++) {
			array[i] = (u.obtenerIdProducto(idVenta).get(i).getIdProducto());
		}

		for (int i = 0; i < tamanio; i++) {
			mw.addObject("nombre" + i, u.obtenernombreProductos(array[i]).get(0).getNombre());
			mw.addObject("img" + i, u.obtenernombreProductos(array[i]).get(0).getUrl());
			mw.addObject("precio" + i, u.obtenernombreProductos(array[i]).get(0).getPrecio());
		}

		mw.addObject("tamanoproducto", tamanio);

		return mw;
	}

	@GetMapping("/producto3")
	public ModelAndView producto3(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		ModelAndView mw = new ModelAndView("producto3");
		int idVenta = 3;

		int tamanio = u.obtenerIdProducto(idVenta).size();
		int array[] = new int[tamanio];

		for (int i = 0; i < tamanio; i++) {
			array[i] = (u.obtenerIdProducto(idVenta).get(i).getIdProducto());
		}

		for (int i = 0; i < tamanio; i++) {
			mw.addObject("nombre" + i, u.obtenernombreProductos(array[i]).get(0).getNombre());
			mw.addObject("img" + i, u.obtenernombreProductos(array[i]).get(0).getUrl());
			mw.addObject("precio" + i, u.obtenernombreProductos(array[i]).get(0).getPrecio());
		}

		mw.addObject("tamanoproducto", tamanio);

		return mw;
	}

	@GetMapping("/producto4")
	public ModelAndView producto4(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		ModelAndView mw = new ModelAndView("producto3");
		int idVenta = 4;

		int tamanio = u.obtenerIdProducto(idVenta).size();
		int array[] = new int[tamanio];

		for (int i = 0; i < tamanio; i++) {
			array[i] = (u.obtenerIdProducto(idVenta).get(i).getIdProducto());
		}

		for (int i = 0; i < tamanio; i++) {
			mw.addObject("nombre" + i, u.obtenernombreProductos(array[i]).get(0).getNombre());
			mw.addObject("img" + i, u.obtenernombreProductos(array[i]).get(0).getUrl());
			mw.addObject("precio" + i, u.obtenernombreProductos(array[i]).get(0).getPrecio());
		}

		mw.addObject("tamanoproducto", tamanio);

		return mw;
	}

	@GetMapping("/producto")
	public ModelAndView producto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		ModelAndView mw = new ModelAndView("producto1");
		if (sesion.getAttribute("login") == null) {
			response.sendRedirect("index");
		}

		int idVenta = Integer.parseInt(request.getParameter("idVenta"));

		List<VentasBien> lista = u.obtenerIdProducto(idVenta);

		int tamanio = lista.size();
		int array[] = new int[tamanio];

		for (int i = 0; i < tamanio; i++) {
			array[i] = lista.get(i).getIdProducto();
		}

		for (int i = 0; i < tamanio; i++) {
			Productos p = u.obtenernombreProductos(array[i]).get(0);
			mw.addObject("nombre" + i, p.getNombre());
			mw.addObject("img" + i, p.getUrl());
			mw.addObject("precio" + i, p.getPrecio());
		}

		mw.addObject("tamanoproducto", tamanio);
		mw.addObject("venta", request.getParameter("idVenta"));

		return mw;
	}

	@GetMapping("/ventaadmin")
    public ModelAndView ventasAdmin(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		HttpSession sesion = request.getSession();
    	ModelAndView mw = new ModelAndView ("ventaadmin");
    	if (sesion.getAttribute("login") == null) {
    	response.sendRedirect("index");
    	}
    	ClienteRest c = new ClienteRest();
    	// Aquí va la respuesta JSONW
    	String json = c.get("http://localhost:9898/ventas");
    	System.out.println(json);
    	
    	
    	ObjectMapper mapper = new ObjectMapper();
    	List<Map<String, Object>> lista = mapper.readValue(json, new TypeReference<List<Map<String, Object>>>() {});
    	
    	
    	mw.addObject("lista", lista);
     return mw;
    }
	
	@GetMapping("/primerajstl")
    public ModelAndView productoUsuario(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		HttpSession sesion = request.getSession();
    	ModelAndView mw = new ModelAndView ("primerajstl");
    	if (sesion.getAttribute("login") == null) {
    	response.sendRedirect("index");
    	}
    	
    	ClienteRest c = new ClienteRest();
    	// Aquí va la respuesta JSONW
    	String json = c.get("http://localhost:9898/productos");
    	System.out.println(json);
    	
    	
    	ObjectMapper mapper = new ObjectMapper();
    	List<Map<String, Object>> lista = mapper.readValue(json, new TypeReference<List<Map<String, Object>>>() {});
    	
    	mw.addObject("lista", lista);
     return mw;
    }
	
	@GetMapping("/ventaId")
    public ModelAndView ventasporId(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		HttpSession sesion = request.getSession();
    	ModelAndView mw = new ModelAndView ("ventaId");
    	if (sesion.getAttribute("login") == null) {
    	response.sendRedirect("index");
    	}
    	
    	int id = (int) sesion.getAttribute("id");
    	
    	ClienteRest c = new ClienteRest();
    	// Aquí va la respuesta JSONW
    	String json = c.get("http://localhost:9898/ventas/" + id);
    	System.out.println(json);
    	
    	
    	ObjectMapper mapper = new ObjectMapper();
    	List<Map<String, Object>> lista = mapper.readValue(json, new TypeReference<List<Map<String, Object>>>() {});
    	
    	mw.addObject("lista", lista);
     return mw;
    }

}
