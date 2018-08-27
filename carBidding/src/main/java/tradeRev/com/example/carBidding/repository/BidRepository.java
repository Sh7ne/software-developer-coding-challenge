package tradeRev.com.example.carBidding.repository;
import tradeRev.com.example.carBidding.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {

}