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
public abstract class FromToMapper<T, E> extends ToMapper<T, E> {

	protected final T NULL_NOT_CORE_ENTITY = null;

	/**
	 * Converte uma entidade do core para uma fora do core ou nulo caso o objeto
	 * seja nulo
	 * 
	 * @param outerEntity
	 * @return entidade fora do core
	 */
	public T from(E outerEntity) {
		return Optional.ofNullable(outerEntity).map(this::fromNonNull).orElse(NULL_NOT_CORE_ENTITY);
	}

	protected abstract T fromNonNull(E entity);

	/**
	 * Converte uma Lista de entidade fora do core para uma do core ou nulo caso o
	 * objeto seja nulo
	 * 
	 * @param outerEntity
	 * @return entidade do core
	 */
	public List<T> fromList(List<E> outerEntities) {
		return Optional.ofNullable(outerEntities).map(this::fromListNonNull).orElse(Collections.emptyList());
	}

	private List<T> fromListNonNull(List<E> outerEntities) {
		return outerEntities.stream().map(this::from).collect(Collectors.toList());
	}

}
