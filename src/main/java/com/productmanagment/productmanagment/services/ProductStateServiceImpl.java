package com.productmanagment.productmanagment.services;
import com.productmanagment.productmanagment.models.ProductState;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@Service
public class ProductStateServiceImpl implements ProductStateService {

    @Override
    public List<ProductState> getAll() {
        List<ProductState> productStates = new ArrayList<>(EnumSet.allOf(ProductState.class));
        return productStates;
    }
}
