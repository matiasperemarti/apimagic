package edu.tallerjava.repositorios;

import edu.tallerjava.modelo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

//Category repository extends JpaRepository and receives the Business Object that will use and the type of
// ID used by it. <Category, Long>.
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
