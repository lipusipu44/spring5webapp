package guru.springframework.spring5webapp.repository;

import com.sun.xml.internal.bind.v2.model.core.ID;
import guru.springframework.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, ID> {
}
