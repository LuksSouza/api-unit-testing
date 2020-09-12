package pt.com.apiunittesting.apiunittesting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.com.apiunittesting.apiunittesting.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
