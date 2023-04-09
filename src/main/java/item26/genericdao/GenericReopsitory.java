package item26.genericdao;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class GenericReopsitory<E extends Entity> {
	
	private Set<E> entities;
	
	public Optional<E> findById(Long id){
		return entities.stream().filter(a -> a.getId().equals(id)).findAny();
	}
	
	public void add(E entity) {
		this.entities.add(entity);
	}

	public GenericReopsitory() {
		this.entities = new HashSet<>();
	}

}
