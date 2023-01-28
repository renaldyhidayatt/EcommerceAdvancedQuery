package com.sanedge.ecommercequery.service.impl;

import com.sanedge.ecommercequery.dto.request.AddressRequest;
import com.sanedge.ecommercequery.dto.response.MessageResponse;
import com.sanedge.ecommercequery.exception.NotFoundException;
import com.sanedge.ecommercequery.models.Address;
import com.sanedge.ecommercequery.models.User;
import com.sanedge.ecommercequery.repository.AddressRepository;
import com.sanedge.ecommercequery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl {

    AddressRepository addressRepository;
    UserRepository userRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, UserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    public MessageResponse create(AddressRequest addressRequest) {
        Address address = new Address();

        address.setFirstName(addressRequest.getFirstName());
        address.setLastName(addressRequest.getLastName());
        address.setAddress(addressRequest.getAddress());
        address.setCity(addressRequest.getCity());
        address.setCountry(addressRequest.getCountry());
        address.setZipCode(addressRequest.getZipCode());

        User user = this.userRepository.findById(addressRequest.getUserId())
                .orElseThrow(() -> new NotFoundException("not user id"));

        address.setUser(user);

        this.addressRepository.save(address);

        return MessageResponse.builder().message("Berhasil membuat address").data(address).statusCode(200).build();
    }

    public MessageResponse getById(Long addressid) {
        Address address = this.addressRepository.findById(addressid)
                .orElseThrow(() -> new NotFoundException("not address id"));

        return MessageResponse.builder().message("Berhasil mendapatkan data").data(address).statusCode(200).build();
    }
}
