package tradeRev.com.example.carBidding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tradeRev.com.example.carBidding.model.Bid;
import tradeRev.com.example.carBidding.repository.BidRepository;
import tradeRev.com.example.carBidding.exception.ResourceException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tradeRev")

public class BidController {

    @Autowired
    BidRepository bidRepository;

    @GetMapping("/bids")
    public List<Bid> getAllBids() {
        return bidRepository.findAll();
    }

    @PostMapping("/bids")
    public Bid createBid(@Valid @RequestBody Bid bid) {
        return bidRepository.save(bid);
    }

    @GetMapping("/bids/{id}")
    public Bid getBidById(@PathVariable(value = "id") Long bidId) {
        return bidRepository.findById(bidId)
                .orElseThrow(() -> new ResourceException("Bid", "id", bidId));
    }

    @PutMapping("/bids/{id}")
    public Bid updateBid(@PathVariable(value = "id") Long bidId,
                           @Valid @RequestBody Bid bidDetails) {

        Bid bid = bidRepository.findById(bidId)
                .orElseThrow(() -> new ResourceException("Bid", "id", bidId));

        bid.setItemId(bidDetails.getItemId());
        bid.setCurrentPrice(bidDetails.getCurrentPrice());
        bid.setClosed(bidDetails.isClosed());


        Bid updatedBid = bidRepository.save(bid);
        return updatedBid;
    }

    @DeleteMapping("/bids/{id}")
    public ResponseEntity<?> deleteBid(@PathVariable(value = "id") Long bidId) {
        Bid bid = bidRepository.findById(bidId)
                .orElseThrow(() -> new ResourceException("Bid", "id", bidId));

        bidRepository.delete(bid);

        return ResponseEntity.ok().build();
    }
}
