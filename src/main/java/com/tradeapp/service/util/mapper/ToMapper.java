package com.tradeapp.service.util.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Paulo Abreu
 * 
 * @param <T> entidade fora do core (EntryPoint ou DataProvider
 * @param <E> entidade do core (UseCase)
 */
public abstract class ToMapper<T, E> {

	protected final E NULL_ENTITY = null;

	/**
	 * Converte uma entidade fora do core para uma do core ou nulo caso o objeto
	 * seja nulo
	 * 
	 * @param outerEntity
	 * @return entidade do core
	 */
	public E to(T outerEntity) {
		return Optional.ofNullable(outerEntity).map(this::toNonNull).orElse(NULL_ENTITY);
	}

	protected abstract E toNonNull(T entity);

	/**
	 * Converte uma Lista de entidade fora do core para uma do core ou nulo caso o
	 * objeto seja nulo
	 * 
	 * @param outerEntity
	 * @return entidade do core
	 */
	public List<E> toList(List<T> outerEntities) {
		return Optional.ofNullable(outerEntities).map(this::toListNonNull).orElse(Collections.emptyList());
	}

	private List<E> toListNonNull(List<T> outerEntities) {
		return outerEntities.stream().map(this::to).collect(Collectors.toList());
	}

}
