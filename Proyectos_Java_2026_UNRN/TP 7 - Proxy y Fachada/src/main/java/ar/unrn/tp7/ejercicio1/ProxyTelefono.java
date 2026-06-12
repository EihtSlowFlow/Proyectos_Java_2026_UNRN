package ar.unrn.tp7.ejercicio1;
import java.util.*;

public class ProxyTelefono implements Set {
    int id;// para hacer el innerjoin con el sujeto
    PersonaDao dao;
    public ProxyTelefono(int id, PersonaDao dao) {
        this.id = id;
        this.dao = dao;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean removeAll(Collection collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection collection) {
        return false;
    }

    @Override
    public boolean containsAll(Collection collection) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] objects) {
        /* No conviene, dos accesos a la BD, uno para el size y otro para recuperar los telefonos, lo que se puede hacer es recuperar los telefonos en un solo acceso a la BD, y luego devolverlos en el toArray.
        String sql = "select t.numero "
                + "from telefonos t "
                + "where t.persona_id = ?";

         */
        Set<Telefono> telefonos = dao.telefonosPorID(id);


        return telefonos.toArray();
    }
}
