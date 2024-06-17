package icc.contactos;

/**
 * Metodos para una estructura que almacene y permita buscar datos de contactos
 * en objetos tipo <code>Registro</code>.
 * @author blackzafiro
 */
public interface IContactos {
	
	/***
	 * Inserta el registro a la estructura de datos.
	 * @param reg registro con los datos del contacto.
	 */
	public void insertaContacto(Registro reg);
	
	/**
	 * Permite buscar los datos de un contacto.
	 * @param nombre el nombre del contacto que se busca o alguna parte de el.
	 * @return referencia al registro con los datos del primer contacto cuyo
	 *         nombre contenga la cadena especificada en el parámetro
	 *         <code>nombre</code>.
	 */
	public Registro consultar(String nombre);
}
