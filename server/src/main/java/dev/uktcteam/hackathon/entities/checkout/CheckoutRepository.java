package dev.uktcteam.hackathon.entities.checkout;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutRepository extends JpaRepository<Checkout, Long> {
    // Add custom query methods if needed
}
