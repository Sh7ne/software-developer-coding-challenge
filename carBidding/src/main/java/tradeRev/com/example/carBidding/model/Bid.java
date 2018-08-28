package tradeRev.com.example.carBidding.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;


    @Entity
    @Table(name = "bids")
    @EntityListeners(AuditingEntityListener.class)
    @JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
            allowGetters = true)
    public class Bid {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long bidId;

        private String currentPrice;

        private String closed;

        private String carId;
        protected Bid() {}

        public Bid(String currentPrice, String closed, String carId) {
            this.currentPrice = currentPrice;
            this.closed = closed;
            this.carId = carId;

        }

        @Override
        public String toString() {
            return String.format(
                    "Bid[bidId=%d, currentPrice='%s', closed='%s',carId='%s']",
                    bidId,currentPrice, closed, carId);
        }

        public Long getBidId() {
            return bidId;
        }

        public void setBidId(Long bidId) {
            this.bidId = bidId;
        }

        public String getCurrentPrice() {
            return currentPrice;
        }

        public String getCarId() {
            return carId;
        }

        public String getClosed() {
            return closed;
        }

    }
