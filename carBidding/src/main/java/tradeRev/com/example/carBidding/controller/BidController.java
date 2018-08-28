package tradeRev.com.example.carBidding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tradeRev.com.example.carBidding.model.Bid;
import tradeRev.com.example.carBidding.repository.BidRepository;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tradeRev")

public class BidController {

    @Autowired
    BidRepository bidRepository;

    @PostMapping("/bids")
    public Bid createBid(@Valid @RequestBody Bid bid) {
        List<Bid> bids= new ArrayList<>();
        String carId=bid.getCarId();
        bids=bidRepository.findByCarId(carId);
        //Check if the car is the first time bidding
        if(bids.size()>0){
        //Find the current winning bid by find the last element in the list
        Bid windBid =bids.get(bids.size()-1);
        float currentPrice=Float.parseFloat(windBid.getCurrentPrice()) ;
        float newPrice=Float.parseFloat(bid.getCurrentPrice());
        //Make sure only higher bidding price can be added to database
        if(newPrice>currentPrice&&(bid.getClosed().equals("false"))){
        return bidRepository.save(bid);}
        else {return null;}
        }
        else return bidRepository.save(bid);
    }

    //Find the highest bid for this car
    @GetMapping("/winBid/{id}")
    public Bid getWinBid(@PathVariable(value = "id") String carId) {
        List<Bid> bids= new ArrayList<>();
        bids = bidRepository.findByCarId(carId);
        //Find the current winning bid by find the last element in the list
        Bid windBid =bids.get(bids.size()-1);
        return windBid;
    }
    //Get bidding information by searching carId
    @GetMapping("/bidHistory/{id}")
    public List<Bid> getBidByCarID(@PathVariable(value = "id") String carId) {

        List<Bid> bids= new ArrayList<>();
        bids = bidRepository.findByCarId(carId);
            return bids;
        }


}