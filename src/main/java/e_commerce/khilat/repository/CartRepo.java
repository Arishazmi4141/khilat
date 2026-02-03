package e_commerce.khilat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import e_commerce.khilat.entity.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {

}
