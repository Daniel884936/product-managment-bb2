package com.productmanagment.productmanagment.DTOAssemblers.productAssembler;

import com.productmanagment.productmanagment.DTOAssemblers.DTOAssemblerFactory.HibernateDTOAssemblerFactory;
import com.productmanagment.productmanagment.configs.ProductConf;
import com.productmanagment.productmanagment.configs.SupplierConf;
import com.productmanagment.productmanagment.dtos.ProductDTO;
import com.productmanagment.productmanagment.dtos.ProductReductionPriceDTO;
import com.productmanagment.productmanagment.dtos.SupplierDTO;
import com.productmanagment.productmanagment.models.Product;
import com.productmanagment.productmanagment.models.ProductReductionPrice;
import com.productmanagment.productmanagment.models.Supplier;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ProductAssemblerHibernate implements  ProductAssembler{

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Product Dto2Pojo(ProductDTO productDTO) {
        if(productDTO== null){
            return  null;
        }

        //Set product reduction prices
        Product result = modelMapper.map(productDTO, Product.class);
        List<ProductReductionPriceDTO> productReductionPriceDTOS  = productDTO.getProductReductionPrices();
        if(productReductionPriceDTOS!= null){
            productReductionPriceDTOS.stream().forEach(productReductionPriceDTO -> {
                //TODO
                result.addProductReductionPrice(HibernateDTOAssemblerFactory.DEFAULT.getProductReductionPriceAssembler().dtoToPojo(productReductionPriceDTO));
            });
        }
        if(productReductionPriceDTOS == null){
            result.setProductReductionPrices(null);
        }

        //Set supplier
        List<SupplierDTO> supplierDTOS = productDTO.getSuppliers();
        if(supplierDTOS != null){
            List<Supplier> suppliers = new ArrayList<>();
            supplierDTOS.stream().forEach(supplierDTO -> {
                //TODO
                suppliers.add(HibernateDTOAssemblerFactory.DEFAULT.getSupplierAssembler().Dto2Pojo(supplierDTO));
            });
            result.setSuppliers(suppliers);
        }
        if(supplierDTOS == null){
            result.setSuppliers(null);
        }
        return result;
    }


    @Override
    public ProductDTO pojo2Dto(Product product, ProductConf productConf) {
        if(product == null){
            return null;
        }
        ProductDTO result = modelMapper.map(product , ProductDTO.class);

        //Set product reduction prices
        List<ProductReductionPrice> productReductionPrices = product.getProductReductionPrices();
        if(productReductionPrices != null){
            List<ProductReductionPriceDTO> productReductionPriceDTOS = new ArrayList<>();
            productReductionPrices.stream().forEach(productReductionPrice -> {
                //TODO
                productReductionPriceDTOS.add(HibernateDTOAssemblerFactory.DEFAULT.getProductReductionPriceAssembler().pojo2Dto(productReductionPrice));
            });
            result.setProductReductionPrices(productReductionPriceDTOS);
        }

        //Set supplier
        if(productConf.getSuppliersConf()!=null){
            List<Supplier> suppliers = product.getSuppliers();
            if(suppliers != null){
                List<SupplierDTO> supplierDTOS = new ArrayList<>();
                suppliers.stream().forEach(supplier -> {
                    //TODO
                    supplierDTOS.add(HibernateDTOAssemblerFactory.DEFAULT.getSupplierAssembler().pojo2Dto(supplier, new SupplierConf()));
                });
                result.setSuppliers(supplierDTOS);
            }
            if(suppliers == null){
                result.setSuppliers(null);
            }
        }
        return result;
    }
}
