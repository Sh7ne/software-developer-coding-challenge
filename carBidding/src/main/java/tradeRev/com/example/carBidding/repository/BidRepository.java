package tradeRev.com.example.carBidding.repository;
import tradeRev.com.example.carBidding.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {
    List<Bid> findByCarId(String carId);
}