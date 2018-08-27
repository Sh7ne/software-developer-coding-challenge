package tradeRev.com.example.carBidding.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

    @Entity
    @Table(name = "bids")
    @EntityListeners(AuditingEntityListener.class)
    @JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
            allowGetters = true)
    public class Bid {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long itemId;

        @NotBlank
        private float currentPrice;

        @NotBlank
        private boolean closed;

        @Column(nullable = false, updatable = false)
        @Temporal(TemporalType.TIMESTAMP)
        @CreatedDate
        private Date createdAt;

        @Column(nullable = false)
        @Temporal(TemporalType.TIMESTAMP)
        @LastModifiedDate
        private Date updatedAt;

        public Long getItemId() {
            return itemId;
        }

        public void setItemId(Long itemId) {
            this.itemId = itemId;
        }

        public float getCurrentPrice() {
            return currentPrice;
        }

        public void setCurrentPrice(float currentPrice) {
            this.currentPrice = currentPrice;
        }

        public boolean isClosed() {
            return closed;
        }

        public void setClosed(boolean closed) {
            this.closed = closed;
        }

        public Date getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
        }

        public Date getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Date updatedAt) {
            this.updatedAt = updatedAt;
        }
    }
