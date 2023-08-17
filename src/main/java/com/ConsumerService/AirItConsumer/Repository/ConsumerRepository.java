package com.ConsumerService.AirItConsumer.Repository;
import com.ConsumerService.AirItConsumer.Model.Financials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ConsumerRepository extends JpaRepository<Financials,Integer> {
}
