package DAO;

import java.util.ArrayList;

public interface DAO<T> {
    
    public boolean cadastrar(T objeto);
    public T consultar(T objeto);
    public boolean editar(T objeto);
    public ArrayList<T> listarTodos(T objeto);
}
