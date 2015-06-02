package fr.utbm.core.dao;

import java.io.Serializable;

public interface IDaoCRUD<E, I extends Serializable> {
	public void register(E entity);
	public E get(Class<E> className, I id);

}
